package genericLibraries;

import java.sql.SQLException;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

/**
 * RequestSpecBuilder and ResponseSpecBuilder are classes in restAssured Library
 * With the help of which we can store some common Actions in both resquest 
 * and response
 * @author Chaitra M
 *
 */
public class BaseClassWithSpecBuilders {
	
	public JavaLibrary jLib = new JavaLibrary();
	public RestAssuredLibrary rLib = new RestAssuredLibrary();
	public DataBaseLibrary dLib = new DataBaseLibrary();
	public RequestSpecification requestSpec;
	public ResponseSpecBuilder responseSpec;
	
	@BeforeSuite
	public void bsConfig() throws SQLException
	{
		dLib.connectToDB();
		Reporter.log("====connection successful====", true);
		
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri("http://localhost");
		builder.setPort(8084);
		builder.setContentType(ContentType.JSON);
		
		requestSpec = builder.build();
	}
	
	@AfterSuite
	public void asConfig() throws SQLException
	{
		dLib.closeDB();
		Reporter.log("======db closed=====",true);
		
		ResponseSpecBuilder builder = new ResponseSpecBuilder();
		responseSpec = builder.log(null);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
