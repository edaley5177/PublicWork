// ----------------------------------------------------------- 
// NAME : Eamonn Daley                         User ID: edaley 
// DUE DATE : 04/06/2018                                       
// PROGRAM ASSIGNMENT #4                                        
// FILE NAME : thread.h (your unix file name)            
// PROGRAM PURPOSE :                                           
//   header file for threads can be reindeer, elf or santa       
// ----------------------------------------------------------- 

#ifndef _CHRISTMASTHREAD_H
#define _CHRISTMASTHREAD_H

// header file
#include "ThreadClass.h"
//#include "thread-support.h"
class SantaThread: public Thread
{
   public:
      SantaThread(int threadId, int t, int r);
      
      
   private:
    void ThreadFunc();
    void Sleep();
    void FlyOff();
    int persId;
    int trips;
    int deer;
    int compTrips;
   
};

class ElfThread: public Thread
{
  public:
	 ElfThread(int threadId);
	 
  private:
	 void ThreadFunc();
   void AskQuestion();
	 int persId;
};

class ReindeerThread: public Thread
{
  public:
     ReindeerThread(int threadId, int td);
	   
  private:
	 void ThreadFunc();
   void ReindeerBack();
   void WaitOthers();
   void WaitSleigh();
	 int persId;
   int totDeer;
};

#endif