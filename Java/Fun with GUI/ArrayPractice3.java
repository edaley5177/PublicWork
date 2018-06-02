public class ArrayPractice3 
{ 
  public static void main(String [] args) 
  { 
    int [] val = { 81, 6, 95, 30, 40, 5, 16 }; 
	 // In the space below, write a loop 
	 // to count the number of values greater 
	 // than or equal to 40. 
	 int i = 0;
	 int forty = 0;
	 while (i < val.length)
	 {
	   if (val[i] >= 40)
		{
		  forty++;
		}
	   i++;
	 }
	 System.out.println("There were " + forty + " values greater than forty.");
  } 
}
