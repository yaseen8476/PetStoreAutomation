package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


//pet store swagger user module

// post https://petstore.swagger.io/v2/user
//get https://petstore.swagger.io/v2/user/{userName}
//put https://petstore.swagger.io/v2/user/{userName}
//delete https://petstore.swagger.io/v2/user/{userName}


public class routes {

	public static String base_url="https://petstore.swagger.io/v2";
	
	//user module
	
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{userName}"; 
	public static String put_url=base_url+"/user/{userName}"; 
	public static String delete_url=base_url+"/user/{userName}"; 
	

	// pet module
	
	public static String PET_post_url=base_url+"/pet";
	public static String PET_get_url=base_url+"/pet/{id}"; 
	public static String PET_put_url=base_url+"/pet"; 
	public static String PET_delete_url=base_url+"/pet/{id}"; 
	
	
	// store module
	//https://petstore.swagger.io/v2/store/order
	
	public static String STORE_post_url=base_url+"/store/order";
	public static String STORE_get_url=base_url+"/store/order/{orderId}"; 
	public static String STORE_delete_url=base_url+"/store/order/{orderId}"; 
	
	
	
}
