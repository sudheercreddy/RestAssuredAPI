package com.api.test.decks;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import InputFiles.PayLoad;
public class getResponse
{

	public static void main (String args[]) {

		//given-- all inputs
		//when-- resource ,sumit the API
		//then--- validate response

		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		//Add the address- POST
		// input text
		//PayLoad.addPlace()-- payload request
		String response=given().log().all().queryParam("key", "qaclick123")
				.headers("content-type","application/json")
				.body(PayLoad.addPlace())
				.when().post("maps/api/place/add/json")// resource
				.then().assertThat().statusCode(200)// response
				.body("scope", equalTo("APP"))
				.header("Server", "Apache/2.4.18 (Ubuntu)").extract().asString();
		System.out.println("*********");
		System.out.println(response);

		//used to capture the value of Json response 
		JsonPath js= new JsonPath(response);
		String Place_ID=js.get("place_id");
		System.out.println(Place_ID);
	
		String UpdateAddress= "11568 floyd drive overland park";
		
		//update the Google Place- PUT
		given().log().all().queryParam("key", "qaclick123").headers("content-type","application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+Place_ID+"\",\r\n" + 
				"\"address\":\""+UpdateAddress+"\",\r\n" + 
				//	"\"address\":\"444 northern run, USA\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}")
		.when().put("maps/api/place/update/json")
		.then().assertThat().log().all()
		.statusCode(200)
		.body("msg",equalTo("Address successfully updated"));

		// Get Status of Place ID.- GET

		String resp3=given().log().all().queryParam("key", "qaclick123").queryParam("place_id", Place_ID)
				.when().get("maps/api/place/get/json")
				.then().statusCode(200).extract().response().asString();


		JsonPath JS2= new JsonPath(resp3);
		String actualAdress= JS2.get("address");

		System.out.println(actualAdress);
		
		//delete the Adress.Place_ID
		
		given().log().all().queryParam("key", "qaclick123").header("place_id",Place_ID )
		.when().delete("maps/api/place/delete/json");





	}
}