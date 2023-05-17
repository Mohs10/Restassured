package uploadanddownload;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class fileuploadanddownload {
	
	
	//@Test(priority=1)
	void singlefileupload()
	{
		File myfile = new File("C:\\Users\\91891\\Desktop\\api.txt");
		given()
		 .multiPart("file",myfile)
		 .contentType("multipart/form-data")
		 
		.when()
		 .post("http://localhost:9090/uploadFile")
		 .then()
		 .statusCode(200)
		 .body("fileName", equalTo("api.txt"))
		 .log().all();
		
		
		    
	/*	given()	
			File myfile = new File("C:\\Users\\91891\\Desktop\\api.txt");
		.when()
		   .post("http://localhost:8080/uploadFile")
		
		.then()
		  .statusCode(200); */
		
	}
	
//        @Test(priority=2)
	void multiplefilesupload()
	{
		File myfile1 = new File("C:\\Users\\91891\\Desktop\\api.txt");
		File myfile2 = new File("C:\\Users\\91891\\Desktop\\api token.txt");
		given()
		 .multiPart("files",myfile1)
		 .multiPart("files",myfile2)
		 .contentType("multipart/form-data")
		 
		.when()
		 .post("http://localhost:9090/uploadMultipleFiles")
		 .then()
		 .statusCode(200)
		 .body("[0].fileName", equalTo("api.txt"))
		 .body("[1].fileName", equalTo("api token.txt"))
		 .log().all();
		
		
		    
	/*	given()	
			File myfile = new File("C:\\Users\\91891\\Desktop\\api.txt");
		.when()
		   .post("http://localhost:8080/uploadFile")
		
		.then()
		  .statusCode(200); */
		
	}

	@Test
	void fileDownload()
	{
		given()
		.when()
		 .get("http://localhost:9090/downloadFile/api token.txt")
		 .then()
		 .statusCode(200)
		 .log().body();
	}
		
	}


	


