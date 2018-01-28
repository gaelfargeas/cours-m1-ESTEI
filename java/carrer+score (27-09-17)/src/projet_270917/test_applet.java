package projet_270917;
import java.applet.*; // package pour l'aspect window
import java.awt.*; //package pour l'aspect graphique



public class test_applet extends Applet{

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
		//ecrit dans l'applet
		
		int L = (getSize().width) ;
		int l = (getSize().height) ;
		
		
		
		FontMetrics fm = getFontMetrics(getFont());
		int l_chaine = fm.stringWidth(msg) ;
		int h_chaine = fm.getHeight() ;
		
		
		g.drawString(msg, (L-l_chaine)/2 ,(l-h_chaine)/2 );
	}
	

	
	
	
	
	
	
	
	
	
	
	
}
