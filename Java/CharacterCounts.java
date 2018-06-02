import java.util.*;
import java.io.*;
/*
Name: Eamonn Daley
Username: edaley
Description: This program will read a text file, and ouput the number of instances of each character
*/
public class CharacterCounts{
	public static void main(String[] args) throws IOException {
		//first make sure i have only one command line argument
		if(args.length != 1){
			System.out.printf("Please provide only one command line argument that is the file name. \n");
			return;
		}
	//the name of the file to read
	String doc = args[0];
	//the array that keeps track of how many of each character there are,
	// characters ASCII code is its spot in the array
	int[] characters = new int[128];
		//this scanner is used to scan each character individually
		Scanner s = null;
		//this scanner is used to count how many lines are in the file
		Scanner ns = null;
		//first scan the document into the ns scanner
		ns = new Scanner(new BufferedReader(new FileReader(doc)));
	
		while(ns.hasNextLine()){
			characters[18]++;
			String tem = ns.nextLine();
			//count number of lines in document
			
		}
		//after while loop, number of lines is one too high 
		characters[18]--;
		//now scan into character by character scanner
		s = new Scanner(new BufferedReader(new FileReader(doc)));
		//now while loop to read in text file one character at a time and increment the right spot in array

		while(s.hasNext()){
			String st = s.next();
			//convert the word to an array of characters
			char[] currWord = st.toCharArray();
			//now a for loop to increment the right spots in the characters array
			for(int i=0; i<currWord.length;i++){
				//first get the ascii number of the character
				int f = (int)currWord[i];
			//increment that spot in the array by one 
						 characters[f]++;
			}
		
		characters[32]++;//finish while loop means i have detected white space 
			//increment space spot
		}
		//increase 32 spot every time white space is detected so subtract for new lines
		characters[32]-=characters[18];
		//because characters 18 is one less due to extra end of file as line
		characters[32]--;

		//now while loop to print out characters array
		int spot = 0;
		while(spot<128){
			//if there are 0 instances of a character don't print that out
			if(characters[spot] ==0){
				spot++;
			}
			//18 is where i counted for the new line 
			else if(spot == 18){
				System.out.printf("'\\n' %d \n",characters[spot]);
				spot++;
			}
			else{
				System.out.printf("'%s' %d\n",(char)spot,characters[spot]);
					spot++;
			}
		}
	}
}