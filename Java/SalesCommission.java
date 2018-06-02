import java.util.*;
class Commission

/**
  author Eamonn Daley
  Date 2/8/2013
*/
{
  public static void main(String[] args)
  {
    System.out.println("Enter your total sales for this month:");
    double sales = 4.3;
    Scanner scan = new Scanner(System.in);
	 sales = scan.nextDouble();
	 System.out.println(sales);
	 System.out.println("Your pay for this month:\n Base pay: 500");
	 System.out.println("commission on " + sales + "is " + sales * .1);
	 
  }
}
