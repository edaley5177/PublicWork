import javax.swing.*;
import java.awt.*;
public class MyFirstGUI
{
  public static void main(String [] args)
  {
    JFrame frame = new JFrame("Eamonn's Awesome Window");
	 frame.setSize(200,200);
	 frame.setVisible(true);
	 frame.setLocation(200,200);
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	 JFrame frame2 = new JFrame("tall thin");
	 frame2.setSize(150,600);
	 frame2.setVisible(true);
	 frame2.setLocation(900,100);
	 frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	 JFrame frame3 = new JFrame("short long");
	 frame3.setSize(1000,150);
	 frame3.setVisible(true);
	 frame3.setLocation(10,900);
	 frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	 MyFrame mine = new MyFrame();
	
  }
}

class MyFrame extends JFrame
{
  JButton button = new JButton("OK");
  JTextField text = new JTextField("Apples", 30);
  
  public MyFrame()
  {
    super("My Fancy window");
	 setLayout(new FlowLayout());
	 
	 add(button);
	 add(text);
	 
	 this.setLocation(700,10);
	 setSize(500,500);
	 setVisible(true);
	 //mine.setDefaultCloseOperation(MyFrame.EXIT_ON_CLOSE);
	 
	 
	 
	 
	 
	 
  }
}