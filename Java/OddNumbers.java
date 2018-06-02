import java.util.*;
class OddNumbers
{
  public static void main(String[] args)
  
 {
   //ask user for numbers
	System.out.println("give me some numbers end with -1");
	int num;
	int odd = 0;
	Scanner scan = new Scanner(System.in);
	num = scan.nextInt(); 
	while (num != -1)
	{
	  if (num % 2 == 1)
	  odd ++;
	  //if it is odd increment odd number
	 num = scan.nextInt();
	}
   System.out.println("There were odd numbers" in );
	System.out.println(num);
	System.out.println(odd);
	
	//give that number to the user
	
 }
}