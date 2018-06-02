class demoprintf
{
  public static void main(String [] args)
  {
    double x = 123.4567898765;
	 System.out.println("x:" + x);
	 System.out.printf("x: %f\n", x);
	 System.out.printf("x: %.2f\n", x);
	 System.out.printf("x: %10.2f\n", x);
	 int m = 3;
	 int y = 22;
	 int sum = m + y;
	 System.out.printf("%d plus %d is %d\n", m, y, sum);
	 double pay = 2355.90;
	 System.out.printf("Twice %,.2f is %,2f\n", pay, 2 * pay);
	 System.out.printf("%c is the favorite character of %s\n", 'C', "bob");
	 System.out.printf("%5d %6.1f\n", 300, 19.3333);
	 System.out.printf("%5d %6.1f\n", 1, 1.0);
	 System.out.printf("%5d %6.1f\n", 3232, 3232.322);
	 
  }
  
}