package projet_19102017;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





public class frame_cal_exept extends Frame implements ActionListener {


	TextField tfa , tfb ,tfr ;
	Button plus , egal ;
	String str="";
	double A,B , R;
	
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		frame_cal_exept tf = new frame_cal_exept();
	tf.show();
	
}

	public frame_cal_exept() {
		// TODO Auto-generated method stub
		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(1,2)); 
		
		setSize(300,300);	
		setTitle("calcule");
		setLayout(new BorderLayout());
		
		//ajoute le bouton quiter
		addWindowListener(new Fermeture());

		//fenetre nombre A
		tfa= new TextField(10);
		tfa.setEditable(true);
		add (tfa , BorderLayout.NORTH);
		p1.add(tfa);
		//fenetre nombre B
		tfb= new TextField(10);
		tfb.setEditable(true);
		add (tfb , BorderLayout.NORTH);	
		p1.add(tfb);
		//fenetre resultat

		tfr= new TextField();
		tfr.setEditable(true);
		add (tfr , BorderLayout.SOUTH);	



		// ajoute les bouton du milieu

		Panel p2 = new Panel();
		p2.setLayout(new GridLayout(1,5)); //declare du gridlayout pour p1

		//ajoute le bouton +
		plus = new Button("+");
		plus.addActionListener(this);
		p2.add(plus);

		//ajoute le bouton egal
		egal = new Button("=");
		egal.addActionListener(this);
		p2.add(egal);

		add(p2 , BorderLayout.CENTER);





	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			/*
	switch (rev.charAt(0)) {
	

	case '+':
		A=Double.parseDouble(tf.getText());
		str="";
		tf.setText(str);
		activeOp();
		break;

	
	

	case '=':
		B=Double.parseDouble(tf.getText());

		
			R=A+B;
		
		str=""+R;
		tfr.setText(str);
		str="";

		break;

	default:
		break;
	}*/
		
		
		System.exit(0);
	}
	
	
	}

