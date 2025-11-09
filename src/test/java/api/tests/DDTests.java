package api.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endpoints.userEndPoints;
import api.payloads.user;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {

	@Test(priority=1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void createUser(String userID,String userName,String fName,String lName,String useremail,String pwd,String ph)
	{
		
		user userPayload = new user();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fName);
		userPayload.setLastName(lName);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		
		Response response= userEndPoints.createUser(userPayload);
		Assert.assertEquals(response.statusCode(),200);
		
		
	}
	
	@Test(priority=2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void getUserByName(String userName)
	{
		

		Response response=userEndPoints.readUser(userName);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);

	}
	
	@Test(priority=3, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void updateUserByName(String userID,String userName, String fName,String lName,String useremail,String pwd,String ph)
	{
		
		//update data by using payload
		user userPayload = new user();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setFirstName(fName);
		userPayload.setLastName(lName);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		

		Response response=userEndPoints.updateUser(userName, userPayload);
		response.then().log().all();
		response.then().log().body().statusCode(200);
		//Assert.assertEquals(response.statusCode(), 200);
	

		//checking the data after update
		
		Response responseAfterUpdate=userEndPoints.readUser(userName);
		response.then().log().all();
		Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);
		
	}
	
	@Test(priority=4, dataProvider="UserNames", dataProviderClass = DataProviders.class)
	public void deleteUserByName(String userName)
	{
		
		Response response=userEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);

	}
	
	
}
