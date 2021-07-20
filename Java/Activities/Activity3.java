package activities;

public class Activity3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double seconds=1000000000 ;
		double Earth = 31557600; 
		double Mercury = 0.2408467;
		double Venus = 0.61519726;
		double Mars = 1.8808158 ;
		double Jupiter =  11.862615;
		double Saturn = 29.447498;
		double Uranus = 84.016846 ;
		double Neptune = 164.79132 ; 
		
		System.out.println("Age on mercury:" +seconds/Earth/Mercury);
		System.out.println("Age on earth:" +seconds/Earth);
		System.out.println("Age on venus:" +seconds/Earth/Venus);
		System.out.println("Age on mars:" +seconds/Earth/Mars);
		System.out.println("Age on Jupiter:" +seconds/Earth/Jupiter);
		System.out.println("Age on Saturn:" +seconds/Earth/Saturn);
		System.out.println("Age on Uranus:" +seconds/Earth/Uranus);
		System.out.println("Age on Neptune:" +seconds/Earth/Neptune);
	
		
		
	}

}
