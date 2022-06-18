package CRUDWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class UpdateProjectTest {
	
	@Test
	public void updateP()
	{
		baseURI = "http://localhost";
		port = 8085;
		
		Random ran = new Random();
		int random = ran.nextInt(100);
		
		//create data
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Chaitra");
	    jObj.put("projectName", "Amdocs-"+random);
		jObj.put("status", "On Going");
		jObj.put("teamSize", 12);
		
		given()
		 .body(jObj)
		 .contentType(ContentType.JSON)
		.when()
		 .put("/projects/TY_PROJ_5617")
		.then()
		 .assertThat().statusCode(200)
		 .log().all();
		
	}

}
