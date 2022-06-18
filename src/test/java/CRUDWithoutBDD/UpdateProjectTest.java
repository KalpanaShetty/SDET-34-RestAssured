package CRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {

	@Test
	public void updateProject()
	
	{
		//Step 1: create pre consitions
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Chaitra");
		jObj.put("projectName", "Amdocs");
		jObj.put("status", "On Going");
		jObj.put("teamSize", 12);
		
		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);
		
		//Step 2: execute action
		Response resp = req.put("http://localhost:8085/projects/TY_PROJ_1007");
		
		//Step 3: validate response
		resp.then().log().all();
	}
}
