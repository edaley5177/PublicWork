// ----------------------------------------------------------- 
// NAME: Eamonn Daley                         User ID: edaley 
// DUE DATE: 04/06/2018                                       
// PROGRAM ASSIGNMENT 4                                        
// FILE NAME: thread.cpp (your unix file name)            
// PROGRAM PURPOSE: 
//    this is the implementation file for each thread, it tells each thread what to do         
// ----------------------------------------------------------- 

#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>
#include  <sys/types.h>
#include  <sys/ipc.h>
#include  <sys/shm.h>
#include <time.h>
#include <math.h>
#include <stdint.h>
#include <limits.h>
#include <iostream>

#include "thread.h"
#include "thread-support.h"


static Semaphore elfSem("ElfSemaphore", 0);//mutex locked when santa is delivering toys
static Mutex mutexDB("deerBack");//mutex to lock totDeerBack
static Semaphore deerSem("ReindeerSem", 0);//semaphore for reindeer returning

static Semaphore santaSem("santa", 0);
static Mutex elfMutex("ElfMutex");
int totDeerBack=0;//the number of reindeer currently back from vacation

int waitingElves[3];//array of elves id's that are waiting for a question to be answered
static Mutex mutexGang("waitingElves");//mutex to lock waitingElves
int eInd=0;//index of next spot to put elf with problem's id in waitingElves
static Mutex mutexInd("eInd");//mutex to lock eInd
//---------------------------------------------------------------//
//  SantaThread Class: 
//     constructor
//---------------------------------------------------------------//

SantaThread::SantaThread(int threadId, int t, int r)
            :persId(threadId), trips(t), deer(r)
{
  ThreadName.seekp(0, ios::beg);
     ThreadName << "Santa #"<<threadId <<'\0';
}

void SantaThread::ThreadFunc()
{
  Thread::ThreadFunc();
  char out[200];
    sprintf(out, "Santa thread starts\n");
    write(1, out, strlen(out)*sizeof(char));
    
    int santaRetired =0;
    Sleep();
    compTrips=0;//number of toy delivery trips completed
    while(santaRetired==0){
      Sleep();
      santaSem.Wait();
      mutexDB.Lock();
      if(totDeerBack==deer){
        //deliver toys
        sprintf(out, "Santa is preparing sleighs\n");
        write(1, out, strlen(out)*sizeof(char));
        compTrips++;
        FlyOff();
        Delay();//delay to deliver toys
        //retire if santa is done delivering

        if (compTrips>= trips)
        {
          sprintf(out, "After (%d) deliveries, Santa retires and is on vacation!\n", compTrips);
        write(1, out, strlen(out)*sizeof(char));
          santaRetired=5;
        }
        else{
          int i;
          for (i = 0; i < deer; ++i)
            deerSem.Signal();
        }
        //after every delivery reset deerBack to 0
        totDeerBack=0;
        Delay();
      }
    
      //only lock the variables i check
      mutexInd.Lock();
       if(eInd ==3 && santaRetired!=5){
        mutexGang.Lock();//only lock the array if I have to 
        sprintf(out, "Santa is helping elves\n");
        write(1, out, strlen(out)*sizeof(char));

        sprintf(out, "Santa answers the question posted by elves %d, %d, %d\n", waitingElves[0], waitingElves[1], waitingElves[2]);
        write(1, out, strlen(out)*sizeof(char));
        Delay();//delay to answer questions
        int i;
        for (i = 0; i < 3; ++i){
          elfSem.Signal();//signal all waiting elves
          //after signaling a waiting elf, release MutexInd so elves can at least have a chance to decrease eInd to simulate getting their question answered
          mutexInd.Unlock();
          Delay();
          Delay();
          mutexInd.Lock();
          
        }
        mutexGang.Unlock();
        Delay();
      } 

      mutexInd.Unlock(); 
      mutexDB.Unlock();  
      Delay();
    }
    
    Exit(); 
}

ElfThread::ElfThread(int threadId)
          :persId(threadId)
{
  ThreadName.seekp(0, ios::beg);
     ThreadName << "Elf # "<<threadId <<'\0';
}
void ElfThread::ThreadFunc()
{
  Thread::ThreadFunc();
  char out[200];

  sprintf(out, "         Elf %d starts\n", persId);
    write(1, out, strlen(out)*sizeof(char));
  while(1){

    Delay();
    elfMutex.Lock();
    mutexGang.Lock();
    mutexInd.Lock();
    //first load my id into the array
    waitingElves[eInd]=persId;
    AskQuestion();
    eInd++;
    if (eInd ==3){

      sprintf(out, "         Elves %d, %d, %d, wake up the Santa\n", waitingElves[0], waitingElves[1], waitingElves[2]);
    write(1, out, strlen(out)*sizeof(char));
    //unlock the mutexes so santa can lock them to prevent dead lock
    mutexInd.Unlock();
    mutexGang.Unlock();
      santaSem.Signal();
    }

    else{
      mutexInd.Unlock();
    mutexGang.Unlock();
      elfMutex.Unlock();

    }
    
    elfSem.Wait();//wait to be released by santa

    mutexInd.Lock();
      eInd--;
      
      if (eInd==0)
      {
        sprintf(out, "         Elves %d, %d, %d, return to work\n", waitingElves[0], waitingElves[1], waitingElves[2]);
    write(1, out, strlen(out)*sizeof(char));
        elfMutex.Unlock();
      }
      //otherwise unlock the elf mutex
      /*else{
        elfMutex.Unlock();
      }*/
      mutexInd.Unlock();
   Delay();
  } 
    Exit(); 
}


ReindeerThread::ReindeerThread(int threadId, int td)
                :persId(threadId), totDeer(td)
{
  ThreadName.seekp(0, ios::beg);
     ThreadName << "Reindeer # "<<threadId <<'\0';
}


void ReindeerThread::ThreadFunc()
{
  Thread::ThreadFunc();
  char out[200];
    sprintf(out, "    Reindeer %d starts\n", persId);
    write(1, out, strlen(out)*sizeof(char));
    while(1){
      //sleep(5);
      Delay();

      mutexDB.Lock();
      totDeerBack++;
      ReindeerBack();
      WaitOthers();
      if (totDeerBack==totDeer){
        sprintf(out, "    The last reindeer %d wakes up Santa\n", persId);
        write(1, out, strlen(out)*sizeof(char));
        santaSem.Signal();
      }
      mutexDB.Unlock();
      WaitSleigh();
      //fly off with santa and wait for him to put me back on vacation
      deerSem.Wait();
      Delay();
    }
    Exit(); 
}