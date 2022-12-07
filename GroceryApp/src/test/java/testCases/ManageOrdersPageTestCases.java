package testCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageOrdersPage;
import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class ManageOrdersPageTestCases extends BaseClass {

	LoginPage lp;

	ManageOrdersPage mOP;

	HomePage hP;
	
	GeneralUtilities gu=new GeneralUtilities();

//Test 1 - To Select COD for Peyments dropdown menu	
	@Test(enabled = false)
	public void selectCODPaymentModeInManageOrdersTab() throws IOException {
		
		lp = new LoginPage(driver);

		lp.enterLoginCredential(ExcelRead.readStringData(0, 0),ExcelRead.readStringData(0, 1));

		lp.clickOnSignInButton();

		hP = new HomePage(driver);

		hP.clickOnManageOrdersTab();

		mOP = new ManageOrdersPage(driver);

		mOP.clickOnSerachInMAnageOrderTab();
		String actual = mOP.selectAValueFromDropDownBtnOnManageOrdersPage();
		String expected = "COD";
		Assert.assertEquals(actual, expected, ":::The Expected dropdown Text is as not expected!!! :::");

		/*
		 * Login click on mo clcik on search clcik on the payment option choose COD
		 */
	}

	
	@Test  (enabled = false)
	public void verifyThatTheUSerGetAnAlertMsgWhenDeletingAnItem() throws InterruptedException, IOException {

		lp = new LoginPage(driver);
		hP = new HomePage(driver);
		mOP = new ManageOrdersPage(driver);

		lp.enterLoginCredential(ExcelRead.readStringData(0, 0),ExcelRead.readStringData(0, 1));

		lp.clickOnSignInButton();

		hP.clickOnManageOrdersTab();

		mOP.deleteAnOrderFromTheTable1();

		String actual = mOP.switchDriverToAlertAndGetText();
		System.out.println(actual);
		gu.alertSwitchingAndDismiss(driver);
		String expected = "Do you want to delete this Order?";
		Assert.assertEquals(actual, expected, ":::The alert is not working as expected!!! :::");
	}

	@Test(enabled = false)
	public void verifyManageOrdersTabIsHighlightedAfterSelection() throws IOException {

		lp = new LoginPage(driver);
		hP = new HomePage(driver);
		mOP = new ManageOrdersPage(driver);

		lp.enterLoginCredential(ExcelRead.readStringData(0, 0),ExcelRead.readStringData(0, 1));

		hP.clickOnManageOrdersTab();

		String actual = mOP.hightLightedWorkersTab();
		String expected = "active nav-link";
		Assert.assertEquals(actual, expected, ":::The manage orders tab is not highlighted when clicked!!! :::");
	}

		
//Verifying filteration is done as per the payment mode choose: Checking atleast first 5 data filtered is matching with "Bank"
		
	@Test (enabled = false)
	public void verifyTheResultsAreFilteredRespectiveOfThePaymentModeDone() throws IOException {

		lp = new LoginPage(driver);
		hP = new HomePage(driver);
		mOP = new ManageOrdersPage(driver);
		lp.enterLoginCredential(ExcelRead.readStringData(0, 0),ExcelRead.readStringData(0, 1));
		lp.clickOnSignInButton();
		hP.clickOnManageOrdersTab();

		boolean actual=
		mOP.checkThePayementModeInTheFilteredTable();
		boolean expected= true;
		
		Assert.assertEquals(actual, expected, Constant.mismatchInExpectedValue);
	}
	
	//------------------------
	
	/*
	 * DO CHECK WITH THE TRAINER
	 * Here the value of i is not recogonized even if \ is provided before and after i+1,
	 * The desired dynamic xpath is given in the utilities by parametering its
	 * attribute, attribute value, and the desired cell/column.
	 */
	
	@Test //(enabled = false)
	public void deleteAnOrderFromTheTable() throws InterruptedException, IOException {

		lp = new LoginPage(driver);
		hP = new HomePage(driver);
		mOP = new ManageOrdersPage(driver);

		lp.enterLoginCredential(ExcelRead.readStringData(0, 0),ExcelRead.readStringData(0, 1));
		lp.clickOnSignInButton();

		hP.clickOnManageOrdersTab();

		mOP.deleteAnOrderFromTheTable();
		
		gu.alertSwitchingAndAccept(driver);

		boolean actual = mOP.deletedElementDoesnotExist();
		
		System.out.println(actual);
		
		boolean expected = true;
		Assert.assertEquals(actual, expected, "::: not working as expected!!! :::");
	
	}


}
