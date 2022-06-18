package ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation {
	
	@Test
	public void staticResponseVGet()
	{
		baseURI = "http://localhost";
		port = 8085;
		
		String expData = "TY_PROJ_1003";
		
		//Step 2: execute the request
		Response resp = when()
		                   .get("/projects");
		
		//Step 3: validate the response
		String actData = resp.jsonPath().get("[1].projectId");
		System.out.println(actData);
		
		Assert.assertEquals(expData, actData);
		
		resp.then().log().all();
		
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	}

}
