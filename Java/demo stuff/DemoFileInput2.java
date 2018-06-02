import java.util.*;
import java.io.*;
/**
author Eamon Daley
date 2-20-2013
*/
public class DemoFileInput2
{
  public static void main(String[] args) throws Exception
  {
    Scanner scan = new Scanner( new File("data.txt") );
	 
	 int num;
	 int sum = 0;
	 while (scan.hasNext())
	 {
	   num = scan.nextInt();
	   sum += num;
	 }
	
	 
	 PrintWriter out = new PrintWriter ("result.txt");
	 
	 
	 out.printf("Sum of all numbers %,d\n", sum);
	 out.close(); 
  }
}