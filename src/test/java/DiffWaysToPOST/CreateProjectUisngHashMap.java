package DiffWaysToPOST;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateProjectUisngHashMap {
	
	@Test
	public void createP()
	{
		baseURI = "http://localhost";
		port = 8085;
		
//		HashMap mp = new HashMap();
//		mp.put("name", "xyz");
//		mp.put("id", "11345ty");
		
		//create data
		HashMap map = new HashMap();
		map.put("createdBy", "Chaitra");
		map.put("projectName", "Amdocs");
		map.put("status", "On Going");
		map.put("teamSize", 12);
//		map.put("spouse", mp);
		
		given()
		 .body(map)
		 .contentType(ContentType.JSON)
		.when()
		 .post("/addProject")
		.then()
		 .assertThat().statusCode(201)
		 .log().all();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
