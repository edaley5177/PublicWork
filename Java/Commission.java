import java.util.Scanner;
class Commission
/**
  Author Eamonn Daley
  Date 2/8/2013
*/
{
  public static void main(String[] args)
  {
    System.out.println("Enter your total sales for this month:");
    double sales = 4.3;
    Scanner scan = new Scanner(System.in);
	 sales = scan.nextDouble();
	  if (sales < 0)
	 {
	   System.out.println("Error must be zero or higher");
	 }
	 if (sales >= 3000)
	 {
	   System.out.println("Conragulations you get a 100$ bonus!!!");
		sales = (sales + 100);
		System.out.println(sales);
	   System.out.println("Your pay for this month:\n Base pay: 500");
	   System.out.println("Commission on " + sales + " is " + sales * .1);
		System.out.println("Total pay: " + (sales + (sales *.1) + 500));
	 }
	 else
	 {
	   System.out.println(sales);
	   System.out.println("Your pay for this month:\n Base pay: 500");
	   System.out.println("Commission on " + sales + " is " + sales * .1);
		System.out.println("Total pay: " + (sales + (sales *.1)));
	   
	 }
  }
}
