public class city
{
  public static void main(String[] args)
  
  {
    Bus city = new Bus();
	 Bus school = new Bus();
	 //Bus airport = new Bus();
	 city.set(3);
	 city.oneMoreAboard();
	 //Scanner scan = new Scanner(System.in);
	 //int i = scan.nextInt();
  }
 
}
class Bus
{
  private int passengers;
  
  public Bus(int start)
  {
    if (start >= 0 && start <= 30)
      passenger = start;
    else
	   passengers = 0;
	 
  }
  public void set(int num)
  {
     if (num >= 0 && num <= 30)
	    passengers = num;
  }
  public void oneMoreAboard()
  {
    passengers++;
  } 
} 