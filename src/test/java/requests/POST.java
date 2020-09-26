package requests;

import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class POST {

	@SuppressWarnings("unchecked")
	@Test(enabled=true)
	void test01() {

/*		Map<String,Object> map = new HashMap<String, Object>(); 
		
		map.put("name", "Harry");
		map.put("Job", "Student");*/
		
		JSONObject request = new JSONObject();
		request.put("name", "Harry");
		request.put("Job", "Student");
		
		System.out.println(request.toJSONString());
		
		given()
		.header("content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201);
	}

}
