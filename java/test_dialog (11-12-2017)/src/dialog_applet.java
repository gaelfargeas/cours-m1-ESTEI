import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.CompositeName;


public class dialog_applet extends Applet implements ActionListener {

		Button b ;
	
	public dialog_applet()
	{
		b=new Button("salut");
		b.addActionListener(this);
		setSize(300, 300);
		setLayout(new BorderLayout());
		add(b,BorderLayout.CENTER);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dialog_applet df = new dialog_applet();
		df.show();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(b))
		{
			Frame fr= null ;
			Component parentcourant = this ;
			while (parentcourant != null && fr == null)
			{
				
				if(parentcourant instanceof Frame)
				{
					fr=(Frame)parentcourant;
				}
				else parentcourant= parentcourant.getParent();
					
				
			}

			msgbox.affrep(fr,"salut");
			
		}
	}

}
