import java.applet.Applet;
import java.util.Hashtable;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class test_Hashtable extends Applet implements ItemListener {

	Canvas zonedessin ;
	List liste;
	Hashtable<String,Color> dict;
	
	public void init()
	{
	setSize(300,300);	
	setLayout(new BorderLayout());
	
	liste= new List();
	liste .addItemListener(this);
	add(liste , BorderLayout.WEST);
	zonedessin=new Canvas();
	add(zonedessin , BorderLayout.CENTER);
	dict = new Hashtable <String,Color>();
	dict.put("blanc", Color.WHITE);
	liste.add("blanc");
	dict.put("rouge", Color.RED);
	liste.add("rouge");
	dict.put("vert", Color.GREEN);
	liste.add("vert");
	
	}
	
	public Color lireColor(String nom)
	{
		return (Color)dict.get(nom);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		zonedessin.setBackground(lireColor(liste.getSelectedItem()));
		zonedessin.repaint();
		
	}

}
