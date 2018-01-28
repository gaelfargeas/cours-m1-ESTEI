package projet_270917;

public class Score2 extends Score{
	
int nbEssai = 0 ;	

	Score2()
{
	super();
	
}

	Score2(String nom, int s, int scoreMax)
	{
		super(nom , s , scoreMax);
		nbEssai = 0 ;
		
	}
	
	public void ajoute(int nppoints)
	{
		super.ajoute(nppoints);
		nbEssai ++;
		
	}
	
}
