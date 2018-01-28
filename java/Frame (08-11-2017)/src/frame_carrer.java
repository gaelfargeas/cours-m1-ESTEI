import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class frame_carrer extends Frame implements ActionListener
{

	carrer_2 carrer;
	calculatrice cal;
	

	
	
	
	public frame_carrer() 
	{
		//initialise l'applet
		setSize(300,300);	
		
		MenuItem mi ;
		setLayout(new BorderLayout());
		
		
		//ajoute un tf
		
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
		add(cal , BorderLayout.WEST);
		cal.init();
		cal.start();
		
		carrer =new carrer_2();
		add(carrer , BorderLayout.CENTER);
		carrer.init();
		carrer.start();
	
	}
	
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		frame_carrer tf = new frame_carrer();
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
