package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageProductPage;
import utilities.ExcelRead;
import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ManageProductPageTestCases extends BaseClass {

	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();
	LoginPage lp;
	HomePage hP;
	ManageProductPage mPP;

	@Test
	public void verifyNonFilledManadatoryFieldThrowsAnAlert() throws InterruptedException, AWTException, IOException {

		lp = new LoginPage(driver);

		lp.enterLoginCredential(ExcelRead.readStringData(0, 0),ExcelRead.readStringData(0, 1));
		lp.clickOnSignInButton();

		hP = new HomePage(driver);
		hP.clickOnManageProductPage();
		mPP= new ManageProductPage(driver);
		mPP.newBtnClick();
		mPP.userTriesToAddAFileWithoutMandatoryFields();
		mPP.saveBtnClick();
		String actual=mPP.alertHandle();
		System.out.println(actual);
		mPP.alertHandleAccept();
		String expected="Please enter weight price";
		Assert.assertEquals(actual, expected, Constant.mismatchInExpectedValue);
	}
	
	
	
}
