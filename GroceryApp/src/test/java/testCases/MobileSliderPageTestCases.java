package testCases;


import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.MobileSliderPage;
import utilities.ExcelRead;


public class MobileSliderPageTestCases extends BaseClass{
	
	LoginPage lp;
	
	HomePage hP;
	
	MobileSliderPage mSP;

//Image Verification failed because xpath is not locatable
  @Test
  public void VerifyThatUserCanUploadAPicture() throws AWTException, InterruptedException, IOException  {
	  
	lp=new LoginPage(driver);
	
	lp.enterLoginCredential(ExcelRead.readStringData(0, 0),ExcelRead.readStringData(0, 1));
	lp.clickOnSignInButton();
	
	hP=new HomePage(driver);
	
	hP.clickOnMobileSliderTab();
	
	mSP=new MobileSliderPage(driver);
	
	
	mSP.clickOnNewBtn();
	
	mSP.clickOnDropDown();
	
	mSP.clickOnChooseFileBtn();
	
	hP.clickOnMobileSliderTab();
	
	boolean actual= mSP.uploadedImageDisplayVerification();
	
	boolean expected=true;
	
	Assert.assertEquals(actual, expected, Constant.errorMsgDisplayError);
	}
}
 
