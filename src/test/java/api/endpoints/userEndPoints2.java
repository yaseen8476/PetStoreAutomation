package api.endpoints;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payloads.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


// which is created to perform CRUD operation (Create,Read, Update, Delete)

public class userEndPoints2 {
	
	// method created for getting URLs from properties file 
	static ResourceBundle getURL()
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes"); // load properties file
		return routes;
	}
	
	
	public static Response createUser(user payload)
	{
		
		String post_url=getURL().getString("post_url");
		
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(post_url);
		
		return response;
		
	}
	
	public static Response readUser(String userName)
	{
		String get_url=getURL().getString("get_url");
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("userName",userName)
		
		.when()
		.get(get_url);
		
		return response;
		
	}
	
	public static Response updateUser(String userName, user payload)
	{
		String put_url=getURL().getString("put_url");
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.pathParam("userName",userName)
		
		.when()
		.put(put_url);
		
		return response;
		
	}
	
	public static Response deleteUser(String userName)
	{
		String delete_url=getURL().getString("delete_url");
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("userName",userName)
		
		.when()
		.delete(delete_url);
		
		return response;
		
	}
	
	
	
}






