

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Generateur_Signaux2 extends Frame implements ActionListener, Runnable {


	Button trace;
	private Thread processus = null ;



	int tab[] =new int[100]; //remplacer 100 par la frequence
	int moy[] = new int [33];
	int nbr =0 ;
	int speed = 100 ;




	public Generateur_Signaux2() {

		setSize(600,600);
		setTitle("Courbe");

		//instantiation
		setLayout(new BorderLayout());

		addWindowListener(new Fermeture() );


	}







	public void trace_ligne(Graphics g)
	{
		g.setColor(Color.red);

		for (int i = 0 ; i < nbr ; i++)
		{

			g.drawLine( (50 +  ( getWidth() / tab.length )*i ), (  ( (getHeight()/2)+tab[i]) ), (50 +  ( getWidth() / tab.length )*(i+1) ) , (  ( (getHeight()/2)+tab[i+1] ) ));	
		}
		g.setColor(Color.blue);
		//moyenne
		for (int i = 0 ; i < nbr -1 ; i++)
		{

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
		Generateur_Signaux2 c = new Generateur_Signaux2();
		c.show();
		c.Start();
	}





	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub


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

				for (int i = 0 ; i < tab.length-1 ; i+=3)
				{

					for (int b = 0 ; b < 3 ; b++)
					{
						tab[i+b]=(int)  ( (Math.random()*200)-100 );
						nbr=i+b;
					}


					moy[i]= ( tab[2*(1+i)] + tab[ (2*(1+i) ) - 1 ] + tab[ (2*(1+i) ) - 2 ] )/3 ;
					repaint();
					processus.sleep(speed);
				}




			} catch (Exception e) {
				// TODO: handle exception
				System.out.print(e.toString());
			}



		}
	}

}
