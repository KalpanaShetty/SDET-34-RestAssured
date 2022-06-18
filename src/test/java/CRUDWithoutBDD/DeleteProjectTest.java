package CRUDWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProjectTest {
	
	@Test
	public void deleteProject()
	{
		//Step 1: create pre conditions
		//Step 2: execute action
		Response resp = RestAssured.delete("http://localhost:8085/projects/TY_PROJ_1007");
		
		//Step 3: validate the response
		resp.then().log().all();
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getContentType());
		System.out.println(resp.getTime());
		System.out.println(resp.getSessionId());
	}

}
