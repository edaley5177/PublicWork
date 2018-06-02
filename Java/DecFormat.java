import java.text.*;
class DecFormat
{
  public static void main(String[] args)
  {
    DecimalFormat f = new DecimalFormat("#0.0##");
	 double x = 15.0163321;
	 System.out.println(x);
	 System.out.println(f.format(x) );
    String s = String.format("%d %03.2f", 99,2.6);
  }
}