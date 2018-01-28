package projet_08112017;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

public class graphique extends Frame implements ActionListener {

	TextField tf ,moyenne , ecartType; 
	int tab[] = new int[100];
	int nbr =1 ;
	
	



	public graphique() {

		setSize(600,600);
		setLayout(new BorderLayout());

		setTitle("calcul");
		tf = new TextField();
		add(tf , BorderLayout.NORTH);
		tf.addActionListener(this);

		moyenne = new TextField();
		add(moyenne , BorderLayout.SOUTH);
		moyenne.setEditable(false);
		
		
		ecartType = new TextField();
		add(ecartType , BorderLayout.SOUTH);
		ecartType.setEditable(false);
		
		
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





	public void trace_ligne(Graphics g, int val1 , int val2 , int i)
	{
		g.setColor(Color.red);

			g.drawLine(50+(500/nbr)*i, 550-val1 , 50+(500/nbr)*(i+1), 550- val2 );

	


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
		while (i!= (nbr-1) )
		{
			trace_ligne(g, tab[i] , tab [i+1] , i);
			i++;
		}

	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		graphique graph = new graphique();
		graph.show();
	}





	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		get_value();
		repaint();
	}

}
