public class Car
{
  public static void main(String [] args)
  {
    private int odo;
	//rivate int amountOfArmor;
	 odo = 0;
	 public void  Car()
	 {
	 
	 }
	 public void Car(int startMiles)
	 {
	   if (startMiles >= 0)
		{
		  odo = startMiles;
		}
	 }
	 public void Drive(int miles)
	 {
	   if (miles > 0)
		{
		  odo += miles;
		}
	 }
	 public void report()
	 {
	   System.out.printf("This car has driven %d miles\n", odo);
	 }
  }
}