package elementRepository;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class LoginPage {

	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	


	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement passWord;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signIn;
	
	@FindBy(xpath="//li[@class='nav-item dropdown']//child::a[1]")
	WebElement profileName;
	
	@FindBy(xpath= "//div[@class='icheck-dark']//child::label")
	WebElement rememberCheckbox;
	
	@FindBy(xpath = "//input[@id='remember']")
	WebElement checkBoxIsSelected;
	
	@FindBy (xpath=" //div[@class='alert alert-danger alert-dismissible']//child::h5")
	WebElement invalidLogin;
	
	
//	public void enterInvalidLoginCredentials(String username,String passwrd) {
//			
//		userName.sendKeys(username);
//		passWord.sendKeys(passwrd);
//		signIn.click();
//		
//	}
	
//	public void enterTheUsername(String uname) {
//		
//		userName.sendKeys(uname);
//	}
//	public void enterThePassword(String pswd) {
//		
//		passWord.sendKeys(pswd);
//	}

	public void clickOnSignInButton() {
		
		gu.clickOnElement(signIn);
		
	}
	
	public String getTextOfSignInButton() {

		return gu.getElementText(signIn);
	}
	
	public String getProfileNameText() {
		
		return gu.getElementText(profileName);
	}
	
	public boolean selectCheckBox() {
		
		rememberCheckbox.click();
		return gu.elementSelectedOrNot(checkBoxIsSelected);
		
	}
	
	public String displayInvalidLoginMsg() {
		
		return gu.getElementText(invalidLogin);
	}
	
	public void enterLoginCredential(String uname, String pswd) {

		gu.loginData(userName, uname);
		gu.loginData(passWord,pswd);

	}
}
