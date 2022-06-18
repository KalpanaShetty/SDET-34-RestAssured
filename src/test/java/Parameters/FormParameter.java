package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class FormParameter {
	
	@Test
	public void formParameter()
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
