package api.endpoints;
//created for perform CRUD operation

import static io.restassured.RestAssured.given;

import api.payload.Userpojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Userendpoints {
	
	
	public static Response CreateUser(Userpojo payload)
	{
		Response response = given()
		      .contentType(ContentType.JSON)
		      .accept(ContentType.JSON)
		      .body(payload)
			.when()
				.post(Routes.post_url);
		
		      return response;
	}
	
	public static Response readUser(String userName)
	{
		Response response = given()
		    .pathParam("username", userName)
			.when()
				.get(Routes.get_url);
		
		      return response;
	}
	
	public static Response updateUser(String userName , Userpojo payload)
	
	{
		Response response = given()
		      .contentType(ContentType.JSON)
		      .accept(ContentType.JSON)
		      .pathParam("username", userName)
		      .body(payload)
			.when()
				.put(Routes.update_url);
		
		      return response;
	}
	public static Response deletereadUser(String userName)
	{
		Response response = given()
		    .pathParam("username", userName)
			.when()
				.delete(Routes.delete_url);
		
		      return response;
	}
	
	

}
