import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.*;


public class AppletThread extends Applet implements Runnable, ActionListener {


	private Thread processus = null ;
	int speed = 1000 ;
	int val = 0;
	Label lb = new Label("vitesse");
	Panel pn = new Panel();
	TextField tf = new TextField() ;
	int pos = 0 ;
	public void init()
	{
		setSize(300 ,300);
		setLayout(new BorderLayout());
		tf.addActionListener(this);
		pn.setLayout(new GridLayout(1, 2));
		pn.add(lb) ;
		pn.add(tf) ;

		add(pn , BorderLayout.NORTH);


	}

	public void start()
	{
		if (processus == null)
		{
			processus = new Thread(this);
			processus.start();;




		}

	}

	public void stop()
	{
		processus.stop();
		processus = null ;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (processus != null)
		{


			try {

				processus.sleep(speed);
				val++;
				repaint();



			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.toString());

			}

		}



	}



	public void paint(Graphics g)
	{

		g.drawString(""+val, 100, 100);
		String mot  = new String("salut");
		if( (pos) < ( ( getWidth() ) - mot.length() )  )
		{
			
		pos ++;	
		} else {
			pos =0;
			
		}
		g.drawString(mot, pos, 150);
		



	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		speed = Integer.parseInt(tf.getText());
		tf.setText("");
	}



}
