package api.tests;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import api.endpoints.routes;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import utilitits.JsonUtilities;


public class PetPayloadTest {
	@Test
	public void createUserwithPetModule()
	{
		String petJsonPayload= JsonUtilities.getProcessedJson("src/test/resources/payloads/pet.json");
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(petJsonPayload)
//		.log().all()
		
		.when()
		.post(routes.post_url)
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	
	
}
