import java.lang.Math;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
//import Eamonn.BlackJack.Card; will work on later 
//create card object
public class CardCounter{
    
   //the number of cards of each type left in the shoe 
   public static int cardsLeft[] = new int[10];//the number of decks in the shoe initially
   public static int decks; //the card i am currently looking at, used when reading in all cards already played
   public static String currCard = "  "; //has 3 characters
   public static int cardsInShoe; //the number of cards remaining to be dealt out 
   public static String dc[] = new String[1];//an array of one string that is the dealer's card
   public static int cardsOver8Left = 0;//will calculate number of cards 8 or higher left in the deck
   public static double probOfHigh = 0.0;    //will be used to calculate what to do next based on this
   public static int myTotal = 0;
   public static String myCards[] = new String[5];//if we have 5 cards 5 card charlie and get out of while loop
   public static int numOfCards = 0;
   public static String stand = "Stand";
   public static String hit = "Hit";  //these are here so i know if one of these 4 aren't returned from a function, something went wrong
   public static String dd = "Double Down";
   public static String split = "Split";
   public static boolean haveAce = false; 
   //public static String actionToTake;//what to do
  
  public static void main(String[] args){
   
    
    //if a function returns something other than one of these 4 strings, error!!
    System.out.println("Enter your the number of decks: ");
    Scanner decksScanner = new Scanner(System.in);
     decks = decksScanner.nextInt();
    //this intializes cards left array spots to teh right numbers
    for(int i =0;i<9;i++){
      cardsLeft[i] = decks*4;
    }
     cardsLeft[9]  = decks*16;
    cardsInShoe = decks*52;
     //to set up how many times my loop will run
    System.out.println("How many cards have been played already?");
    Scanner cardsPlayedScanner = new Scanner(System.in);
    int cardsPlayed = cardsPlayedScanner.nextInt();
    if(cardsPlayed >cardsInShoe){
      System.out.println("Too many, not possible!");
    }
     //now a loop to scan in  all the cards that have been played
     System.out.println("What cards are those?");
    int cardsScanned = 0;
    Scanner cardScanner = new Scanner(System.in);
    while(cardsScanned <cardsPlayed){
      currCard = cardScanner.nextLine();
      String card[] = new String[1];
      card[0] = currCard;
      boolean ne =  updateCounts(card);
      if(ne == false){
        System.out.println("Last card was invalid please try again");
        return;
      }
      cardsScanned++;
    }
    for(int i =7; i<=9;i++){
      cardsOver8Left +=cardsLeft[i]; 
    }
    
    System.out.println("How many cards do I have?");
    Scanner numScanner = new Scanner(System.in);
     int numCards = numScanner.nextInt();//only add to numOfCards when i update my total
    System.out.println("What are they?");
    String mc[] = new String[2];
    for(int i =0; i<numCards;i++){
       Scanner ncScan = new Scanner(System.in);
    String nextCard = ncScan.nextLine();
      mc[i] = nextCard;
      
    }
    updateMyTotal(mc);
    System.out.println("What card does the dealer have showing?");
    Scanner dealerCardScanner = new Scanner(System.in);
    String dealerCard = dealerCardScanner.nextLine();
    char rdc = dealerCard.charAt(0);
    dc[0]=dealerCard;
    updateCounts(dc);
    //now look at my cards and dealer's card, update the counts, and get my total 
   
    //is the chance that a 8 or higher card will be dealt next
     probOfHigh = (cardsOver8Left*1.0)/(cardsInShoe*1.0);
    System.out.println("probability of high is " + probOfHigh);
    String nextAction = "             ";//the next thing that the computer suggests i should do
    boolean haveSplit = false;
    int t =0;
    while(myTotal<21 && numOfCards<=4 && t<100){
      Scanner  nextCardScanD = new Scanner(System.in);
          String nextCardD;// = nextCardScanD.nextLine();
             String ncd[] = new String[1];
      System.out.println("my total is "+myTotal);
      t++;//prevents infinite loop
     if(numOfCards == 2 && myCards[0].charAt(0) == myCards[1].charAt(0)  && !haveSplit){
        //if i only have 2 cards and i have a pair
        //add bool have split, says if i have split this turn, i can only split once per turn
        //this won't get called if i have split
         nextAction = seeIfSplit(myCards);//method that will return a string that determines what i should do if i can split my cards
         System.out.println(nextAction);
         switch(nextAction){
           case "Hit":
             //update my total,the number of cards i have, the myCards arrray,
             //and the counts. All of this is done in update my total function
             //i don't need the if hit and if dd functions
             System.out.println("What card did you get?");
          nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
             updateMyTotal(ncd);
             break;
           case "Split":
             //work on later
             System.out.println("Said to split");
             haveSplit = true;
             return;
             
           case "Stand":
            return;
           case "Double Down":
             System.out.println("What card did you get?");
          nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
             updateMyTotal(ncd);
             return;
           default:
             System.out.println("a function said something other than hit stand split or dd ERROR!!!");
             return;
         }
      }
    //if i don't have a pair, see what my total is and go from there
   else if(myTotal >=13 && myTotal<=16 && haveAce ==false){
      if(probOfHigh>=.25){
        System.out.println(stand);
        return;
      }
        else{
            System.out.println(hit);
            System.out.println("What card did you get?");
           /*if( ifHit(numOfCards+1) !=0){
              System.out.println("if hit was called with wrong # cards");
            }*/
          
        }
    }
      else if(myTotal>=17 && haveAce ==false){
       System.out.println(stand);
       return;
     }
      else if(haveAce==true && numOfCards ==2){
        //see what other card is
        String othCard;
        if(myCards[0].charAt(0) !='A'){
          othCard = myCards[0];
        }
        else{
          othCard = myCards[1];
        }
        
        switch(othCard.charAt(0)){
          case '2':
          case '3':
            switch(rdc){
            case '4':
              if(probOfHigh >.25){
                System.out.println(stand);
                return;
              }
              else{  
                System.out.println(hit);
                System.out.println("What card did you get?");
                 nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
                updateMyTotal(ncd);
              }
              break;
            case '5':
            case '6':
              System.out.println(dd);
              System.out.println("What card did you get?");
                 nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
                updateMyTotal(ncd);
              return;
            default:
            System.out.println(hit);
            System.out.println("What card did you get?");
                 nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
                updateMyTotal(ncd);
            break;  
          }
          case '4':
          case '5':
            if(rdc =='4' || rdc =='5' || rdc =='6'){
              System.out.println(dd);
              System.out.println("What card did you get?");
               nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
              updateMyTotal(ncd);
              return;
            }
            else{
              System.out.println(hit);
              System.out.println("What card did you get?");
               nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
              updateMyTotal(ncd);
            }
            break;
          case '6':
            if(rdc =='2'){
              if(probOfHigh >.25){
             System.out.println(dd);
              System.out.println("What card did you get?");
              nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
                updateMyTotal(ncd);
              return;
              }
              else{
              System.out.println(hit);
              System.out.println("What card did you get?");
                nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
                updateMyTotal(ncd);
              }
            }
            else if(rdc >='3' && rdc <='6'){
              System.out.println(dd);
              System.out.println("What card did you get?");
              nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
                updateMyTotal(ncd);       
              return;
            }
            else{
              System.out.println(hit);
              System.out.println("What card did you get?");
              nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
                updateMyTotal(ncd);
            }
            break;
          case '7':
            if(rdc == '2' || rdc =='7' || rdc =='8'){
              System.out.println(stand);
              return;
            }
            else if(rdc >='3' && rdc <='6'){
              System.out.println(dd);
              System.out.println("What card did you get?");
              nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
                updateMyTotal(ncd);      
              return;
            }
            else{
              System.out.println(hit);
              System.out.println("What card did you get?");
             nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
                updateMyTotal(ncd);
            }
            break;
          case '8':
          case '9':
            System.out.println(stand);
            return;
          default:
            System.out.println("the other card is invalid");
            return;
        }
      }
      else if(myTotal <8){
        System.out.println(hit);
        System.out.println("What card did you get?");
         nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
             updateMyTotal(ncd);
      }
      else if(myTotal ==8){
        if(rdc =='5' || rdc=='6'){
          System.out.println(dd);
          System.out.println("What card did you get?");
           nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
             updateMyTotal(ncd);
          return;
        }
        else{
          System.out.println(hit);
          System.out.println("What card did you get?");
           nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
             updateMyTotal(ncd);
          
        }
      }
      else if(myTotal ==9){
        if(rdc >='3' && rdc<='6'){
          System.out.println(dd);
          System.out.println("What card did you get?");
           nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
             updateMyTotal(ncd);
          return;
        }
        else if(rdc =='2'){
          if(probOfHigh >=.25){
            System.out.println(dd);
          System.out.println("What card did you get?");
           nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
             updateMyTotal(ncd);
            return;
          }
          else{
            System.out.println(hit);
          System.out.println("What card did you get?");
           nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
             updateMyTotal(ncd);
          }
          
        }
        else{
          System.out.println(hit);
          System.out.println("What card did you get?");
           nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
             updateMyTotal(ncd);
        }
      }
      else if(myTotal ==10){
        if(rdc =='1' || rdc =='A'){
          System.out.println(hit);
          System.out.println("What card did you get?");
           nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
             updateMyTotal(ncd);
        }
        else{
          System.out.println(dd);
          System.out.println("What card did you get?");
           nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
             updateMyTotal(ncd);
          return;
        }
        
      }
      else if(myTotal ==11){
        if(rdc =='A'){
          if(probOfHigh >=.25){
            System.out.println(dd);
          System.out.println("What card did you get?");
           nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
             updateMyTotal(ncd);
            return;
          }
          else{
            System.out.println(hit);
          System.out.println("What card did you get?");
           nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
             updateMyTotal(ncd);
          }
        }
        else{
          System.out.println(dd);
          System.out.println("What card did you get?");
           nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
             updateMyTotal(ncd);
          return;
        }
      }
      else if(myTotal == 12){
        if(rdc>='4' && rdc<='6'){
          System.out.println(stand);
          return;
        }
        else{
          System.out.println(hit);
          System.out.println("What card did you get?");
           nextCardD = nextCardScanD.nextLine();
             ncd[0] = nextCardD;
             updateMyTotal(ncd);
        }
      }
      
      
    }
    if(myTotal >21){
    System.out.println("Busted! Sorry you have even outsmarted a computer.");
      return;
    }
    else{
      System.out.println("5 Card charlie!!");
      return;
    }
   
  }
  
   //will update counts for how many cards of each kind are left
   public static boolean updateCounts(String cards[]){
    for(int i =0; i<cards.length;i++){
      //debug
      String myCard = cards[i];
     // System.out.println("inside update counts");
      char mc = myCard.charAt(0);
      //debug
      switch(mc){
        case 'A':
          cardsInShoe-=1;
          cardsLeft[0]-=1;
          break;
        case '2':
          cardsInShoe-=1;
          cardsLeft[1]-=1;
          break;
        case '3':
          cardsInShoe-=1;
          cardsLeft[2]-=1;
          break;
        case '4':
          cardsInShoe-=1;
          cardsLeft[3]-=1;
          break;
        case '5':
          cardsInShoe-=1;
          cardsLeft[4]-=1;
          break;
        case '6':
          cardsInShoe-=1;
          cardsLeft[5]-=1;
          break;
        case '7':
          cardsInShoe-=1;
          cardsLeft[6]-=1;
          break;
        case '8':
          cardsInShoe-=1;
          cardsLeft[7]-=1;
          break;
        case '9':
          cardsInShoe-=1;
          cardsLeft[8]-=1;
          break;
        case '1':
        case 'J':
        case 'Q':
        case 'K':
          cardsInShoe-=1;
          cardsLeft[9]-=1;
          break;  
          
         default:
          return false;
         // break;
      }  
    }
    return true;
  }
  //this will update my total, the my cards array,
  //the number of cards i have, if i have an ace or not, and the counts
  public static void updateMyTotal(String myNewCards[]){
    for(int i =0; i <myNewCards.length;i++){
       myCards[numOfCards] = myNewCards[i];
      String str =myNewCards[i];
        char realCard = str.charAt(0);
      if(realCard >='1' && realCard <='9'){
        //convert to int and add to myTotal
        if(realCard == '1'){
          //add 10
          myTotal+=10;
        cardsOver8Left-=1; 
        }
        else{
          myTotal += ((int)myCards[i].charAt(0) - 48);
          if(realCard == '8' || realCard =='9'){
            //if my card is an 8 or 9 update that count
            cardsOver8Left-=1;
          }
        }
      }
      else if(realCard == 'A'){
        //add 1 or 11
        haveAce = true;
        myTotal+=11;
        if(myTotal>21){
          myTotal-=10;
        }
      }
      else{
        //add 10
        myTotal+=10;
        cardsOver8Left-=1;
      }
      numOfCards++;
    }
    updateCounts(myNewCards);
    return;
  }
  //will return what i should do if i have a pair
  public static String seeIfSplit(String myPair[]){
    char myBoth = myPair[0].charAt(0);
    char dealCard = dc[0].charAt(0);
    if(numOfCards !=2){
      return "This method only accepts 2 cards and it was called with " + myPair.length + " cards.";
    }
    //will end method if pair is not passed in
    if(myPair[0].charAt(0) != myPair[1].charAt(0)){
      return "see if split method was called with out a pair ERROR!!!";
    }
    else{
      switch(myBoth){
        case 'A':
        case '8':
          return split;
        case '2':
          if(dealCard >='2' && dealCard<='7'){
            return split;
          }
          else{
            return hit;
          }
        case '3':
          if(dealCard >='2' && dealCard >='7'){
            return split;
          }
          //if the dealer has an 8 showing, hit or split depending on the chances of a high card being next
          else if(dealCard =='8'){
            //if there is a good chance for a high card take a hit
            if(probOfHigh >=.25){
              return hit;
            }
            //if not, split 'em
            else{
              return split;
            }
            
          }
          else{
            return hit;
          }
        case '4':
          if(dealCard >='1' && dealCard <= '3' || dealCard >='7'){
            return hit;
          }
          //if you have a pair of 4s and the dealer has a 4 showing, make decision based on prob of high
          else if(dealCard == '4'){
            if(probOfHigh>=.25){
              return hit;
            }
            else{
              return split;
            }
          }
          //if the dealer's card is 5 or 6, split
          else{
            return split ;
          }
        case '5':
          //if the dealer's card is 2-9, DD
          if(dealCard>='2' && dealCard<='9'){
            return dd;
          }
          //if 10 or A just hit
          else{
            return hit;
          }
        case '6':
          if(dealCard>='2' && dealCard<='6'){
             return split;
          }
          else{
             return hit;
          }
        case '7':
          if(dealCard>='2' && dealCard <='7'){
            return split;
          }
          else{
           return hit;
          }
        default:
          return stand;
      } 
    }
  }
} 