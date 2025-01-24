package dsalgo_stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import static org.testng.Assert.assertEquals;

import dsalgo_pagefactory.Login_pf;
import dsalgo_utils.LoggerLoad;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_sd {

	Login_pf login=new  Login_pf();
	@Given("The user is on the DS Algo Home Page")
	public void the_user_is_on_the_ds_algo_home_page() {

		login.GetStarted();	
		LoggerLoad.info("User is on Home Page");   
	}

	@When("The user should click the Sign in link")
	public void the_user_should_click_the_sign_in_link() {
		login.clicksign();    
	}

	@Then("The user should be redirected to Sign in page")
	public void the_user_should_be_redirected_to_sign_in_page() {
		String username = login.validatesigninpage();
		assertEquals(username, "Username:", "Title do not match");
		LoggerLoad.info("User should be redirected ti sign in page"); 

	}	


	@Given("The user is on the DS Algo Sign in Page")
	public void the_user_is_on_the_ds_algo_sign_in_page() {

		login.GetStarted();	
		login.clicksign();   
		LoggerLoad.info("User is on Signin Page");
	}
	
	
	@When("^The user clicks login button after entering valid (.*) and (.*)$")
	public void the_user_clicks_login_button_after_entering_valid_and(String Username, String Password) throws InvalidFormatException, IOException {

		login.login2(Username , Password);	
	}

	@When("user clicks login to DsAlgo application for valid with {string} and {int}")
	public void user_clicks_login_to_ds_algo_application_for_valid_with_and(String Sheetname, Integer Rownumber) throws InvalidFormatException, IOException {

		String username =login.getusernamefromExcel(Sheetname, Rownumber);
		String password =login.getpasswordfromExcel(Sheetname, Rownumber);
		login.login(username, password);

	}
	@Then("^user should see an (.*) and (.*)$")
	public void user_should_see_an(String Sheetname, int Rownumber) throws com.fasterxml.jackson.databind.exc.InvalidFormatException, InvalidFormatException, IOException {

		String excelSuccess=login.getsuccessmsgfromExcel(Sheetname, Rownumber);
		String actualSuccess=login.printsuccessmessage();
		assertEquals(actualSuccess,excelSuccess); 
		LoggerLoad.info("Expected Message - feature exampels :  " +excelSuccess);
		LoggerLoad.info("Actual Message - Actual :  " +actualSuccess);
	}
	@And("The user should logout from Ds Algo page")
	public void the_user_should_logout_from_ds_algo_page() {
		login.Signout();	    
	}
	@Then("^user can see an (.*) and (.*)$")
	public void user_can_see_an_and_row_number(String Sheetname, Integer Rownumber) throws com.fasterxml.jackson.databind.exc.InvalidFormatException, InvalidFormatException, IOException {
		String errorMessage=login.geterrormsgfromExcel(Sheetname, Rownumber);
		String actualError=login.printErrormessage();
		assertEquals(actualError,errorMessage);
		LoggerLoad.info("Erorr Message - from excel :  " +errorMessage);
		LoggerLoad.info("Erorr Message - Actual :  " +actualError);

	}

	@Then("^user can able to see an (.*) and (.*)$")
	public void user_can_able_to_see_an(String Sheetname ,Integer Rownumber) throws com.fasterxml.jackson.databind.exc.InvalidFormatException, InvalidFormatException, IOException {
		String username =login.getusernamefromExcel(Sheetname, Rownumber);
		String password =login.getpasswordfromExcel(Sheetname, Rownumber);
		String popupmsg=login.getpopupmsgfromExcel(Sheetname, Rownumber);
		String actualpopup=login.printPopupmessage(username,password);
		assertEquals(actualpopup,popupmsg);
		LoggerLoad.info("popup message  - Actual :  " +actualpopup);
		LoggerLoad.info("popup message  - Excel :  " +popupmsg);

	}

}