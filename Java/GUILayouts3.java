import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUILayouts3 extends JFrame
{
  JCheckBox b1 = new JCheckBox("shiny", true);
  JCheckBox b2 = new JCheckBox("fun", false);
  
  JTextField txt1 = new JTextField("red");
  JTextField txt2 = new JTextField("green");
  JTextField txt3 = new JTextField("blue");
  JTextField txt4 = new JTextField("yellow");
  JTextField txt5 = new JTextField("orange");
  
  JButton btn1 = new JButton("Btn 1");
  JButton btn2 = new JButton("Btn 2");
  JButton btn3 = new JButton("Btn 3");
  JButton btn4 = new JButton("Btn 4");
  JButton btn5 = new JButton("Btn 5");
  
  
  public static void main(String [] args)
  {
    GUILayouts3 gq = new GUILayouts3();
  }
  
  public GUILayouts3()
  {
    super("GUI Question");
	 setLayout(new GridLayout(2, 2));
	 JPanel panel1 = new JPanel();
	 panel1.setLayout(new GridLayout(2, 1));
	 JPanel panel2 = new JPanel();
	 panel2.setLayout(new GridLayout(1, 2));
	 
	 //panel1.setBorder(BorderFactory.createTitledBorder("Buttons"));
	 
	 //setSize(50, 120);
	 
	 panel1.add(btn1);
	 panel1.add(btn2);
	 
	 panel2.add(btn3);
	 panel2.add(btn4);
	 
	 add(txt1);
	 add(panel1);
	 add(panel2);
	 add(txt2);
	 
	 pack();
	 setVisible(true);
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}