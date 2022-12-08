package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageSliderPage {
	
	WebDriver driver;
	
	GeneralUtilities gu=new GeneralUtilities();
	
	public ManageSliderPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//div[@class='col-sm-12']//child::a[1]")
	WebElement newBtn;
	
	@FindBy (xpath = "//input[@id='main_img']")
	WebElement chooseFile;
	
	@FindBy (xpath = "//input[@id='link']")
	WebElement linkInput;
	
	@FindBy (xpath = "//button[text()='Save']")
	WebElement saveBtn;
	
	@FindBy (xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]//img")
	WebElement image;
	
	public boolean uploadManageSliderImage() throws AWTException, InterruptedException {
		
		gu.clickOnElement(newBtn);
		
		gu.fileUpload(chooseFile, System.getProperty("user.dir")+"\\src\\main\\resources\\UploadFiles\\ManageSliderPic.jpg", driver);
		
		gu.waitForMinimumTime();
		
		gu.inputValueToATextField(linkInput, "www.pexels.com" );
		
		gu.clickJavaScriptExecutor(saveBtn, driver);
		
		return gu.elementDisplayedOrNot(image);
	}
}
