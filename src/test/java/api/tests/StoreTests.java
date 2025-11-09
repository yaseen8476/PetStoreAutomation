package api.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.StoreEndPoints;
import api.payloads.PetPayload;
import io.restassured.response.Response;



public class StoreTests {
	
	int orderId;
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		
		//logs
		
		logger= LogManager.getLogger(this.getClass());
		
	}

	@Test(priority=1)
	public void createOrder()
	{
		
		logger.info("********* Creating Order *********");
		String storePayload= PetPayload.getStorePayload(0);
		Response res= StoreEndPoints.createOrder(storePayload);
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
		logger.info("********* Order Created *********");
        orderId = res.jsonPath().getInt("id");
        System.out.println("Order created with ID: " + orderId);
		
	}
	
	@Test(dependsOnMethods = "createOrder")
	public void getOrder()
	{
		
		logger.info("********* Fetch Order *********");
		Response res= StoreEndPoints.getOrder(orderId);
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
		logger.info("********* Order Details Fetched *********");
	}
	
	
	@Test(dependsOnMethods = "getOrder")
	public void deleteOrder()
	{
		logger.info("********* Deleting Order *********");
		Response res= StoreEndPoints.deleteOrder(orderId);
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
		logger.info("********* Order Details Deleted *********");
		
	}
	

}
