package com.api.test.decks;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import InputFiles.PayLoad;
import io.restassured.path.json.JsonPath;

public class testng_Json {
	
	@Test
	public void test1() {
		JsonPath js= new JsonPath(PayLoad.courses());
		String coursetitile= js.get("courses[0].title");
		String text="Selenium Python";
		System.out.println(coursetitile);
		
	}

}
