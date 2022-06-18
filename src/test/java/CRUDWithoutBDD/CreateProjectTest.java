package CRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	
	@Test
	public void createProjectTest()
	{
		//Step 1: create preconditions
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Chaitra");
		jObj.put("projectName", "Amdocs");
		jObj.put("status", "On Going");
		jObj.put("teamSize", 12);
		
		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);
		
		//Step 2: execute the action
		Response resp = req.post("http://localhost:8085/addProject");
		
		//Step 3: Validate the response
//		System.out.println("----------this is as pretty string------------");
//		System.out.println(resp.asPrettyString());
//		
//		System.out.println("----------this is as string------------");
//		System.out.println(resp.asString());
//		
//		System.out.println("-----------this is pretty print-----------");
//		System.out.println(resp.prettyPrint());
//		
//		System.out.println("-----------This is pretty peek-----------");
//		System.out.println(resp.prettyPeek());
		
		ValidatableResponse valiadte = resp.then();
		valiadte.log().all();
	}

}
