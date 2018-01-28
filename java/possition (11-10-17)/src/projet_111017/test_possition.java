package projet_111017;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;

public class test_possition extends Applet{

	
	
	public void init()
	{
		
		setSize(300,300);
		setLayout(new BorderLayout());
		add (new Button("Nord"),BorderLayout.NORTH);
		add (new Button("centre"),BorderLayout.CENTER);
		add (new Button("sud"),BorderLayout.SOUTH);
		add (new Button("est"),BorderLayout.EAST);
		add (new Button("ouest"),BorderLayout.WEST);



		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
