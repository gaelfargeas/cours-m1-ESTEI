
public class Loto 	{

	public static int main(String[] args)	 {
		// TODO Auto-generated method stub
		//variable
		int compteur = 0;	//nombre d'essais
		double nbreAleatoire = 0;
		int gagner = 0 ;
	
		//2arg ?
		if (args.length <2) System.out.println("argument non saisis" );
		
		else	 {
			
		int n = Integer.parseInt(args[0]); //nombre a ateindre
		
		while ((int)nbreAleatoire != n) 
		{
			nbreAleatoire = Math.random()*1000;
			compteur+=1;
		}
		System.out.println("Nombre "+ n +" atteint apres " + compteur + " tirage" );
		
		if ( compteur<=Integer.parseInt(args[1]) ) {
			System.out.println("gagner" );
			gagner = 1 ;
		}
			else {
				System.out.println("perdu" );
				gagner = 0;
				
			}
				}
		return gagner;											}
						}	

