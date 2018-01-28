package projet_270917;

public class Score {
	public String name;
	private int leScore;
	int scoreMax = 100;
	
	Score()
	{
		this.name="inconnue";
		this.leScore=0;
		
	}
	
	
	Score(String nom, int s , int scoreMax)
	{
		this.name=nom;
		this.leScore=s;
		this.scoreMax =scoreMax;
	}
	
	int getScore()
	{
		return (leScore);
		
	}
	
	void setScore(int vall)
	{
		if (vall < scoreMax)
		{
		leScore = vall;	
		}
		else
		{
			leScore = scoreMax ;
		}
	}
	
	
	
	public void ajoute(int points)
	{
		setScore(leScore + points);
	}
	
	public void affiche() 
	{
		System.out.println("joueur " + name + " avec le score " + leScore);	
		
	}
	
	
	
	
	
	
	
}
