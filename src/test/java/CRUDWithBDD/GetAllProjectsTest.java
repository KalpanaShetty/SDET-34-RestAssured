package CRUDWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllProjectsTest {
	
	@Test
	public void getAllP()
	{
		baseURI = "http://localhost";
		port = 8085;
		
		when()
		 .get("/projects")
		.then()
		 .assertThat().statusCode(200)
		 .log().all();
	}

}
