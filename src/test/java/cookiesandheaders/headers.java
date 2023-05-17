package cookiesandheaders;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class headers {

	
	
	
	//@Test(priority=1)//basic validation
	void testHeaders()
	{
		given()
		.when()
			.get("https://www.google.com/")
		.then()
			.header("Content-Type","text/html; charset=ISO-8859-1")
			.and()
			.header("Content-Encoding","gzip")
			.and()
			.header("Server","gws");
			
			
	}
	
	//@Test(priority=2)
		void getHeaders()
		{
			Response res=given()
			.when()
				.get("https://www.google.com/");
			//get single header info
				String headervalue = res.getHeader("Content-Type");
			System.out.println("The value of content-type header is :"+headervalue);
				
		}
		
	//	@Test(priority=3)
				void getallHeaders()
				{
					Response res=given()
					.when()
						.get("https://www.google.com/");
					//get all header info
						Headers myheaders=res.getHeaders();
						for(Header hd:myheaders)
							
						{
							System.out.println(hd.getName()+"   "+hd.getValue());
							
						}
						
						
				}
	
	
}
