package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageLocationPage;
import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class ManageLocationTestCases extends BaseClass {

	LoginPage lp;

	HomePage hP;

	ManageLocationPage mLP;

	GeneralUtilities gu = new GeneralUtilities();

	@Test //(enabled= false,priority = 0)
	public void verifyAClcikOnActiveStatusWillGetTurnIntoOrangeColor() throws InterruptedException, IOException {

		lp = new LoginPage(driver);
		hP = new HomePage(driver);
		mLP = new ManageLocationPage(driver);

		lp.enterLoginCredential(ExcelRead.readStringData(0, 0), ExcelRead.readStringData(0, 1));

		lp.clickOnSignInButton();

		hP.clickOnManageLocationPage();
		
		mLP.clickOnStatus();
		
		String actual=mLP.getElementBgColor();
		
		String expected = "rgba(255, 193, 7, 1)";
		
		Assert.assertEquals(actual, expected, Constant.errorMsgBGColorMismatch);

	}
	
	@Test// (enabled=false)
	public void verifyAClcikOnStatusWillChangeToActiveOrInactive() throws IOException, InterruptedException {
		
		lp = new LoginPage(driver);
		hP = new HomePage(driver);
		mLP = new ManageLocationPage(driver);

		lp.enterLoginCredential(ExcelRead.readStringData(0, 0), ExcelRead.readStringData(0, 1));

		lp.clickOnSignInButton();

		hP.clickOnManageLocationPage();

		
		String actual=mLP.getElementText();
		String expected="Inactive";
		Assert.assertEquals(actual, expected, Constant.mismatchInExpectedValue);
	}
}
