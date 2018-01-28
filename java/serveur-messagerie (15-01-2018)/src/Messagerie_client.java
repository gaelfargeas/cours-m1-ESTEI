import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;


public class Messagerie_client extends Frame implements Runnable,ActionListener {

	TextField question , log;
	TextArea reponse;
	BufferedReader depuisserveur ;
	PrintWriter versserveur ;
	Label lbq ,lbr , lblog ;
	Button bpco;
	boolean isco;
	Socket S;

	Thread process = null;

	public Messagerie_client ()
	{
		isco = false;
		setSize(400, 400);
		setLayout(new GridLayout(3, 1));
		setTitle("messagerie locale client");

		lbq= new Label("question :");
		lbr= new Label("reponse du serveur:");
		lblog= new Label("log :");

		question = new TextField(10);
		reponse = new TextArea();
		log = new TextField(10);

		bpco= new Button("connect");
		bpco.addActionListener(this);

		Panel p1 = new Panel(new GridLayout(2, 1) );
		Panel p2 = new Panel(new GridLayout(2, 1) );
		Panel p3 = new Panel(new GridLayout(3, 1) );


		p1.add(lbq);

		question.setEditable(true);
		question.addActionListener(this);
		p1.add(question);

		add(p1);

		p2.add(lbr);
		p2.add(reponse);
		reponse.setEditable(false);
		add(p2);


		p3.add(bpco);
		p3.add(lblog);
		p3.add(log);
		log.setEditable(false);
		add(p3);

		addWindowListener(new Fermeture());
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Messagerie_client ms = new Messagerie_client();
		ms.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		if (arg0.getSource().equals(question))
		{

			try {

				versserveur = new PrintWriter(S.getOutputStream() , true);
				versserveur.println(question.getText());
				reponse.append("client : " + question.getText() + "\n" );

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.toString());
			}



		}else if (arg0.getSource().equals(bpco))
		{

			if(isco == false) 
			{//si on est pas co et que l'on appui sur le bouton

				process = new Thread(this);
				process.start();
				bpco.setLabel("Disconnect");
				isco=true;
				log.setText("isco = " + isco);
			}else if (isco == true)
			{
				try 
				{
					S.close();
					process.stop();
					bpco.setLabel("connect");
					isco=false;

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.toString());
				}


			}

		}


	}

	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		int port = 1023;

		//while (true) 
		{
			try 
			{
				//conect au serveur		

				InetAddress addr = InetAddress.getByName("localhost");
				SocketAddress sockaddr = new InetSocketAddress(addr, port);
				S =new Socket();
				S.connect(sockaddr);
				log.setText("connecter au serveur sur le port " + port);

				traitement(S);


			} catch (Exception e) 
			{
				// TODO: handle exception
				System.out.println(e.toString());
			}
		}
	}

	public void traitement (Socket s) 
	{
		try {

			depuisserveur = new BufferedReader(new InputStreamReader(s.getInputStream()));
			versserveur = new PrintWriter(s.getOutputStream(),true);
			while(S.isConnected())
			{
				reponse.append("serveur : " + depuisserveur.readLine() + "\n");
			}
			log.setText("DECONNEXION . vous ete deconnecter du serveur");


		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}




	}





}
