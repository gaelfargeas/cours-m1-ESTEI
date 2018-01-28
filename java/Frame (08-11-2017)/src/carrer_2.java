
import java.applet.*; // package pour l'aspect window
import java.awt.*; //package pour l'aspect graphique

public class carrer_2 extends Applet {
	
	
	int x,y,c;
	int cnt=0;
	
	public void init()
	{
		//definit la taille de la fenetre
		setSize(200,200);
		//set background color to black
		setBackground(Color.BLACK);
		//set foreground color to yellow
		setForeground(Color.YELLOW);
		
		
	}

	public int carrer_getx ()
	{
		
		int L = (getSize().width) ;
		double nbreAleatoire = 0;
		nbreAleatoire = Math.random()*100;
		
		while (nbreAleatoire > L)
		{
		nbreAleatoire = Math.random()*10;
		}

		return ((int)nbreAleatoire);


	}


	public int carrer_gety ()
	{

		int l = (getSize().height) ;

		double nbreAleatoire = 0;
		nbreAleatoire = Math.random()*100;
		while (nbreAleatoire > l)
		{
		nbreAleatoire = Math.random()*100;
		}

		return ((int)nbreAleatoire);


	}

	public void paint (Graphics g)
	{
		
		
		//dessins un rectangle (aleatoire)
		//g.drawRect( (carrer_getx()) , (carrer_gety()) , (carrer_getx()) , (carrer_gety()) );	
		
		//corection : dessins 20 carrer (aleatoire)
		int L = (getSize().width) ;
		int l = (getSize().height) ;
		
			
		
		
		do
		{
			
		x = (int)(Math.random()*l);
		y = (int)(Math.random()*L);
		int min = Math.min(l-x , L-y);
		c = (int)(Math.random()*min);
		g.drawRect(x, y, c, c);

		
		
		
		
		
		cnt ++;
		}
		while (cnt <=20);
		


	}


}
