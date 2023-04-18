package postrequestindifferentways;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

/*
 Different ways to create post request body
 1)post request body using Hashmap
 2)post request body creation using using Org.JSON
 3)post request body creation using POJO class
 4)post request using external json file data 
 */
public class postrequest2 {

	// 2)post request body creation using using Org.JSON
	
	@Test(priority=1)
	void testpostusingOrgjsonlibrary() {
		
		JSONObject data = new JSONObject();
		
		data.put("name","scott");
		data.put("Location","France");
		data.put("phone","23659");
		
		String coursesArr[]= {"C","C++"};
		data.put("courses",coursesArr );
		given()  //what type of data we r sending
		.contentType("application/json")
		  .body(data.toString()) //here we change the data in string format 
		  
		  .when()

		    .post("http://localhost:3000/students")
		    
		  .then()
		    .statusCode(201)
		    .body("name",equalTo("scott"))
		    
		    .body("Location",equalTo("France"))
		    .body("phone",equalTo("23659"))
		    .body("courses[0]",equalTo("C"))
		    .body("courses[1]",equalTo("C++"))
		    .header("Content-Type","application/json; charset=utf-8")
		    .log().all();
		  
		
		
	}
	
	//deleting student record
	@Test(priority=2)
	void testDelete()
	{
		given()
		.when()
		.delete("http://localhost:3000/students/13")
		.then()
		.statusCode(200);
		
		}
	
	
	
}




		

	
	

