import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Messagerie_serveur extends Frame implements Runnable,ActionListener {

	TextField question ,log;
	TextArea reponse;
	BufferedReader depuisclient ;
	PrintWriter versclient ;
	Label lbq ,lbr , lblog ;

	ServerSocket serveur ;
	Socket S;

	Thread process = null;

	public Messagerie_serveur ()
	{

		setSize(400, 400);
		setLayout(new GridLayout(3, 1));
		setTitle("messagerie locale serveur");

		lbq= new Label("question :");
		lbr= new Label("reponse :");
		lblog= new Label("log :");

		question = new TextField(10);
		reponse = new TextArea();
		log = new TextField(10);

		Panel p1 = new Panel(new GridLayout(2, 1) );
		Panel p2 = new Panel(new GridLayout(2, 1) );
		Panel p3 = new Panel(new GridLayout(2, 1) );


		p1.add(lbq);

		question.setEditable(true);
		question.addActionListener(this);
		p1.add(question);

		add(p1);

		p2.add(lbr);
		p2.add(reponse);
		reponse.setEditable(false);
		add(p2);

		p3.add(lblog);
		p3.add(log);
		log.setEditable(false);
		add(p3);

		addWindowListener(new Fermeture());

		process = new Thread(this);
		process.start();
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Messagerie_serveur ms = new Messagerie_serveur();
		ms.setVisible(true);
	}


	public void run() {
		// TODO Auto-generated method stub
		int port = 1023;


		try {
			//crée le serveur
			serveur = new ServerSocket(port);
			log.setText("Serveur connecter sur le port " + port);
			
			while(true)
			{
				S= serveur.accept();
				traitement(S);
			}



		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}

	public void traitement (Socket s) 
	{
		try {

			depuisclient = new BufferedReader(new InputStreamReader(s.getInputStream()));
			versclient = new PrintWriter(s.getOutputStream(),true);
			versclient.println("bienvenue sur le serveur");
			while (true)
			{
			reponse.append("client : " + depuisclient.readLine() + "\n");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(question))
		{
			
			try {
				
				versclient = new PrintWriter(S.getOutputStream() , true);
				
				versclient.println(question.getText());
				reponse.append("serveur : " + question.getText() + "\n");
				question.setText("");
			} catch (Exception er) {
				// TODO: handle exception
				System.out.println(er.toString());
			}
			
			
			
		}
	}
	
}
