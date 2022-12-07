package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ManageProductPage {

	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu=new WaitUtility();

	public ManageProductPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='col-sm-12']//child::a[1]")
	WebElement newBtn;

	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFile;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtn;
	

	public void newBtnClick() {

		gu.clickOnElement(newBtn);
	}

	public void userTriesToAddAFileWithoutMandatoryFields() throws InterruptedException, AWTException {

		gu.selectValueFromScroll(0, 2000, driver);;
		gu.waitForMinimumTime();
		wu.explicitWaitUtilityForElementToBeClickable(driver, 5, chooseFile);
		gu.fileUpload(chooseFile, System.getProperty("user.dir") + "\\src\\main\\resources\\UploadFiles\\Salad.jpg",
				driver);
		gu.waitForMinimumTime();
	}

	public void saveBtnClick() throws InterruptedException   {
		
		
		gu.clickJavaScriptExecutor(saveBtn, driver);
		//gu.clickOnElement(saveBtn);

	}

	public void alertHandleAccept() throws InterruptedException {

		gu.alertSwitchingAndAccept(driver);

	}

	public String alertHandle() throws InterruptedException {

		
		return gu.alertSwitchingAndGetText(driver);

	}
}
