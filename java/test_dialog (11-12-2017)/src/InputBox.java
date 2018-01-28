import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputBox extends Dialog implements ActionListener {

	TextField tf ;
	Button ok,cancel;
	String msg ;
	public  InputBox(Frame fr, String str)
	{
		//contructeur herité
		super (fr,"message",true);
		//gestionnaire de possitionement

		setLayout(new BorderLayout());
		//text	
		
		Label lb = new Label(str , Label.CENTER);
		add(lb , BorderLayout.NORTH);
		
		tf = new TextField(20);
		add(tf , BorderLayout.CENTER);
		//bouton

		Panel p = new Panel();
		p.setLayout(new FlowLayout());
		ok = new Button("OK");
		p.add(ok);
		ok.addActionListener(this);

		cancel = new Button("Cancel");
		p.add(cancel);
		cancel.addActionListener(this);

		add(p , BorderLayout.SOUTH);

		//redimentionement et possitionement
		pack();
		Dimension d = getToolkit().getScreenSize();
		setLocation(d.width/2, d.height/2);
		setVisible(true);

	}

	public static String affmsg (Frame fr , String str) {

		InputBox ib = new InputBox(fr , str);
		ib.dispose();
		String rep = ib.msg;
		return rep;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource().equals(ok))
		{
			msg =tf.getText();
			setVisible(false);	
		}else if (e.getSource().equals(cancel)) 
		{
			msg="";
			setVisible(false);
		}
		 

	}
}
