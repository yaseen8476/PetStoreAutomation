package api.endpoints;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payloads.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


// which is created to perform CRUD operation (Create,Read, Update, Delete)

public class userEndPoints {

	
	public static Response createUser(user payload)
	{
		
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(routes.post_url);
		
		return response;
		
	}
	
	public static Response readUser(String userName)
	{
		
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("userName",userName)
		
		.when()
		.get(routes.get_url);
		
		return response;
		
	}
	
	public static Response updateUser(String userName, user payload)
	{
		
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.pathParam("userName",userName)
		
		.when()
		.put(routes.put_url);
		
		return response;
		
	}
	
	public static Response deleteUser(String userName)
	{
		
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("userName",userName)
		
		.when()
		.delete(routes.delete_url);
		
		return response;
		
	}

}






