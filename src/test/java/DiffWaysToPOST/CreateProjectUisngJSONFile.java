package DiffWaysToPOST;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreateProjectUisngJSONFile {
	
	@Test
	public void createP()
	{
		baseURI = "http://localhost";
		port = 8085;
		
		//create data
		File file = new File(".\\requestData.json");
		
		given()
		 .body(file)
		 .contentType(ContentType.JSON)
		.when()
		 .post("/addProject")
		.then()
		 .assertThat().statusCode(201)
		 .log().all();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
