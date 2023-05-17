package cookiesandheaders;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesDemo {
	
	//@Test(priority=1)
	void testCookies()
	{
		given()
		
		.when()
		   .get("https://www.google.com/")
		   
		   .then()
		     .cookie("1P_JAR","2023-04-18-04")
		     .log().all();
	}
	
	@Test(priority=2)
	void getCookiesinfo()
	{
		
		Response res=given()
		
		
		.when()
		   .get("https://www.google.com/");
		
		//get single cookie info
		/*String Cookie_value = res.getCookie("1P_JAR");
		System.out.println("value of cookie is=====>"+Cookie_value);
		*/
		
		//get all cookie info only name
	/*	Map<String,String> cookies_values = res.getCookies();
		System.out.println(cookies_values.keySet());
		
		*/
		
		
		//get all cookie info with value
		Map<String,String> cookies_values = res.getCookies();
		for(String k:cookies_values.keySet())
		{
			String cookie_value=res.getCookie(k);
			System.out.println(k+"       "+cookie_value);
		}
		
		
		 
	}

}
