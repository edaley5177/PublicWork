// ----------------------------------------------------------- 
// NAME : Eamonn Daley                         User ID: edaley 
// DUE DATE : 04/20/2018                                       
// PROGRAM ASSIGNMENT #5                                        
// FILE NAME : thread.h (your unix file name)            
// PROGRAM PURPOSE :                                           
//   header file for threads can be reindeer, elf or santa
//    or a monitor       
// ----------------------------------------------------------- 

#ifndef _CHRISTMASTHREAD_H
#define _CHRISTMASTHREAD_H

// header file
#include "ThreadClass.h"

// ----------------------------------------------------------- 
// FUNCTION  SantaThread : (function name)                          
//     variable declarations for the santa thread                            
// PARAMETER USAGE :                                           
//    threadId -this threads unique ID
//    e- the total number of elves, used to initalize totElves for the monitor
//    t-the total number of trips santa needs to make before retiring
//    r-the total number of reindeer santa has              
// FUNCTION CALLED :                                           
//             ThreadFunc
// ----------------------------------------------------------- 
class SantaThread: public Thread
{
   public:
      SantaThread(int threadId, int e,int t, int r);
      
      
   private:
    void ThreadFunc();
    void Sleep();
    void FlyOff();
    int elves;
    int persId;
    int trips;
    int deer;
   // int compTrips;
   
};


// ----------------------------------------------------------- 
// FUNCTION  ElfThread : (function name)                          
//     variable declarations for the elf threads                            
// PARAMETER USAGE :                                           
//    threadID- a unique id for each elf thread               
// FUNCTION CALLED :                                           
//    ThreadFunc          
// ----------------------------------------------------------- 
class ElfThread: public Thread
{
  public:
	 ElfThread(int threadId);
	 
  private:
	 void ThreadFunc();
   
	 int persId;
};

// ----------------------------------------------------------- 
// FUNCTION  ReindeerThread : (function name)                          
//     variable declarations for reindeer                           
// PARAMETER USAGE :                                           
//           threadId-a unique id for each reindeer       
// FUNCTION CALLED :                                           
//           ThreadFunc  
// ----------------------------------------------------------- 
class ReindeerThread: public Thread
{
  public:
     ReindeerThread(int threadId);
	   
  private:
	 void ThreadFunc();
   
	 int persId;
};

// ----------------------------------------------------------- 
// FUNCTION  ChristmasMonitor: (function name)                          
//     variable and function declartions for the monitor                           
// PARAMETER USAGE :                                           
//    Name-the name of the monitor               
// FUNCTION CALLED :                                           
//             
// ----------------------------------------------------------- 
class ChristmasMonitor: public Monitor
{
  public: 
    ChristmasMonitor(char* Name);
    void ReindeerBack(int x);
    void AskQuestion(int id);
    void AnswerQuestion();
    void Sleep();
    void FlyOff();
    //int SantaAsleep();
    void SetVariables(int e, int r, int t);
    int AllDeerBack();
    int SantaRetired();
    void LoadSleigh();
    int ewq;


  private:
    int totElves;
    char out[200];
    
    int totDeer;
    int deerBack;
    int dr;//the number of reindeer that have been released
    int totTrips;
    int santaUp;
    int tripsComp;
    int waitingElves[3];

    void WaitOthers();
    void WaitSleigh();
    Condition elf;
    Condition santa;
    Condition santaAv;
    Condition deer;//signaled when the last deer goes on vacation
    Condition elfCond;//used for elves to wait for santa to finish answering questions before asking their own
    Condition warmingHut;//santa signals this to tell reindeer he's ready to deliver toys
    Condition goAway;//santa signals this to tell each reindeer they can go on vacation
};

#endif