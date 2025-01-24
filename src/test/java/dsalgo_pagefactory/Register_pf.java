package dsalgo_pagefactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import dsalgo_utils.ConfigReader;
import dsalgo_utils.DriverManager;
import dsalgo_utils.ExcelReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Register_pf {

	String Excelpath = ConfigReader.excelpath();
	WebDriver driver = DriverManager.getdriver();
	ConfigReader configFileReader = DriverManager.configReader();
	List<Map<String, String>> listScenarios = null;

	@FindBy(xpath = "//button[text()='Get Started']")
	WebElement Getstartedbtn;
	@FindBy(xpath = "//a[text()='NumpyNinja']")
	WebElement hometext;
	@FindBy(xpath = "//h5[@class='card-title']")
	WebElement HomeDStext;
	@FindBy(xpath = "//a[text()=' Register ']")
	WebElement Registerlink;
	@FindBy(name = "username")
	WebElement UName;
	@FindBy(name = "password1")
	WebElement Pwd;
	@FindBy(name = "password2")
	WebElement confirmpwd;
	@FindBy(xpath = "//input[@value='Register']")
	WebElement Registerbtn;
	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement actualMessage;

	public Register_pf() {
		PageFactory.initElements(driver, this);
	}

	public void GetStarted() {
		Getstartedbtn.click();
		try {
			readExcel();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getstartedtext() {
		String getstext = Getstartedbtn.getText();
		return getstext;
	}

	public String getTitile() {
		String title = driver.getTitle();
		return title;
	}

	public String getHomePageText() {
		String hometitle = hometext.getText();
		return hometitle;

	}

	public String getHomeDSText() {

		String getHomeDS = HomeDStext.getText();
		return getHomeDS;
	}

	public void Rlink() {

		Registerlink.click();
	}

	public String printPopupmessage(String Username, String Password, String confirmpassword) {
		String popupmessage = "";
		if (Username.isEmpty()) {
			popupmessage = UName.getAttribute("validationMessage");
		} else if (Password.isEmpty()) {
			popupmessage = Pwd.getAttribute("validationMessage");
		} else if (confirmpassword.isEmpty()) {
			popupmessage = confirmpwd.getAttribute("validationMessage");
		}
		return popupmessage;
	}

	public String getExpectedValue(int rowNumber, String columnName) {
		return listScenarios.get(rowNumber).get(columnName);
	}

	// Expected message from Excel
	public String getExpectedMessage(int rowNumber) {

		return getExpectedValue(rowNumber, ("Message")); 
	}

	// Actual message from Register Page
	public String getActualMessage(int rowNumber) {

		return printPopupmessage(listScenarios.get(rowNumber).get("UserName"),
				listScenarios.get(rowNumber).get("Password"), listScenarios.get(rowNumber).get("Passwordconfirmation"));
	}


	public void login(String username, String password, String Passwordconfirmation) {

		UName.clear();
		UName.sendKeys(username);
		Pwd.clear();
		Pwd.sendKeys(password);
		confirmpwd.clear();
		confirmpwd.sendKeys(Passwordconfirmation);
		// Registerbtn.click();
	}

	public void click_login() {
		Registerbtn.click();

	}

	public void closebrowser() {
		driver.quit();
	}

	
	public String getActualMessage() {
		return actualMessage.getText();
	}

	private void readExcel()
			throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		ExcelReader excelReader = new ExcelReader();
		listScenarios = excelReader.getData(Excelpath, "Register");
	}

}
