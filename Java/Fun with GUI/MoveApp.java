import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MoveApp
{
  public static void main(String [] args)
  {
    MyFrame frame = new MyFrame("Button Window");
	 
  }
}
class MyFrame extends JFrame
{
  JButton Clear = new JButton("clear text");
  JButton clickButton = new JButton("Click Me!!!!!!!!");
  JTextField text = new JTextField("this is a text field", 30);
  public MyFrame(String s)
  {
    super(s);  // this is calling the JFrame Title
	 setLayout(new FlowLayout() );
	 add(clickButton);
	 add(Clear);
	 add(text);
	 //add(Clear);
	 Clear.addActionListener( new Clearer() );
	 clickButton.addActionListener( new ClickHandler() );
	 
	 
	 
	 this.setLocation(10,10);
	 this.setSize(500,200);
	 this.setVisible(true);
	 this.setResizable(false);
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
  }
  
  class ClickHandler implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
	 {
	   text.setText("Clicked!!!!!!!");
		
	 }
  }
  class Clearer implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
	 {
	   text.setText("");
	 }
  }
}