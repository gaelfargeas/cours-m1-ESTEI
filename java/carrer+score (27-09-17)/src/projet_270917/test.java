package projet_270917;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tmp ;
		
		
		Score s1 =new Score();	
		s1.affiche();
	
	Score s2 = new Score("paul" , 10 , 200); //instanciation de l'objet ... en utilisant le constructeur.
	s2.affiche();
	
// change la valeur du score et l'affiche
s2.setScore(90);
s2.affiche();

//recuperer la valeur du score
tmp = s2.getScore();
System.out.println("le score est "+ tmp);

//change la valeur du score et l'affiche
s2.setScore(150);
s2.affiche();	
	




// tous casser sa 

Score j1 =new Score("joueur1" , 0 , 200);	
j1.affiche();
int nbr = 0;
int compteur = 0 ;



do
{
//tirage
nbr=(int)(Math.random()*10);
//ajoute le nombre tirer
j1.ajoute(nbr);

//incremente le compteur
compteur++; 


} while( (j1.getScore()) < (j1.scoreMax) );

System.out.println("le joueur " + j1.name + " a atteint le score " + j1.getScore() + " au bout de " + compteur + " tirage");


	}

}
