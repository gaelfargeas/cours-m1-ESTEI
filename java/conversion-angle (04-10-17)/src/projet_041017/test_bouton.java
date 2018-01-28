package projet_041017;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;


public class test_bouton extends Applet implements ActionListener {


	Button b;
	Button b2 , yolo;
	int count = 0 ;


	public void init()
	{
		//definit la taille de la fenetre
		setSize(200,200);
		b = new Button("ajouter"); // crée un bouton ajouter
		b.addActionListener(this); //active le bouton
		add(b);
		b2 = new Button("enlever"); // crée un bouton ajouter
		b2.addActionListener(this); //active le bouton
		add(b2);
		yolo = new Button("yolo"); // crée un bouton ajouter
		yolo.addActionListener(this); //active le bouton
		add(yolo);
	}

	public void paint (Graphics g)
	{


		g.drawString("" + count , 100, 100);



	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource().equals(b))
		{
			count++;
			repaint();	

		}else if(e.getSource().equals(b2))
		{
			count--;
			repaint();	

		}else if(e.getSource().equals(yolo))
		{
			
			count=(int)(Math.random()*1000);
			repaint();
		}
		






	}


}
