package ApiChaining;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Updateuser {
	
	@Test
	void test_updateuser(ITestContext context) {
		
	Faker faker=new Faker();
	
	JSONObject data = new JSONObject();
	
	data.put("name",faker.name().fullName());
	data.put("gender","Male");
	data.put("email",faker.internet().emailAddress());
	data.put("status","active");
	
	String bearerToken = "8b6ab29e2a9cf4cec4025696662ed408b56a12e3c1a7a0ab454a2c37475ce925";
	
	int id =(Integer) context.getSuite().getAttribute("user_id"); 
	
	given()
			.headers("Authorization","Bearer "+bearerToken)
			.contentType("application/json")
			.pathParam("id",id)
			.body(data.toString())
			
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
			.then()
			.statusCode(200)
			.log().all();
	System.out.println("Generated id is"+ id);
	
	
	

}
}
