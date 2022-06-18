package genericLibraries;

import io.restassured.response.Response;

/**
 * This class contains restassured specific methods
 * @author Chaitra M
 *
 */
public class RestAssuredLibrary {
	
	/**
	 * This method will fetch the data from response using json path
	 * @param jsonPath
	 * @param response
	 * @return
	 */
	public String getJsonData(String jsonPath,Response response)
	{
		String jsonData = response.jsonPath().get(jsonPath);
		return jsonData;
	}

}
