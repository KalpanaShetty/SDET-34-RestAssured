package Authentications;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuthTest {
	
	@Test
	public void basicAuthTest()
	{
		//Basic auth is less secured
		//basic auth consists of username and password
		//its in readable format hence can be shared easily
		//not preferred
		
	    baseURI = "http://localhost";
	    port = 8085;
	    
	    given()
	      .auth()
	      .basic("rmgyantra", "rmgy@9999")
	    .when()
	       .get("/login")
	    .then()
	       .assertThat().statusCode(202)
	       .log().all();
	    
	    
	    
	    
	    
	    		
	
	}

}
