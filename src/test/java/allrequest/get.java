package allrequest;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;





public class get {
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
		void getUser()
		{
		 given()
		 
		 .when() //. is used becoz we r accessing it from given
		    .get("https://reqres.in/api/users?page=2")
		 
		 .then()  //. is used becoz we r accessing it from given 
		 .header("Content-Type","application/json; charset=utf-8")
			.and()
			.header("Content-Encoding","gzip")
              .statusCode(200)
		     .body("page",equalTo(2)) //here we r validating the body of the response 
		      .log().all();  //it display the resonse 
		      
	}
	
}


}

		
