class Road
{
  public static void main(String [] args)
  {
    Car fancy = new Car(1000);
	 car old = new Car(25000);
	 
	 fancy.drive(5);
	 fancy.drive(2);
	 fancy.report();
	 old.report();
	 ForsaleCar goodDeal = new ForSaleCar(3500.00, 10500);
  }

}