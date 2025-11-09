package api.tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.PetEndPoints;
import api.payloads.PetPayload;
import io.restassured.response.Response;


public class PetTests {

	//PetPayload petPayload;
	public Logger logger;
	
	long petId; // test pet Id
	
	@BeforeClass
	public void setup() {
		
		//logs
		
		logger= LogManager.getLogger(this.getClass());
		
		
	}
	
	@Test(priority=1)
	public void testPostPet() 
	{
		
		String petPayload= PetPayload.getPetPayload(0);
		logger.info("********* Creating Pet *********");
		Response response= PetEndPoints.createPet(petPayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(),200);
		logger.info("********* Pet Is Created *********");
		
        // Extract generated ID from response and save globally
        petId = response.jsonPath().getLong("id");
        System.out.println("Pet created with ID: " + petId);
	}
	
	@Test(priority=2, dependsOnMethods = "testPostPet")
	public void testGetPet() 
	{
		
		logger.info("********* Fetch Pet *********");
		Response response= PetEndPoints.getPetById(petId);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(),200);
		Assert.assertEquals(response.jsonPath().getLong("id"), petId);
		logger.info("********* Fetching Pet *********");
	}
	
	@Test(priority=3, dependsOnMethods = "testGetPet")
	public void testUpdatePet() {
		
		
		
		logger.info("********* Updating Pet *********"); 
	    String petPayload = PetPayload.getPetPayload(petId);// Get original payload

	   // Replace the ID
	  //  petPayload = petPayload.replace("\"id\": 0", "\"id\": " + petId);

	    // Replace the status
	    petPayload = petPayload.replace("\"status\": \"available\"", "\"status\": \"sold\"");

        Response response = PetEndPoints.updatePetById(petId, petPayload);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("status"), "sold");
        logger.info("********* Pet Is Updated *********");
        
    }

    @Test(priority = 4, dependsOnMethods = "testUpdatePet")
    public void testDeletePet() {
    	
    	logger.info("********* Deleting Pet *********");
        Response response = PetEndPoints.deletePetById(petId);
        response.then().log().all();

        Assert.assertEquals(response.statusCode(), 200);
        logger.info("********* Pet Is Deleted *********");
    }
}
	
	
