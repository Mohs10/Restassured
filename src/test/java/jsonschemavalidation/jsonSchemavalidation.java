package jsonschemavalidation;

import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class jsonSchemavalidation {
	
	
	
	
	@Test
	void jsonschemavalidation() {
		
		
		
		given()
		
			.when()
				.get("http://localhost:3000/students")
			.then()
				.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJsonSchema.json"));
	
	}
	

}
