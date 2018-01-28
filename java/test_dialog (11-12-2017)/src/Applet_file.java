import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.lang.invoke.SwitchPoint;
import java.net.*;
import java.util.StringTokenizer;

import javax.swing.border.Border;

public class Applet_file extends Applet implements ActionListener, ItemListener {

	TextArea ta ;
	String name ="copie.java";
	Button bt = new Button("SAVE");
	Button bt2 = new Button("SAVE AS");
	File f ;
	List liste ;
	String str = ".";
	TextField tf ;


	public void  init()
	{


		setSize(800,800);
		setLayout(new BorderLayout());

		ta = new TextArea();
		add(ta , BorderLayout.CENTER);
		tf = new TextField();
		tf.setEditable(false);
		Panel p2 = new Panel();
		Panel p = new Panel();

		p.setLayout(new GridLayout(2, 1));
		p2.setLayout(new GridLayout(1, 2));

		p2.add (bt);
		bt.addActionListener(this);

		p2.add (bt2);
		bt2.addActionListener(this);
		p.add(p2);
		p.add(tf);
		add(p,BorderLayout.SOUTH);

		read_file(name);

		liste = new List();
		add (liste , BorderLayout.WEST);

		remplir_list(str);
		liste.addItemListener(this);



	}



	public void read_file(String nom_fichier)
	{
		if(isTXT(nom_fichier)) 
		{
			try 
			{

				//clear le textarea
				ta.append("");
				ta.setText("");
				//url lien vers le fichier
				URL url = new  URL(getCodeBase(), nom_fichier);
				//lie le fichier a notre io input
				InputStream in = url.openStream();
				//
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader br = new BufferedReader(isr);
				String ligne ;
				while ( (ligne = br.readLine()) != null )
				{
					if ( ligne.length() !=0  )
					{
						ta.append( ligne + "\n");

					}

				}


			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.toString());
			}
		}else 
		{

			try {
				//clear la zone de text
				ta.append("");
				ta.setText("");
				//affiche
				ta.append(liste.getSelectedItem() +" n'est pas un fichier Text.");

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.toString());

			}


		}
	}

	public void write_to_file(String nom_fichier)
	{
		if (isTXT(nom_fichier))
		{
			try 
			{

				PrintWriter pr = new PrintWriter(new FileOutputStream(nom_fichier));
				pr.write(ta.getText());
				pr.close();

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.toString());
			}
		}else
		{
			ta.append(liste.getSelectedItem() +" n'est pas un fichier Text. les modification ne peuvent pas etre enregistrer");
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(bt))
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

			/*if( ( msgbox.affrep(fr,"salut") ) )
			{
				write_to_file(name);
			}*/

		}else if (arg0.getSource().equals(bt2))
		{


		}



	}
	public void remplir_list(String s)
	{
		f = new File(s);
		if (f.isDirectory() )
		{
			liste.clear();
			liste.addItem("..");

			for (int i = 0 ; i< f.list().length ; i ++)
			{

				liste.addItem(f.list()[i]);
			}
		}
		//si s'est un fichier sa reste dans l'arbor
		if (f.isFile())
		{
			read_file(liste.getSelectedItem());
			str = str + "/../";

		}

		try {

			if (f.isDirectory())
			{
				tf.setText(f.getCanonicalPath());
			}else if(f.isFile())
			{
				tf.setText(liste.getSelectedItem() +" est un fichier de " +f.length() + " octet");
			}


		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}




	}



	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(liste.getSelectedItem());

		str= str + "/"  + liste.getSelectedItem();
		remplir_list(str);



	}


	public boolean isTXT(String nom_fichier)
	{
		String[] texte = {".txt" , "java" , ".doc" , ".docx" , ".text" , ".html"};
		//recupere la fin du fichier .untruck
		StringTokenizer ts = new StringTokenizer(nom_fichier , ".");
		String val = "" ;
		while (ts.hasMoreTokens())
		{
			val = ts.nextToken();	
		}

		for (int i = 0 ; i< texte.length ; i++)
		{
			if (val.equals(texte[i]))
			{
				return true ;
			}
		}


		//test V1
		/*
		for (int i = 0 ; i< texte.length ; i++)
		{
			if (nom_fichier.endsWith(texte[i]))
			{
				return true ;
			}
		}*/
		return false ;
	}

}
