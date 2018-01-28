package projet_111017;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculatrice extends Applet implements ActionListener{


	TextField tf ;
	Button clear , plus , moins , div , mul , egal ;
	String str="";
double A,B , R;
int op;
	public void init()
	{

		setLayout(new BorderLayout());
		tf= new TextField();
		tf.setEditable(false);

		add (tf , BorderLayout.NORTH);

		// ajoute les bouton du milieu

		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(2,5)); //declare du gridlayout pour p1
		for (int i=0 ; i<10;i++) 
		{
			Button b = new Button(""+i);
			b.addActionListener(this);
			b.setActionCommand(""+i);
			p1.add(b);


		}

		add(p1 , BorderLayout.CENTER);


		//ajoute les bouton du bas

		Panel p2 = new Panel();
		p2.setLayout(new GridLayout(1,6));

		clear = new Button("C");
		clear.addActionListener(this);
		p2.add(clear);

		plus = new Button("+");
		plus.addActionListener(this);
		p2.add(plus);

		moins = new Button("-");
		moins.addActionListener(this);
		p2.add(moins);

		div = new Button("/");
		div.addActionListener(this);
		p2.add(div);

		mul = new Button("X");
		mul.addActionListener(this);
		p2.add(mul);

		egal = new Button("=");
		egal.addActionListener(this);
		egal.setEnabled(false);
		p2.add(egal);

		add(p2 , BorderLayout.SOUTH);






	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String rev = e.getActionCommand();


		switch (rev.charAt(0)) {
		case 'C':
			str="";
			tf.setText(str);
			break;

		case '+':
			op=0;
			A=Double.parseDouble(tf.getText());
			str="";
			tf.setText(str);
			activeOp();
			break;
			
		case '-':
			op=1;
			A=Double.parseDouble(tf.getText());
			str="";
			tf.setText(str);
			activeOp();
			break;
			
		case '/':
			op=2;
			A=Double.parseDouble(tf.getText());
			str="";
			tf.setText(str);
			activeOp();
			break;
			
		case 'X':
			op=3;
			A=Double.parseDouble(tf.getText());
			str="";
			tf.setText(str);
			activeOp();
			break;
			
		case '=':
			B=Double.parseDouble(tf.getText());
			
			switch (op) {
			case 0:
				R=A+B;
				break;
			case 1:
				R=A-B;
				break;
			case 2:
				R=A/B;
				break;
			case 3:
				R=A*B;
				break;

			default:
				break;
			}
			
			egal.setEnabled(false);
			plus.setEnabled(true);
			moins.setEnabled(true);
			mul.setEnabled(true);
			div.setEnabled(true);

			
			str=""+R;
			tf.setText(str);
			str="";
			
			break;
			
		default:
			str += e.getActionCommand();
			tf.setText(""+Integer.parseInt(str) );
			break;
		}





	}


void activeOp() {
	egal.setEnabled(true);
	plus.setEnabled(false);
	moins.setEnabled(false);
	mul.setEnabled(false);
	div.setEnabled(false);
	
}
}
