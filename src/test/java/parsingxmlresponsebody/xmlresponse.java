package parsingxmlresponsebody;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class xmlresponse {

	//validation on the json response by using xml path
	@Test(priority=1)
	void testXMLResponse()
	{
		//Approach 1 i.e without returning the response into variable
		
		given()
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=2")
		.then()
		 	.statusCode(200)
		 	.headers("Content-Type","application/xml; charset=utf-8")
		 	//validating the static data of xml 
		 	.body("TravelerinformationResponse.page", equalTo("2"))
		 	.body("TravelerinformationResponse.travelers.Travelerinformation[1].name", equalTo("jkhaumann"));
		
		
	}
	
	@Test(priority=2)
	void testXMLResponse1()
	{
		//Approach 2 i.e  returning the response into variable
		Response res= 
		
		given()
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=2");
		   
		  Assert.assertEquals(res.getStatusCode(), 200);
		  Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
		  
		  String pageNo=res.xmlPath().get("TravelerinformationResponse.page").toString();
		  Assert.assertEquals(pageNo,"2");
		  
		  String travelerName=res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		  Assert.assertEquals(travelerName, "ASCAS");
		
	}
	
	
	@Test(priority=3)
	
	//validating total number of traveller
	void testXMLResponsebody()
	{
		
		
		
		Response res= 
		
		given()
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=2");
		
		XmlPath xmlobj=new XmlPath(res.asString());
		//this get all the nodes of travelerinfo
		List<String>travellers=xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation"); //total number of traveller stored in traveller variable
		Assert.assertEquals(travellers.size(),10);
		
	//verify traveller name is present in xml response or not
	
	//capture all the traveller name 
	
	List<String>traveller_names=xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
	
	boolean status=false;
	for(String travellername:traveller_names)
	{
	if(travellername.equals("ASCAS"))
	{
		status=true;
		break;
	}
	}
	//System.out.println(travellername);
	Assert.assertEquals(status,true);
	
	}
	

	
	
	
	
	
}






