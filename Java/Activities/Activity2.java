package activities;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Array[]= {10,77,10,10,-11,10};
		int Searchnum=10;
		int Sum=30; 
		
		System.out.println("Result" +" " +result(Array,Searchnum,Sum));

	}
	
	public static boolean result(int Array[],int Searchnum,int Sum)
	
	{
		int temp_sum=0; 
		for(int number:Array)
		{
			if(number==Searchnum)
			{
			temp_sum=temp_sum + Searchnum;	
			}
			
			if(temp_sum >Sum)
			{
				break;
			}
		}
		
		
		return temp_sum==Sum;
         
}
	
	
}