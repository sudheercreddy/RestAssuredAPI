package InputFiles;

import io.restassured.path.json.JsonPath;

public class LibaryMethods {

	
	public static String addBook(String isbn, String aisle) {
		
		String addbook="{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with RPA\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"Sudheer chittireddy1\"\r\n" + 
				"}\r\n" + 
				"";
		return addbook;
	}
	
	public static JsonPath reusableMethod(String response) {
		
		JsonPath js1= new JsonPath(response);
		return js1;
		
	}
}
