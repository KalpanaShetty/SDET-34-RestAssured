package ResponseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import genericLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class ResponseTimeValidation {
	
	@Test
	public void responseTimev()
	{
		baseURI = "http://localhost";
		port = 8085;
		
		JavaLibrary jLib = new JavaLibrary();
		
		//create data
		ProjectLibrary pLib = new ProjectLibrary("Shashi", "Xylem-"+jLib.getRandomNum(), "CreatedBy", 1);
		
		Response resp = given()
		  .body(pLib)
		  .contentType(ContentType.JSON)
		.when()
		  .post("/addProject");
		
		System.out.println(resp.getTime());
		
		resp.then().assertThat().time(Matchers.lessThan(4L));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
