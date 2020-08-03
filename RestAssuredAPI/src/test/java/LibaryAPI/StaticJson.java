package LibaryAPI;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import InputFiles.LibaryMethods;
import InputFiles.ResuableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class StaticJson {
	@Test
	public void addBook() throws IOException {
		
		RestAssured.baseURI="http://216.10.245.166";
		// Add the book to the Libary- POST
		//Given input data
		String res= given().headers("Content-Type","application/json").body(GenerateStringFroResource("C:\\Users\\abc\\Desktop\\API\\addBook.json"))
		//submit- WHEN
		
		.when().post("Library/Addbook.php")
		//Response- THEN
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1= ResuableMethods.rattoJson(res);
		String responseMessage= js1.get("ID");
		System.out.println(responseMessage);
	}
	public static String GenerateStringFroResource (String path) throws IOException
	{
		return new String (Files.readAllBytes(Paths.get(path)));
		
		
	}
}
