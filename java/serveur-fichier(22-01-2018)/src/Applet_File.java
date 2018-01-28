import java.awt.*;
import java.applet.*;
import java.io.*;
import java.net.*;
import java.util.StringTokenizer;
import java.awt.event.*;

public class Applet_File extends Applet implements ActionListener, ItemListener{

	String name = "Copie2.java";
	TextArea ta;
	Button save ;
	Button save_as ;
	List liste ;
	TextField tf ;
	String str = ".";
	public void init()
	{
		setSize(600,600);
		setLayout(new BorderLayout());

		ta = new TextArea();
		add(ta, BorderLayout.CENTER);
		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(1,2));
		save = new Button("Save");
		save.addActionListener(this);
		save_as = new Button("Save As");
		save_as.addActionListener(this);
		p1.add(save);
		p1.add(save_as);
		Panel p2 = new Panel();
		p2.setLayout(new GridLayout(2,1));
		tf = new TextField(10);
		p2.add(p1);
		p2.add(tf);
		add(p2, BorderLayout.SOUTH);
		liste = new List();
		liste.addItemListener(this);
		add(liste,BorderLayout.WEST );
		read_file(name);
		remplir_liste(str);
	}
	public void remplir_liste(String s)
	{
		File f = new File(s);
		if(f.isDirectory())
		{
			liste.removeAll();
			liste.addItem("..");
			for (int i = 0; i <f.list().length; i++)
			{
				liste.addItem(f.list()[i]);
			}
			try
			{
				tf.setText(f.getCanonicalPath()+ " est un répertoire");
			}
			catch(IOException e)
			{
				System.out.println(e.toString());
			}

		}
		else if (f.isFile())
		{
			{
				read_file(str);
				str = str + "/..";

			}
			try
			{
				tf.setText(f.getCanonicalPath()+ " est un fichier de taille : " + f.length()+ " octets");
			}
			catch(IOException e)
			{
				System.out.println(e.toString());
			}
		}

	}	

	public void read_file(String nom_fichier)
	{
		if (is_Text_File(nom_fichier))
		{
			try
			{

				URL url = new URL (getCodeBase(),nom_fichier);
				InputStream in = url.openStream();
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader br = new BufferedReader(isr);
				String ligne;
				while ((ligne = br.readLine()) != null) 
				{
					if((ligne.length() != 0) )
					{
						ta.append(ligne+"\n");
					}
				}
			}
			catch(Exception e)
			{
				System.out.println(e.toString());

			}
		}		
	}
	public boolean is_Text_File(String name)
	{
		boolean flag = false;
		String nom = "";
		StringTokenizer st;
		String []  tab = {"txt", "text", "java", "doc", "docx"};
		st = new StringTokenizer(name, "/", false);
		while(st.hasMoreTokens())
		{
			nom = st.nextToken();
		}	
		st = new StringTokenizer(nom, ".", false);
		st.nextToken();
		String ext = st.nextToken();
		System.out.println(ext);
		for (int i = 0; i < tab.length; i++)
		{
			if (ext.startsWith(tab[i]))
			{
				flag = true;
			}

		}

		return flag;

	}
	public void write_to_file(String nom_fichier)
	{
		try
		{
			PrintWriter pr = new PrintWriter(new FileOutputStream(nom_fichier));
			pr.write(ta.getText());
			pr.close();

		}
		catch(Exception e)
		{
			System.out.println(e.toString());

		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(save))
		{
			write_to_file(name);
		}
		else
		{
			//FileDialog fd = new FileDialog(this, "Save", FileDialog.SAVE)
		}
		
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("objet selectionné : " +liste.getSelectedItem());
		str = str + "/"+liste.getSelectedItem() ;
		remplir_liste(str);
		System.out.println("Str :" +str);

		//System.out.println("objet selectionné : " +liste.getSelectedItem());

	}
}
