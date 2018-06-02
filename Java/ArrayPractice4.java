public class ArrayPractice4 
{ 
  public static void main(String [] args) 
  { 
    int [] val = { 81, 6, 95, 30, 40, 5, 16 };
	  // Report the sum of every odd-valued element
	 // in the array.  
	 int h = 0;
	 int odd = 0;
	 //loop through all elements
	 
	 while (h < 7)
	 {
	   if (val[h] %2 == 1)
		{
		  odd = odd + val[h];
		}
		h++;
	 }
	 System.out.println("The odd-valued elements had a sum of: " + odd);
  } 
}
