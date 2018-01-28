package projet_111017;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Temperature extends Applet implements ActionListener {


	TextField tfc , tff;

	public void init()
	{

		Label l;
		setSize(300,300);
		l = new Label ("Conversion de temperature");
		add (l);
		tfc = new TextField(10);
		tfc.addActionListener(this);

		tff = new TextField(10);
		tff.addActionListener(this);

		add (tfc);
		add (tff);

	}


	public void paint (Graphics g)
	{





	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(tfc))
		{

			double far=0;
			far =( ( ( Double.parseDouble( tfc.getText() )  )* (9.0/5.0) )+32 );
			tff.setText(""+far);



			repaint();
		} else {


			double deg=0;
			deg =( Double.parseDouble( tff.getText() ) );
			deg -= 32;
			deg *= (5.0/9.0);
			
			tfc.setText(""+deg);	



		}





	}

}
