import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class NewTest {
	   
	String SSHkey="ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQC5MHSUXXkbp2g2Mn7df+sKVGlquszQafCYcnpWWyJQKg1bQswpMufeSZ824GgwZM5pxFPZMsLu8+FVJP3xmDu/KAGwe7Od1yL2sD5vRJHOxm6EqdbK26tic6HUh4Ay4aIDEeYn/RNZRdqMe56vDU8HzLfW//WTiQH4CAFsqmQ6RRHOSTqJAddpEREQGbjvLo2RC54CNBTzjKkXTPYO4SkfxMCISEv6tz4Dz25l3Bb+P6O/Eh1ybckTWWFjnkmOkbLL3iLGYxZmObc3CIb76GdPLcaET3E96lbTVhJKvHUYHhD3kzLF42aGaDT/ETAfjr3H2tlcciuVAL+eLBu6DJSbVS9R6OgJG9UbRWv1opVN7ZyejY6h4lX6/kZ3FbKo/abZCnSAuoQcxKYXs2tBzQwVTr9k6gO0OJzw6q/mkw0CPetuFQiUycXgXgJqRBQLbCSlcjlx54dAdytDbK5ZBU+gH5H8kr8Cq8qRdMxN84Zp5r8/1qCLtEkD9xT3zgnvtEE=";
	int sshKeyId=0;
	final static String ROOT_URI="https://api.github.com";
	RequestSpecification requestSpec;
	
	@BeforeClass
	public void setup()
	{
		           requestSpec = new RequestSpecBuilder()
				  .setContentType(ContentType.JSON)
				  .setBaseUri("https://api.github.com")
				  .addHeader("Authorization","token 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")
				  .build();
		  
		
	}	
	
	@Test (priority=1,enabled=true)
  public void post() throws IOException {
	  
	  String reqBody= "{\"title\":\"TestKey\",\"key\": \""+ SSHkey + "\" }";

	  Response response=  given().spec(requestSpec)
			              .body(reqBody)
			              .when().post("/user/keys");
	  
	  System.out.println(response.getBody().prettyPrint());
	  response.getStatusCode();
	  try {
		  sshKeyId = response.jsonPath().get("id");
		  System.out.println(sshKeyId);
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	
	  response.then().statusCode(201);
	  System.out.println("POST method passed"); 
			 
	  
//	  Headers responseHeaders = response.then().extract().headers();
	  
	 
  }
	
	@Test(priority=2,enabled=true)
  public void get() 
	
	{
	  
	  Response response = 
		        given().contentType(ContentType.JSON)
		        .spec(requestSpec)
		        .get(ROOT_URI + "/user/keys"); // Send GET request
	             System.out.println(response.asPrettyString());	  
	             response.then().statusCode(200).log().all(); 		      
  }
  
	@Test(priority=3,enabled=true)
  public void delete() {
	  
	  Response response= 
			  given()
			   .spec(requestSpec)
				.when().pathParam("keyId", sshKeyId)
			  .delete("/user/keys/{keyId}");
	  
	
	  
	  System.err.println(response.asPrettyString());
		Reporter.log(response.asPrettyString());
		// Assertion
		try {
			System.out.println("DELETE RESPONSE:\n"+response.getStatusCode());
			response.then().body("status", equalTo(204));
		}catch(Exception e) {}
	}
	  
  }
  
  
  

