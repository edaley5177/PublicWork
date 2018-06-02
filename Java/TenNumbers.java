import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/*
author: Eamonn Daley 
Date: 4/12/2013
*/
public class TenNumbers
{
	public static void main(String [] args)
	{
		ManyNumbers mn = new ManyNumbers("Alan Jackson - Program 6");
	}
}

class ManyNumbers extends JFrame
{
	public static final int MAX_NUM = 10;
	
	JTextField [] nums = new JTextField[MAX_NUM];
	int [] ran = new int[10];
	JCheckBox big = new JCheckBox("Big Numbers", true);
	Random random = new Random();
	
	public ManyNumbers(String s)
	{
		super(s);
		setLayout(new FlowLayout());
		
		JButton newnumbers = new JButton ("New Numbers");
		
		JPanel numsholder = new JPanel();
	    int i = 0;
	    while (i < 10)
		 {
		   nums[i] = new JTextField("0"); 

		   numsholder.add(nums[i]);
		   i++;
		 		  
		  
		}
		
		int f = 0;
		while(f < 10)
		{
		  String box = Integer.toString(ran[f]);
		  f++;
		}
		
		add(numsholder);
		add(newnumbers);
		newnumbers.addActionListener(new NumberChanger());	
	  
      


		// You can use "pack" instead of "setSize" -- pack makes 
		// the window just the right size for the added components.
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class NumberChanger implements ActionListener
	{
	  public void actionPerformed(ActionEvent e)
	  {
	    
	    //nums[3].setText(Integer.toString(ran[3])); 
		 
		int r = 0;
		while (r < 10)
		{
		  ran[r] = random.nextInt(100);
		  r++;
		
		} 

	    int d = 0;
	    while (d < 10)
		  {
		    nums[d].setText(Integer.toString(ran[d])); 
		  
			  
		    if (ran[d] >= 50)
		    {
		      nums[d].setBackground(Color.RED);
		    }
		    else
		    {
		      nums[d].setBackground(Color.WHITE);
		    }
		 
		  


		    d++;
		 		  
		  
		  }
		  int l = 0;
		  /*while (ran[l] >= 50)
		  {
		    nums[l].setBackground(Color.RED);
		  }*/
	           
	  }
	}
}