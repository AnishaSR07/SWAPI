package demo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import utils2.ExcelUtility;
public class DataDrivenExamples {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row = null;
	static XSSFCell cell = null;
	@Test
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

}
