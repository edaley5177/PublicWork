import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class colors extends JFrame
{
 public static void main(String [] args);
 {
   super("colors");
	setLayout(new BorderLayout());
   JTextField red = new JTextField("red");
	JTextField blue = new JTextField("Blue");
	JTextField green = new JTextField("green");
	JPanel top = new JPanel();
	top.add(red);
	top.add(blue);
	top.add(green);
	
	add(top, BorderLayout.NORTH);
	
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 } 
}