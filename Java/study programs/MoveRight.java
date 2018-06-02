import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MoveRight
{
  public static void main(String [] args)
  {
    Mywin frame = new Mywin("Move Right");
  }
  
}
class Mywin extends JFrame
{
  JButton move = new JButton("Move right");
  JTextField mover = new JTextField("mover");
  public Mywin(String s)
  {
    super(s);
	 setLayout(new GridLayout(1, 3));
	 add(mover);
	 add(move);
	 move.addActionListener(new Help());
	 setVisible(true);
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
}
class Help implements ActionListener
{
  
}