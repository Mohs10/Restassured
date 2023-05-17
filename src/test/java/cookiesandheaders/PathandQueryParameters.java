package cookiesandheaders;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class PathandQueryParameters {
	
	//fetching the particular id of particluar page
	
	@Test
	void testqueryandpathparameters()
	{
		given()
		.pathParam("mypath","users")
		.queryParam("page",3)
		.queryParam("id",1)
		
		.when()
		    .get("https://reqres.in/api/{mypath}")
		 .then()
		 .statusCode(200)
		 .log().all();
	}

}
