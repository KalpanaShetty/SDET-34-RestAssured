package DiffWaysToPOST;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoClass.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class CreateProjectuisngPOJO {
	
	@Test
	public void createP()
	{
		baseURI = "http://localhost";
		port = 8085;
		
		//create data
		ProjectLibrary pLib = new ProjectLibrary("Deepa", "BOSCH", "Created", 20);
		
		given()
		 .body(pLib)
		 .contentType(ContentType.JSON)
		.when()
		 .post("/addProject")
		.then()
		 .assertThat().statusCode(201)
		 .log().all();
	}

}
