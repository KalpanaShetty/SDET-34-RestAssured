package DiffWaysToPOST;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUisngJSONObj {

	@Test
	public void createP()
	{
		baseURI = "http://localhost:8085";
		
		
		//create data
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Chaitra");
		jObj.put("projectName", "Amdocs");
		jObj.put("status", "On Going");
		jObj.put("teamSize", 12);
		
		given()
		 .body(jObj)
		 .contentType(ContentType.JSON)
		.when()
		 .post("/addProject")
		.then()
		 .assertThat().statusCode(201)
		 .log().all();
	}
}
