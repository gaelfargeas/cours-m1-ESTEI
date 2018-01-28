package projet_270917;
import java.applet.*; // package pour l'aspect window
import java.awt.*; //package pour l'aspect graphique



public class dessins extends Applet{

	String msg ="bonjour dans une applet";
	
	public void init()
	{
		//definit la taille de la fenetre
		setSize(200,200);
		//set background color to black
		setBackground(Color.BLACK);
		//set foreground color to yellow
		setForeground(Color.YELLOW);
		
		Font f = new Font("Helvetica",Font.BOLD+Font.ITALIC , 22);
		setFont(f);
	}
	
	public void paint (Graphics g)
	{
		//dessin un cercle
		int rayon = 20;
		int L = ((getSize().width)/2)-(rayon/2) ;
		int l = ((getSize().height)/2)-(rayon/2) ;
		
		//dessin le 1er cercle en rouge
		g.setColor(Color.red);
		g.fillOval(L, l, rayon, rayon);
		
		//dessin le 2eme cercle en jaune
		g.setColor(Color.yellow);
		g.fillOval(L +30, l, rayon, rayon);
		
		//dessin une ligne en cyan en dessous des 2 cercle
		g.setColor(Color.cyan);
		g.drawLine(L-20, l+50 , L+80, l+50);
		
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
}
