package dsalgo_pagefactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import dsalgo_utils.ConfigReader;
import dsalgo_utils.DriverManager;
import dsalgo_utils.ExcelReader;
import dsalgo_utils.LoggerLoad;

public class Linkedlist_pf {
	

	WebDriver driver= DriverManager.getdriver();
	ConfigReader configFileReader=DriverManager.configReader();
	String Excelpath = ConfigReader.excelpath();
	List<Map<String, String>> testdata=null;
	
   
	String Pythoncode1;
	String result;
	String pythoncode;
	
	   @FindBy (xpath = "//a[@href='linked-list']") WebElement getstartedlinkedlist;
	   @FindBy (xpath="//a[@href='introduction']")WebElement introductionLink;  
		@FindBy (xpath="//a[@href='/linked-list/creating-linked-list/']")WebElement creatinglinkedlistLink; 
		@FindBy (xpath="//a[@href='/linked-list/types-of-linked-list/']")WebElement typesOfLinkedlistLink;  
		@FindBy (xpath="//a[@href='/linked-list/implement-linked-list-in-python/']")WebElement implementLinkedlistInPythonLink; 
		@FindBy (xpath="//a[@href='/linked-list/traversal/']")WebElement traversalLink; 
		@FindBy (xpath="//a[@href='/linked-list/insertion-in-linked-list/']")WebElement insertionLink; 
		@FindBy (xpath="//a[@href='/linked-list/deletion-in-linked-list/']")WebElement deletionLink; 
		@FindBy (xpath="//a[@href='/linked-list/practice']")WebElement practicequestionLink; 
		@FindBy(xpath = "//a[@href='/tryEditor']")WebElement tryHerebtn;
		@FindBy(xpath = "//textarea[@tabindex='0']")WebElement entertryeditor; 
		@FindBy(xpath = "//button[@type='button']")WebElement runButton;
		@FindBy(id = "output")WebElement output;
		@FindBy(xpath= "//h4[text()='Linked List']") WebElement linkedlisthometext;
		@FindBy(xpath= "//div[@class='col-sm']/strong/p[@class='bg-secondary text-white']") WebElement allliststext;
		
		 public Linkedlist_pf() {
		    	
				PageFactory.initElements(driver,this);
		}
		 
		 public void clickLLgetstarted() {
			 getstartedlinkedlist.click();
			 
			 try {
					readExcel();
				} catch (InvalidFormatException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
			
					e.printStackTrace();
				}
			}
		 
		public void clickIntroductionLink() {
			
			introductionLink.click();
		}

		public void clickCreatingLinkedlistLink() {
		
			creatinglinkedlistLink.click();
		}

	
	    public String getallpagestext() {
	    	String pages =allliststext.getText();
	    	return pages;
	    	
	    }
	    public String linkedlistpagetext() {
	    	String linkedtitle=linkedlisthometext.getText();
	    	return linkedtitle;
	    	
	    }
	  
	    
public void clicktypesOfLinkedlistLink() {
		
	 typesOfLinkedlistLink.click();
			
		}
public void clickimplementLinkedlistInPythonLink() {
		
	 implementLinkedlistInPythonLink.click();
	}
public void clicktraversalLink() {
		
	 traversalLink.click();	
		}
public void clickinsertion() {

	insertionLink.click();
}


public void clickdeletionLink() {
		
	 deletionLink.click();
	}

public void clicpracticequestionLinkk() {
	 
	 practicequestionLink.click(); 	
		
	}

public void clickTryhere() {
	tryHerebtn.click();
	 
}

public String EnterTryeditor(String pythoncode)  {

	
	 entertryeditor.sendKeys(pythoncode);
	return pythoncode;


}
public void clickrunbtn() {
	
	runButton.click();	  
}

public String gettextrun() {
String rbtn=runButton.getText();
return rbtn;
	
}


public String alertmsg() {
    try {
        Alert alert = driver.switchTo().alert();
        String getalertmsg = alert.getText();
        alert.accept();
        return getalertmsg;
    } catch (Exception e) {
    	
        return "No alert found.";
    }
}
 
 public String CodefromExcel(String sheetname, int RowNumber) throws InvalidFormatException, IOException {
		Pythoncode1= testdata.get(RowNumber).get("pythoncode");
		result = testdata.get(RowNumber).get("ExpectedOutput");
		return Pythoncode1;

	}
 
 
 
 public String ResultfromExcel(String sheetname, int RowNumber) throws InvalidFormatException, IOException {
	 	result = testdata.get(RowNumber).get("ExpectedOutput");
		LoggerLoad.info("Expected result from Excel sheetname " + sheetname + " and " + RowNumber + " : " + result);
		return result;
	}
 private void readExcel()
			throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		ExcelReader excelReader = new ExcelReader();
		testdata = excelReader.getData(Excelpath, "phythoncode");
	}
 
 public String getActualResult() {
		return output.getText();
	}
 
 
 public void clickpracticeQuestion() {
	 practicequestionLink.click();
	
 }
 
 public String getScriptOutput() {
		return output.getText();
	}

}
