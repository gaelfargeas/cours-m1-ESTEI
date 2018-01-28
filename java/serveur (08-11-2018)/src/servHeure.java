import java.net.*;



public class servHeure {
	
	
static int port;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ServerSocket serveur;
		
		
		port= 1024;
		try {
			//lance le serveur sur le port 1024
			serveur= new ServerSocket(port);
			System.out.println("serveur en cour sur le port " +port);
			while(true)
			{
				Socket s = serveur.accept() ;
				new maconnexion(s);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(e.toString());
		}
		
		
	}

}
