package api.tests;

import io.restassured.RestAssured;
import utilitits.JsonUtilities;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class Demo {

    @Test
    public void createUserWithRandomData() {
        RestAssured.baseURI = "https://reqres.in/api";

       String userjsonPayload = JsonUtilities.getProcessedJson("src/test/resources/payloads/user.josn");
        
      /*  
        
        String rawPayload= "{\r\n"
        		+ "    \"name\": \"${__RandomString(8)}\",\r\n"
        		+ "    \"job\": \"Senior Automation Test Engineer\",\r\n"
        		+ "    \"location\": \"Chennai\",\r\n"
        		+ "    \"phone\": \"${__RandomPhone(10)}\",\r\n"
        		+ "    \"candidateDetails\": [\r\n"
        		+ "        {\r\n"
        		+ "            \"course1\": \"Java\",\r\n"
        		+ "            \"course2\": \"RestAssured\",\r\n"
        		+ "            \"course3\": \"C\",\r\n"
        		+ "            \"course4\": \"C++\",\r\n"
        		+ "            \"course5\": \".Net\",\r\n"
        		+ "            \"course6\": \"Azure Devops\"\r\n"
        		+ "        }\r\n"
        		+ "    ],\r\n"
        		+ "    \"gender\": \"Male\",\r\n"
        		+ "    \"age\": \"29\"\r\n"
        		+ "}";
        
        String payload = JsonUtilities.getProcessedJsonString(rawPayload);
        */
        
        given()
            .header("Content-Type", "application/json")
            .header("x-api-key","reqres-free-v1")
            //.body(payload)
            .body(userjsonPayload)
            .log().all()
        .when()
            .post("/users")
        .then()
            .statusCode(201)
            .log().all();
    }
}
