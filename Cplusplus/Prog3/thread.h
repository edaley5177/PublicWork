// ----------------------------------------------------------- 
// NAME : Eamonn Daley                         User ID: edaley 
// DUE DATE : 03/23/2018                                       
// PROGRAM ASSIGNMENT 3                                        
// FILE NAME : thread.h (your unix file name)            
// PROGRAM PURPOSE :                                           
//    this is the header file for a thread        
// ----------------------------------------------------------- 

#ifndef _PASSTHREAD_H
#define _PASSTHREAD_H

// header file
#include "ThreadClass.h"
class PassThread : public Thread
{
   public:
      PassThread(int threadInd, int array[]);
      int Swap;//used to tell main if this thread swapped numbers

   private:
   void ThreadFunc();
   int globInd;
   int *sort;
   
};

#endif
