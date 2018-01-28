
package projet_270917;
import java.applet.*; // package pour l'aspect window
import java.awt.*; //package pour l'aspect graphique


public class TextRelief extends Applet{

	String msg ="bonjour dans une applet";
	Color col ;
	
	
	
	
	
	
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
		
		int vert = 255;
		
		
		for (int i=0; i<12; i++)
		{
			
			
			
			//g.clearRect(0, 0, L, l);
			
			col= new Color( 0, vert,0);
			g.setColor(col);
			g.drawString(msg, ( (L-l_chaine)/2 )+(i*5) ,((l-h_chaine)/2)+(i*5) );
			vert -=20;
			
		}
	
	}
	
	
}
