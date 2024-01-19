package businessLogics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

public class ReadDataFromJsonFileTest {
public static void main(String[] args) throws Throwable {
	FileReader reader= new FileReader("/SDET34-RestAssuredFW/Sample.json");
	JSONParser jsonParser= new JSONParser();
	Object obj = jsonParser.parse(reader);
	JSONObject map = (JSONObject)obj;
	map.get("Name");
	map.get("UserName");
	
	System.out.println(map.get("Name"));
}
}
