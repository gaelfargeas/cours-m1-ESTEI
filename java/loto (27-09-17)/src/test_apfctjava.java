import java.util.Scanner;
public class test_apfctjava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

String[] data;
int gagner =0 ;
data=new String[2] ;

Scanner sc = new Scanner(System.in);

System.out.println("veiller taper le nombre a atteindre" );
data[0]= sc.nextLine() ;
System.out.println("veiller taper le maximum de lancer pour gagner ");
data[1]= sc.nextLine() ;

gagner =Loto.main(data);
	while (gagner == 0) {
		
	gagner = Loto.main(args);	
	}
	
	
	
	}

}
