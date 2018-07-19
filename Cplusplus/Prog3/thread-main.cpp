// ----------------------------------------------------------- 
// NAME : Eamonn Daley                         User ID: edaley 
// DUE DATE : 03/23/2018                                       
// PROGRAM ASSIGNMENT 3                                        
// FILE NAME : thread-main.cpp (your unix file name)            
// PROGRAM PURPOSE :                                           
//    this is the main program that creates and terminates all threads        
// ----------------------------------------------------------- 


#include <iostream>
#include "thread.h"
#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>


#define Even 0
#define Odd 1
#define FALSE 0
#define TRUE 1

//int  Sort(int , int [], int, PassThread *[]);
//---------------------------------------------------------------//
//  main program 
//---------------------------------------------------------------//

int arrSize, Swapped;
int *poopy;
int main(int argc, char *argv[])
{
    printf("Concurrent Even-Odd Sort \n");

    //first get main to read in the numbers from a file, and save them directly into the array
    int i, pass,j;
    cin >> arrSize;

    printf("Number of input data = %d \n", arrSize);
    poopy = new int[arrSize];

    int k=0;//used to only print 20 numbers per line
    for (i = 0; i < arrSize; i++)
          cin >> poopy[i];

      printf("Input array: \n");
      for (i = 0; i < arrSize; i++){
        k++;
        if (k>20)
            {
                k=0;
                printf("\n");
            }
            printf("%4d", poopy[i]);
      }
    printf("\n");
    PassThread *threads[arrSize];

i=0;
Swapped = TRUE;
    while (Swapped) {
        printf("Iteration %d :\n",i );
    Swapped = FALSE;
     pass=i%2;
     //first create and begin all threads

     if (pass ==0)
        printf("Even Pass:\n");
       
    else
        printf("Odd Pass:\n");
     
        for (j = 1+pass; j < arrSize; j += 2)
        {
            threads[j]= new PassThread(j, poopy);
            threads[j]->Begin();
        }

        for (j = 1+pass; j < arrSize; j+=2)
         {
            
            threads[j]->Join();
            if (threads[j]->Swap ==TRUE)
                Swapped=TRUE;     
        }

        printf("Result after iteration %d :\n", i);
        k=0;
        for (j = 0; j < arrSize; ++j)
        {
            k++;
            printf("%4d", poopy[j]);
            //to make sure i don't print more than 20 numbers per line
            if (k>20)
            {
                k=0;
                printf("\n");
               
            }
        }
        printf("\n");
    i++;
    }

    printf("Final Result after iteration %d :\n", i-1);
    k=0;
        for (j = 0; j < arrSize; ++j)
        {
            k++;
            printf("%4d", poopy[j]);
        
             if (k>20)
            {
                k=0;
                printf("\n");
            }
        }
        printf("\n");
     return 0;
}