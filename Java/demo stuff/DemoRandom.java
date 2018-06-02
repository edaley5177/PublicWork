import java.util.*;
class DemoRandom
{
  public static void main(String[] args) throws Exception
  {
    Random random = new Random();
    int i = 0;
	 int num6 = 0;
	 while (i <= 4)
	 {
	   int num = random.nextInt(27);
	   num++; 
		System.out.println(num);
		i++;
		if (num == 6)
	   {
	     num6++;
		
	   }
	 }
	
	 System.out.println("you got 6 "+ num6 +" times");
  }
}