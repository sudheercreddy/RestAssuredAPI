package com.api.test.decks;

import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * This class is specifically designed to automate our REST APIs
 *
 * @author Sudheerqa.selenium
 * @version 1.0
 */

public class DeckOfCardsAutmoationAPITests {

	int statusCode;

	@SuppressWarnings("unchecked")
	@Test
	void shuffleCards() {
		RestAssured.baseURI = "https://deckofcardsapi.com/api/deck/new/shuffle/";

		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("deck_count", 1);

		httpRequest.header("Content-Type", "application/json");

		httpRequest.body(requestParams.toJSONString());

		Response response = httpRequest.request(Method.POST);

		statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);

		JsonPath newData = response.jsonPath();
		String result = newData.get("success");
		String deckId = newData.get("deck_id");
		String shuffled = newData.get("shuffled");
		String remaining = newData.get("remaining");

		Assert.assertEquals(result, "true");
		assertNotNull(deckId);
		Assert.assertEquals(shuffled, "true");
		Assert.assertEquals(remaining, 52);

	}

	@SuppressWarnings("rawtypes")
	@Test
	void drawCardFromDeck() {
		RestAssured.baseURI = "https://deckofcardsapi.com/api/deck/3p40paa87x90/draw/?count=2";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "2");

		statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		JsonPath newData = response.jsonPath();
		List result = newData.get("cards");
		String deckId = newData.get("deck_id");
		String success = newData.get("success");
		String remaining = newData.get("remaining");

		Assert.assertEquals(result, "true");
		assertNotNull(deckId);
		Assert.assertEquals(success, "true");
		Assert.assertEquals(remaining, 50);

	}

	@Test
	void reshuffleCards() {
		RestAssured.baseURI = "https://deckofcardsapi.com/api/deck/3p40paa87x90/shuffle/";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "2");

		statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		JsonPath newData = response.jsonPath();

		String success = newData.get("success");
		String deckId = newData.get("deck_id");
		String shuffled = newData.get("shuffled");
		String remaining = newData.get("remaining");

		Assert.assertEquals(success, "true");
		assertNotNull(deckId);
		Assert.assertEquals(shuffled, "true");
		Assert.assertEquals(remaining, 52);

	}

	@SuppressWarnings("unchecked")
	@Test
	void createNewDeck() {
		RestAssured.baseURI = "https://deckofcardsapi.com/api/deck/new/";

		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("jokers_enabled", "true");

		httpRequest.header("Content-Type", "application/json");

		httpRequest.body(requestParams.toJSONString());

		Response response = httpRequest.request(Method.POST);

		statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);

		JsonPath newData = response.jsonPath();
		String result = newData.get("success");
		String deckId = newData.get("deck_id");
		String shuffled = newData.get("shuffled");
		String remaining = newData.get("remaining");

		Assert.assertEquals(result, "true");
		assertNotNull(deckId);
		Assert.assertEquals(shuffled, "false");
		Assert.assertEquals(remaining, 52);

	}

	@Test
	void getDeck() {
		RestAssured.baseURI = "https://deckofcardsapi.com/api/deck/new/shuffle/?cards=AS,2S,KS,AD,2D,KD,AC,2C,KC,AH,2H,KH";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "2");

		statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		JsonPath newData = response.jsonPath();

		String success = newData.get("success");
		String deckId = newData.get("deck_id");
		String shuffled = newData.get("shuffled");
		String remaining = newData.get("remaining");

		Assert.assertEquals(success, "true");
		assertNotNull(deckId);
		Assert.assertEquals(shuffled, "true");
		Assert.assertEquals(remaining, 12);

	}

	@SuppressWarnings("rawtypes")
	@Test
	void addToPile() {
		RestAssured.baseURI = "https://deckofcardsapi.com/api/deck/3p40paa87x90/pile/testpile/add/?cards=AS,2S";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "2");

		statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		JsonPath newData = response.jsonPath();

		String success = newData.get("success");
		String deckId = newData.get("deck_id");
		String remaining = newData.get("remaining");
		List piles = newData.get("piles");

		Assert.assertEquals(success, "true");
		assertNotNull(deckId);
		Assert.assertEquals(remaining, 12);
		assertNotNull(piles);

	}

	@SuppressWarnings("rawtypes")
	@Test
	void shufflePiles() {
		RestAssured.baseURI = "https://deckofcardsapi.com/api/deck/3p40paa87x90/pile/testpile/shuffle/";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "2");

		statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		JsonPath newData = response.jsonPath();

		String success = newData.get("success");
		String deckId = newData.get("deck_id");
		String remaining = newData.get("remaining");
		List piles = newData.get("piles");

		Assert.assertEquals(success, "true");
		assertNotNull(deckId);
		Assert.assertEquals(remaining, 12);
		assertNotNull(piles);

	}

	@SuppressWarnings("rawtypes")
	@Test
	void listCardsByPile() {
		RestAssured.baseURI = "https://deckofcardsapi.com/api/deck/3p40paa87x90/pile/testpile/list/";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "2");

		statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		JsonPath newData = response.jsonPath();

		String success = newData.get("success");
		String deckId = newData.get("deck_id");
		String remaining = newData.get("remaining");
		List piles = newData.get("piles");

		Assert.assertEquals(success, "true");
		assertNotNull(deckId);
		Assert.assertEquals(remaining, 42);
		assertNotNull(piles);

	}

	@SuppressWarnings("rawtypes")
	@Test
	void DrwaFromPile() {
		RestAssured.baseURI = "https://deckofcardsapi.com/api/deck/3p40paa87x90/pile/testpile/draw/?cards=AS";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "2");

		statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		JsonPath newData = response.jsonPath();

		String success = newData.get("success");
		String deckId = newData.get("deck_id");
		String remaining = newData.get("remaining");
		List piles = newData.get("piles");
		List cards = newData.get("cards");

		Assert.assertEquals(success, "true");
		assertNotNull(deckId);
		Assert.assertEquals(remaining, 12);
		assertNotNull(piles);
		assertNotNull(cards);
	}
}
