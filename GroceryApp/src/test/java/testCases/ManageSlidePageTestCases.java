package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageSliderPage;
import utilities.ExcelRead;

public class ManageSlidePageTestCases extends BaseClass {

	LoginPage lp;

	HomePage hP;

	ManageSliderPage mSP;

	@Test
	public void verifyOnlyImageGetsDeletedFromTheTableWhenUserDeletesItThroughEditOption() throws IOException, AWTException, InterruptedException {

		lp = new LoginPage(driver);
		hP = new HomePage(driver);
		mSP = new ManageSliderPage(driver);

		lp.enterLoginCredential(ExcelRead.readStringData(0, 0), ExcelRead.readStringData(0, 1));

		lp.clickOnSignInButton();

		hP.clickOnManageSliderPage();
		
		mSP.uploadManageSliderImage();
	}
}
