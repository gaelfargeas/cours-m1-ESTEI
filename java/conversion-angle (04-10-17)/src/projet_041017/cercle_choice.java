
package projet_041017;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;


public class cercle_choice extends Applet implements ActionListener , ItemListener {


	Button b;
	TextField tf;

	TextField rouge;
	TextField vert;
	TextField bleu;
	int rayon = 20;
	Choice choix;

	public void init()
	{
		//definit la taille de la fenetre
		setSize(300,300);



		Label l = new Label("rayon");
		rouge =new TextField(10);
		rouge.addActionListener(this);
		vert =new TextField(10);
		vert.addActionListener(this);		
		bleu =new TextField(10);
		bleu.addActionListener(this);
		tf =new TextField(10);
		tf.addActionListener(this);
		
		
		choix = new Choice();
		choix.addItem("cercle");
		choix.addItem("carrer");
		choix.addItemListener(this);


		add(l);

		add(tf);

		add(choix);

		add(rouge);
		add(vert);
		add(bleu);


	}

	public void paint (Graphics g)
	{
		
		//color couleur = new Color(arg0)
		//dessin un cercle

		int L = ((getSize().width)/2)-(rayon/2) ;
		int l = ((getSize().height)/2)-(rayon/2) ;


		if (choix.getSelectedItem().equals("carrer")) {

			//g.setColor(couleur);
			g.fillRect(L, l, rayon, rayon);

		}else{

			//dessin un cercle 
			//g.setColor(couleur);
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