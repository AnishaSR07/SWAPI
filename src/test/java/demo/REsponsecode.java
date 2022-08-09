package demo;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ExtentReportListner;
//6. Verify different API response like – 200, 404, 400 etc
public class REsponsecode  extends ExtentReportListner {

	public int RESPONSE_STATUS_CODE_200 = 200;
	public int RESPONSE_STATUS_CODE_400 = 400;
	public int RESPONSE_STATUS_CODE_404 = 404;
  @BeforeClass
  
	public void GetResponse() {

		RestAssured.baseURI = "https://swapi.dev/";
		RestAssured.basePath = "api/planets/1/";
		}
 @Test(priority=1)
	 public void Response1() {
		 try {
		test.log(LogStatus.INFO, "My test is starting......");
		Response response = RestAssured.given().when().get("https://swapi.dev/");
		int statusCode = response.getStatusCode();
		 Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status code is "+statusCode);
		 test.log(LogStatus.PASS,"Status code is 200");
 }catch (Exception e) {

			// TODO: handle exception
		}
	 }
  @Test(priority=2)

	public void Response2() {
		 try {
		test.log(LogStatus.INFO, "My test is starting......");
		Response response = RestAssured.given().when().get("https://swapi.dev//");
		int statusCode = response.getStatusCode();
		 Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_400, "Status code is"+statusCode);
		 test.log(LogStatus.PASS,"Status code is "+statusCode);
		 test.log(LogStatus.INFO, "My test is starting......");
		 }catch (Exception e) {

			// TODO: handle exception
		}
	 }
	@Test(priority=3)
	public void Response3() {
    try {
		test.log(LogStatus.INFO, "My test is starting......");
		Response response = RestAssured.given().when().get("https://swapi.dev/api/");
		int statusCode = response.getStatusCode();
		 Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_404, "Status code is"+statusCode);
		 test.log(LogStatus.PASS,"Status code is "+statusCode);
		 test.log(LogStatus.INFO, "My test is starting......");
		 }catch (Exception e) {

			// TODO: handle exception
		}
	}

}
