package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.Userendpoints;
import api.payload.Userpojo;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTest {
	
	@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class )
	public void testPostUser(String UserID, String UserName, String fname , String lname, String useremail, String pwd, String phn )
	{
		Userpojo userpayload = new Userpojo();
		
		userpayload.setId(Integer.parseInt(UserID));
		userpayload.setUsername(UserName);
		userpayload.setFirstname(fname);
		userpayload.setLastname(lname);
		userpayload.setEmail(useremail);
		userpayload.setPassword(pwd);
		userpayload.setPhone(phn);
		
		
		Response response=Userendpoints.CreateUser(userpayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	
	@Test(priority=2, dataProvider="UserName", dataProviderClass=DataProviders.class )
	public void testDeleteUserbyName(String userName)
	{
		Response response=Userendpoints.deletereadUser(userName);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	

}
