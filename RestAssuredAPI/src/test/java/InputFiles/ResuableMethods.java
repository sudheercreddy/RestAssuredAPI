package InputFiles;

import io.restassured.path.json.JsonPath;

public class ResuableMethods {

	public  static JsonPath rattoJson(String response) {
		JsonPath js1= new JsonPath(response);
		return js1;

	}

}
