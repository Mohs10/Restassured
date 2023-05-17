package cookiesandheaders;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class logindemo {
	
	
	@Test(priority=1)
     
	void testlogs()
	{
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
		
		
		
		//it will print everything includeing body header etc
		//.log().all();
		
        //it will only print only resposne body
		//.log().body();
		
		//it will print only cookies from the response
		//.log().cookies();
		
		//it will only print headers
		.log().headers();
	}
	
	
	
}
