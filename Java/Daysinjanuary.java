import java.util.Scanner;
class Daysinjanuary
/**
 Eamonn Daley
 1.30.2013
*/
{
  public static void main(String[] args)
  {
    System.out.println("How many days are in january? Don't enter a decimal");
    Scanner scan = new Scanner(System.in);
	 int days = 30;
	 days = scan.nextInt();
	 if (days < 31 || days > 31)
	 {
	   System.out.println("Wrong!");
	 }
	 else 
	 {
	   System.out.println("Correct!");
    }
  }
}