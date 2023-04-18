package postrequestindifferentways;
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
public class postrequest1 {

	// 1)post request body using Hashmap
	
	@Test(priority=1)
	void testpostusingHashMap() {
		
		HashMap hm = new HashMap();
		
		//now will store the data in key and value pair
		
		hm.put("name","scott");
		hm.put("Location","France");
		hm.put("phone","123597");
		
		String courseArr[]= {"C","C++"};  //array is use becoz course contain more that one value 
		hm.put("courses", courseArr);
		
		given()  //what type of data we r sending
		.contentType("application/json")
		  .body(hm)
		  
		  .when()

		    .post("http://localhost:3000/students")
		    
		  .then()
		    .statusCode(201)
		    .body("name",equalTo("scott"))
		    
		    .body("Location",equalTo("France"))
		    .body("phone",equalTo("123597"))
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
		.delete("http://localhost:3000/students/9")
		.then()
		.statusCode(200);
		
		}
	
	
	
}




		

	
	

