package testrest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Xmltestfile {
	
	Response response;
	
	
	
	@Test
	
	public void testxml() throws IOException {
		
		
		
		String filepath =System.getProperty("user.dir") + "/src/test/resources/Mul.xml";
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		String reqbody =IOUtils.toString(fis, "UTF-8") ;
		
		RestAssured.baseURI= "http://www.dneonline.com";
 
		
		Response response= 	RestAssured.given()
							.accept(ContentType.XML)
									.body(reqbody).when().log().all()
													.post("/calculator.asmx");
	
	//	response = httprequest.when().body(reqbody).post("/calculator.asmx");

		
		String xmlresponse = response.asPrettyString();
		
		
		String fileout =System.getProperty("user.dir") + "/src/test/resources/Mulout.xml";
		FileOutputStream fos = new FileOutputStream(fileout);
		byte[] array =xmlresponse.getBytes();
		fos.write(array);
		fos.close();
		
		
		
	}

}
