

package projet_041017;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;


public class conversion2 extends Applet implements ActionListener {


	TextField tf ,tfrad , tfcos , tfsin ,tftang;


	public void init()
	{
		//definit la taille de la fenetre
		setSize(300,300);


		Label l= new Label("Angle en degrés");


		tf =new TextField(10);
		tf.addActionListener(this);
		
		add(l);
		add(tf);

		tfrad =new TextField(10);
		Place_text(l, "Angle en radian", tfrad);

		tfcos =new TextField(10);
		Place_text(l, "cos", tfcos);

		tfsin =new TextField(10);
		Place_text(l, "sin", tfsin);

		tftang =new TextField(10);
		Place_text(l, "tang", tftang);



	}

	public void Place_text(Label l ,String str , TextField tf)
	{
		l = new Label(str);
		tf.addActionListener(this);
		tf.setEditable(false);
		add(l);
		add(tf);
	}

	double arrondie (double rad , int n)
	{
		double v = 0;

		v=(int)rad * Math.pow(10, n);
		v /=Math.pow(10, n);

		return v;
	}

	public void paint (Graphics g)
	{





	}

	double degre_to_radian (String str)
	{	

		double rad = 0 ;
		int v= Integer.parseInt(str)% 360;
		rad = (v/180.0)*Math.PI;
		return rad;

	}

	double cosinus (double rad)
	{	

		double cos=Math.cos(rad);
		return cos;

	}


	double sinus (double rad)
	{	

		double sin=Math.sin(rad);
		return sin;

	}

	double tangente (double rad)
	{	

		double tan=Math.tan(rad);
		return tan;

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(tf))
		{
			//convertie en radian
			double rad = degre_to_radian( tf.getText() );
			tfrad.setText(""+arrondie(rad ,2 ));

			//cos
			tfcos.setText(""+arrondie(cosinus(rad) , 2 ) );
			//sin 
			tfsin.setText(""+arrondie(sinus(rad) ,2 ));			

			//tang
			tftang.setText( ""+arrondie(tangente(rad),2 ));			



			repaint();	
		}



	}




}