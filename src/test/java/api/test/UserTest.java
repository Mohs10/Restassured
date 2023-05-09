package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Userendpoints;
import api.payload.Userpojo;
import io.restassured.response.Response;

public class UserTest {
	
	Faker faker; //global lib 
	 Userpojo userPayload;

	@BeforeClass
	public void setupData()
	{
		faker = new Faker();
		userPayload = new Userpojo();  //once the userpojo class pass thedata the userpayload have the data 
		//payload is generating the id number 
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPhone(faker.internet().password(5,10));
		
		
	}
	
	
	@Test(priority =1)
	public void testPostUser() //here we r calling the end point by passing the required input 
	{
		Response response=Userendpoints.CreateUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority =2)
	public void testGetUserbyName() //here we r calling the end point by passing the required input 
	{
	   Response response = Userendpoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority =3)
	public void testUpdateUserbyName() 
	
	{
		//update data using payload
		
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		
	   Response response = Userendpoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	
	
	
		//verifying data is updated or not 
		
		Response responseAfterupdate = Userendpoints.readUser(this.userPayload.getUsername());
		Assert.assertEquals(responseAfterupdate.getStatusCode(), 200);
		}
	
	
	@Test(priority =4)
	public void testDeleteUserbyName() 
	
	{
		
		
	   Response response = Userendpoints.deletereadUser(this.userPayload.getUsername());
		
		Assert.assertEquals(response.getStatusCode(), 200);
	
	}
}
