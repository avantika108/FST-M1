package activities;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Plane {
	private int maxPassengers;
	private List<String> passengers;
	private Date lastTimeTookoff;
	private Date lasttimelanded;
	
	public Plane(int maxPassengers) {
		// TODO Auto-generated constructor stub
	this.maxPassengers=maxPassengers;	
	this.passengers= new ArrayList<>();
	
	}

	public void onboard(String passengers)
	{ 
		this.passengers.add(passengers) ;
	}
	public Date takeoff() {
		this.lastTimeTookoff = new Date();
		return lastTimeTookoff ;
	}
	public void land () {
		this.lasttimelanded= new Date();
		this.passengers.clear();
		
	}
	public Date getLastTimeLanded() {
		return lasttimelanded ;
	}
	public List<String> getPassesngers() {
		
		return passengers;
	}
	
	
	
}
