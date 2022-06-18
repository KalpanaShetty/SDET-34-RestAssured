package CRUDWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectTest {
	
	@Test
	public void createP()
	{
		//create the required data
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Chaitra");
	    jObj.put("projectName", "Amdocs");
		jObj.put("status", "On Going");
		jObj.put("teamSize", 12);
		
		given()//preconsitions
		 .body(jObj)
		 .contentType(ContentType.JSON)
		.when() // action
		 .post("http://localhost:8085/addProject")
		.then() //validation
		 .assertThat().statusCode(201)
		 .log().all();
		
	}

}
