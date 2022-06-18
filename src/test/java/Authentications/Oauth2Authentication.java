package Authentications;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2Authentication {
	
	@Test
	public void Oauth2Test()
	{
		//Oauth2 - provides single level security - two way security\
		//Client ID and Client secret - given by API dev
		//Client Id and Client secret is generated with Oauth APPs
		//Its secured - with Client ID and Client Secret - Oauth App will generate access Toekn
		//Access token is valid for stipulated time- with in which v can use it multiple times
		
		//Base URI - http://coop.apps.symfonycasts.com
		//End Point - /token -> to generate access token
		//Client ID - SDET34-B1-Oauth
		//Client Secret - ff0104c48b6a416c7253eebeaeefa0e7 
		//Call back URl/Redirect URL - http://example.com
		
		//Stage 1: provide details and get the access Token
		
		baseURI = "http://coop.apps.symfonycasts.com";
		
		Response resp = given()
						.formParam("client_id", "SDET34-B1-Oauth")
						.formParam("client_secret", "ff0104c48b6a416c7253eebeaeefa0e7")
						.formParam("grant_type", "client_credentials")
						.formParam("redirect_uri", "http://example.com")
						.formParam("code", "authorization_code")
						.when()
						.post("/token");
		
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		//Stage 2: utilise the access token in the request
		//end point - /api/USER_ID/eggs-collect -> to collect the eggs
		
		given()
		  .auth()
		  .oauth2(token)
		  .pathParam("USER_ID", 1914)
		.when()
		  .post("/api/{USER_ID}/eggs-count")
		.then()
		  .log().all();
	}

}
