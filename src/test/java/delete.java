import org.testng.annotations.Test;



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;

import java.util.HashMap;


public class delete {
/*
	
	given()  
	(content type , set cookies , add auth , add param ,set headers info etc comes under given )
	
	when()
    ( get , post , put , delete comes under when )
    	
	then()
	(validate status code , extract response , extract headers cookies & response body)
	*/
	
	
	public class HTTPRequests{
	
		int id;
		@Test(priority=1)
		void createUser()
		{
			
          HashMap data=new HashMap();//used to store data or parameters 
		  data.put("name","pavan");
		  data.put("job","Training");
          
          
          
          id = given()  //This is id contains the id which is capture from resposne 
             .contentType("application/json")
             .body(data)
		 
		 .when() //. is used becoz we r accessing it from given
		    .post("https://reqres.in/api/users")
		    .jsonPath().getInt("id") ;    //capturing id from resposne 
		 
		   /*   .then()  //. is used becoz we r accessing it from given 
		 
              .statusCode(201)
		 //    .body("page",equalTo(2)) //here we r validating the body of the response 
		      .log().all();  //it display the resonse */
		      
	}
	
		@Test (priority=2)
		
		//,dependsOnMethods= {"createUser"})  //it will check if createuser pass or not then update suer will execute  
		
		void updateUser()
		{
			
          HashMap data=new HashMap();//used to store data or parameters 
		  data.put("name","pavan");
		  data.put("job","teacher");
          
          
          
         given()  //This is id contains the id which is capture from resposne 
             .contentType("application/json")
             .body(data)
		 
		 .when() //. is used becoz we r accessing it from given
		    .put("https://reqres.in/api/users/"+id) //Instead of hardcoding the value id u can concatenate or we can say will receive the id value dynamically from post 
		    
		    
		    .then()
		    .statusCode(200)
		    .log().all();
         
         
         //craeteuser and update user is realted here 
		 
		    
		      
	}
		
@Test (priority=3)
		
		
		void deleteUser()
		{
			
        
         given()  
            
		 
		 .when() 
		    .delete("https://reqres.in/api/users/"+id) //Instead of hardcoding the value id u can concatenate or we can say will receive the id value dynamically from post 
		    
		    
		    .then()
		    .statusCode(204)
		    .log().all();
         
         
         
}


}
}