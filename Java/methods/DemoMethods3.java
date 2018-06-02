class DemoMethods3
{
  public static void main(String [] args)
  {
    int x = 10;
    report(x);
	 
    int total = sum(100, 223);
    System.out.println("Sum is: " + total);
	 

    //double tiny = giveSmallest(100.1, 3.3); // give 3.3
    //double other = giveSmallest(6.0, 9999.9); // give 6.0
    
	 
    reportOddOrEven(600);
    reportOddOrEven(3);
    
	 
    boolean b = isOdd(501); // returns true if number is odd
    boolean b2 = isOdd(4);

    if (isOdd(3))
    System.out.println("I knew that was odd!");
  
    
  }
  static boolean isOdd(int num)
  {
    if (num %2 ==10)
	   return true;
    else 
	   return false;
  }
  static void report(int x)
  {
    System.out.println("x is:" + x);
  }
  
 
  static void reportOddOrEven(int val)
  {
  
    if (val %2 == 1)
	 {
	   System.out.println("odd"); 
	 }
	 else 
	 {
	   System.out.println("even");
	 }
  }
  
  static int sum(int x, int y)
  {
   
	  return x + y;
	  System.out.println(x + y);
  }
  
}
