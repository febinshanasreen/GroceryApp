package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageUsersPage;
import utilities.ExcelRead;
import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ManageUsersPageTestCases extends BaseClass {

	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();
	LoginPage lp;
	HomePage hP;
	ManageUsersPage mUP;

	@Test
	public void verifyPasswordOfAUserIsVisibleWhenClicked() throws InterruptedException, IOException {

		lp = new LoginPage(driver);
		hP = new HomePage(driver);
		mUP = new ManageUsersPage(driver);

		lp.enterLoginCredential(ExcelRead.readStringData(0, 0), ExcelRead.readStringData(0, 1));
		lp.clickOnSignInButton();
		hP.clickOnManageUsersPage();
		boolean actual=mUP.clickOnShowPasswordSymbol();
		
		Assert.assertTrue(actual, Constant.mismatchInExpectedValue);
	
	}
	
	@Test  (enabled=false)
	public void verifyNoPaswordIsRepeated() throws IOException {
		
		
		lp = new LoginPage(driver);
		hP = new HomePage(driver);
		mUP = new ManageUsersPage(driver);

		lp.enterLoginCredential(ExcelRead.readStringData(0, 0), ExcelRead.readStringData(0, 1));
		lp.clickOnSignInButton();
		hP.clickOnManageUsersPage();
		mUP.checkForRepetivePasswords();
	}
	
}
