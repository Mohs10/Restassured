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
public class postrequest3 {

	// 3)post request body creation using POJO class
	
	@Test(priority=1)
	void testpostusingPojo() {
		
		Pojo_postreq data= new Pojo_postreq ();
		data.setName("Scott");
		data.setLoaction("France");
		data.setPhone("123456");
		String courseArr[]= {"C","C++"};
		
		data.setCourses(courseArr);
		
		
		
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
/*	@Test(priority=2)
	void testDelete()
	{
		given()
		.when()
		.delete("http://localhost:3000/students/13")
		.then()
		.statusCode(200);
		
		}*/
	
	
	
}




		

	
	

