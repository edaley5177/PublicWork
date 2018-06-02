/**
Author: Eamonn Daley
Date: 2/18/2013
*/

import java.util.*;
class BarChart
{
  public static void main(String[] args)
  {
    System.out.println("Enter today's sales for store 1:");
	 Scanner scan = new Scanner(System.in);
	 int sales1 = 0;
	 int sales2 = 0;
	 int sales3 = 0;
	 sales1 = scan.nextInt();
	 while (sales1 < 0)
	 {
	   System.out.println("Error must enter a positive number.");
		sales1 = sales1 + (sales1 * 2 + sales1);
		System.out.println("Enter today's sales for store 1:");
		sales1 = scan.nextInt();
		
		
	 }

	 System.out.println("Enter today's sales for store 2:");
	 sales2 = scan.nextInt();
	 while (sales2 < 0)
	 {
	   System.out.println("Error must enter a positive number.");
		sales2 = sales2 + (sales2 * 2 + sales2);
		System.out.println("Enter today's sales for store 2");
		sales2 = scan.nextInt();
	 }

	 System.out.println("Enter today's sales for store 3:");
	 sales3 = scan.nextInt();
	 while (sales3 < 0)
	 {
	   System.out.println("Error must enter a positive number.");
		sales3 = sales3 + (sales3 * 2 + sales3);
		System.out.println("Enter today's sales for store 3");
		sales3 = scan.nextInt();
	 } 
	 System.out.print("Store1:");
	 while (sales1 >= 10)
	 {
      System.out.print("*********x");
	 	sales1 -= 10;
	 }
    if (sales1 == 1)
	 {
      System.out.print("*");
    }
    if (sales1 == 2)
	 {
		System.out.print("**");
	 }
	 if (sales1 == 3)
	 {
	   System.out.print("***");
	 }
	 if (sales1 == 4)
	 {
	   System.out.print("****");
	 }
	 if (sales1 == 5)
	 {
	   System.out.print("*****");
	 }
	 if (sales1 == 6)
	 {
	   System.out.print("******");
	 }
	 if (sales1 == 7)
	 {
	   System.out.print("*******");
	 }
	 if (sales1 == 8)
	 {
	   System.out.print("********");
	 }
	 if (sales1 == 9)
	 {
	   System.out.print("*********");
	 }
	 System.out.print("\nStore2:");
	 while (sales2 >= 10)
	 {
      System.out.print("*********x");
	   sales2 -= 10;
	 }
	 if (sales2 == 1)
	 {
      System.out.print("*");
	 }
	 if (sales2 == 2)
	 {
	   System.out.print("**");
	 }
    if (sales2 == 3)
	 {
      System.out.print("***");
	 }
	 if (sales2 == 4)
	 {
	   System.out.print("****");
    }
	 if (sales2 == 5)
	 {
	   System.out.print("*****");
	 }
	 if (sales2 == 6)
	 {
	   System.out.print("******");
	 }
	 if (sales2 == 7)
	 {
	   System.out.print("*******");
	 }
	 if (sales2 == 8)
	 {
	   System.out.print("********");
	 }
	 if (sales2 == 9)
	 {
   	System.out.print("*********");
	 }
	 System.out.print("\nStore3:");
    while (sales3 >= 10)
    {
	   System.out.print("*********x");
		sales3 -= 10;
    }
	 if (sales3 == 1)
	 {
      System.out.print("*");
	 }
	 if (sales3 == 2)
	 {
	   System.out.print("**");
	 }
	 if (sales3 == 3)
	 {
	   System.out.print("***");
	 }
	 if (sales3 == 4)
	 {
	   System.out.print("****");
	 }
	 if (sales3 == 5)
	 {
	   System.out.print("*****");
	 }
	 if (sales3 == 6)
	 {
	   System.out.print("******");
	 }
	 if (sales3 == 7)
	 {
	   System.out.print("*******");
	 }
	 if (sales3 == 8)
	 {
	   System.out.print("********");
	 }
	 if (sales3 == 9)
	 {
	   System.out.print("*********");
	 }
	 }
  }