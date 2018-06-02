class methods
{
  public static void main(String[] args)
  {
     doubleIt(167);
	  doubleIt(31);
	  doubleIt(49);
  }
  static void doubleIt(int val)
  {
    int twice;
	 twice = val * 2;
	 System.out.println("Twice " + val + " is " + twice);
  }
}