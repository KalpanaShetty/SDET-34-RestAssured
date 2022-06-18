package CRUDWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjectTest {
	
	@Test
	public void getAllProjectTest()
	{
		//Step 1: create preconditions
		//Step 2: Execute the request
		Response resp = RestAssured.get("http://localhost:8085/projects");
		
		//Step 3: validate the response
		resp.then().log().all();
	}

}
