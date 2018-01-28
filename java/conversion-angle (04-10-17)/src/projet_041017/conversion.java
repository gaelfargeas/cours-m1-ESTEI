

package projet_041017;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;


public class conversion extends Applet implements ActionListener {


	TextField tf ,tf2 , tf3 , tf4 ,tf5;


	public void init()
	{
		//definit la taille de la fenetre
		setSize(300,300);



		Label l1 = new Label("angle en degré");
		Label l2 = new Label("angle en radian");
		Label l3 = new Label("cos");
		Label l4 = new Label("sin");
		Label l5 = new Label("tang");

		tf =new TextField(10);
		tf.addActionListener(this);

		
		tf2 =new TextField(10);
		tf2.addActionListener(this);
		tf2.setEditable(false);
		
		tf3 =new TextField(10);
		tf3.addActionListener(this);
		tf3.setEditable(false);
		
		tf4 =new TextField(10);
		tf4.addActionListener(this);
		tf4.setEditable(false);
		
		tf5 =new TextField(10);
		tf5.addActionListener(this);
		tf5.setEditable(false);
		



		add(l1);
		add(tf);

		add(l2);
		add(tf2);

		add(l3);
		add(tf3);

		add(l4);
		add(tf4);

		add(l5);
		add(tf5);


	}

	public void paint (Graphics g)
	{





	}
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(tf))
		{
			String str = tf.getText();
			
			//convertie en radian
			int v= Integer.parseInt(str)% 360;
			double rad = (v/180.0)*Math.PI;
			tf2.setText(""+rad);
			
			//cos
			double cos=Math.cos(rad);
			tf3.setText(""+cos);
			//sin 
			double sin=Math.sin(rad);
			tf4.setText(""+sin);			
			
			//tang
			double tang=Math.tan(rad);
			tf5.setText(""+tang);			
			
			
			
			repaint();	
		}



	}




}