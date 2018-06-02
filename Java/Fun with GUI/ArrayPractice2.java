public class ArrayPractice2 
{ 
  public static void main(String [] args)
  { 
    int [] val = { 39, 6, 95, 30, 40, 50, 60 }; 
	 // In the space below, write a loop
	 // to calculate and print the sum of the
    // values in the val val:
	 int i = 0;
	 int sum = 0;
	 
    while (i < val.length)
	 {
	   
		sum = val[i] + sum;
		
      i++;
	 }
	 System.out.println(sum);
	} 
}
