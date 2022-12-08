package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageSliderPage;

public class ManageSliderPageTestCases extends BaseClass {
	
	LoginPage lp;
	
	HomePage hP;
	
	ManageSliderPage mSP;
	
  @Test
  public void verifyImageUploadedGettingDisplayed() throws AWTException, InterruptedException {
	  
	  lp=new LoginPage(driver);
	  hP=new HomePage(driver);
	  mSP=new ManageSliderPage(driver);
	  
	  lp.enterLoginCredential(null, null);
	  lp.clickOnSignInButton();
	  hP.clickOnManageSliderPage();
	  boolean actual= mSP.uploadManageSliderImage();
	  Assert.assertTrue(actual, Constant.errorMsgDisplayError);
	  
  }
}
