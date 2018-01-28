package projet_041017;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;



public class test_clavier extends Applet implements KeyListener {

	
	String msg = "";
	public void init()
	{
		//definit la taille de la fenetre
		setSize(300,300);
		addKeyListener(this); //ajout d'ecouteur de clavier
		
	}


	public void paint (Graphics g)
	{
		
		
		g.drawString(msg , 50, 50);



	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		if(msg.length()< 10)
		{
		msg += c;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int c =e.getKeyCode();
		if (c == KeyEvent.VK_DELETE)
		{
			if(msg.length() > 0)
			{
			msg.substring(0, msg.length()-2);
			}
			repaint();	
			
		}
		
		
	}

}
