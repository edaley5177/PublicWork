/**
Eamonn Daley
1/23/2013
*/
import javax.swing.*;
import java.util.Scanner;
class HowMuch
{
  public static void main(String[] args)
  {
    JOptionPane.showMessageDialog(null, "How Much is that ipod touch?");
	 System.out.println("how much would you like to spend on accesories?");
	 Scanner keyboard = new Scanner(System.in);
	 double acc = 100;
	 acc = keyboard.nextDouble();
	 System.out.println("what is the cost of the ipod?");
	 double icost = 299.99;
	 icost = keyboard.nextDouble();
	 double songs = 29;
	 System.out.println("How many songs would you buy at .99 a song?");
	 songs = keyboard.nextInt();
	 songs = songs * .99;
	 System.out.println("Song Summary:\ntotal on songs is:" + songs);
	 double total = icost + icost * .06 + acc + acc * .06 + songs + songs * .06;
	 double ipodacctotal = icost + acc;
	 double ipodacctax = icost * .06 + acc * .06;
	 double ipodsub = ipodacctotal + ipodacctax;
	 System.out.println("\nHardware Summary:\nipod and accesories is:" + ipodacctotal + " " + "\nipod and accerioes tax is:" + ipodacctax);
	 System.out.println("ipod subtotal is:" + ipodsub);
	 System.out.println("\nGrand Total is:" + total);
  }
}