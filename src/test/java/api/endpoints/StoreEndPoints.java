package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {

	public static Response createOrder(String storePayload)
	{
				
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(storePayload)
				.log().all()
				
				.when()
				.post(routes.STORE_post_url);
				
				return res;
		
	}
	
	public static Response getOrder(int orderId)
	{
				
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("orderId", orderId)
				.log().all()
				
				.when()
				.get(routes.STORE_get_url);
				
				return res;
		
	}
	
	public static Response deleteOrder(int orderId)
	{
				
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("orderId", orderId)
				.log().all()
				
				.when()
				.delete(routes.STORE_delete_url);
				
				return res;
		
	}
	
}
