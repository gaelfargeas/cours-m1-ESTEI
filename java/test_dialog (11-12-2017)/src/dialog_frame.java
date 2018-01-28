import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class dialog_frame extends Frame implements ActionListener {

		Button b ;
	
	public dialog_frame()
	{
		b=new Button("salut");
		b.addActionListener(this);
		setSize(300, 300);
		setLayout(new BorderLayout());
		add(b,BorderLayout.CENTER);
		
		addWindowListener(new Fermeture());

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dialog_frame df = new dialog_frame();
		df.show();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(b))
		{
			msgbox.affrep(this,"salut");
			
		}
	}

}
