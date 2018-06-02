public class DemoMethods1
{
	public static void main(String [] args)
	{
		System.out.println("He was laughing");
		laugh();
		System.out.println("and");
		laugh();
		System.out.println("and also");
		laugh();
		System.out.println("On bad days, he says");
		cry();
		System.out.println("He laughed really hard");
		laugh(50);
		laugh(10);
		laugh(23);
		
		//sum(10.1, 2.2);
		//sum(1.0, 1.0);
		
		int x = y() + 2;
		int val = twice(43);
		int num = twice(100) + 2;
	}
	static int twice(int num)
	{
	  return num *2;
	}
	static void laugh()
	{
	  System.out.println("ha ha ha!!");
	  
	}
	static int y()
	{
	  return 500;
	}
	static void cry()
	{
	  System.out.println("waah!");
	}
	static void laugh(int times)
	{
	  int i = 1;
	  while (i <= times)
	  {
	    System.out.println("hahahaha" + times);
	 
	  } 
   }
	static void sum(double num1, double num2, double num3)
   {
	  double total = num1 + num2;
	  System.out.printf("%.1f + %.1f = %.1f/n", num1, num2, total);
	}
}