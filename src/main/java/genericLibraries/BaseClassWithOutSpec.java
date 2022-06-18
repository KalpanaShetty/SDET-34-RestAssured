package genericLibraries;

import java.sql.SQLException;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

/**
 * This class consists of basic configuration annotations
 * @author Chaitra M
 *
 */
public class BaseClassWithOutSpec {
	
	public JavaLibrary jLib = new JavaLibrary();
	public RestAssuredLibrary rLib = new RestAssuredLibrary();
	public DataBaseLibrary dLib = new DataBaseLibrary();
	
	@BeforeSuite
	public void bsConfig() throws SQLException
	{
		dLib.connectToDB();
		Reporter.log("=========Connection successful========",true);
		
		baseURI = "http://localhost";
		port = 8084;
	}
	
	
	@AfterSuite
	public void asConfig() throws SQLException
	{
		dLib.closeDB();
		Reporter.log("=======database closed=======", true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
