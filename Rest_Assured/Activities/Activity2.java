package restAssuredActivities;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;

public class Activity2 {
	final static String ROOT_URI= "https://petstore.swagger.io/v2/user";
	
	@Test(priority=1,enabled=true)
	public void addNewUserFromFile() throws IOException {
        // Import JSON file
       
        // Read JSON file as String
        File file = new File("resources/userinfo.json");
		FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
		fis.read(bytes);
		String reqBody = new String(bytes, "UTF-8");
        Response response = 
            given().contentType(ContentType.JSON) // Set headers
            .body(reqBody) // Pass request body from file
            .when().post(ROOT_URI); // Send POST request
 
        fis.close();
 
        // Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("1111"));
        System.out.println(response.asPrettyString());
    }
    
    @Test(priority=2,enabled=true)
	public void getUserInfo() {
        // Import JSON file to write to
        File outputJSON = new File("resources/useroutput.json");
 
        Response response = 
            given().contentType(ContentType.JSON) // Set headers
            .pathParam("username", "panther") // Pass request body from file
            .when().get(ROOT_URI + "/{username}"); // Send POST request
        
        // Get response body
        String resBody = response.getBody().asPrettyString();
        System.out.println(resBody);
 
        try {
            // Create JSON file
            outputJSON.createNewFile();
            // Write response body to external file
            FileWriter writer = new FileWriter(outputJSON.getPath());
            writer.write(resBody);
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
        
     
        // Assertion
        response.then().body("id", equalTo(1111));
        response.then().body("username", equalTo("panther"));
        response.then().body("firstName", equalTo("Justin"));
        response.then().body("lastName", equalTo("Case"));
        response.then().body("email", equalTo("justincase@mail.com"));
        response.then().body("password", equalTo("password123"));
        response.then().body("phone", equalTo("9812763450"));
        
    }
    
    @Test(priority=5)
	public void deleteUser() throws IOException {
        Response response = 
            given().contentType(ContentType.JSON) // Set headers
            .pathParam("username", "panther") // Add path parameter
            .when().delete(ROOT_URI + "/{username}"); // Send POST request
        
        try {
        	  System.out.println(response.asPrettyString());
              // Assertion
              response.then().body("code", equalTo(200));
              response.then().body("message", equalTo("panther"));
        
        }
    	catch(Exception e)
        {
    		e.printStackTrace();
        }
      
      
    }
	
 
}
