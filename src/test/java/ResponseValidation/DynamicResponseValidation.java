package ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidation {
	
	@Test
	public void dynamicResponseV()
	{
		baseURI = "http://localhost";
		port = 8085;
		
		String expData = "TY_PROJ_1003";
		
		//create request
		Response resp = when()
		                   .get("/projects");
		
		//capture the response
		boolean flag = false;
		
		List<String> list = resp.jsonPath().get("projectId");
		for(String actData:list)
		{
			if(actData.equals(expData))
			{
				System.out.print(actData);
				flag = true;  // flag rising
				break;
			}
		}
		
	    Assert.assertTrue(flag);
	    
	    resp.then().log().all();
		
		
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	}

}
