package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {
	
	//path parameter is associated with resourcepath/endpoint of url
	//path paramter helps to send same request with different end points
	//path parameter is used with {}
	@Test
	public void pathParameterTest()
	{
		baseURI = "http://localhost";
		port = 8085;
		
		given()
		  .pathParam("pid", "TY_PROJ_6213")
		.when()
		  .get("/projects/{pid}")
		.then().log().all();
	}

}
