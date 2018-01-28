
import java.applet.*; // package pour l'aspect window
import java.awt.*; //package pour l'aspect graphique

public class carrer_cercle extends Applet {


	int x,y,c;
	int cnt=0;
	int choix =0;
	int rayon = 20;
	Color couleur;
	int r,v,b;


	public void init()
	{
		//definit la taille de la fenetre
		setSize(200,200);
		//set background color to black
		setBackground(Color.BLACK);
		//set foreground color to yellow
		setForeground(Color.YELLOW);


	}

	public void choix(String type) 
	{

		if (type == "cercle")
		{
			choix =1;
		}else
		{
			choix=0;	
		}

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





		if (choix == 0) {



			//corection : dessins 20 carrer (aleatoire)
			int L = (getSize().width) ;
			int l = (getSize().height) ;
			do
			{
				//change la couleur
				r = (int)(Math.random()*255);
				v = (int)(Math.random()*255);
				b = (int)(Math.random()*255);
				
				couleur = new Color(r,v,b);
				
				//position aleatoirement et dessin le carrer
				x = (int)(Math.random()*l);
				y = (int)(Math.random()*L);
				int min = Math.min(l-x , L-y);
				c = (int)(Math.random()*min);

				g.setColor(couleur);
				g.drawRect(x, y, c, c);

				cnt ++;
			}
			while (cnt <=20);	
		}else
		{

			int L = ((getSize().width))-(rayon/2) ;
			int l = ((getSize().height))-(rayon/2) ;

			do
			{
				//change la couleur
				r = (int)(Math.random()*255);
				v = (int)(Math.random()*255);
				b = (int)(Math.random()*255);
				
				couleur = new Color(r,v,b);
				
				
				//position aleatoirement et dessin le cercle
				x = (int)(Math.random()*l);
				y = (int)(Math.random()*L);
				int min = Math.min(l-x , L-y);
				c = (int)(Math.random()*min);
				g.setColor(couleur);
				g.drawOval(y, x, c, c);

				cnt ++;
			}
			while (cnt <=20);	

		}

		cnt =0;


	}


}
