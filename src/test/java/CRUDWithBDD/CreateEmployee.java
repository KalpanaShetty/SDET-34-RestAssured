package CRUDWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreateEmployee {
	
	@Test
	public void createEmpT()
	{
		baseURI = "http://localhost:8085";
		
		//create data
		File file = new File(".\\empdata.json");
		
		given()
		 .body(file)
		 .contentType(ContentType.JSON)
		.when()
		 .post("/employees")
		.then().assertThat().statusCode(201).log().all();
	}

}
