import java.util.*;
import java.io.*;
public class DemoFileInput
{
  public static void main(String[] args)
  {
    try
	 {
	 
      Scanner scan = new Scanner( new File("data.txt") );
    }
	 catch (Exception e)
	 {
	   System.out.println("Error! could not open file.");
		System.out.println("Please pick another name.");
	 }
  }
}