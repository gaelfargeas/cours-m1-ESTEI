import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

public class FTP_client extends Frame implements Runnable , ActionListener, ItemListener{


	int portserveur ;
	String adrserveur;
	Thread process = null ;
	Socket sk ;
	BufferedReader depuisServeur;
	PrintWriter versServer ;


	TextArea ta ;

	List liste ;
	TextField tf ;
	Button bpco ,savetoserver ,savetoclient;
	boolean isco=false;

	boolean isls = false;
	boolean iscd = false;
	boolean isget = false;

	public FTP_client (String adr , int port)
	{

		setSize(600,600);
		setTitle("FTP Client");
		setLayout(new BorderLayout());


		adrserveur = adr ;
		portserveur = port ;
		addWindowListener(new Fermeture());

		//==========zone au top============================
		Panel p = new Panel();
		p.setLayout(new GridLayout(2, 2));
		//crée les boutons
		bpco= new Button("connect");
		bpco.addActionListener(this);

		savetoclient= new Button("save to client");
		savetoclient.addActionListener(this);
		savetoclient.setEnabled(false);

		savetoserver= new Button("save to server");
		savetoserver.addActionListener(this);
		savetoserver.setEnabled(false);

		//crée une zone de texte
		tf = new TextField();
		tf.setEditable(false);
		p.add(tf);
		p.add(bpco);
		p.add(savetoclient);
		p.add(savetoserver);
		add(p,BorderLayout.NORTH);
		//rajoute mon text area
		ta = new TextArea();
		add(ta , BorderLayout.CENTER);

		//ajoute la liste
		liste = new List();
		liste.addItemListener(this);
		add(liste,BorderLayout.WEST );

		//lance le serveur
		//new Thread(this).start();

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FTP_client c1 = new FTP_client("localhost", 1024);
		c1.setVisible(true);


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
				System.out.println("reçus du serveur : "+ ligne);

				switch (ligne) {
				case "a+" :
					System.out.println("fonction quitter");

					fin=true;
					break;
				case "ls":
					System.out.println("is ls");
					isls=true;
					iscd=false;
					isget=false;
					//recupere le message suivant (message apres ls)

					ligne= depuisServeur.readLine();
					break;
				case "cd":
					isls=false;
					iscd=true;
					isget=false;
					//recupere le message suivant (message apres cd)
					ligne= depuisServeur.readLine();

					System.out.println("message reçus du serveur "+ligne);


					//jsp pk les if marche pas et les case marche avec les strings
					//si s'est un fichier 
					switch (ligne) 
					{
					case "ce n'est pas un dossier":
						//on le recupere et on l'affiche sur le text area
						versServer.println("get " + liste.getSelectedItem());
						System.out.println("envoyer au serveur : get " + liste.getSelectedItem() );
						isls=false;
						iscd=false;
						isget=false;
						ta.setText("");
						//reset les variable bool car le serveur va envoyer get
						break;

					default:
						tf.setText("vous ete dans le dossier : "+liste.getSelectedItem());
						break;
					}


					break;

				case "get":
					isls=false;
					iscd=false;
					isget=true;
					//recupere le message suivant (message apres get)
					//ligne= depuisServeur.readLine();

					break;
				case "put" :

					isls=false;
					iscd=false;
					isget=false;

					System.out.println("envoyer au serveur " +ta.getText());
					versServer.println(ta.getText());
					versServer.println("<EOF>");

					break;
				case "":
					//si on reçois un message vide on reset tout
					iscd = false;
					isls = false;
					isget = false;
					break;
				default:
					break;
				}

				if( isls == true )
				{
					liste.addItem(ligne);
					System.out.println("ligne ajouter : " +ligne);
				}
				else if( iscd == true )
				{
					//clear la liste
					liste.clear();
					liste.addItem(ligne);
					//passe en mode ls pour recuperer les nouveau repertoir et fichier
					iscd=false;
					isls=true;

				}
				else if (isget == true)
				{
					switch (ligne) {
					case "get":

						break;

					default:
						ta.append(ligne + "\n");
						break;
					}
				}
			}	
			System.out.println("sortie du while");
			disconnect();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			//.setText("probleme de connexion avec le serveur");
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
			tf.setText(depuisServeur.readLine());
			versServer.println("ls");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			//heure.setText("impossible de se connecter avec le serveur ");
		}
	}

	public void disconnect() 
	{
		try {
			System.out.println("fonction disconected");

			versServer.println("quit");

			sk.close();

			isco=false;
			//reset les bouton et les zone de text (liste et texte field et texte area
			bpco.setLabel("connect");
			ta.setText("");
			liste.removeAll();

			tf.setText("deconnecte du serveur");
			savetoclient.setEnabled(false);
			savetoserver.setEnabled(false);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			//heure.setText("de fermet la connection avec le serveur ");
		}
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		versServer.println("cd " + liste.getSelectedItem());
		System.out.println("envoyer au serveur cd "+liste.getSelectedItem() );

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource().equals(bpco))
		{

			if(isco == false) 
			{//si on est pas co et que l'on appui sur le bouton

				process = new Thread(this);
				process.start();
				bpco.setLabel("Disconnect");
				isco=true;
				System.out.println("isco = "+isco);
				savetoclient.setEnabled(true);
				savetoserver.setEnabled(true);

			}
			else if (isco == true)
			{
				try 
				{
					versServer.println("quit");

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.toString());
				}
			}
		}

		if (arg0.getSource().equals(savetoclient))
		{

			try {
				FileDialog fd = new FileDialog(this, "Sauvegarder", FileDialog.SAVE);
				fd.show();

				PrintWriter pr = new PrintWriter(new FileOutputStream( (fd.getDirectory()+ "\\" + fd.getFile( ) )));
				pr.write(ta.getText());
				pr.close();
			} catch (Exception e) {
				System.out.println(e.toString());
			}

		}
		if (arg0.getSource().equals(savetoserver))
		{
			try {
				//renvoie ce qui est dans le textarea au serveur avec un put devant
				if (ta.getText()!=null)
				{
					System.out.println("envoy au serveur : "+ liste.getSelectedItem());
					versServer.println("put " + liste.getSelectedItem() );

				}else
				{
					System.out.println("erreur sur l'envoie du fichier au serveur");
					tf.setText("erreur sur l'envoie du fichier au serveur");
				}

			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}

	}








}
