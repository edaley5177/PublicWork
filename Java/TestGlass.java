public class TestGlass 
{ 
   public static void main(String [] args) 
   { 
      Glass milk = new Glass(15); // 15 ounces of milk 
      Glass juice = new Glass(3); // 3 ources of juice 

      milk.drink(2); 
      milk.drink(1); 

      milk.report(); 
		

      juice.fill(6);  // went from 3 to 9 ounces 
      juice.drink(1); // now down to 8 ounces 

      juice.report();  

      juice.spill(); 

      juice.report(); 
		
   } 
} 

class Glass 
{ 
  private int oz = 0;
   // Declare a variable to keep track of the number of ounces in a glass here
  public Glass(int o)
  {
   oz = o;
  }
  public int drink(int ozm)
  {
    oz = oz - ozm;
    return ozm;
  }
  public int fill(int ozj)
  {
    oz = ozj + oz;
	 return ozj;
  }
  public void spill()
  {
    oz = 0;
  }
    // Write the methods here.  You will need a constructor, plus the drink, report, fill, 
    // and spill methods.  These methods are for any generic glass -- they are not specific  
    // to the milk or juice instances of a glass (i.e., you should not mention "juice" or  
    // "milk" inside the Glass class). 
   public void report()
  {
    System.out.println("Glass has " + oz + " ounces.");
  }
} 