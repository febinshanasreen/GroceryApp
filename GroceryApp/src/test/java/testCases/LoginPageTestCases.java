package testCases;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class LoginPageTestCases extends BaseClass {

	LoginPage lp;

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "Nazrin", "pass123" }, { "Aby", "Aby1234" }, { "Alex", "Alex1234" },
				{ "Ani", "Ani1234" } };
	}



//Test Case 1 : Verify Sign In button text
	@Test(groups = "Medium")
	public void verifyTheTextogSignInButton() {

		lp = new LoginPage(driver);

		String actual = lp.getTextOfSignInButton();
		String expected = "Sign In";

		Assert.assertEquals(actual, expected, ":::The Login Button text is not as expected!!! :::");
	}

//Test Case 2 : Valid Login 

	@Test(groups = "High")
	public void verifyThatTheUserCanLoginWithValidUsernameAndPassword() throws IOException {

		lp = new LoginPage(driver);

		lp.enterLoginCredential(ExcelRead.readStringData(0, 0),ExcelRead.readStringData(0, 1));
		lp.clickOnSignInButton();
		String actual = lp.getProfileNameText();
		String expected = "Admin";
		Assert.assertEquals(actual, expected, Constant.errorMesageInvalidLogin);
	}
	/*
//Test Case 3: Remember me functionality

	@Test 
	public void verifyThatTheUserCanSelectRememberMeCheckBox() throws InterruptedException, IOException {

		lp = new LoginPage(driver);

		lp.enterLoginCredential(ExcelRead.readStringData(0, 0),ExcelRead.readStringData(0, 1));

		boolean actual = lp.selectCheckBox();
		boolean expected = true;
		Assert.assertEquals(actual, expected, ":::Selection is not as expected!!!");

	}

//Test Case 4: Invalid Login attempt

	@Test(enabled = false, dataProvider = "data-provider")
	public void verifyThatTheUserIsNotAbleToLoginUsingInvalidUsernameAndPassword(String uname, String paswd) {

		lp = new LoginPage(driver);
		lp.enterLoginCredential(uname, paswd);
		lp.clickOnSignInButton();
		String actual = lp.displayInvalidLoginMsg();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, Constant.errorMessageUnauthorizedAccess);
	}
*/
}
