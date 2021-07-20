package activities;

public class MountainBike extends Bicycle {

	public MountainBike(int gears, int currentspeed ,int startheight ) {
		super(gears, currentspeed);
		seatHeight= startheight ;
		// TODO Auto-generated constructor stub
	}
 public int seatHeight ;
 
 public void setHeight(int newvalue) {
	 
	 seatHeight = newvalue ;
	 
 }
 
 @Override
public String bicycleDesc() {
	// TODO Auto-generated method stub
	return (super.bicycleDesc() + "\n Seat height is" +" " +seatHeight);
	
}
 
 

}
