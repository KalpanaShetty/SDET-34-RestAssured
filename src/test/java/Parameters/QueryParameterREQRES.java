package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameterREQRES {
	
	@Test
	public void queryParameterT()
	{
		baseURI = "https://reqres.in";
		
		given()
		  .queryParam("page", 3)
		.when()
		  .get("/api/users")
		.then().assertThat().statusCode(200).log().all();
	}

}
