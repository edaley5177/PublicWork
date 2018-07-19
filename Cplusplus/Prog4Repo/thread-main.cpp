// ----------------------------------------------------------- 
// NAME : Eamonn Daley                         User ID: edaley 
// DUE DATE : 04/06/2018                                       
// PROGRAM ASSIGNMENT 4                                        
// FILE NAME : thread-main.cpp (your unix file name)            
// PROGRAM PURPOSE :                                           
//    this is the main program that creates and terminates all threads and reads numbers from cmd line       
// ----------------------------------------------------------- 


#include <iostream>
#include "thread.h"
#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>
int main(int argc, char *argv[])
{
	char out[200];

	int elves, deer, trips, i;
	
	elves=atoi(argv[1]);
	deer = atoi(argv[2]);
	trips=atoi(argv[3]);

	if (elves==0)
		elves =7;
	if (deer==0)
		deer = 9;
	if(trips==0)
		trips=5;

	SantaThread Santa(1, trips, deer);
	ElfThread *Elfs[elves];
	ReindeerThread *Reindeer[deer];
	//create and start santa thread
	Santa.Begin();

	//make and begin all elf threads
	
	for (i = 0; i < elves; ++i)
	{
		Elfs[i] = new ElfThread(i);
		Elfs[i]->Begin();
		/* code */
	}
	
	//make and begin all reindeer threads
	
	for (i = 0; i < deer; ++i)
	{
		Reindeer[i] = new ReindeerThread(i, deer);
		Reindeer[i]->Begin();
	}
	//only join with santa
	Santa.Join();
    Exit();
	return 0;
}