package demo;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_01 {

	public class TC_01 {
//1.The API should be able to return a list of all the Star Wars characters.
	@Test(priority=1)
	public void test_01() {

		RestAssured.baseURI = "https://swapi.dev";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "/api/people");
		 Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status received " + response.getStatusLine());
		System.out.println("Response " + response.prettyPrint());
		//
		given().when().get("https://swapi.dev/api/people").then()
.assertThat().statusCode(200).log().all();

	}

	//2.	The API should be able to return the details of a specified Star Wars Character Users should be able to search for the details of a character or planet Task
	@Test(priority=2)
	public void test_02() {
		Response response = get("https://swapi.dev/api/planets/");
		System.out.println(response.getBody().asString());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	//5.5. Content-Type is present Content-Type header is application/json payload schema is valid Verify few attributes of the characters in the output (type, length , value etc)
	@Test(priority=3)
	public void test_post() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		jsonMap.put("length", "120000");
		jsonMap.put("name", "Death Star");

		JSONObject request = new JSONObject(jsonMap);
		System.out.println("JSON request is : "+request);

		request.put("length", "120000");
		request.put("name", "Death Star");

		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		header("Content-Type","application/json").
		body(request.toJSONString()).

		when().
		get("https://swapi.dev/api/starships/9/").
		then().
		statusCode(200);

	}





}
