package api.tests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.google.common.graph.EndpointPair;

import api.endpoints.userEndPoints;
import api.payloads.user;
import io.restassured.http.ContentType;
import io.restassured.internal.support.FileReader;
import io.restassured.response.Response;

public class userTests {

	Faker faker;
	user userPayload;
	public Logger logger; // for logs
	
	@BeforeClass
	public void setup()
	{
		
		faker=new Faker();
		userPayload=new user();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());;
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());

		
		
		//logs

		logger= LogManager.getLogger(this.getClass());
		
	}
	
	@Test(priority=1)
	public void testPostUser() 
	{
		logger.info("********* Creating User *********");
		Response response= userEndPoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(),200);
		logger.info("********* User Is Created *********");
	}
	
	@Test(priority=2)
	public void getUserByName()
	{
		
		logger.info("********* Reading User Info *********");
		Response response=userEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("********* User Info Is Displayed *********");
	}
	
	@Test(priority=3)
	public void updateUserByName()
	{
		
		//update data by using payload
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		logger.info("********* Updating User *********");
		Response response=userEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		response.then().log().body().statusCode(200);
		//Assert.assertEquals(response.statusCode(), 200);
	
		logger.info("********* User Is Updated *********");
		//checking the data after update
		
		Response responseAfterUpdate=userEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);

		
	}
	
	@Test(priority=4)
	public void deleteUserByName()
	{
		logger.info("********* Deleting User *********");
		Response response=userEndPoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("********* User Is Deleted *********");
		
	}
	
	
}


