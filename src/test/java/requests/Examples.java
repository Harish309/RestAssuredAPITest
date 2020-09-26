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

public class Examples {

	@Test(enabled=false)
	public void test_GET() {

		baseURI = "http://localhost:3000/";
		given().param("name", "Automation")
		.get("/subjects").then().statusCode(200).log().all();

	}

	@SuppressWarnings("unchecked")
	@Test(enabled=false)
	public void test_POST() {

		baseURI = "http://localhost:3000/";
		JSONObject request = new JSONObject();
		request.put("firstName", "Tom");
		request.put("lastName", "Cooper");
		request.put("subjectId", "3");

		given().contentType(ContentType.JSON).accept(ContentType.JSON).header("ContentType","application/json").
		body(request.toJSONString())
		.when()
		.post("/users")
		.then().statusCode(201).log().all();
	}

	@SuppressWarnings("unchecked")
	@Test(enabled=false)
	public void test_PATCH() {

		baseURI = "http://localhost:3000/";
		JSONObject request = new JSONObject();
		request.put("lastName", "Shepherd");

		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		header("ContentType","application/json").
		body(request.toJSONString())
		.when()
		.patch("/users/3")
		.then().statusCode(200).log().all();
	}

	@SuppressWarnings("unchecked")
	@Test(enabled=false)
	public void test_PUT() {

		baseURI = "http://localhost:3000/";
		JSONObject request = new JSONObject();
		request.put("firstName", "Mary");
		request.put("lastName", "Jane");
		request.put("subjectId", "3");

		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		header("ContentType","application/json").
		body(request.toJSONString()).
		when().
		patch("/users/3").
		then().statusCode(200).log().all();
	}

	@Test(enabled=true)
	public void test_DELETE() {

		baseURI = "http://localhost:3000/";

		when().delete("/users/3").
		then().
		statusCode(200).log().all();
	}


}
