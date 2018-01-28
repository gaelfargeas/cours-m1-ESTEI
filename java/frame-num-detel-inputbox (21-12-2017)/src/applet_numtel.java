import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.*;
import java.net.URL;
import java.util.StringTokenizer;

public class applet_numtel extends Frame implements ActionListener{
	boolean numtrouver = false;
	String newname;
	String lenom , leprenom;
	
	Label nom , numero;
	TextField tfnom , tfnum , log;
	public applet_numtel ()
	{
		setSize(300, 300);
		Panel p = new Panel();


		nom = new Label("NOM");
		numero = new Label("N° de telephone");

		tfnom =new TextField(10);
		tfnum =new TextField(10);
		log =new TextField(10);

		tfnom.setEditable(true);
		tfnum.setEditable(false);
		log.setEditable(false);
		tfnom.addActionListener(this);
		tfnum.addActionListener(this);

		p.setLayout(new GridLayout(5,1));
		p.add(nom);
		p.add(tfnom);
		p.add(numero);
		p.add(tfnum);
		p.add(log);

		add (p);




		addWindowListener(new Fermeture());
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		applet_numtel ap = new applet_numtel() ;
		ap.show();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(tfnom)) 
		{
			getnumero(tfnom.getText());

		}else if (e.getSource().equals(tfnum)) 
		{


			addnumero(tfnum.getText());
			tfnum.setEditable(false);
			tfnum.setText("");
		}
	}

	public void getnumero(String nom)
	{
		System.out.println(nom);
		search_name(nom);
	}

	public void search_name(String nom)
	{

		try 
		{
			//recuperer le fichier pour voir si le nom existe


			FileReader annuaire = new FileReader("annuaire.txt");
			BufferedReader br = new BufferedReader(annuaire);
			String ligne ;

			//cherche le nom dans le fichier texte
			while ( (ligne = br.readLine()) != null )
			{
				if ( ligne.length() !=0  )
				{
					if(ligne.startsWith(nom + ":"))
					{
						StringTokenizer st = new StringTokenizer(ligne) ;
						String numero = st.nextToken();
						numero = st.nextToken();
						tfnum.setText(numero);
						numtrouver=true;
						log.setText("nom trouver");

					}

				} 

			}
			//si il ne trouve pas le numero
			if(!numtrouver) 
			{
				//ecrit numero non trouver et invite a le rajouter
				tfnum.setText("");
				log.setText("nom inconnue, vous pouvez ajouter un numero si vous le desirer.");
				newname = tfnom.getText() ;
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());


		}
		if(!numtrouver) 
		{
			tfnum.setEditable(true);
		}
		numtrouver=false;

	}


	public void addnumero (String newnum) 
	{
		//essai de rajouter une ligne au fichier avec le nouveau nom et numero
		try {

			File file = new File("annuaire.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter pr = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(pr);

			bw.write(newname + ": " + newnum);
			bw.newLine();
			
			bw.close();
			pr.close();
			log.setText("nom rajouter");
		} catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println(e.toString());
		}



	}

}





