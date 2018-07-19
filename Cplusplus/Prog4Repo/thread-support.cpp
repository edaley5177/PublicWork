// ----------------------------------------------------------- 
// NAME: Eamonn Daley                         User ID: edaley 
// DUE DATE: 04/06/2018                                       
// PROGRAM ASSIGNMENT 4                                        
// FILE NAME: thread-support.cpp (your unix file name)            
// PROGRAM PURPOSE: 
//    this is the implementation file for each thread method, it contatins all of the functions for the threads        
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
//#include <synch.h>
#include <stdint.h>
#include <limits.h>

//#include "thread.h"
#include "thread-support.h"
//#include "ThreadClass.h"

//---------------------------------------------------------------//
//  PassThread Class: 
//     constructor
//---------------------------------------------------------------//

/*void SupportThread::ThreadFunc()
{
  Thread::ThreadFunc();
}*/
void ElfThread::AskQuestion(){
	char out[50];
	//elf asks question
    sprintf(out, "         Elf %d has a problem\n", persId);
    write(1, out, strlen(out)*sizeof(char));
}
void ReindeerThread::ReindeerBack(){
	char out[50];
	//reindeer returns
	sprintf(out, "    Reindeer %d returns\n", persId);
    write(1, out, strlen(out)*sizeof(char));
    //return;
}
void ReindeerThread::WaitOthers(){
	//reindeer waits for the rest of the reindeer to get back
    return;
}

void ReindeerThread::WaitSleigh(){
	/*sprintf(out, "    Reindeer %d is waiting on sleigh\n", persId);
    write(1, out, strlen(out)*sizeof(char));*/
    return;
}

void SantaThread::FlyOff(){
    char out[50];
	sprintf(out, "The team flies off (%d)!\n", compTrips);
        write(1, out, strlen(out)*sizeof(char));
    return;
}
void SantaThread::Sleep(){
    return;
}
