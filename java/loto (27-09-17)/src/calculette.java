
public class calculette {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
if (args.length <3) System.out.println("argument non saisis" );
		
		else	 {
			//init
		float premier , deuxieme , resultat =0 	;
		char opperation;
		
		//recupere les nombre
		premier = (float)Double.parseDouble(args[0]);
		deuxieme = (float)Double.parseDouble(args[2]);
		
		//recuperation opperation a faire
		opperation = args[1].charAt(0);
		
		switch (opperation) 
		{
		
		case '+' : resultat = premier + deuxieme ;
					break ;
		case 'x' : resultat = premier * deuxieme ;
					break ;
		case '/' : resultat = premier / deuxieme ;
					break ;
		case '-' : resultat = premier - deuxieme ;
					break ;
		default: 	break ;
		}
			System.out.println("" + premier +" " + opperation + " " + deuxieme + " = " + resultat );
		}
		
	}

}
