package CRUDWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProjectTest {
	
	@Test
	public void getSingleProject()
	{
		String expData = "Harish";
		
		//Step 1: create pre conditions
		//Step 2: execute request
		Response resp = RestAssured.get("http://localhost:8085/projects/TY_PROJ_1007");
		
		//Step 3: validate response
		resp.then().log().all();
		String actData=resp.jsonPath().get("createdBy");
		System.out.println(actData);
		Assert.assertEquals(expData, "");
	
	}

}
