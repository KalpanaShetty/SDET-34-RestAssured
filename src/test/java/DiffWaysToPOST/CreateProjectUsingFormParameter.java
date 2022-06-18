package DiffWaysToPOST;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class CreateProjectUsingFormParameter {

	@Test
	public void createP()
	{
		given()
		  .formParam("createdBy", "Chaitra")
		  .formParam("projectName", "TYSS")
		  .formParam("status", "On Going")
		  .formParam("teamSize", 122)
		.when()
		  .post("http://localhost:8085/addProject")
		.then().assertThat().statusCode(201).log().all();

	}
}
