import java.util.*;
class LoopsFilesDemo2
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
	 int sum = 0;
	 int num;
	 System.out.println("Give me some to add (End with a -1)");
	 num = scan.nextInt();
	 while (num != -1)
	 {
	   sum += num;
		num = scan.nextInt();
	 }
	 
	 System.out.println("the sum is " + sum);
  }
}