package requests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GET {

	@Test(enabled=false)
	void test01() {

		Response response = get("https://reqres.in/api/users?page=2");


		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());

		int statusCode = response.statusCode();

		AssertJUnit.assertEquals(statusCode, 200);
	}

	@Test(enabled=true)
	void test02() {

		given().
		get("https://reqres.in/api/users?page=2").then().statusCode(200)
		.body("data.id[0]", equalTo(7))
		.body("data.first_name", hasItems("Michael","Lindsay"));
	}

}
