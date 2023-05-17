package Fakerlibrary;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class fakerlibrary {

	
	// by using fake library we can generate fake data 
	
	@Test
	void testgenerateDummydata()
	{
		Faker faker=new Faker();
		
		String fullname = faker.name().fullName();
		String firstname = faker.name().firstName();
		String lastname = faker.name().lastName();
		String username = faker.name().username();
		String password = faker.internet().password();
		String phoneno = faker.phoneNumber().cellPhone();
		String email = faker.internet().safeEmailAddress();
		
		System.out.println("Full Name:"+fullname);
		System.out.println("First Name:"+firstname);
		System.out.println("Last Name:"+lastname);
		System.out.println("Username:"+username);
		System.out.println("password:"+password);
		System.out.println("Phoneno:"+phoneno);
		System.out.println("Emailid:"+email);
		
		
	}
}
