package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameter {
	
	@Test
	public void queryPTest()
	{
		baseURI = "http://localhost";
		port = 8085;
		
		given()
		  .queryParam("designation", "Team Lead")
		.when()
		  .get("/employees")
		.then()
		  .assertThat().statusCode(200)
		  .log().all();
	}

}
