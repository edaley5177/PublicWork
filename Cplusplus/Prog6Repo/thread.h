// ----------------------------------------------------------- 
// NAME : Eamonn Daley                         User ID: edaley 
// DUE DATE : 04/27/2018                                       
// PROGRAM ASSIGNMENT 6                                        
// FILE NAME : thread.h           
// PROGRAM PURPOSE :                                           
//    Header file for prime finding threads       
// ----------------------------------------------------------- 

#ifndef PRIME_THREAD 
#define PRIME_THREAD

#include <iostream>
#include "ThreadClass.h"
const int NOT_DEFINED  = -2;
const int END = -1;

class PrimeThread : public Thread
{
	public: 
		PrimeThread(int threadId, int ind, int spacesToAdd, int x);
		~PrimeThread();
		SynOneToOneChannel *mailbox;//the channel it uses to recieve a number from 
		
	private:
		void ThreadFunc();
		//int persId;
		int index;//where this thread should store the prime number in the global array
		int number;//number passed in from predecessor
		int spaces;//the number of spaces to add to the beginning of everything this thread prints
		int nid;//id of my neighbor
		int cid;//id of my creator
		PrimeThread *neighbor;

};

class MasterThread: public Thread
{
	public:
		MasterThread(int threadId, int n);
		int limit;//the number passed in from console
	private:
		void ThreadFunc();
};
#endif