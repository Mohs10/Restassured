package api.endpoints;  //it will only contain the endpoints of the url

/*
 Swagger URI --->https://petstore.swagger.io
 
 Create user (post)  :https://petstore.swagger.io/v2/user
 get user (post)  :https://petstore.swagger.io/v2/user/{username}
Update user (post)  :https://petstore.swagger.io/v2/user/{username}
Delete user (post)  :https://petstore.swagger.io/v2/user/{username}
 */

public class Routes { 
	//here we r maintaining the url 
	
	 public static String base_url = "https://petstore.swagger.io/v2";
	 
	 
	//user module  for pet store
	 
	 public static String post_url = base_url+"/user";
	 public static String get_url = base_url+"/user/{username}";
	 public static String update_url = base_url+"/user/{username}";
	 public static String delete_url = base_url+"/user/{username}";
	 
	 //store module endpoints for petstore
	 
	 

}
