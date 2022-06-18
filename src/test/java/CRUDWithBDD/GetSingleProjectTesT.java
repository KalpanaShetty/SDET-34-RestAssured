package CRUDWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetSingleProjectTesT {
	
	@Test
	public void getSingleP()
	{
		baseURI = "http://localhost:8085";
		
		when()
		 .get("/projects/TY_PROJ_5617")
		.then()
		 .assertThat().statusCode(200)
		 .log().all();
	}

}
