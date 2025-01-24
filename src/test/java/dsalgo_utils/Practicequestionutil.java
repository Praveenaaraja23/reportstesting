
package dsalgo_utils;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import dsalgo_utils.LoggerLoad;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import dsalgo_utils.LoggerLoad;

//import driverFactory.DriverFactory;
import dsalgo_utils.DriverManager;

public class Practicequestionutil {


	String Excelpath = ConfigReader.excelpath();
	WebDriver driver= DriverManager.getdriver();
	ConfigReader configFileReader=DriverManager.configReader();
	String code;
	String result;

	public void waitForElement(WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));

	}

	public String getCodefromExcel(String Sheetname,int Rownumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testdata = reader.getData(Excelpath, Sheetname);
		code = testdata.get(Rownumber).get("PythonCode");
		result = testdata.get(Rownumber).get("Output");
		return code;
	}

	public void enterCode(String code, WebElement element) {

		new Actions(driver).sendKeys(element, code).perform();
	}

	public void enterCodePractice(String code, WebElement element) {
		new Actions(driver).moveToElement(element).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
		String[] str1 = code.split("\n");
		for (int i = 0; i < str1.length; i++) {
			if (str1[i].equalsIgnoreCase("\\b")) {
				element.sendKeys(Keys.BACK_SPACE);
			} else {
				element.sendKeys(str1[i]);
				element.sendKeys(Keys.RETURN);
			}
		}


	}

	public String getResultfromExcel(String Sheetname,int Rownumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testdata = reader.getData(Excelpath, Sheetname);
		result = testdata.get(Rownumber).get("Output");
		LoggerLoad.info("Expected result from Excel sheetname " + Sheetname + " and " + Sheetname + " : " + result);
		return result;
	}
}
