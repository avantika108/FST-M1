package activities;

import java.util.HashMap;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Integer,String> colours = new HashMap<Integer,String>(); 
		colours.put(1, "Orange");
		colours.put(2, "Green");
		colours.put(3, "Yellow");
		colours.put(4, "White");
		colours.put(5, "Red"); 
		
		System.out.println("Original hashmap" + " " +colours);
		
		colours.remove(1, "Orange");
		System.out.println("Checking whether green colour present" + " " +colours.containsValue("Green"));
		
		System.out.println("Size of map:" + " "+colours.size());
		 System.out.println("New hashmap is:" +colours);
		
		

	}

}
