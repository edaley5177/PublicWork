// ----------------------------------------------------------- 
// NAME : Eamonn Daley                         User ID: edaley 
// DUE DATE : 04/27/2018                                       
// PROGRAM ASSIGNMENT 6                                        
// FILE NAME : thread-main.cpp           
// PROGRAM PURPOSE :                                           
//    main file that creates and begins the master thread and the first prime thread       
// ----------------------------------------------------------- 

#include <iostream>
#include <string.h>
#include "ThreadClass.h"
#include "thread.h"

PrimeThread *firstPrimeThread;
int *primes;
int main(int argc, char const *argv[])
{
	
	int n;
	if (argc==2)
		n=atoi(argv[1]);
	else
		n=30;//default of 30 of no argument given
	
	primes=new int[n];
	MasterThread *master;

	firstPrimeThread= new PrimeThread(2, 0, 3, 1);
	firstPrimeThread->Begin();

	master = new MasterThread(1, n);
	master->Begin();

	master->Join();
	//master will join with the first prime thread

	Exit();
	return 0;
}