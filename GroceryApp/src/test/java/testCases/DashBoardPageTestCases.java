package testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashBoardPage;
import elementRepository.LoginPage;
import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class DashBoardPageTestCases extends BaseClass {

	GeneralUtilities gu = new GeneralUtilities();
	LoginPage lp;
	DashBoardPage dBP;

//	Verify The Text Of Dashboard
	
	@Test
	public void verifTheTextOfDashboard() throws IOException {
		lp = new LoginPage(driver);
		dBP = new DashBoardPage(driver);

		lp.enterLoginCredential(ExcelRead.readStringData(0, 0),ExcelRead.readStringData(0, 1));
		lp.clickOnSignInButton();

		String actual = dBP.displayTabName();
		String expected = "Dashboard";

		Assert.assertEquals(actual, expected, Constant.mismatchInExpectedValue);
	}

//Verif table heading are as expected
	
	@Test
	public void verifyTableHearderFieldValidation() throws IOException {

		lp = new LoginPage(driver);
		dBP = new DashBoardPage(driver);

		lp.enterLoginCredential(ExcelRead.readStringData(0, 0),ExcelRead.readStringData(0, 1));
		lp.clickOnSignInButton();

		dBP.clickOnMoreinfoManageTab();
		boolean actual =dBP.compareTwoLists();
		boolean expected=true;
	
		Assert.assertEquals(actual, expected);
		
		
	}
}
