package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payloads.PetPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {

	
	//create pet
	public static Response createPet(String petPayload)
	{
		
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(petPayload)

		.when()
		.post(routes.PET_post_url);
		
		return response;

		
	}
	
	//get pet
	
	public static Response getPetById(long petId)
	{
		
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("id", petId)
		
		.when()
		.get(routes.PET_get_url);
		
		return response;
	}
	
	
	//update pet
	
	public static Response updatePetById(long petId, String petPayload)
	{
		
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		//.pathParam("id", petId)
		.body(petPayload)
		
		.when()
		.put(routes.PET_put_url);
		
		return response;
	}
	
	
	//delete pet
	
	public static Response deletePetById(long petId)
	{
		
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("id", petId)
		
		.when()
		.delete(routes.PET_delete_url);
		
		return response;
	}
	
}
