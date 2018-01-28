package projet_041017;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;


public class Segment extends Applet implements MouseListener,MouseMotionListener {

	int x0 = 50 ;
	int y0 = 50 ;
	int x1 = 100 ;
	int y1 = 100 ;
	Color couleur =  Color.RED ;
	
	
	
	public void init()
	{
		//definit la taille de la fenetre
		setSize(200,200);
		addMouseListener(this); //ajout d'ecouteur de souris
		addMouseMotionListener(this);
	}


	public void paint (Graphics g)
	{
		
		
		g.setColor(couleur);
		g.drawLine(x0, y0, x1, y1);



	}

	double distance (int xa, int ya , int xb , int yb)
	{
		double res =0;
		res= Math.sqrt(  Math.pow( (xb - xa), 2) + Math.pow( (yb - ya), 2 )  );
		
		return res ;
		
		
	}





	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub


		if( (distance( x0, y0 , e.getX() , e.getY() ) )  < (distance( x1, y1 , e.getX() , e.getY() ) )      )
		{

			x0 = e.getX();
			y0 = e.getY();
			repaint();	

		}
		else {

			x1 = e.getX();
			y1 = e.getY();
			repaint();	

		}
		//change la couleur (aleatoire)
		couleur = Color.red ;

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
		if( (distance( x0, y0 , e.getX() , e.getY() ) )  < (distance( x1, y1 , e.getX() , e.getY() ) )      )
		{

			x0 = e.getX();
			y0 = e.getY();
			repaint();	

		}
		else {

			x1 = e.getX();
			y1 = e.getY();
			repaint();	

		}
	}


	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}





}

