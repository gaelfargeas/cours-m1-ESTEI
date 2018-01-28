import java.awt.*;
import java.awt.event.*;
public class msgbox extends Dialog implements ActionListener{

	boolean flag = false ;
	Button ok,cancel;

	public  msgbox(Frame fr , String msg , boolean okcancel)
	{
		//contructeur herité
		super (fr , "message",true);
		//gestionnaire de possitionement
		setLayout(new BorderLayout());
		add(new Label(msg , Label.CENTER), BorderLayout.CENTER);

		//bouton

		Panel p = new Panel();
		p.setLayout(new FlowLayout());
		ok = new Button("OK");
		p.add(ok);
		ok.addActionListener(this);
		if(okcancel)
		{
			cancel = new Button("Cancel");
			p.add(cancel);
			cancel.addActionListener(this);

		}

		add(p , BorderLayout.SOUTH);

		//redimentionement et possitionement
		pack();
		Dimension d = getToolkit().getScreenSize();
		setLocation(d.width/2, d.height/2);
		setVisible(true);

	}

	public static void affmsg (Frame fr,String msg) {

		msgbox mb = new msgbox(fr, msg,false);
		mb.dispose();
	}

	public static boolean affrep (Frame fr,String msg) {

		msgbox mb = new msgbox(fr, msg,true);
		mb.dispose();
		return mb.flag;

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource().equals(ok))
		{
			flag=true ;
			setVisible(false);	
		}else 
		{
			flag=false ;
			setVisible(false);
		}


	}


}
