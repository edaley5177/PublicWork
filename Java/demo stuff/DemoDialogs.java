import javax.swing.*;

class DemoDialogs
{
  public static void main(String[] args)
  {
    JOptionPane.showMessageDialog(null, "Amaxing Number doubling Number program!");	
	 String input = JOptionPane.showInputDialog("Give me a number"); 
	 int num = Integer.parseInt(input);
	 int twice = num + num;
	 JOptionPane.showMessageDialog(null, "twice" + num + "is" + twice);
  }
}