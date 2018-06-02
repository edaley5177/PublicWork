import java.util.Scanner;

class Coffee
{
  public static void main(String[] args)
  {
     double coffee = 2.99;
	  int days = 30;
	 
	 System.out.println("How many days would you like to use for this calculation:");
	 
	 Scanner keyboard = new Scanner(System.in);
	 days = keyboard.nextInt();
	 System.out.println( "Cost for"  + days + "days is:" + coffee * days);
	 
  }
}