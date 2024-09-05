package steps.config;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.parsing.Parser;

public class RestAssuredConfig {

	@Before
	public void setup() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.baseURI = "http://localhost:8080/";
		RestAssured.basePath = "/api/v1";
		RestAssured.defaultParser = Parser.JSON;
		
		RestAssured.requestSpecification = new RequestSpecBuilder().
				build();
		
		RestAssured.responseSpecification = new ResponseSpecBuilder().
				build();
	}
	
}
