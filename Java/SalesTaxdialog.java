
import javax.swing.JOptionPane;

public class SalesTaxdialog
{
   public static void main(String [] args)
   {
      String input = JOptionPane.showInputDialog("How much was your purchase?"); 
		double num = Double.parseDouble(input);
		JOptionPane.showMessageDialog(null, "The tax on that $" + num + " purchase was $" + num * .06);
   }
}