package RequestChaining;

import org.testng.annotations.Test;

import genericLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class CreateProjectAndGetTheProject {
	
	@Test
	public void createPAndGet()
	{
		baseURI = "http://localhost:8085";
		
		JavaLibrary jLib = new JavaLibrary();
		
		//Step 1: create the project - post()
		ProjectLibrary pLib = new ProjectLibrary("Raghavendra", "Accenture-"+jLib.getRandomNum(), "Created", 20);
		
		Response resp = given() //Step 2: Capture the response
						.body(pLib)
						.contentType(ContentType.JSON)
						.when()
						.post("/addProject");
	
		//Step 3: store that response in a variable
		String proid = resp.jsonPath().get("projectId");
		System.out.println(proid);
		
		//Step 4: use the response variable in another request - get()
		given()
		  .pathParam("pid", proid)
		.when()
		  .get("/projects/{pid}")
		.then()
		  .assertThat().statusCode(200).log().all();
		
		//Step 4: delete the same project - delete()
		when()
		  .delete("/projects/"+proid)
		.then().assertThat().statusCode(204).log().all();
		
	}

}
