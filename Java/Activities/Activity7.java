package activities;

public class Activity7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MountainBike mb = new MountainBike(2, 20, 30);
		System.out.println(mb.bicycleDesc());
		mb.speedUp(20);
		mb.applyBrake(10);

	}

}
