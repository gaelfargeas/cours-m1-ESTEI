package projet_08112017;

import java.util.StringTokenizer;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class test_StringTokenizer extends Frame implements ActionListener {

	TextField tf; 
	TextField tf2;


	public test_StringTokenizer() 
	{
		setSize(600,600);
		setLayout(new GridLayout(2, 1));

		setTitle("calcul");

		Label l1 = new Label("operation");
		add(l1);

		tf = new TextField();
		add(tf);
		tf.addActionListener(this);

		Label l2 = new Label("resultat");
		add(l2);

		tf2 = new TextField();
		add(tf2);
		tf2.setEditable(false);

		addWindowListener(new Fermeture() );


	}


	public void paint (Graphics g)
	{	
		//affiche l'applet


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		test_StringTokenizer STK = new test_StringTokenizer();
		STK.show();


		/*
		String str ="ceci est un test";
		StringTokenizer st = new StringTokenizer(str);
		String mot ;
		int i =0;
		while (st.hasMoreTokens())
		{
			i++;
		 mot = st.nextToken();
		System.out.println("Le mot a la position " + i + " est  : " + mot );

		}*/
	}


















	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//variable
		double a =0  ,b=0 ;
		String op ="";
		String str = e.getActionCommand();
		StringTokenizer st = new StringTokenizer(str);
		
		//init la 1er valeur
		try {
		a = Double.parseDouble( st.nextToken() );	
		}
		catch (Exception f) {
			
		System.out.println(f.toString());	
		tf2.setText("error");	
		}
				
		
		while (st.hasMoreTokens())
		{
			
			// il faut rajouter la gestion des ()
			try {	
			op =  st.nextToken();
			b =  Double.parseDouble(st.nextToken() );	
			}
			catch (Exception f) {
				
			System.out.println(f.toString());	
				
			}
				
				
				
			
			
			
			
			switch (op) 
			{
			case "+":
				a=a+b;
				tf2.setText(""+a);
				break;
			case "-":
				a=a-b;
				tf2.setText(""+a);
				break;
			case "/":
				a=a/b;
				tf2.setText(""+a);
				break;
			case "*":
				a=a*b;
				tf2.setText(""+a);
				break;
			default:
				tf2.setText("error");
				break;
			}

	
			
		}


	}

}
