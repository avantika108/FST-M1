package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//accept number inputs from the console using Scanner class and store them in an array.	
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number");
		ArrayList<Integer> list = new ArrayList<Integer>() ;
//use the Random class to generate an index value and print the value in the array at then generated index value.
		Random indexGen = new Random();
		System.out.println("Random integers please");
		System.out.println("(EOF or non-integer to terminate): ");
		
		while(scan.hasNextInt())  {
			
			list.add(scan.nextInt());
		}
	//To print the number from an array, we convert the ArrayList into an array using the toArray() method	
		Integer nums[]=list.toArray(new Integer[0]);
		
		
		//Use indexGen to generate an integer value with the bounds set to the length of nums array.
		int index = indexGen.nextInt(nums.length);
		
		//Print the index value that was generated and the value in the array at that index value.
		
		System.out.println("Index value generated" +" "+index);
		
		System.out.println("value in array generaated at index" + " "+nums[index]);
		
		scan.close();
		
		

	}

}
