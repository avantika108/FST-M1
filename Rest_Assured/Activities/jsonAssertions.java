package testrest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class jsonAssertions {
	
	RequestSpecification httprequest;
	ResponseSpecification res;
	Response response;
	
	@BeforeClass
	public void setup() {
		
		 RestAssured.baseURI= "https://run.mocky.io/v3/fb95ebba-a172-48a6-9725-43fdb94c74c0";
		 httprequest = RestAssured.given().log().all();
		 response= httprequest.when().get();
		 
		 res = RestAssured.expect();
		 res.statusCode(200);
		 
		 RestAssured.given(httprequest, res).get().then().log().all();
		
		
	}
	
	@Test

	public void  complexjson() {
		
		//Extract the name of player whose jersey is 20
		
		String playername =response.path("players.find {it.jerseyNumber==20}.name");
		System.out.println(playername);
		
				
				//Find all name whose jersey no. greater than 20
				 
				List<String> allplayername=response.path("players.findAll {it.jerseyNumber>=3}.name");
				System.out.println(allplayername);
				
				//Extract values of min & max
				
				String maxvalue =response.path("players.max {it.jerseyNumber}.name ");
				System.out.println(maxvalue);
				
				String minvalue = response.path("players.min {it.jerseyNumber}.name") ;
				System.out.println(minvalue);
				
				
				
			//  Combine find and find all
				
	  Map<String,?> findkeeper =  response.path("players.findAll {it.position=='Keeper'}.find {it.nationality=='Argentina'}");
	    System.out.println(findkeeper);
	    
	    for(Map.Entry<String, ?>entry :findkeeper.entrySet()) {
	    	
	    	System.out.println(entry.getKey() + "->" +entry.getValue());
	    } 
	    
	    
				
				//Collect and sum 
	    
	    int sumofjersey = response.path("players.collect{it.jerseyNumber}.sum()");
	    System.out.println(sumofjersey);
				
				    
		//In this example, we use findAll() multiple times to extract the full objects (i.e. all the details) of players 
	    //that match the parameters we specify. We are extracting a list of maps:
	    
	    
				    
				
		
	}
}
