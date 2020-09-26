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

public class PUT_PATCH {

	@SuppressWarnings("unchecked")
	@Test(enabled=false)
	void test01_PUT() {


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
		.put("https://reqres.in/api/users/2")
		.then()
		.statusCode(200);
	}

	@SuppressWarnings("unchecked")
	@Test(enabled=true)
	void test02_PATCH() {

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
		.patch("https://reqres.in/api/users/2")
		.then()
		.statusCode(200);
	}

}
