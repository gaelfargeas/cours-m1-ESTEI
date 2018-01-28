
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Calendar;
import java.util.StringTokenizer;


public class MyFTP implements Runnable {

	File f = new File(".");
	File f2;
	Socket client;
	BufferedReader depuisclient;
	PrintWriter versclient;
	StringTokenizer st;
	public MyFTP(Socket s) {
		client = s;
		try {

			depuisclient = new BufferedReader(new InputStreamReader(client.getInputStream()));
			versclient = new PrintWriter(client.getOutputStream(),true);
			//String lue = depuisclient.readLine();
			versclient.println("bienvenue sur le serveur FTP");
			new Thread(this).start();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		boolean fin = false ;
		try {
			String lue ;
			while (!fin) {

				lue = depuisclient.readLine();
				System.out.println(lue);
				
				if (lue.startsWith("ls"))
				{
					versclient.println("ls");
					//versclient.println("vous ete dans le dossier : " + f.getCanonicalPath()+ "\\" );
					versclient.println("..");
					for (int i = 0 ; i< f.list().length ; i ++)
					{
						versclient.println(f.list()[i]);
					}	
				}
				else if (lue.startsWith("cd"))
				{
						versclient.println("cd");
						st = new StringTokenizer(lue);
						st.nextToken();
						String path = (f.getCanonicalPath() + "\\" + st.nextToken() );
						System.out.println(path);
						
						 f2 = new File(path);
						 //verrifie que se qu'on a mis apres cd est un dossier
						if (f2.isDirectory()) {
							f=new File(path);
							versclient.println("..");
							for (int i = 0 ; i< f.list().length ; i ++)
							{
								versclient.println(f.list()[i]);
							}
						} else if (f2.isFile())
						{
							versclient.println("ce n'est pas un dossier");
							
						}
						
				}
				else if (lue.startsWith("get"))
				{
					versclient.println("get");
					st = new StringTokenizer(lue);
					st.nextToken();
					String path = (f.getCanonicalPath() + "\\" + st.nextToken() );
					f2 = new File(path);
					String ligne ="";
					BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream(path) ) );
					if (f2.isFile())
					{
						while ( (ligne = br.readLine()) != null )
						{
							if ( ligne.length() !=0  )
							{
								versclient.println(ligne);
							}
						}
						br.close();
					}
					
					
				}
				else if (lue.startsWith("put"))
				{
					versclient.println("put");
					st = new StringTokenizer(lue);
					st.nextToken();
					String path = (f.getCanonicalPath() + "\\" + st.nextToken() );
					PrintWriter pr = new PrintWriter(new FileOutputStream(path));
					String ligne ;
					while ( ( ligne = depuisclient.readLine() ) != null )
					{
					pr.write(ligne);
					}
					
					pr.close();		
					
					
				}
				else if (lue.startsWith("quit"))
				{
					stop() ;
					fin=true;
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
	}

	public void stop() 
	{
		try {
			versclient.println("a+");
			client.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());

		}


	}


}
