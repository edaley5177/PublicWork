import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class bagels extends JFrame
{
  JCheckBox b1 = new JCheckBox("shiny", true);
  JCheckBox b2 = new JCheckBox("fun", false);
  JCheckBox cream = new JCheckBox("cream cheese", false);
  JCheckBox butter = new JCheckBox("butter", false);
  JCheckBox jam = new JCheckBox("cherry jam", true);
  
  JTextField txt1 = new JTextField("red");
  JTextField txt2 = new JTextField("green");
  JTextField txt3 = new JTextField("blue");
  JTextField txt4 = new JTextField("yellow");
  JTextField txt5 = new JTextField("orange");
  JTextField label = new JTextField("OCC Bagel Cost Calculator");
  
  JButton btn1 = new JButton("Btn 1");
  JButton btn2 = new JButton("Btn 2");
  JButton btn3 = new JButton("Btn 3");
  JButton btn4 = new JButton("Btn 4");
  JButton btn5 = new JButton("Btn 5");
  JButton calc = new JButton("Calculate");
  JButton exit = new JButton("Exit");
  
  JRadioButton white = new JRadioButton("white", false);
  JRadioButton wheat = new JRadioButton("wheat", true);
  //JRadioButton angry = new JRadioButton("angry", false);
  
  ButtonGroup moodGroup = new ButtonGroup();
  
  
  public static void main(String [] args)
  {
    bagels gq = new bagels();
  }
  
  public bagels()
  {
    super("GUI Question");
	 setLayout(new BorderLayout());
	 
	 JPanel bageltypes = new JPanel();
	 JPanel bottom = new JPanel();
	 JPanel toppings = new JPanel();
	 JPanel center = new JPanel();
	 bageltypes.setLayout(new GridLayout(2, 1));
	 toppings.setLayout(new GridLayout(3, 1));
	 center.setLayout(new GridLayout(1, 2));
	 center.add(bageltypes);
	 center.add(toppings);
	 bottom.add(calc);
	 bottom.add(exit);
	 bageltypes.add(white);
	 bageltypes.add(wheat);
	 toppings.add(cream);
	 toppings.add(butter);
	 toppings.add(jam);
	 toppings.setBorder(BorderFactory.createTitledBorder("Toppings"));
	 bageltypes.setBorder(BorderFactory.createTitledBorder("Bagels"));
	 
	 
	 /*
	 moodGroup.add(happy);
	 moodGroup.add(angry);
	 
	 add(happy);
	 add(sad);
	 add(angry);
	 */
	 //sad.setSelcted(true);
	 
	 label.setForeground(Color.GREEN);
	 add(label, BorderLayout.NORTH);
	 add(bottom, BorderLayout.SOUTH);
	 add(center, BorderLayout.CENTER);
	 exit.addActionListener(new Exit());
	   	 
	 
	// if (sad.isSelected())
	  // JOptionPane.showMessageDialog(null, "Unfortunate!");

		 
	 pack();
	 setVisible(true);
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
 class Exit implements ActionListener
	 {
	   public void actionPerformed(ActionEvent e)
		{
		  System.exit(0);
		}
	 }
}