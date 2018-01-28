
package projet_270917;
import java.applet.*; // package pour l'aspect window
import java.awt.*; //package pour l'aspect graphique


public class Text_Encadre extends Applet{

	String msg ="bonjour dans une applet";
	
	
	
	
	
	
	public void init()
	{
		//definit la taille de la fenetre
		setSize(500,500);
		//set background color to black
		setBackground(Color.BLACK);
		//set foreground color to yellow
		setForeground(Color.YELLOW);
		
		Font f = new Font("Helvetica",Font.BOLD+Font.ITALIC , 22);
		setFont(f);
	}
	
	public void paint (Graphics g)
	{
		
		int L = (getSize().width) ;
		int l = (getSize().height) ;
		
		
		
		FontMetrics fm = getFontMetrics(getFont());
		int l_chaine = fm.stringWidth(msg) ;
		int h_chaine = fm.getHeight() ;
		int x0 = (L-l_chaine)/2;
		int y0 = (l-h_chaine)/2;
		
		
			
		g.drawString(msg,x0 , y0 );
		
		g.drawRect( (x0 - 10 ) , (y0 -(h_chaine) ) , (l_chaine +20 ) , (h_chaine +20) );
			
	
	}
	
	
}