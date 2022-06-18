package Authentications;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerTokenTest {
	
	@Test
	public void bearerTokenTest() 
	{
		//Its secured compared to basic auth
		//Token is generated with username and passowrd and given by API dev
		//Token can be used untill it expires or API dev changes
		//Token can be used multiple times
		
		//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
		//baseUri - https://api.github.com
		//endpoint - /user/repos
		//http method used - post()
		
		baseURI = "https://api.github.com";
		
		JSONObject jObj = new JSONObject();
		jObj.put("name", "SDET34BearerRest");
		
		given()
		  .body(jObj)
		  .auth()
		  .oauth2("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")
		.when()
		  .post("/user/repos")
		.then()
		  .assertThat().statusCode(201)
		  .log().all();
		    
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
