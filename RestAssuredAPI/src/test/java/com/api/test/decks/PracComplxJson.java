package com.api.test.decks;

import InputFiles.PayLoad;
import io.restassured.path.json.JsonPath;

public class PracComplxJson {

	public static void main(String[] args) {

		JsonPath js= new JsonPath(PayLoad.courses());
		int Totalcourses=js.getInt("courses.size()");
		int purOrd= js.getInt("dashboard.purchaseAmount");
		//System.out.println(Totalcourses);
		//System.out.println(purOrd);
		//System.out.println(js.get("courses[0].title"));
		String courseCopies= js.get("courses[0].title");

		for (int i = 0; i < Totalcourses; i++) {
			String CoiurseTitile= js.get("courses["+i+"].title");
			if(CoiurseTitile.equalsIgnoreCase("Appium")) {
				int coursee= js.get("courses["+i+"].price");
				//System.out.println(coursee);
				break;
			}


			//sum of all courses


			for (int ji = 0; ji < Totalcourses; ji++) {
				int courseprice = js.get("courses["+ji+"].copies");
				int prives = js.get("courses["+ji+"].price");
				System.out.println(courseprice);

				String CoiurseTitile1= js.get("courses["+i+"].title");
				if(CoiurseTitile1.equalsIgnoreCase("Appium")) {
					int element1= courseprice*prives;	
				}else if(CoiurseTitile1.equalsIgnoreCase("Selenium Python")) {
					int element2= courseprice*prives;	
				}else if (CoiurseTitile1.equalsIgnoreCase("Selenium Python")) {
					int element3= courseprice*prives;
					 {
						System.out.println("no matching");
					}
					 

				}

			}


		}

	}

}


