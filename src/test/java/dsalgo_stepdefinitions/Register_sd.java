package dsalgo_stepdefinitions;


import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import dsalgo_utils.LoggerLoad;
import dsalgo_pagefactory.Linkedlist_pf;
import dsalgo_pagefactory.Register_pf;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Register_sd {

	Register_pf registerPage=new Register_pf();
	Linkedlist_pf linkedlist = new Linkedlist_pf();
	String expectedMessage = "";
	String actualMessage = "";
		
	
	@Given("The user navigates DSAlgo portal with url")
	public void the_user_navigates_ds_algo_portal_with_url() {
		
		
		LoggerLoad.info("User is in " +registerPage.getstartedtext()+ "page");
	    
	}
	
	@When("The user chooses to clicks on Getstarted button")
	public void the_user_chooses_to_clicks_on_getstarted_button() {
	    
		registerPage.GetStarted();
	}
	
	@Then("User should be navigated to home page")
	public void user_should_be_navigated_to_home_page() {
		
		assertEquals(registerPage.getHomeDSText(), "Data Structures-Introduction");
		LoggerLoad.info("User is navigated to Home page");
	   
	}
	
	@Given("User initiates by clicking on Register link in home page")
	public void user_initiates_by_clicking_on_register_link_in_home_page() {
	
		registerPage.GetStarted();
		registerPage.Rlink();
	}
	   
	@When("^User wants to enter data from excel sheet (.*) and (.*)$")
	public void user_wants_to_enter_data_from_excel_sheet_and(String Sheetname, Integer rowNumber)
			throws InvalidFormatException, IOException {

		registerPage.login(registerPage.getExpectedValue(rowNumber, "UserName"),
		registerPage.getExpectedValue(rowNumber, "Password"),
		registerPage.getExpectedValue(rowNumber, "Passwordconfirmation"));
		registerPage.click_login();
	}

	@Then("^User is expected to see the Message in console output from excel sheet (.*) and (.*)$")
	public void user_is_expected_to_see_the_message_in_console_output_from_excel_sheet_and(String sheetName,
			Integer rowNumber) throws InvalidFormatException, IOException {

		expectedMessage = registerPage.getExpectedMessage(rowNumber);
		actualMessage = registerPage.getActualMessage(rowNumber);
		LoggerLoad.info("Actual Message displayed:" +actualMessage);
		assertEquals(actualMessage,expectedMessage);
	}

	@Then("^User is expected to see the Error message in console output from excel sheet (.*) and (.*)$")
	public void user_is_expected_to_see_the_error_message_in_console_output_from_excel_sheet_and(String sheetName,
			Integer rowNumber) throws InvalidFormatException, IOException {

		expectedMessage = registerPage.getExpectedMessage(rowNumber);
		actualMessage = registerPage.getActualMessage();
		LoggerLoad.info("Actual Message displayed:" +actualMessage);
		assertEquals(actualMessage,expectedMessage);
	}

	@Then("User is expected to navigate to home page and Message in console output from excel sheet (.*) and (.*)$")
	public void user_is_expected_to_navigate_to_home_page_and_message_in_console_output_from_excel_sheet_and(
			String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {

		expectedMessage = registerPage.getExpectedMessage(rowNumber);
		actualMessage = registerPage.getActualMessage();
		LoggerLoad.info("Actual Message displayed:" +actualMessage);
		assertEquals(actualMessage,expectedMessage);
	}

}




