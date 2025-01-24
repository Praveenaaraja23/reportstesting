package dsalgo_pagefactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import dsalgo_utils.ConfigReader;
import dsalgo_utils.DriverManager;
import dsalgo_utils.ExcelReader;
import dsalgo_utils.LoggerLoad;

public class Login_pf {

	WebDriver driver= DriverManager.getdriver();
	ConfigReader configFileReader=DriverManager.configReader();

	@FindBy(xpath = "//button[@class='btn']")
	WebElement getstarted;
	@FindBy(xpath="//a[@href='/login']")
	WebElement Signin;
	@FindBy(id = "id_username")
	WebElement username1;
	@FindBy(id = "id_password")
	WebElement password1;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement Login;
	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement successmsg;
	@FindBy(xpath="//a[text()='Sign out']")
	WebElement signout;
	@FindBy(xpath ="//div[@role='alert']")
	WebElement errormessage;
	@FindBy(xpath="//label[@for='id_username']")
	WebElement usernamefield;
	@FindBy(xpath="//label[@for='id_password']")
	WebElement passwordfield;
	@FindBy(xpath="//a[text()=' Vidya ']")
	ExcelReader reader = new ExcelReader();
	String Excelpath = ConfigReader.excelpath();

	public Login_pf() {
		PageFactory.initElements(driver , this);

	}

	public void GetStarted() {
		getstarted.click();
	}

	public void clicksign() {

		Signin.click();
	}
	public void  login(String Username, String Password ) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException{
		username1.clear();
		username1.sendKeys(Username);
		password1.clear();
		password1.sendKeys(Password);
		Login.click();	
	}
	public void  login2(String Username, String Password ) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException{
	List<Map<String,String>> testData = 
			reader.getData(Excelpath, "Login");
	Username = testData.get(0).get("Username");
	Password = testData.get(0).get("Password");
	username1.clear();
	username1.sendKeys(Username);
	password1.clear();
	password1.sendKeys(Password);
	Login.click();	
	}
	public String printsuccessmessage() {
		String succesmsg=successmsg.getText();
		return succesmsg;

	}

	public  void Signout() {		
		signout.click();
	}	

	public String printErrormessage() {
		String errormsg;
		errormsg=errormessage.getText();
		return errormsg;
	}
	public String printPopupmessage(String Username, String Password) {
		String popupmessage="";
		if(Username.isEmpty() || (Username.isEmpty() && Password.isEmpty()))
		{
			popupmessage = username1.getAttribute("validationMessage");
		}
		else if (Password.isEmpty())
		{
			popupmessage = password1.getAttribute("validationMessage");
		}
		return popupmessage;	
	}

	public String validatesigninpage() {
		String username=usernamefield.getText();
		return username;

	}

	public String getsuccessmsgfromExcel(String Sheetname, int Rownumber)  throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException  {	
		List<Map<String,String>> testData = reader.getData(Excelpath, Sheetname);
		LoggerLoad.info("To read the Data from Excelsheet");
		String SuccessMessage = testData.get(Rownumber).get("SuccessMessage");
		return SuccessMessage;

	}
	public String getusernamefromExcel(String Sheetname, int Rownumber)  throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException  {	

		List<Map<String,String>> testData = 
				reader.getData(Excelpath, Sheetname);

		String Username  = testData.get(Rownumber).get("Username");
		return Username;
	}

	public String getpasswordfromExcel(String Sheetname, int Rownumber)  throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException  {	

		List<Map<String,String>> testData = 
				reader.getData(Excelpath, Sheetname);

		String password  = testData.get(Rownumber).get("Password");
		return password;
	}

	public String geterrormsgfromExcel(String Sheetname, int Rownumber)  throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException  {	
		List<Map<String,String>> testData = 
				reader.getData(Excelpath, Sheetname);

		String ErrorMessage = testData.get(Rownumber).get("ErrorMessage");
		return ErrorMessage;

	}
	public String getpopupmsgfromExcel(String Sheetname, int Rownumber)  throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException  {	
		List<Map<String,String>> testData = 
				reader.getData(Excelpath, Sheetname);

		String popupmsg = testData.get(Rownumber).get("ErrorMessage");
		return popupmsg;


	}
}