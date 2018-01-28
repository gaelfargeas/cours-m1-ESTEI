import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class choixFichier extends Frame implements ActionListener {

	
	String file ;
	//Button save , save_as ;
	TextArea ta ;
	FileDialog fd , fd_save ;
	Menu m1;
	public choixFichier()
	{		
		super("selection de fichier");

		setSize(600,600);

		//save = new Button("SAVE");
		//save.addActionListener(this);
		//save_as = new Button("SAVE AS");
		//save_as.addActionListener(this);
		ta = new TextArea();


		setLayout(new BorderLayout());
		add(ta , BorderLayout.CENTER);

		ta.append("bienvenue sur ce magnifique editeur");
		msgbox.affmsg(this, "ceci s'est une vertion beta . Merci de votre comprehension.");


		fd=new FileDialog(this, "choisir", FileDialog.LOAD);
		fd.setDirectory(".");
		fd_save=new FileDialog(this, "Enregistrer", FileDialog.SAVE);
		fd_save.setDirectory(".");
		MenuBar mb = new MenuBar();
		setMenuBar(mb);

		m1 = new Menu("fichier");
		mb.add(m1);

		add_item(m1,"Selection ...", "Select");
		m1.addSeparator();
		add_item(m1, "SAVE", "save");
		add_item(m1, "SAVE AS", "save_as");
		m1.addSeparator();
		add_item(m1, "new JAVA class", "java");
		m1.addSeparator();
		add_item(m1,"Quitter","Exit");

		m1.getItem(2).setEnabled(false);

		addWindowListener(new Fermeture());
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		choixFichier cf = new choixFichier();
		cf.show();
	}

	public void add_item (Menu m ,String str , String cmd)
	{
		MenuItem mi = new MenuItem(str);
		mi.setActionCommand(cmd);
		mi.addActionListener(this);
		m.add(mi);
	}

	public void read_file(String nom_fichier)
	{

		try 
		{

			//clear le textarea
			ta.setText("");

			//lie le fichier a notre io input
			InputStream in = new FileInputStream(nom_fichier);

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
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}

	public void Save(String nom_fichier)
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
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Select"))
		{
			ta.append("");
			ta.setText(" ");
			
			fd.setVisible(true);
			String file_name = fd.getDirectory() + fd.getFile();
			System.out.println(file_name);
			read_file(file_name);
			file =file_name;
			m1.getItem(2).setEnabled(true);


		}else if (e.getActionCommand().equals("save"))
		{

			System.out.println("save");
			boolean ok = msgbox.affrep(this,"voulez vous vraiment ecrase ce fichier ?");
			if (ok)
			{
				Save(file);
				System.out.println("OK");

			}else
			{
				System.out.println("CANCEL");
			}

		}else if (e.getActionCommand().equals("save_as"))
		{
			System.out.println("save as");
			fd_save.setVisible(true);
			String file_name = fd_save.getDirectory() + fd_save.getFile();
			System.out.println(file_name);
			Save(file_name);
	
		}else if (e.getActionCommand().equals("java"))
		{
			System.out.println("crée un fichier class java");
			ta.append("");
			ta.setText("");
			
			
			ta.append("public class test {\n\n");
			ta.append("	public static void main(String[] args) {\n");
			ta.append("	}\n");
			ta.append("}\n");
		}else if (e.getActionCommand().equals("Exit"))
		{
			System.exit(0);

		}
	}

}
