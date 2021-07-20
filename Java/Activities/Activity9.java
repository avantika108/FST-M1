package activities;

import java.util.ArrayList;

public class Activity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	ArrayList <String> mylist= new  ArrayList <String> ();
	mylist.add("Avantika");
	mylist.add("Akshat");
	mylist.add("Chandra");
	mylist.add("Lisa");
	mylist.add("Steph");
	
	for(String x:mylist)
	{
		System.out.println(x);
	}
	 
	System.out.println("Retrieve 3 name from mylist"+ " " +mylist.get(2));
	System.out.println("Check if name exists in mylist" + " " +mylist.contains("Steph") );
	System.out.println("No. of names present in arraylist"+ " " +mylist.size());
	System.out.println("Remove the name from the list"+ " " +mylist.remove(3));
	System.out.println("New size of the list"+ " " +mylist.size());
	
	System.out.println("Rename the item present in the list" +mylist.set(2, "Christopher"));
	
System.out.println("New elements added list");
for(String s:mylist) {
	
	System.out.println(s);
}

	}

}
