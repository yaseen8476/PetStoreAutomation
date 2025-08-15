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
	
	
	
	// store module
	
	
	
	
	// pet module
	
	
	
}
