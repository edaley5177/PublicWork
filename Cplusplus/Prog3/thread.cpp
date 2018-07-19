// ----------------------------------------------------------- 
// NAME: Eamonn Daley                         User ID: edaley 
// DUE DATE: 03/23/2018                                       
// PROGRAM ASSIGNMENT 3                                        
// FILE NAME: thread.cpp (your unix file name)            
// PROGRAM PURPOSE: 
//    this is the implementation file for each thread, it tells each thread what to do         
// ----------------------------------------------------------- 




#include <iostream>
#include "thread.h"
#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>

#define FALSE 0
#define TRUE 1
//---------------------------------------------------------------//
//  PassThread Class: 
//     constructor
//---------------------------------------------------------------//

PassThread::PassThread(int threadInd, int array[])
    :globInd(threadInd), sort(array)
{
  ThreadName.seekp(0, ios::beg);
     ThreadName << "My index is "<<threadInd <<'\0';
}

//---------------------------------------------------------------//
//  PassThread Class body: 
//     each thread looks at 2 numbers in the array and swaps if neccessary
//---------------------------------------------------------------//

void PassThread::ThreadFunc()
{
  Thread::ThreadFunc();
    
    //change to sprintf
    printf("        Thread %d Created\n", globInd);
   // cout << "        Thread "<<globInd <<" Created"<<endl;
    Swap=FALSE;

      printf("        Thread %d, compares x[%d] and x[%d] \n",globInd, globInd, globInd-1);

      if (sort[globInd-1] > sort[globInd]) {
        	int temp;
            temp= sort[globInd-1];
            sort[globInd-1]= sort[globInd];
            sort[globInd]= temp;
            Swap= TRUE;
            printf("        Thread %d, swaps x[%d] and x[%d] \n",globInd, globInd, globInd-1);
          }
          printf("        Thread %d exits\n", globInd);
    Exit(); 
}
