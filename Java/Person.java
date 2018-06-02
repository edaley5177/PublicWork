public class Person
{
  private int age;
  private String name;
  public Person(String startName, int startAge)
  {
   
   name = startName;
	if (age >= 0)
	{
	  age = startAge;
	}
	else 
	  age = 0;
	
    
  }
  public static void main(String [] args)
  {
    Person p = new Person("John kerry", 63);
	 Person seceretary = new Person("hill", 65);
	 System.out.println(p.toString());
  }
}