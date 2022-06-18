package DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import pojoClass.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class CreateMultipleProjects {
	
	@Test(dataProvider = "projectData")
	public void createMultipleP(String createdBy, String ProjectName, String Status, int teamSize)
	{
		JavaLibrary jLib = new JavaLibrary();
		
		baseURI = "http://localhost";
		port = 8085;
				
		
		//Step 1: create data
		ProjectLibrary pLib = new ProjectLibrary(createdBy, ProjectName+jLib.getRandomNum(), Status, teamSize);
		
		given()
		 .body(pLib)
		 .contentType(ContentType.JSON)
		.when()
		 .post("/addProject")
		.then()
		 .assertThat().statusCode(201)
		 .log().all();
	}
	
	
	@DataProvider(name = "projectData")
	public Object[][] getData()
	{
		Object[][] data = new Object[3][4];
		
		data[0][0] = "Deepa";
		data[0][1] = "Bosch";
		data[0][2] = "Created";
		data[0][3] = 12;
		
		data[1][0] = "Bindu";
		data[1][1] = "EPS";
		data[1][2] = "Created";
		data[1][3] = 14;
		
		data[2][0] = "Archana";
		data[2][1] = "Xylem";
		data[2][2] = "Created";
		data[2][3] = 12;
		
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
