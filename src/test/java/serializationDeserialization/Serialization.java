package serializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.EmployeeDetails;

public class Serialization {
	
	@Test
	public void serializationTest() throws JsonGenerationException, JsonMappingException, IOException
	{
		//Step 1: create a object of pojoclass
		EmployeeDetails emp = new EmployeeDetails("Chaitra", "typ123", 1234, "c@ty.com");
		
		//Step 2: create a object of objectMapper - jackson mapper tool
		ObjectMapper oMap = new ObjectMapper();
		
		//Step 3: use writeValue() from objectmapper and store in a json file
		oMap.writeValue(new File("./empDetails.json"), emp);
	}
	
	

}
