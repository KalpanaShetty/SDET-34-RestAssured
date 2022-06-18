package End2EndScenario;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClassWithOutSpec;
import genericLibraries.EndPointsLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

import pojoClass.ProjectLibrary;

public class CreateProjectAndVerifyInDataBase extends BaseClassWithOutSpec {
	
	@Test
	public void createPAndVerifyInDb() throws SQLException
	{
		//Step 1: create project using post()
		ProjectLibrary pLib = new ProjectLibrary("Chaitra", "Xylem-"+jLib.getRandomNum(), "Created", 12);
	
		Response resp = given()
						.body(pLib)
						.contentType(ContentType.JSON)
						.when()
						.post(EndPointsLibrary.createProject);
		
		//resp.then().log().all();
		
		//Step 2: Capture the response and retreive projectID
		String expData = rLib.getJsonData("projectId", resp);
		System.out.println(expData);
		
		//Step 3: Connect to database and verify the project
		String query = "select * from project;";
		String actData = dLib.executeQueryAndGetTheData(query, 1, expData);
		System.out.println(actData);
		
		//Step 4: validate
		Assert.assertEquals(expData, actData);
	}

}
