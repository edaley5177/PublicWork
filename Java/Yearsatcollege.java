import java.util.*;
class Yearsatcollege
{
  public static void main(String [] args)
  {
    System.out.println("how many years have you been in college?");
    int years;
	 Scanner scan = new Scanner(System.in);
	 years = scan.nextInt();
	 if (years == 1)
	 {
	   System.out.println("freshman");
	 }
	 if (years == 2 )
	 {
	   System.out.println("sophomore");
	 }
	 if (years == 3)
	 {
	   System.out.println("Junior");
	 }
	 if (years == 4)
	 {
	   System.out.println("Senior");
	 }
	 else
	 {
	   System.out.println("invalid data");
	 }
	 
  }
  
}