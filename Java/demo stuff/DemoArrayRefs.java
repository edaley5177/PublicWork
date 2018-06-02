public class DemoArrayRefs
{
  public static void main(String [] args)
  {
    int [] x = new int [4];
	 printArray(x);
  }

  public static void printArray(int [] other)
  {
    other [2] = 99;
	 int i = 0;
	 while (i < other.length)
	 {
	   System.out.println("val: " + other[i]);
		i++;
	 }
  }
}