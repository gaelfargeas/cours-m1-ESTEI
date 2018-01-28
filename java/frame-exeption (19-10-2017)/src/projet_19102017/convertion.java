package projet_19102017;


//initiation au exeption 


public class convertion {

	public static void main(String[] arg)
	{
		try 
		{

			int val = Integer.parseInt(arg[0]);
			System.out.println("val : "+val);	

		}
		catch (ArrayIndexOutOfBoundsException e) {

			System.out.println("veillez saisir des arguments");

		}
		catch (NumberFormatException e) {

			System.out.println("la chaine saisie n'est pas convertible");
			System.out.println("veillez saisir un nombre");
			System.out.println("tu est d'une nullité absolue. copyright by JPP");

		}

	}



}
