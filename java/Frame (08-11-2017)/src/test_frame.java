import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class test_frame extends Frame implements ActionListener
{

	calculatrice cal;
	TextField tf;
	

	
	
	
	public test_frame() 
	{
		//initialise l'applet
		setSize(300,300);	
		
		MenuItem mi ;
		setLayout(new BorderLayout());
		
		
		//ajoute un tf
		 tf= new TextField();
		 add(tf , BorderLayout.NORTH);
		 
		//ajoute la calculatrice
		addWindowListener(new Fermeture());
		
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		Menu m1 = new Menu("fichier");
		mb.add(m1);
		
		mi = new MenuItem("quiter");
		mi.addActionListener(this);
		m1.add(mi);
		
				
		
		
		cal =new calculatrice();
		add(cal , BorderLayout.CENTER);
		cal.init();
		cal.start();
	
	}
	
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		test_frame tf = new test_frame();
		tf.show();
		
	}	
	public void paint (Graphics g)
	{	
		//affiche l'applet
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	
	
	
	


	
	
	

}
