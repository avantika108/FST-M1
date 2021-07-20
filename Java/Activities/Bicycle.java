package activities;

public  class Bicycle implements BicycleOperations,BicycleParts
{
         public int gears, currentSpeed;
    public Bicycle(int gears, int currentspeed)
	{   
		this.gears=gears;
		this.currentSpeed = currentSpeed;
	}
	
	public void applyBrake(int decrement)
	{
		currentSpeed -=decrement ;
		System.out.println("Current speed for applying brake:" + " "+currentSpeed);
		
	}
	
	public void speedUp(int increment)
	
	{
		currentSpeed += increment ;	
		System.out.println("Current speed after increment" + " "+currentSpeed);
	}
	
	public String bicycleDesc() 
	
	{
		return ("No. of gears" + " "+gears +" "+"Current Speed of bicycle"+ " " +currentSpeed) ;
	}

	

	
	
	
}
