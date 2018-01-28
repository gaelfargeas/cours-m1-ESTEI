package projet_041017;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;


public class Cercle_Text_Button extends Applet implements ActionListener , ItemListener {


	Button b;
	TextField tf;
	int rayon = 20;
	CheckboxGroup groupe;
	Checkbox carrer ;
	Checkbox cercle ;

	public void init()
	{
		//definit la taille de la fenetre
		setSize(200,200);
	
		
		
		Label l = new Label("tracer");
		tf =new TextField(10);
		tf.addActionListener(this);
		add(l);
		
		add(tf);
		groupe = new CheckboxGroup();	
		carrer = new Checkbox("carrer" , groupe , false);
		cercle = new Checkbox("cercle" , groupe , true);
		
		add(cercle);
		carrer.addItemListener(this);
		
		add(carrer);
		cercle.addItemListener(this);
		

	}

	public void paint (Graphics g)
	{
		//dessin un cercle
		
		int L = ((getSize().width)/2)-(rayon/2) ;
		int l = ((getSize().height)/2)-(rayon/2) ;
		

		if (carrer.getState()) {
			
			g.setColor(Color.cyan);
			g.fillRect(L, l, rayon, rayon);
			
		}else{
			
			//dessin un cercle 
			g.setColor(Color.red);
			g.fillOval(L, l, rayon, rayon);

			
			
		}

		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
			String str = tf.getText();
			rayon = Integer.parseInt(str);
			repaint();


	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}


}