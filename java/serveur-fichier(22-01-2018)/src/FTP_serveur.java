
import java.net.ServerSocket;
import java.net.Socket;



public class FTP_serveur {
	
	
static int port;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ServerSocket serveur;
		
		
		port= 1024;
		try {
			//lance le serveur sur le port 1024
			serveur= new ServerSocket(port);
			System.out.println("serveur FTP en cour sur le port " +port);
			while(true)
			{
				Socket s = serveur.accept() ;
				new MyFTP(s);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(e.toString());
		}
		
		
	}

}
