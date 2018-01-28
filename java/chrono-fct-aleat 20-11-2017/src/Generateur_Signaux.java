

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Generateur_Signaux extends Frame implements ActionListener, Runnable , MouseListener {


	Button trace;
	private Thread processus = null ;



	int tab[] =new int[100]; 
	int moy[] = new int [33];
	Panel pn = new Panel();
	Button start = new Button("start") ;
	Button clear = new Button("clear") ;
	Button stop = new Button("stop") ;
	
	TextField info;
	int nbr =1 ;
	int speed = 1500 ;




	public Generateur_Signaux() {

		setSize(600,600);
		setTitle("Courbe");

		//instantiation
		setLayout(new BorderLayout());
		info = new TextField(10);
		info.setEditable(false);
		add (info , BorderLayout.SOUTH);
		addMouseListener(this);		
		pn.setLayout(new GridLayout(1, 3));


		start.addActionListener(this);
		clear.addActionListener(this);
		stop.addActionListener(this);


		pn.add(start) ;
		pn.add(clear) ;
		pn.add(stop) ;

		stop.setEnabled(false);
		start.setEnabled(true);
		clear.setEnabled(false);
		add(pn , BorderLayout.NORTH);

		
		
		
		
		addWindowListener(new Fermeture() );


	}







	public void trace_ligne(Graphics g)
	{
		g.setColor(Color.red);

		for (int i = 0 ; i < tab.length -1 ; i++)
		{

			g.drawLine( (50 +  ( getWidth() / tab.length )*i ), (  ( (getHeight()/2)+tab[i]) ), (50 +  ( getWidth() / tab.length )*(i+1) ) , (  ( (getHeight()/2)+tab[i+1] ) ));	
		}

		//moyenne
		for (int i = 0 ; i < moy.length -1 ; i++)
		{
			g.setColor(Color.blue);
			g.drawLine( (50 +  ( getWidth() / moy.length )*i ), (  ( (getHeight()/2)+moy[i]) ), (50 +  ( getWidth() / moy.length )*(i+1) ) , (  ( (getHeight()/2)+moy[i+1] ) ));	
		}




	}

	public void init_tableau ()
	{

		for (int i = 0 ; i < tab.length ; i++)
		{
			tab[i]=(int)  ( (Math.random()*200)-100 );
		}
		for (int i = 0 ; i < moy.length ; i++)
		{
			
			moy[i]= ( tab[2*(1+i)] + tab[ (2*(1+i) ) - 1 ] + tab[ (2*(1+i) ) - 2 ] )/3 ;
		}

	}



	public void trace_axes (Graphics g) 
	{
		int H = getHeight(); //hauteur
		int L = getWidth();	//largeur
		//verticale
		g.drawLine(50, 50, 50, H); 
		//horizontale
		g.drawLine(25, H/2, L, H/2);


	}



	public void paint (Graphics g)
	{			
		trace_axes(g);
		trace_ligne(g);
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Generateur_Signaux c = new Generateur_Signaux();
		c.show();
	}





	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String bp_select = e.getActionCommand();
		switch (bp_select) {
		case "start":


			Start();

			stop.setEnabled(true);
			start.setEnabled(false);
			clear.setEnabled(false);
			break;
		case "clear":
			//clear les tableau
			
			for (int i =0 ; i < tab.length ; i++)
			{
				tab[i]=0;
			}
			for (int i =0 ; i < moy.length ; i++)
			{
				moy[i]=0;
			}
			repaint();
			stop.setEnabled(false);
			start.setEnabled(true);
			clear.setEnabled(false);
			break;
		case "stop":

			Stop();
			stop.setEnabled(false);
			start.setEnabled(true);
			clear.setEnabled(true);

			break;
		default:
			break;
		}

	}


	public void Start()
	{
		if (processus == null)
		{
			processus = new Thread(this);
			processus.start();
		}

	}

	public void Stop()
	{
		processus.stop();
		processus = null ;

	}




	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (processus != null)
		{
			try {
				init_tableau();
				repaint();
				processus.sleep(speed);

			} catch (Exception e) {
				// TODO: handle exception
				System.out.print(e.toString());
			}



		}
	}







	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String str = "X=" +e.getX() + " Y="+e.getY();
		info.setText(str);
		
		
		
	}







	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}







	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}







	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}







	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
