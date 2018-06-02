import java.util.*;

public class SalesTax
{
   public static void main(String [] args)
   {
	  Scanner keyboard = new Scanner(System.in);
     double spent = 25;
	  System.out.println("how much money did you spend?");
	  spent = keyboard.nextDouble();
	  spent = spent * .06;
	  System.out.println("total tax on purchase is " + spent);

   }
}

