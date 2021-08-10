package restAssuredActivities;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;

public class Activity1 {

	
		// TODO Auto-generated method stub
		
		 // Set base URL
	    final static String ROOT_URI = "https://petstore.swagger.io/v2/pet";
	 
	    @Test(priority=1)
	    public void addNewPet() {
	        // Create JSON request
	        String reqBody = "{"
	            + "\"id\": 10891,"
	            + "\"name\": \"Panther\","
	            + " \"status\": \"passed\""
	        + "}";
	 
	        Response response = 
	            given().contentType(ContentType.JSON) // Set headers
	            .body(reqBody) // Add request body
	            .when().post(ROOT_URI); // Send POST request
	        
	        System.out.println(response);
	 
	        // Assertion
	        response.then().body("id", equalTo(10891));
	        response.then().body("name", equalTo("Panther"));
	        response.then().body("status", equalTo("passed"));
	    }
	 
	    @Test(priority=2)
	    public void getPetInfo() {
	        Response response = 
	            given().contentType(ContentType.JSON) // Set headers
	            .when().pathParam("petId", "10891") // Set path parameter
	            .get(ROOT_URI + "/{petId}"); // Send GET request
	        
	        System.out.println(response);
	 
	        // Assertion
	        response.then().body("id", equalTo(10891));
	        response.then().body("name", equalTo("Panther"));
	        response.then().body("status", equalTo("passed"));
	    }
	    
	    @Test(priority=3)
	    public void deletePet() {
	        Response response = 
	            given().contentType(ContentType.JSON) // Set headers
	            .when().pathParam("petId", "10891") // Set path parameter
	            .delete(ROOT_URI + "/{petId}"); // Send DELETE request
	        
	         System.out.println(response);
	 
	        // Assertion
	        response.then().body("code", equalTo(200));
	        response.then().body("message", equalTo("10891"));
	    }

	}


