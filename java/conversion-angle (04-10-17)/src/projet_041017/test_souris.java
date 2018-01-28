package projet_041017;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class test_souris extends Applet implements MouseListener,MouseMotionListener {

	int x = 50 ;
	int y = 50 ;
	String msg = "Bonjour";
	
	
	public void init()
	{
		//definit la taille de la fenetre
		setSize(200,200);
		addMouseListener(this); //ajout d'ecouteur de souris
		addMouseMotionListener(this);
	}
	
	
	public void paint (Graphics g)
	{
		
		g.drawString(msg, x, y);
		


	}
	
	
	
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		x = e.getX();
		y = e.getY();
		repaint();
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		//test si la souris est a l'interieur de la fenetre
		if( contains( e.getX() , e.getY() ) )
		{
		x = e.getX();
		y = e.getY();
		repaint();	
		}
		

	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	
	
	
	
}
