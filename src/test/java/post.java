import org.testng.annotations.Test;



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;

import java.util.HashMap;


public class post {
/*
	
	given()  
	(content type , set cookies , add auth , add param ,set headers info etc comes under given )
	
	when()
    ( get , post , put , delete comes under when )
    	
	then()
	(validate status code , extract response , extract headers cookies & response body)
	*/
	
	
	public class HTTPRequests{
	
		@Test
		void createUser()
		{
			
          HashMap data=new HashMap();//used to store data or parameters 
		  data.put("name","pavan");
		  data.put("job","Training");
          
          
          
          given()
             .contentType("application/json")
             .body(data)
		 
		 .when() //. is used becoz we r accessing it from given
		    .post("https://reqres.in/api/users")
		 
		 .then()  //. is used becoz we r accessing it from given 
		 
              .statusCode(201)
		 //    .body("page",equalTo(2)) //here we r validating the body of the response 
		      .log().all();  //it display the resonse 
		      
	}
	
}


}