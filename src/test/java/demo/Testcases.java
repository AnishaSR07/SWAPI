package demo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ExtentReportListner;
import utils2.ExcelUtility;
public class Testcases extends ExtentReportListner {
	static RequestSpecification request;
	static int status_code;
	static String id="";
	static ExtentTest logger;
	static ExtentReports extent=new ExtentReports();
	static String baseurl="https://swapi.dev";
  @Test(priority=1)

	public  void check() {
	int statuscode=0;
	try {
    	test.log(LogStatus.INFO, "My test is starting......");
		RestAssured.baseURI = "https://swapi.dev";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/api/people");
		statuscode=response.getStatusCode();
    Assert.assertEquals(statuscode, 200);
		 test.log(LogStatus.PASS,"Status code is "+statuscode);
    }catch (Exception e) {

	test.log(LogStatus.FAIL,"Status code is "+statuscode);
	}
}
  @Test(priority=2)
public static void datadriven() {
	String excelpath="C:\\Users\\anisha.s.r\\git\\REST-assured_Project\\data\\TestData.xlsx";
	String sheetname="Sheet1";
  baseURI = "https://swapi.dev/api";
	ExcelUtility excel = new ExcelUtility(excelpath, sheetname);
	JSONObject request= new JSONObject();
  request.put("name", excel.getCellData(1, 0));
	request.put("height", excel.getCellData(1, 1));
	request.put("gender", excel.getCellData(1, 2));
	Response response = given().header("Content-Type", "application/json").body(request.toJSONString()).when().post("/people").then().extract().response();

}
@Test(priority=3)
public void test_02() {
  Response response = get("https://swapi.dev/api/planets/");
	System.out.println(response.getBody().asString());
	int statusCode = response.getStatusCode();
	Assert.assertEquals(statusCode, 200);
}
  //5.5. Content-Type is present Content-Type header is application/json payload schema is valid Verify few attributes of the characters in the output (type, length , value etc)
	@Test(priority=4)
	public void test_03() {
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
