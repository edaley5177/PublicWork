import java.util.*;
class ReportTwice
{
  public static void main(String[] args)
  {
    System.out.println("Give me some numbers");
    int num;
    int twicenum;
    Scanner scan = new Scanner(System.in); 
	 num = scan.nextInt();
    while (num != -1)
    {
      twicenum = num * 2;
		num = scan.nextInt();
		System.out.println(num + "twice is " + twicenum);
    }
	 twicenum = num * 2;
	 System.out.println(twicenum);
	 System.out.println(num);
  }
}