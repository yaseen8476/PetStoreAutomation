package api.payloads;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import utilitits.JsonUtilities;

public class PetPayload {

    public static String getPetPayload(long petId) {
        String pet = JsonUtilities.getProcessedJson("src/test/resources/payloads/pet.json");

        // Replace id
      //  json = json.replace("\"id\": 0", "\"id\": " + petId);

        // Replace all random placeholders
       // while (json.contains("${__RandomString(8)}")) {
      //      json = json.replaceFirst("\\$\\{__RandomString\\(8\\)\\}", JsonUtilities.getRandomString(8));
       // }

        return pet;
    }
    
    
    public static String getStorePayload(long orderID)
    {
    	
    	String store=JsonUtilities.getProcessedJson("src/test/resources/payloads/store.json");
    	
    	return store;

    	
    }
    
    
    
    
}





