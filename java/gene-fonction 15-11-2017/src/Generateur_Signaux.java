

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Generateur_Signaux extends Frame implements ActionListener {


	Choice choix;
	Label L;
	TextField resultat ,ampl ,offset ,frequence; 
	Button trace;


	int tab[] =new int[50]; //remplacer 100 par la frequence
	int nbr =1 ;





	public Generateur_Signaux() {

		setSize(600,600);
		setTitle("Courbe");

		//instantiation
		setLayout(new BorderLayout());
		Panel control = new Panel();
		control.setLayout(new GridLayout(2, 5));

		L=new Label("Signal");
		choix = new Choice();
		ampl = new TextField(10);
		offset = new TextField(10);
		frequence = new TextField(10);
		trace=new Button("tracé");
		resultat= new TextField(10);

		//label

		control.add(L);
		L=new Label("Amplitude");
		control.add(L);
		L=new Label("Offset");
		control.add(L);
		L=new Label("Frequence");
		control.add(L);
		L=new Label("");
		control.add(L);

		//placement



		choix.addItem("Sinusoide");
		choix.addItem("Carré");
		choix.addItem("Triangle");
		control.add(choix);

		ampl.setText("1000");
		control.add(ampl);
		offset.setText("0");
		control.add(offset);		
		frequence.setText("50");
		control.add(frequence);		

		control.add(trace);
		trace.addActionListener(this);
		add(control , BorderLayout.NORTH);
		add(resultat , BorderLayout.SOUTH);
		resultat.setEditable(false);

		addWindowListener(new Fermeture() );


	}







	public void trace_ligne(Graphics g)
	{
		g.setColor(Color.red);

		for (int i = 0 ; i < tab.length -1 ; i++)
		{

			g.drawLine( (50 +  ( getWidth() / tab.length )*i ), (  ( (getHeight()/2)+tab[i]) ), (50 +  ( getWidth() / tab.length )*(i+1) ) , (  ( (getHeight()/2)+tab[i+1] ) ));	
		}





	}

	public void init_tableau_Sinusoide ()
	{
		double val;
		int amplitude =1000;
		int offs =0 ;
		try {
			amplitude = Integer.parseInt(ampl.getText());
			offs = Integer.parseInt(offset.getText());

		} catch (Exception e) {

			System.out.println(e.toString());

		}



		for (int i = 0 ; i < tab.length ; i++)
		{


			val = i*(4*Math.PI / (tab.length - 1) );
			tab[i]= (int)(  (amplitude * Math.sin(val) ) - offs +(amplitude/10 *Math.random()) );



		}


	}

	public void init_tableau_Carre ()
	{
		int amplitude =1000;
		int offs = 0 ;
		try {
			amplitude = Integer.parseInt(ampl.getText());
			offs = Integer.parseInt(offset.getText());

		} catch (Exception e) {

			System.out.println(e.toString());

		}

		for (int ia = 0 ; ia < tab.length/4 ; ia++)
		{
			tab[ia]= (int)( (-amplitude) - offs );
		}
		for (int ib = tab.length/4 ; ib < 2*tab.length/4 ; ib++)
		{
			tab[ib]= (int)( (amplitude) - offs );
		}
		for (int ic = 2*tab.length/4 ; ic < 3*tab.length/4 ; ic++)
		{
			tab[ic]= (int)( (-amplitude) - offs );
		}			
		for (int id = 3*tab.length/4 ; id < tab.length ; id++)
		{
			tab[id]= (int)( (amplitude) - offs );
		}	





	}


	public void init_tableau_Triangle ()
	{
		
		int amplitude =1000;
		int offs = 0 ;
		try {
			amplitude = Integer.parseInt(ampl.getText());
			offs = Integer.parseInt(offset.getText());

		} catch (Exception e) {

			System.out.println(e.toString());

		}

		for (int ia = 0 ; ia < tab.length/4 ; ia++)
		{
			tab[ia]= (int)( ( (-amplitude/(tab.length/4))*ia) - offs );
		}
		for (int ib = tab.length/4 ; ib < 2*tab.length/4 ; ib++)
		{
			tab[ib]= (int)(tab[tab.length/4] + ( (amplitude/tab.length/4)*ib) - offs );
		}
		
		for (int ic = 2*tab.length/4 ; ic < 3*tab.length/4 ; ic++)
		{
			tab[ic]= (int)(2*tab.length/4 + ( (amplitude/(2*tab.length/4))*ic) - offs );
		}			
		for (int id = 3*tab.length/4 ; id < tab.length ; id++)
		{
			tab[id]= (int)(3*tab.length/4 + ( (amplitude/(2*tab.length/4))*id) - offs );
		}


	}


	public void trace_axes (Graphics g) 
	{
		int H = getHeight(); //hauteur
		int L = getWidth();	//largeur
		//verticale
		g.drawLine(50, 50, 50, H); 
		//horizontale
		g.drawLine(25, H/2, L, H/2);


	}

	public void set_moyenne()
	{
		double moyenne =0;
		for (int i = 0 ; i < tab.length ; i++)
		{
			moyenne += tab[i];
		}
		resultat.setText("" + moyenne);

	}



	public void paint (Graphics g)
	{			
		trace_axes(g);
		trace_ligne(g);
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Generateur_Signaux c = new Generateur_Signaux();
		c.show();
	}





	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub


		tab = new int[Integer.parseInt (frequence.getText())];
		String signal = choix.getSelectedItem();
		switch (signal)
		{
		case "Sinusoide" :
			init_tableau_Sinusoide();
			break;
		case "Carré" :
			init_tableau_Carre();

			break;
		case "Triangle" :
			init_tableau_Triangle();

			break;
		default :
			break;
		}


		set_moyenne();
		repaint();
	}

}
