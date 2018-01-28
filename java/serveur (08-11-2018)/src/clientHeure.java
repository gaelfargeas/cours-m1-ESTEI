import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class clientHeure extends Frame implements Runnable , ActionListener {


	int portserveur ;
	String adrserveur;
	Thread process = null ;
	Socket sk ;
	BufferedReader depuisServeur;
	PrintWriter versServer ;
	Label heure = new Label("connection au serveure");
	Button but ;


	public clientHeure (String adr , int port)
	{

		setSize(300,300);
		setLayout(new BorderLayout());


		adrserveur = adr ;
		portserveur = port ;
		addWindowListener(new Fermeture());

		Panel p = new Panel(new GridLayout(2,1));
		p.add(heure);
		heure.setAlignment(Label.CENTER);
		but = new Button("h");
		p.add(but);
		but.addActionListener(this);
		add(p);


		//lance le serveur
		new Thread(this).start();

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		clientHeure c1 = new clientHeure("localhost", 1024);
		c1.setVisible(true);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(but) )
		{
			versServer.println("h");

		}


	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Boolean fin = false ;
		String ligne;

		try {
			connect();
			
			while(!fin)
			{		
				ligne = depuisServeur.readLine();

				switch (ligne) {
				case "":
					fin = true;
					break;
				case "Au revoir" :
					fin = true;
					break;

				case "il est":
					heure.setText(ligne);
					break;
				default:
					ligne ="" ;
					break;
				}

			}	
			disconnect();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			heure.setText("probleme de connexion avec le serveur");
		}
		finally
		{
			process =null;

		}

	}


	public void connect() 
	{
		try {

			sk = new Socket(adrserveur, portserveur);
			depuisServeur = new BufferedReader(new InputStreamReader(sk.getInputStream() ) );
			versServer = new PrintWriter(sk.getOutputStream(), true );
			versServer.println("");
			versServer.println("h");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			heure.setText("impossible de se connecter avec le serveur ");
		}




	}

	public void disconnect() 
	{
		try {

			sk.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			heure.setText("de fermet la connection avec le serveur ");
		}




	}




}
