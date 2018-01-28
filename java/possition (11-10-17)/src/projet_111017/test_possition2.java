package projet_111017;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;

public class test_possition2 extends Applet {
	
	
	
	public void init()
	{
		
		setSize(300,300);
		setLayout(new GridLayout(2,3));
		
		for (int i=0 ; i<5 ; i++)
		{
			
			String str = "b"+i;
			Button b= new Button (str) ;
			place_bouton(b);
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
	}

	public void place_bouton (Button b )
	{
		add(b);
		
		
	}
	
	
	
	
	
}
