
public class testThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		threadAffiche t1 = new threadAffiche("t1");
		threadAffiche t2 = new threadAffiche("t2");
		t1.start();
		t2.start();
		
		
	}

}
