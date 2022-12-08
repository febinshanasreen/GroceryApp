package testCases;

import java.io.IOException;
import java.util.List;

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

	@Test (enabled= false)
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
	
	@Test  //(enabled=false)
	public void VerifyThatTheClickOnLockTurnsInToRedOROrange() throws IOException, InterruptedException {
		
		
		lp = new LoginPage(driver);
		hP = new HomePage(driver);
		mUP = new ManageUsersPage(driver);

		lp.enterLoginCredential(ExcelRead.readStringData(0, 0), ExcelRead.readStringData(0, 1));
		lp.clickOnSignInButton();
		hP.clickOnManageUsersPage();
		mUP.clickOnLock();
	
		String actual= mUP.bgColorOFLock();
		String expected= gu.checkForequalance(actual, " rgba(40, 167, 69, 1)", "rgba(255, 193, 7, 1)");
		Assert.assertEquals(actual, expected, Constant.errorMsgBGColorMismatch);
	
	}
	
}
