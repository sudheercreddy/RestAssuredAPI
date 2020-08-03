package LibaryAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import InputFiles.ResuableMethods;

public class LibaryBooksTest {

	public static void main(String[] args) {
		
		RestAssured.baseURI="http://216.10.245.166";
		// Add the book to the Libary- POST
		//Given input data
		String res= given().headers("Content-Type","application/json").body(InputFiles.LibaryMethods.addBook("",""))
		//submit- WHEN
		
		.when().post("Library/Addbook.php")
		//Response- THEN
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1= ResuableMethods.rattoJson(res);
		String responseMessage= js1.get("ID");
		System.out.println(responseMessage);
		
		//Retrieve the Book using the Book Name
		
		String getResponse=given().queryParam("AuthorName", "sudheer")
		.when().get("Library/GetBook.php")
		.then().assertThat().statusCode(200).extract().response().toString();
		System.out.println(getResponse);
		System.out.println("hello");
		
		//Retrieve the Book using the Book Number
	}

}
