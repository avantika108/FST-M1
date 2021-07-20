package activities;

import java.util.Arrays;

public class Activity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {87,32,98,27,45,90,32} ;
        insertionsort(arr);
        System.out.println("Sorted array in ascending order");
        System.out.println(Arrays.toString(arr));
	}

	 static void insertionsort(int[] arr) {
		// TODO Auto-generated method stub
       int n = arr.length;
       int i ;
       for(i=1;i<n;i++)
       {
    	   int key=arr[i];  
    	    int j=i-1;
       while(j>=0 && arr[j]>key)
       {
    	   arr[j+1]=arr[j];
    	   j=j-1;
       }
		arr[j+1]=key;
		
	}}
}
