package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageExpensePage;
import utilities.ExcelRead;
 

public class ManageExpensePageTestCases extends BaseClass {
	
	LoginPage lp;
	HomePage hP;
	ManageExpensePage mEP;

// Test Case 1: To add an expense title 
	
  @Test //(enabled = false)
  public void verifyExpenseTitleCanBeAddedAndItIsGettingListedInTheCategoryList() throws IOException {
	  
	  lp = new LoginPage(driver);
	  hP=new HomePage(driver);
	  mEP=new ManageExpensePage(driver);
	  
	  lp.enterLoginCredential(ExcelRead.readStringData(0, 0),ExcelRead.readStringData(0, 1));
	  lp.clickOnSignInButton();
	  hP.clickOnManageExpenseTab();
	  mEP.clickOnExpenseCategory();
	  mEP.clickOnNew();
	  mEP.EnterValueOfTitle("CranBerrys");
	  mEP.clickOnSave();
	  
	  boolean actual= mEP.valueDesiredIsPresentInTheListOrNot("CranBerrys");
	  boolean expected= true;
	  Assert.assertEquals(actual, expected, ":::The Item is not added to the title");
  }
  
//Test Case 2: To get category Already exisiting while adding an item which already exists
  
  @Test (enabled = false)
  public void verifyExpenseTitleAddedAlreadyThrowsAnAlertSayingAlreadyExisting() throws IOException{
	  
	  lp = new LoginPage(driver);
	  hP=new HomePage(driver);
	  mEP=new ManageExpensePage(driver);
	  
	  lp.enterLoginCredential(ExcelRead.readStringData(0, 0),ExcelRead.readStringData(0, 1));
	  lp.clickOnSignInButton();
	  hP.clickOnManageExpenseTab();
	  mEP.clickOnExpenseCategory();
	  mEP.clickOnNew();
	  mEP.EnterValueOfTitle("Pistachios");
	  mEP.clickOnSave();
	  
	  String actual= mEP.itemAdditionFailureAlertText();
	  String expected= "Alert!" ;
	  Assert.assertEquals(actual, expected, ":::Action performed is not as expected");
  }
  
 
}
