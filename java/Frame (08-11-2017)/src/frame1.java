
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class frame1 extends Frame implements ActionListener
{

	carrer_cercle choix;





	public frame1() 
	{
		//initialise l'applet
		setSize(300,300);	

		MenuItem mi ;
		setLayout(new BorderLayout());

		addWindowListener(new Fermeture());

		//bar de menue
		MenuBar mb = new MenuBar();
		setMenuBar(mb);

		//menu fichier
		Menu m1 = new Menu("fichier");
		mb.add(m1);

		//menu editer
		Menu m2 = new Menu("Editer");
		mb.add(m2);

		//ajoute le sous menu quiter au menu fichier
		mi = new MenuItem("quiter");
		m1.setActionCommand("quiter");
		mi.addActionListener(this);
		m1.add(mi);


		//ajoute le sous menu carrer au menu editer
		mi = new MenuItem("carrer");
		m1.setActionCommand("carrer");
		mi.addActionListener(this);
		m2.add(mi);

		//ajoute le sous menu cercle au menu editer
		mi = new MenuItem("cercle");
		m1.setActionCommand("cercle");
		mi.addActionListener(this);
		m2.add(mi);
		m2.addSeparator();

		//ajoute le sous menu retracer au menu editer
		mi = new MenuItem("retracer");
		m1.setActionCommand("retracer");
		mi.addActionListener(this);
		m2.add(mi);

		choix =new carrer_cercle();
		add(choix , BorderLayout.CENTER);
		choix.init();
		choix.start();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		frame1 tf = new frame1();
		tf.show();

	}	
	public void paint (Graphics g)
	{	
		//affiche l'applet


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub


		switch (e.getActionCommand()) {


		case "quiter":
			System.exit(0);	
			
			break;

		case "cercle":
			choix.choix("cercle");
			choix.repaint();

			break;
		case "carrer":
			choix.choix("carrer");
			choix.repaint();

			break;
		case "retracer":
			choix.repaint();
			
			break;

		default:
			break;
		}












	}










}
