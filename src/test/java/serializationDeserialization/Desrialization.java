package serializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.EmployeeDetails;

public class Desrialization {
	
	@Test
	public void deserializationTest() throws JsonParseException, JsonMappingException, IOException
	{
		//Step 1: Create an object of ObjectMapper
		ObjectMapper oMap = new ObjectMapper();
		
		//Step 2: read the value from file using readValue()
		EmployeeDetails emp = oMap.readValue(new File("./empDetails.json"), EmployeeDetails.class);
		
		//Step 3: access the value using getters
		System.out.println(emp.geteName());
		System.out.println(emp.getEmail());
		System.out.println(emp.getEphone());
	}

	
}
