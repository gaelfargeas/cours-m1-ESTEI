package projet_111017;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class test_possition3 extends Applet implements ActionListener {

	
	CardLayout carte;
	Panel fruitetlegume ;
	Button bouton = new Button("fruit ou legume");
	
	
	public void init () 
	{
		
		//panel pour les fruit
		
		Panel p1 = new Panel();
		p1.add( new Button("Pomme"));
		p1.add( new Button("Poire"));
		p1.add( new Button("Abricot"));
		p1.add( new Button("Orange"));
		
		
		//panel pour les legume
		
		Panel p2 = new Panel();
		p2.add( new Button("Viande"));
		p2.add( new Button("Poulet"));
		p2.add( new Button("Boeuf"));
		p2.add( new Button("Mouton"));

		fruitetlegume =new Panel();
		carte = new CardLayout();
		fruitetlegume.setLayout(carte);
		fruitetlegume.add("fruit", p1);
		fruitetlegume.add("legume", p2);

			setLayout(new BorderLayout());
			add (bouton , BorderLayout.NORTH);
			add (fruitetlegume , BorderLayout.CENTER);
			bouton.addActionListener(this);
	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		carte.next(fruitetlegume);
	}
	
	
	
}
