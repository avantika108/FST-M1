package activities;

import java.util.HashSet;

public class Activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet <String> hs = new HashSet <String>() ;
		hs.add("IBM");
		hs.add("TCS");
		hs.add("Acenture");
		hs.add("Infosys");
		hs.add("Wallmart");
		hs.add("Google");
		System.out.println(" 6 objects added below through hashset:" +hs);
		
		
		System.out.println("Size of hashset is :"+ "" +hs.size()) ;
     	hs.remove("Acenture");		
		System.out.println("Check whether hashset conatins elemnt:" + " " +hs.contains("IBM"));
		System.out.println("New hashset elements are:" +hs);
		
	

	}

}
