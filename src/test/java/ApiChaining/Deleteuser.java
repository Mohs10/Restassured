package ApiChaining;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;


public class Deleteuser {
	
	@Test

	void test_deleteuser(ITestContext context)
	{
		String bearerToken = "8b6ab29e2a9cf4cec4025696662ed408b56a12e3c1a7a0ab454a2c37475ce925";
		
		int id =(Integer) context.getSuite().getAttribute("user_id");
		
		given()
			.headers("Authorization","Bearer "+bearerToken)
			.pathParam("id",id)
		.when()
			.delete("htpps://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(204)
			.log().all();
			
	}
	
}
