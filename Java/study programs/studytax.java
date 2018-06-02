import java.util.*;
class studytax
{
  public static void main(String[] args)
  {
    System.out.println("What was the cost of your purchase?");
    Scanner scan = new Scanner(System.in);
    double price;
	 price = scan.nextDouble();
	 double taxrate = .06;
	 double tax;
	 tax = price * taxrate;
	 System.out.println("The tax on that " + price + " purchase is " + tax); 
  }
 
}