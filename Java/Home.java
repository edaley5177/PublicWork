public class Home
{
  public static void main(String[] args)
  {
    Person pres= new Person();
	 pres.setName("obama");
	 pres.setAge(54);
  }
}
class Person
{
  private String name;
  private int age;
  public void setName(String name)
  {
    System.out.println(name);
  }
  public void setAge(int age)
  {
    System.out.println(age);
	 
  }
}