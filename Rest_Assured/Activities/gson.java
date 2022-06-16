package testrest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.GoogleMapAPIResponse;
import pojo.GoogleMapRequestAPI;
import pojo.locationapi;

public class gson {

	private GoogleMapRequestAPI body;
	
	RequestSpecification httprequest;
	
	DataFormatter formatter = new DataFormatter();
	
	
	@DataProvider(name ="excelData")
	public Object[][] getdata() throws IOException{
		
		String userDirectory = System.getProperty("user.dir");
	    System.out.println(userDirectory);
		
		String filepath = userDirectory + "/src/test/resources/excelread.xlsx" ;
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		
		System.out.println(filepath);
		XSSFWorkbook worbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = worbook.getSheetAt(0);
		
		
		
		int rowcount = sheet.getPhysicalNumberOfRows();
		
		int columncount = sheet.getRow(0).getLastCellNum();
		
		String data[][] = new String [rowcount-1][columncount];
		
		for(int i=1;i<rowcount;i++) {
			
			XSSFRow row = sheet.getRow(i)  ;
			
			for(int j=0;j<columncount;j++) {
				
				XSSFCell cell =  row.getCell(j);
				CellType type = cell.getCellType();
				
				if(type == CellType.NUMERIC) {
					
					data[i-1][j] = formatter.formatCellValue(cell);
					
				}
				
				else if (type == CellType.STRING) {
					
					data[i-1][j] = formatter.formatCellValue(cell);
				}
				
			}
		}
		
		
		return data;
		
		
	}
	
	
	
	@BeforeClass
	public void setup() {
		
		httprequest = new RequestSpecBuilder().
						setContentType(ContentType.JSON)
						.setBaseUri("https://rahulshettyacademy.com")
						.build();
		
		
	}

	@Test(priority=1,dataProvider = "excelData")
	public void post(ITestContext context ,String Testcasename,String Accuracy ,String Name, String Phone_number, String Address,
			String Website , String language) {

		locationapi loc = new locationapi();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);

		List<String> types = new ArrayList<>();
		types.add("shoe park");
		types.add("shop");
		
		int accu = Integer.parseInt(Accuracy);

		body = new GoogleMapRequestAPI(loc, accu, Name, Phone_number, Address, types, Website, language);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonbody = gson.toJson(body);
		System.out.println(jsonbody);


		
		Response response = RestAssured.given().
										spec(httprequest).
									when().log().all().
									queryParams("key", "qaclick123").
									body(jsonbody)
								.post("maps/api/place/add/json");


		String postactualresult = response.asPrettyString();
		
		System.out.println(response.asPrettyString());

		Gson gsond = new GsonBuilder().create();
		GoogleMapAPIResponse gresp = gsond.fromJson(postactualresult, GoogleMapAPIResponse.class);
		System.out.println(gresp.getStatus());
		System.out.println(gresp.getPlace_id());
		System.out.println(gresp.getScope());
		System.out.println(gresp.getReference());

		String placeid = gresp.getPlace_id();
		JsonObject bodydel = new JsonObject();
		bodydel.addProperty("place_id", placeid);
		
		context.setAttribute("place_id", placeid);
		
		

	}
	
	@Test(priority=2,dependsOnMethods = "post")
	public void put(ITestContext context) {
		
	
		
	String placeid=	(String) context.getAttribute("place_id");

	
		
		JsonObject putbody = new JsonObject();
		putbody.addProperty("place_id", placeid);
		putbody.addProperty("address","70 Summer walk, USA");
		putbody.addProperty("key", "qaclick123");
		
		System.out.println(putbody.toString());
		
		
		Response put = RestAssured.given(). 
									spec(httprequest).
									log().all().when().body(putbody.toString())
								.put("maps/api/place/update/json");
		
		System.out.println(put.asPrettyString());
		

		
	}
	
	@Test(priority=3, dependsOnMethods = "post")
	public void delete(ITestContext context) {
		
		
		String placeid=	(String) context.getAttribute("place_id");
		JsonObject bodydel = new JsonObject();
		bodydel.addProperty("place_id", placeid);
		

		System.out.println(bodydel.toString());

		Response delete = RestAssured.given()
								.spec(httprequest).	
										log().all()

								.when().body(bodydel.toString())
								.delete("maps/api/place/delete/json");

		System.out.println(delete.asPrettyString());
		
				
	}

}
