package activities;

import com.sun.source.util.TaskEvent;

public class Activity6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Plane plane=new Plane(10);
		plane.onboard("Avantika");
		plane.onboard("Agrima");
		plane.onboard("Akshat");
		
		System.out.println("Take off time"+ " " +plane.takeoff());
		System.out.println("List of passengers"+" " +plane.getPassesngers());
		Thread.sleep(5000);
        plane.land();
        System.out.println("Time of landing"+ " " +plane.getLastTimeLanded());

	}

}
