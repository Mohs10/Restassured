package Authentication;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class authentication {

	
	
	//@Test(priority=1)
	void testBasicAuthentication()
	{
		given()
		//directly hit to server 
			.auth().basic("postman","password")
		.when()
			.get("https://postman-echo.com/basic-auth")
			.then()
				.statusCode(200)
				.body("authenticated",equalTo(true))
				.log().all();
	}
	//@Test(priority=2)
	void testDigestAuthentication()
	{
		given()
		//it will check multipe times then hit the server
			.auth().digest("postman","password")
		.when()
			.get("https://postman-echo.com/basic-auth")
			.then()
				.statusCode(200)
				.body("authenticated",equalTo(true))
				.log().all();
	}
	
	
//	@Test(priority=3)
	void testPreemptiveAuthentication() //depends on api designed 
	{
		given()
			.auth().preemptive().basic("postman","password")
		.when()
			.get("https://postman-echo.com/basic-auth")
			.then()
				.statusCode(200)
				.body("authenticated",equalTo(true))
				.log().all();
	}
	//@Test(priority=4)
	void testBearerTokenAuthentication()
	{
		String bearerToken = "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";
		
		given()
			.headers("Authorization","Bearer "+bearerToken)
			
			.when()
				.get("https://api.github.com/user/repos")
			.then()
			.statusCode(200)
			.log().all();
				
		
	}
	
//	@Test(priority=5)
		void testOAuth1Authentication()
		{
			//String bearerToken = "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";
			
			given()
					.auth().oauth("consumerKey", "consumerSecrat","accessToken", "tokenSecrate")
				.when()
					.get("url")
				.then()
				.statusCode(200)
				.log().all();
					
			
		}
		
//	@Test(priority=6)
			void testOAuth2Authentication()
			{
				//String bearerToken = "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";
				
				given()
						.auth().oauth2("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")
					.when()
						.get("https://api.github.com/user/repos")
					.then()
					.statusCode(200)
					.log().all();
						
				
			}
			
			@Test(priority=7) 
			void testAPIKeyAuthentication()
			{
				//method1
				
			/*	given()
						.queryParam("appid", "22eecb43212f7300fbc5a8783eaea45d")  //appid is apikey
					.when()
						.get("https://api.openweathermap.org/data/2.5/weather?q=Delhi")
					.then()
					.statusCode(200)
					.log().all();
					 */
				
				//method2
				
				given()
				.queryParam("appid", "22eecb43212f7300fbc5a8783eaea45d")  //appid is apikey
				.pathParam("mypath", "data/2.5/weather")
				.queryParam("q", "Delhi")
			.when()
				.get("https://api.openweathermap.org/{mypath}")
			.then()
			.statusCode(200)
			.log().all();
						
				
			}
		
		
}




