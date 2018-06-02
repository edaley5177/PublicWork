import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ManyButtons
{
  public static void main(String [] args)
  {
    MyFrame F = new MyFrame();
  }
}

class MyFrame extends JFrame
{
  JButton [] button = new JButton[150];

  
  public MyFrame()
  {
    
    super("Title for Many Buttons");
	 setLayout(new FlowLayout());
	 int i = 0;
	 while (i < 150)
	 {
	   button[i] = new JButton("Button" + i);
		add(button[i]);
	 
		i++;
		
	   
	 }
	 ReportClick handler = new ReportClick();
	 int j = 0;
	 while (j < button.length)
	 {
	   button[i].addActionListener(handler);
		j++;
	 }
	 this.setVisible(true);
	 this.setSize(200, 1000);
    this.setLocation(10, 10);
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
  }
  class ReportClick implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
	 {
	   JButton btn = (JButton) event.getSource();
	   System.out.println("This source is: " + event.getSource());
	 }
  }
}