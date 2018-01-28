import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Calendar;


public class maconnexion implements Runnable {


	Socket client;
	BufferedReader depuisclient;
	PrintWriter versclient;

	public maconnexion(Socket s) {
		client = s;
		try {

			depuisclient = new BufferedReader(new InputStreamReader(client.getInputStream()));
			versclient = new PrintWriter(client.getOutputStream(),true);
			//String lue = depuisclient.readLine();
			versclient.println("bienvenue sur le serveur Heure");
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
		String lue ;
		while (!fin) {
			try {
				
				Calendar C = Calendar.getInstance();
				
				String heure =  C.get(Calendar.HOUR) + " h "
											+ C.get(Calendar.MINUTE) + " m "
											+ C.get(Calendar.SECOND) + " s ";
				
				lue = depuisclient.readLine();
				System.out.println(lue);
	
				switch (lue) {
				case "h":
					versclient.println("il est");
					versclient.println(heure);
					
					break;
				case "" :
					fin =true;
					break;
				default:
					lue = "";
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.toString());
			}




		}
		stop() ;
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
