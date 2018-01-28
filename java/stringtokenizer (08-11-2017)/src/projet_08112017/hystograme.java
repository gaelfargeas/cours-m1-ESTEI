package projet_08112017;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

public class hystograme extends Frame implements ActionListener {

	TextField tf; 
	int tab[] = new int[100];
	int nbr  ;



	public hystograme() {

		setSize(600,600);
		setLayout(new BorderLayout());

		setTitle("calcul");
		tf = new TextField();
		add(tf , BorderLayout.NORTH);
		tf.addActionListener(this);


		addWindowListener(new Fermeture() );


	}


	public void get_value()
	{
		String str= tf.getText();
		StringTokenizer st = new StringTokenizer(str) ;
		int i=0;
		nbr=0;


		while (st.hasMoreTokens())
		{
			try
			{
				tab[i]=Integer.parseInt(st.nextToken())	;

				System.out.println(tab[i]);
				i++;
				nbr ++;
			}
			catch (Exception e)
			{
				System.out.println(e.toString());
			}

		}


	}





	public void trace_rectangle(Graphics g, int val , int i)
	{
		Color c = new Color( (int)( Math.random()*255 ), (int)( Math.random()*255 ) , (int)( Math.random() )*255 );
		g.setColor(c);
		
		
		g.fillRect(50+(500/nbr)*i, (550-val), 550/nbr, val);
		//v1 
		/*if (50+(i*50) <550)
		{
			g.fillRect(50+(i*50), (550-val), 50, val);
		}*/

	}




	public void trace_axes (Graphics g) 
	{

		g.drawLine(50, 50, 50, 575);
		g.drawLine(25, 550, 550, 550);

	}





	public void paint (Graphics g)
	{	
		//affiche l'applet
		trace_axes(g);
		int i=0 ;
		while (i!= nbr)
		{
			trace_rectangle(g, tab[i] , i);
			i++;
		}

	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hystograme hyst = new hystograme();
		hyst.show();
	}





	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		get_value();
		repaint();
	}

}
