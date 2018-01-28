
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.*;


public class ChonometreThread extends Applet implements Runnable, ActionListener {


	private Thread processus = null ;
	long speed = 10 ;
	boolean fpause = true ;
	int val = 0;
	Panel pn = new Panel();
	Button start = new Button("start") ;
	Button pause = new Button("pause") ;
	Button stop = new Button("stop") ;
	int pos = 0 ;
	String temps =new String();

	public void init()
	{
		setSize(300 ,300);
		setLayout(new BorderLayout());
		pn.setLayout(new GridLayout(1, 3));


		start.addActionListener(this);
		pause.addActionListener(this);
		stop.addActionListener(this);


		pn.add(start) ;
		pn.add(pause) ;
		pn.add(stop) ;

		stop.setEnabled(false);
		start.setEnabled(true);
		pause.setEnabled(false);

		add(pn , BorderLayout.NORTH);

	}

	public void Start()
	{
		if (processus == null)
		{
			processus = new Thread(this);
			processus.start();
			fpause=true;
			val = 0;
		}

	}

	public void Stop()
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
				if (fpause == true)
				{
					val ++ ;
					temps = (val/360000) + " heure(s) " +( (val - ( (val/360000)*360000 ) )/6000 ) + " minut(e) " +  ((val - ( (val/6000)*6000 ) )/100 ) + " seconde(s) : " + (val - ( (val/100)*100 ) ) +" mseconde(s)" ;
					repaint();
				}				




			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.toString());

			}

		}



	}



	public void paint(Graphics g)
	{



		FontMetrics fm = getFontMetrics(getFont());
		int l_chaine = fm.stringWidth(temps);
		g.drawString(temps, getWidth()/2 - l_chaine/2 , getHeight()/2 );

		if (processus == null)
		{
			//chaine de caractere a afficher
			String depart =  0 + " heure(s) " + 0 + " minute(s) " + 0 + " seconde(s) : " + 0 +" mseconde(s)" ;
			// on recupere la taille de la chaine de caractere
			int l_depart = fm.stringWidth(depart);
			g.drawString(depart, getWidth()/2 - l_depart/2 , getHeight()/2 );
		}


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String bp_select = e.getActionCommand();
		switch (bp_select) {
		case "start":


			Start();

			stop.setEnabled(true);
			start.setEnabled(false);
			pause.setEnabled(true);
			break;
		case "pause":
			if (fpause == true)
			{
				fpause = false;
			}else
			{
				fpause=true;
			}

			stop.setEnabled(true);
			start.setEnabled(false);
			pause.setEnabled(true);
			break;
		case "stop":

			Stop();
			fpause=false;

			stop.setEnabled(false);
			start.setEnabled(true);
			pause.setEnabled(false);

			break;
		default:
			break;
		}




	}



}
