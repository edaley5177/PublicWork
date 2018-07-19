// ----------------------------------------------------------- 
// NAME : Eamonn Daley                         User ID: edaley 
// DUE DATE : 04/27/2018                                       
// PROGRAM ASSIGNMENT 6                                        
// FILE NAME : thread.cpp           
// PROGRAM PURPOSE :                                           
//    contains implementation of the master and prime threads       
// ----------------------------------------------------------- 

#include <iostream>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <stdint.h>
#include <string.h>
#include "ThreadClass.h"
#include "thread.h"


extern PrimeThread *firstPrimeThread;
extern int *primes;
// ----------------------------------------------------------- 
// FUNCTION  strstream : (function name)                          
//     The purpose of this function, is to make an empty food tray                          
// PARAMETER USAGE :                                           
//   	n is the number of bowls that need tot be in the tray              
// FUNCTION CALLED :                                           
//              
// ----------------------------------------------------------- 
strstream *Filler(int n)
{
     int  i;
     strstream *Space;

     Space = new strstream;
     for (i = 0; i < n; i++)
          (*Space) << ' ';
     (*Space) << '\0';
     return Space;
}

PrimeThread::PrimeThread(int threadId, int ind, int spacesToAdd, int x)
{
	  ThreadName.seekp(0, ios::beg);
     ThreadName << "Prime" << threadId << ends;
     //persId=threadId;
     spaces=spacesToAdd;
     neighbor = NULL;
     number = NOT_DEFINED;
     UserDefinedThreadID = threadId;
     index=ind;
     cid =x;
     strstream ChannelName;
     ChannelName << "Channel" << index - 1 << "-" << index << ends;
     mailbox = new SynOneToOneChannel(ChannelName.str(), cid, UserDefinedThreadID);

}

PrimeThread::~PrimeThread()
{
     delete mailbox;
}

void PrimeThread::ThreadFunc()
{

	Thread::ThreadFunc();
	char out[100];
	int mine;
	int gift;
	strstream *Space;

	
	while(true){
    	
		mailbox->Receive(&mine, sizeof(int));
		
		if (mine == END){
			
			break;
		}

		if (number == NOT_DEFINED){

		 	number=mine;
		 	Space=Filler(spaces);
			primes[index]=mine;
			sprintf(out, "%sP%d starts and memorizes %d\n", Space->str(), UserDefinedThreadID, mine);
    		write(1, out, strlen(out)*sizeof(char));
		}
		else{
		

			
				Space=Filler(spaces);
				sprintf(out, "%sP%d recieves %d\n", Space->str(), UserDefinedThreadID, mine);
    			write(1, out, strlen(out)*sizeof(char));
    		
    		gift=mine;
		
			if (mine%UserDefinedThreadID ==0){
				//ignore and wait for the next number
				Space=Filler(spaces);
				sprintf(out, "%sP%d ignores %d\n", Space->str(), UserDefinedThreadID, mine);
    			write(1, out, strlen(out)*sizeof(char));
			}
		
			else{
					if (neighbor==NULL){
						nid =gift;
						sprintf(out, "%sP%d creates P%d\n", Space->str(), UserDefinedThreadID, nid);
    					write(1, out, strlen(out)*sizeof(char));
						neighbor = new PrimeThread(gift, index+1, spaces+2, UserDefinedThreadID);
						neighbor->Begin();
						Delay();
					}
				Delay();
				Space=Filler(spaces);
				sprintf(out, "%sP%d sends %d to P%d\n", Space->str(), UserDefinedThreadID, gift, nid);
    			write(1, out, strlen(out)*sizeof(char));
				neighbor->mailbox->Send(&gift, sizeof(int));
			}
		}

		
	}

	Space=Filler(spaces);
	sprintf(out, "%sP%d recieves END\n", Space->str(), UserDefinedThreadID);
    write(1, out, strlen(out)*sizeof(char));
    if (neighbor!=NULL){
    	neighbor->mailbox->Send(&mine, sizeof(int));
    	neighbor->Join();
    }
    Exit();
}

MasterThread::MasterThread(int threadID, int n)
{
	limit=n;
	UserDefinedThreadID=threadID;
     ThreadName.seekp(0, ios::beg);
     ThreadName << "Master" << ends;
}

void MasterThread::ThreadFunc()
{
	Thread::ThreadFunc();
	char out[100];

	sprintf(out, "Master starts\n");
    write(1, out, strlen(out)*sizeof(char));

    //master will fill all spots in the array with -1
    for (int i = 0; i < limit; ++i)
    	primes[i]=-1;
    
    for (int i = 2; i <= limit; ++i)
    {
    	sprintf(out, "Master sends %d to P2\n", i);
    	write(1, out, strlen(out)*sizeof(char));
    	firstPrimeThread->mailbox->Send(&i, sizeof(int));
    }
    sprintf(out, "Master sends END\n");
    write(1, out, strlen(out)*sizeof(char));
    int end=END;
    firstPrimeThread->mailbox->Send(&end, sizeof(int));


    firstPrimeThread->Join();
    //once i have joined with the first thread, print out the array
     sprintf(out, "Master prints the complete result:\n");
    write(1, out, strlen(out)*sizeof(char));
    int j=0;
    while(primes[j]!= -1){
    	 sprintf(out, "%4d", primes[j]);
    	write(1, out, strlen(out)*sizeof(char));
    	j++;
    }
    sprintf(out, "\n");
    write(1, out, strlen(out)*sizeof(char));

    sprintf(out, "Master terminates\n");
    write(1, out, strlen(out)*sizeof(char));
    Exit();
}