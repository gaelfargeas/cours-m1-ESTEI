
public class threadAffiche extends Thread {

	public threadAffiche(String nom)
	{
		super(nom) ;

	}

	public void run()
	{

		for (int i = 0 ; i < 10 ; i ++ ) 
		{

			System.out.println(" je suis le processus : " + getName());

			Thread.yield(); // passe la main a d'autre processus




		}


	}


}
