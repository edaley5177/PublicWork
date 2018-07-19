// ----------------------------------------------------------- 
// NAME: Eamonn Daley                         User ID: edaley 
// DUE DATE: 04/20/2018                                       
// PROGRAM ASSIGNMENT 5                                        
// FILE NAME: thread.cpp (your unix file name)            
// PROGRAM PURPOSE: 
//    this is the implementation file for each thread, it tells each thread what to do         
//  it also contains the definitions of the monitor functions
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
static ChristmasMonitor SantaMarley("Bob");
// ----------------------------------------------------------- 
// FUNCTION  SantaThread::SantaTrhead: (function name)                          
//     initializes private variables for the santa thread                            
// PARAMETER USAGE :                                           
//      threadId-a unique id for this santa thread
//      t-the number of trips santa must take before retiring
//      r-the total number of reindeer santa has
//      e-the total number of elves at the north pole       
// FUNCTION CALLED :                                           
//            
// ----------------------------------------------------------- 

SantaThread::SantaThread(int threadId, int e, int t, int r)
            :persId(threadId), trips(t), deer(r), elves(e)
{
  ThreadName.seekp(0, ios::beg);
     ThreadName << "Santa #"<<threadId <<'\0';
}

// ----------------------------------------------------------- 
// FUNCTION  SantaThread::ThreadFunc: (function name)                          
//     tells the santa thread what to do                            
// PARAMETER USAGE :                                           
//                
// FUNCTION CALLED :                                           
//            SantaMarley.SetVariables(int, int, int), SantaMarley.Sleep()
// ----------------------------------------------------------- 
void SantaThread::ThreadFunc()
{
  Thread::ThreadFunc();
  char out[200];
    sprintf(out, "Santa thread starts\n");
    write(1, out, strlen(out)*sizeof(char));
    
    SantaMarley.SetVariables(elves,deer,trips);

    //int santaRetired =0;
    //Sleep();
    //compTrips=0;//number of toy delivery trips completed
    //santa needs to signal elfCond so they can have a problem
    while(SantaMarley.SantaRetired() ==0){
      /* sprintf(out, "Santa thread starts to sleep\n");
    write(1, out, strlen(out)*sizeof(char));*/
      SantaMarley.Sleep();
      
     

      /*compTrips++;
      sprintf(out, "Santa helped elves %d times\n", compTrips);
    write(1, out, strlen(out)*sizeof(char));*/
     /* if (compTrips>=trips)
      {
        santaRetired=3;
        
        //REMOVE THIS LATER
        //THIS IS TO PREVENT SANTA FROM RUNNING FOREVER
      }*/

      
    }
    /*
    sprintf(out, "Santa retires\n");
    write(1, out, strlen(out)*sizeof(char));*/
    
    Exit(); 
}


// ----------------------------------------------------------- 
// FUNCTION  ElfThread::ElfThread: (function name)                          
//      initalizes private variables for the elf threads                            
// PARAMETER USAGE :                                           
//               threadId-a personal Id for each elf, used so i can print out which one has a question
// FUNCTION CALLED :                                           
//           
// ----------------------------------------------------------- 
ElfThread::ElfThread(int threadId)
          :persId(threadId)
{
  ThreadName.seekp(0, ios::beg);
     ThreadName << "Elf # "<<threadId <<'\0';
}

// ----------------------------------------------------------- 
// FUNCTION  ElfThread::ThreadFunc: (function name)                          
//      tells each elf thread what to do                            
// PARAMETER USAGE :                                           
//               
// FUNCTION CALLED :                                           
//           SantaMarley.AskQuestion(int)
// ----------------------------------------------------------- 
void ElfThread::ThreadFunc()
{
  Thread::ThreadFunc();
  char out[200];

  sprintf(out, "         Elf %d starts\n", persId);
    write(1, out, strlen(out)*sizeof(char));

    time_t t;
    srand((unsigned)time(&t));
  while(1){
    
    for (int i = 0; i < rand()%20000; ++i)
      Delay();
      
      SantaMarley.AskQuestion(persId);

   
    for (int i = 0; i < rand()%20; ++i)
      Delay();
  } 
    Exit(); 
}

// ----------------------------------------------------------- 
// FUNCTION  ReindeerThread::ReindeerThread: (function name)                          
//      initializes private variables for reindeer threads                            
// PARAMETER USAGE :                                           
//        threadId-a unique Id for each reindeer, used so i can print out which just got back       
// FUNCTION CALLED :                                           
//           
// ----------------------------------------------------------- 
ReindeerThread::ReindeerThread(int threadId)
                :persId(threadId)
{
  ThreadName.seekp(0, ios::beg);
     ThreadName << "Reindeer # "<<threadId <<'\0';
}
// ----------------------------------------------------------- 
// FUNCTION  ReindeerThread::ThreadFunc: (function name)                          
//      tells each Reindeer thread what to do                            
// PARAMETER USAGE :                                           
//               
// FUNCTION CALLED :                                           
//           
// ----------------------------------------------------------- 

void ReindeerThread::ThreadFunc()
{
  Thread::ThreadFunc();


  char out[200];
    sprintf(out, "    Reindeer %d starts\n", persId);
    write(1, out, strlen(out)*sizeof(char));
  time_t t;
    srand((unsigned)time(&t));
  while(1){


   for (int i = 0; i < rand()%1000; ++i)
      Delay();

    SantaMarley.ReindeerBack(persId);


    for (int i = 0; i < rand()%1000; ++i)
      Delay();
  }

    Exit(); 
}

// ----------------------------------------------------------- 
// FUNCTION  ChristmasMonitor::ChristmasMonitor: (function name)                          
//      initializes private variables and condition variables for the monitor                            
// PARAMETER USAGE :                                           
//     elf-a condition variable used to alert elves that they have been released by santa and may go back to work
//     deer-a condition used to account for fast reindeer
//      santa-a conditon variable used by both the reindeer and elves to wake up santa 
//      elfCond-a condition used by elves to wait for santa to go to sleep before asking a question
//      warmingHut-a condition used by reindeer that weren't the last to get back, so they will wait until santa is woken up to get on the sleigh
//      goAway-  a condition used by all reindeer, if a reindeer is waiting on this, it means he is attached to the sleigh and is waiting to be released by santa to go on vacation    
// FUNCTION CALLED :                                           
//           
// ----------------------------------------------------------- 
ChristmasMonitor::ChristmasMonitor(char* Name)
        : Monitor(Name, HOARE), elf("elf"), deer("deer"), santaAv("available"),santa("Santa"), elfCond("elfCond"), warmingHut("hut"), goAway("vacay")
{
     ewq=0;
     deerBack=0;
     tripsComp=0;
      santaUp=0;
      //we=0;
}
/*
FUNCTION  ChristmasMonitor::SetVariables: (function name)  
  Called by santa to initalize 3 important private monitor variables
PARAMETER USAGE : 
  e-the total number of elves in the north pole
  r- the total number of reindeer
  t-the total number of trips santa must make before retiring

FUNCTION CALLED :  

*/
void ChristmasMonitor::SetVariables(int e, int r, int t)
{
  MonitorBegin();
  totElves = e;
  totDeer = r;
  totTrips = t;
  //debug
  /*sprintf(out, "Santa has set variables\n");
  write(1, out, strlen(out)*sizeof(char));*/
  //ewq=0;
  MonitorEnd();
}
/*
FUNCTION  ChristmasMonitor::SantaRetired: (function name)  
  Called to check if santa is retired yet
PARAMETER USAGE : 

FUNCTION CALLED :  
    
*/
int ChristmasMonitor::SantaRetired(){
  if (tripsComp==totTrips)
    return 1;
  else
    return 0;
}
/*
FUNCTION  ChristmasMonitor::AskQuestion: (function name)  
  Called by elves when they have a question for santa
PARAMETER USAGE : 
  elfId- the personal id of the elf who asked a question

FUNCTION CALLED :  
    wait(), signal()
*/
void ChristmasMonitor::AskQuestion(int elfId)
{
  MonitorBegin();
  //elfMx.Wait();
  if (SantaRetired())
  {
    deer.Wait();
  }
  sprintf(out, "         Elf %d has a problem\n", elfId);
  write(1, out, strlen(out)*sizeof(char));
  
  while(santaUp){//reindeer must wait until santa is asleep before registering that they are back
     /* if (ewq==3){
         sprintf(out, "         Elf %d waits for santa to finish with other elves\n", elfId);
  write(1, out, strlen(out)*sizeof(char));*/
       santaAv.Wait();//if santa is up when the last deer gets back, then he is answering elves questions or he could not have gotten to go back to sleep after releasing all reindeer
      //}
      
     /* else{
         sprintf(out, "         Elf %d waits for santa to finish with deer\n", elfId);
  write(1, out, strlen(out)*sizeof(char));
        deer.Wait();*/
      //}
    
    }
  
  //the elf must first wait for santa to release the three elves that currently have a question
  waitingElves[ewq] =elfId;
  ewq++;
  //debug
 /*sprintf(out, "         Elf %d adds to the array ewq is %d\n", elfId, ewq);
  write(1, out, strlen(out)*sizeof(char));*/
  if (ewq==3)
  {

    //make santa up so elves can't ask questions
    //santaUp=1;
    //if there is a group of 3,wait until santa is asleep to wake him up

    //wake up santa and wait until he releases you

    //wait until santa goes back to sleep before asking a question
 /*while (santaUp==1)
  {
    
    //santa.Wait();//only wait if santa is dealing with elves, or on a trip
    //THE PROBLEM WITH THIS APPROACH IS SANTA SIGNALS THIS ELF, AND THIS ELF SIGNALS SANTA BEFORE HE GOES TO SLEEP SO THE SIGNAL GOES AWAY LIKE IT NEVER HAPPENED
  }*/
    sprintf(out, "         Elves %d, %d, %d wake up the Santa\n", waitingElves[0], waitingElves[1], waitingElves[2]);
  write(1, out, strlen(out)*sizeof(char));
    santa.Signal();
    //elf.Wait();
  }

 /* else{
    //elfCond.Wait();
   
  //signal so another elf can run and ask a question
  //elfCond.Signal();
    //elfMx.Signal();
  }*/

 elf.Wait();
   ewq--;
   //debug
   /*sprintf(out, "         Elf %d returned to work\n", elfId);
  write(1, out, strlen(out)*sizeof(char));*/
    if (ewq==0)
    {
      sprintf(out, "         Elves %d, %d, %d return to work\n", waitingElves[0], waitingElves[1], waitingElves[2]);
      write(1, out, strlen(out)*sizeof(char));
      //santaUp=0;//set this so a thread that is waiting for santa to wake up can be release from its while loop
      //elfCond.Signal();
      //once the last elf gets answered, he signals anyone waiting for santa to be available
     
       //debug
      /*sprintf(out, "         Elf %d returned to work LAST ONE is going to signal waiting ones\n", elfId);
  write(1, out, strlen(out)*sizeof(char));*/
     /*for (int i = 0; i < totElves; ++i)
     {
       
      santaAv.Signal();
     }*/
     
      /*sprintf(out, "         Elf %d returned to work LAST ONE\n", elfId);
  write(1, out, strlen(out)*sizeof(char));*/
    }
    else{
      //debug
     /* sprintf(out, "         Elf %d returned to work\n", elfId);
  write(1, out, strlen(out)*sizeof(char));*/
    }

     //debug
      /*sprintf(out, "         Elf %d signals santaAv\n", elfId);
  write(1, out, strlen(out)*sizeof(char));*/

  for (int i = 0; i < totElves+totDeer; ++i)
  {
    /* code */
    santaAv.Signal();
  }
      
  MonitorEnd();
}

/*
FUNCTION  ChristmasMonitor::Sleep(): (function name)  
  Called by santa to regiester that he is asleep and wait to be woken up by either the reindeer or the elves
PARAMETER USAGE : 

FUNCTION CALLED :  
    wait(), signal(), sprintf, write
*/
void ChristmasMonitor::Sleep()
{
  MonitorBegin();


  santaUp=0;
  //debug
  /*sprintf(out, "Santa is not up\n");
  write(1, out, strlen(out)*sizeof(char));*/

  santa.Wait();
  santaUp=1;
 if (AllDeerBack()){
        //if the reindeer are all back go on a trip

        //first release all the reindeer waiting in the warming hut
        LoadSleigh();
        FlyOff();

      }
      
      if (ewq==3)
      {
        //answer the elves questions, and release them
          //debug
/*  sprintf(out, "Santa answers question\n");
  write(1, out, strlen(out)*sizeof(char));*/
        AnswerQuestion();
        //compTrips++;//REMOVE LATER
        //debug
       /* sprintf(out, "Santa helped elves %d times\n", compTrips);
    write(1, out, strlen(out)*sizeof(char));*/

      }
      
      if (SantaRetired())
      {
        sprintf(out, "After (%d) deliveries, Santa retires and is on vacation!\n", tripsComp);
  write(1, out, strlen(out)*sizeof(char));
        /* code */
      }
  //debug
  /*sprintf(out, "Santa is up\n");
  write(1, out, strlen(out)*sizeof(char));*/
  
  //debug
 /* sprintf(out, "Santa is done sleeping\n");
  write(1, out, strlen(out)*sizeof(char));*/
  
  MonitorEnd();
}
/*
FUNCTION  ChristmasMonitor::AllDeerBack: (function name)  
  Called by santa and reindeer to check if all of the reindeer are back from vacation
PARAMETER USAGE : 
  

FUNCTION CALLED :  
    
*/
int ChristmasMonitor::AllDeerBack()
{
  if (deerBack==totDeer)
    return 1;

  else
    return 0;
}

/*
FUNCTION  ChristmasMonitor::AnswerQuestion: (function name)  
  Called by santa so he can answer the question and release each elf
PARAMETER USAGE : 

FUNCTION CALLED :  
    signal(), sprintf, write
*/
void ChristmasMonitor::AnswerQuestion()
{
  //MonitorBegin();

  sprintf(out, "Santa is helping elves\n");
      write(1, out, strlen(out)*sizeof(char));
  sprintf(out, "Santa answers the question posted by elves %d, %d, %d \n", waitingElves[0], waitingElves[1], waitingElves[2]);
      write(1, out, strlen(out)*sizeof(char));

 elf.Signal();
 elf.Signal();
 elf.Signal();
//santa should release waiting reindeer
 //deer.Signal();
  //MonitorEnd();
}

/*
FUNCTION  ChristmasMonitor::ReindeerBack: (function name)  
  Called by each reindeer to register that he is back from vacation and if he is the last one then wake up santa, 
  otherwise wait for the rest to get back
PARAMETER USAGE : 
  x-the personal id of the reindeer that has returned

FUNCTION CALLED :  
    wait(), signal(), sprintf, write
*/
void ChristmasMonitor::ReindeerBack(int x){
MonitorBegin();

while(santaUp){//reindeer must wait until santa is asleep before registering that they are back
     
     /*sprintf(out, "    Reindeer %d is waiting for santa to be available\n", x);
  write(1, out, strlen(out)*sizeof(char));*/
      santaAv.Wait();
      /*if (deerBack<totDeer-1 && deerBack>0){
        sprintf(out, "    Reindeer %d is waiting on deer\n", x);
  write(1, out, strlen(out)*sizeof(char));
       deer.Wait();//if santa is up when the last deer gets back, then he is answering elves questions or he could not have gotten to go back to sleep after releasing all reindeer
      }
      
      else{
        sprintf(out, "    Reindeer %d is waiting on elves\n", x);
  write(1, out, strlen(out)*sizeof(char));
        elfCond.Wait();
      }*/
    
    }
sprintf(out, "    Reindeer %d returns\n", x);
  write(1, out, strlen(out)*sizeof(char));
      
  deerBack++;
  if (deerBack==totDeer)
  {

    
    
    sprintf(out, "    The last reindeer %d wakes up santa\n", x);
  write(1, out, strlen(out)*sizeof(char));
    santa.Signal();
  }
  else{
    WaitOthers();
  }
  //all will wait to be released by Santa
  WaitSleigh();
  deerBack--;
  if (deerBack==0)
  {
    //debug
  /*sprintf(out, "    Reindeer %d goes on vacation LAST ONE\n", x);
  write(1, out, strlen(out)*sizeof(char));*/
    /*for (int i = 0; i < totDeer; ++i)
     {
      
      santaAv.Signal();
     }*/
   // santaAv.Signal();
  }
    //debug
  /*sprintf(out, "    Reindeer %d singals santaAv\n", x);
  write(1, out, strlen(out)*sizeof(char));*/
  for (int i = 0; i < totDeer+totElves; ++i)
  {
    /* code */
    santaAv.Signal();
  }
 // santaAv.Signal();
  //debug
  /*sprintf(out, "    Reindeer %d goes on vacation\n", x);
  write(1, out, strlen(out)*sizeof(char));*/
MonitorEnd();
}

/*
FUNCTION  ChristmasMonitor::WaitOthers: (function name)  
  Called by reindeer when they are not the last to get back, so they wait for the rest to return
PARAMETER USAGE : 

FUNCTION CALLED :  
    wait()
*/
void ChristmasMonitor::WaitOthers(){
  warmingHut.Wait();//santa will signal this
}

/*
FUNCTION  ChristmasMonitor::WaitSleigh: (function name)  
  Called by all the reindeer once they are released from the warming hut, they call this to wait on santa to release them back on vacation
PARAMETER USAGE : 

FUNCTION CALLED :  
  signal(), sprintf, write
*/
void ChristmasMonitor::WaitSleigh(){
  
 goAway.Wait();

}
/*
FUNCTION  ChristmasMonitor::FlyOff: (function name)  
  Called by santa when all the reindeer are on the sleigh and he can deliver toys
PARAMETER USAGE : 

FUNCTION CALLED :  
     signal(), sprintf, write
*/
void ChristmasMonitor::FlyOff(){

 // MonitorBegin();
   //when santa starts this trip, account for it
  tripsComp++;
  sprintf(out, "The team flies off (%d)!\n", tripsComp);
  write(1, out, strlen(out)*sizeof(char));
  //once the trip is completed, release all reindeer back on vacation
  
  for (int i = 0; i < totDeer; ++i){
    /*sprintf(out, "Santa released a deer %d times\n", i);
  write(1, out, strlen(out)*sizeof(char));*/
    goAway.Signal();
  }
  //MonitorEnd();
}

/*
FUNCTION  ChristmasMonitor::LoadSleigh: (function name)  
    santa will call this function to signal all the reindeer waiting in the warming hut
PARAMETER USAGE : 

FUNCTION CALLED :  
     signal(), sprintf, write
*/

void ChristmasMonitor::LoadSleigh(){
//MonitorBegin();
 sprintf(out, "Santa is preparing the sleighs\n");
  write(1, out, strlen(out)*sizeof(char));
  for (int i = 0; i < totDeer-1; ++i)
  {
    warmingHut.Signal();
  }
//MonitorEnd();
}