package End2EndScenario;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClassWithSpecBuilders;
import genericLibraries.EndPointsLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.ProjectLibrary;

public class CreateProjectAndVerifyWithBuilders extends BaseClassWithSpecBuilders {
	
	@Test
	public void createP() throws SQLException
	{
		//Step 1: create project using post()
				ProjectLibrary pLib = new ProjectLibrary("Chaitra", "Xylem-"+jLib.getRandomNum(), "Created", 12);
			
				Response resp = given()
						        .spec(requestSpec)
								.body(pLib)
								.when()
								.post(EndPointsLibrary.createProject);
				
				//resp.then().log().all();
				//resp.then().spec(responseSpec);
				
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
