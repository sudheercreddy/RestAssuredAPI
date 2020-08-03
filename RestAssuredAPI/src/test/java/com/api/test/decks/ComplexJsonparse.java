package com.api.test.decks;

import InputFiles.PayLoad;
import io.restassured.path.json.JsonPath;

public class ComplexJsonparse {
	public static void main(String[] args) {
		JsonPath js= new JsonPath(PayLoad.courses());

		int purAmount= js.getInt("dashboard.purchaseAmount");
		System.out.println(purAmount);
		int coursesTol= js.getInt("courses.size()");
		System.out.println("All course titles----" + coursesTol);
		//array element courses
		String firstCourse= js.get("courses[0].title");
		System.out.println(firstCourse);

		String secondCourse= js.get("courses[1].title");
		System.out.println(secondCourse);

		String thirdCourse= js.get("courses[2].title");
		System.out.println(thirdCourse);


		for (int i = 0; i < coursesTol; i++) {  
			System.out.println("Priting the data of elements");
			System.out.println("Course is "+ js.get("courses["+i+"].title"));
			System.out.println("price is "+ js.get("courses["+i+"].price"));
			System.out.println("copies is "+ js.get("courses["+i+"].copies"));
			System.out.println("*******");
}

		}
	}


