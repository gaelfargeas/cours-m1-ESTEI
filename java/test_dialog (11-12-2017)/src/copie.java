import java.io.*;
import java.util.StringTokenizer;





public class copie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InputStream in ;
		OutputStream out;
		int c=0;





		try {
			//recupere in fichier
			
			in = new FileInputStream(args[0]);
			StringTokenizer st = new StringTokenizer(args[0] ,".",false);
			String str = st.nextToken()+"_O."+st.nextToken();
			out = new FileOutputStream(str);
			
			//lit jusqu'a qu'il n'y est plus rien a lire
			while ( (c = in.read() ) != -1 )
			{
				
				
				System.out.println(c);
				if (97< c && c<122)
				{
					c-=32;
				}
				out.write(c);
				
			}
			in.close();
			out.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString() );

		}
		

	}

}
