package CRUDWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteProjectTest {
	
	@Test
	public void deleteP()
	{
		baseURI = "http://localhost";
		port = 8085;
		
		when()
		 .delete("/projects/TY_PROJ_5617")
		.then()
		 .assertThat().statusCode(204)
		 .log().all();
	}

}
