package ApiChaining;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Getuser {

	
	
	@Test
	void test_getuser(ITestContext context)
	{
	   int id =(Integer) context.getSuite().getAttribute("user_id"); //this should come from createuser request
	   
	   String bearerToken = "8b6ab29e2a9cf4cec4025696662ed408b56a12e3c1a7a0ab454a2c37475ce925";
	   
	   given()
	   	.headers("Authorization","Bearer "+bearerToken)
	   	.pathParam("id",id)
	   	
	   	.when()
	   		.get("https://gorest.co.in/public/v2/users/{id}")
	   	.then()
	   		.statusCode(200)
	   		.log().all();
	   	
	}
	
	
	
}
