package LibaryAPI;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import InputFiles.LibaryMethods;
import InputFiles.ResuableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

//dynamic build json payload
public class LibarybookTestNg {
	@Test(dataProvider="BookData")
	public void addBook(String isbn,String aisle) {
		
		RestAssured.baseURI="http://216.10.245.166";
		// Add the book to the Libary- POST
		//Given input data
		String res= given().headers("Content-Type","application/json").body(LibaryMethods.addBook(isbn,aisle))
		//submit- WHEN
		
		.when().post("Library/Addbook.php")
		//Response- THEN
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1= ResuableMethods.rattoJson(res);
		String responseMessage= js1.get("ID");
		System.out.println(responseMessage);
	}
	@DataProvider(name="BookData")
	public Object[][] getData() {
		
		return new Object[][] {{"BookNo","1000"},{"BookNo","1001"},{"BookNo","1002"}};
	}

}
