package ApiChaining;

import static io.restassured.RestAssured.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

public class Createuser {

	@Test
	void test_createuser(ITestContext context) {
		Faker faker = new Faker();
		JSONObject obj = new JSONObject();
		obj.put("name", faker.name().fullName());
		obj.put("gender", "Male");
		obj.put("email", faker.internet().emailAddress());
		obj.put("status", "inactive");

		String bearerToken = "8b6ab29e2a9cf4cec4025696662ed408b56a12e3c1a7a0ab454a2c37475ce925";
		int id = given().headers("Authorization", "Bearer " + bearerToken).contentType("application/json")
				.body(obj.toString()).when().post("https://gorest.co.in/public/v2/users").jsonPath().getInt("id");
		System.out.println(id);
		// context.setAttribute("user_id", id);
		context.getSuite().setAttribute("user_id", id);
	}

}


/*void test_createuser(ITestContext context) {
	Faker faker = new Faker();

	JSONObject data = new JSONObject();

	data.put("name", faker.name().fullName());
	data.put("gender", "Male");
	data.put("email", faker.internet().emailAddress());
	data.put("status", "inactive");

	String bearerToken = "8b6ab29e2a9cf4cec4025696662ed408b56a12e3c1a7a0ab454a2c37475ce925";

	int id = given().headers("Authorization", "bearer " + bearerToken).contentType("application/json")
			.body(data.toString()) // coverting the jsonobject to string

			.when().post("https://gorest.co.in/public/v2/users").jsonPath().getInt("id"); // whatever response getting
																							// from bteh request
																							// jsonpath will capture the
																							// id

	System.out.println("Generated id is:" + id);

	context.getSuite().setAttribute("user_id", id);
}*/
