package elementRepository;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class MobileSliderPage {

	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();

	WaitUtility wu=new WaitUtility();
	
	public MobileSliderPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='col-sm-12']//child::a[1]")
	WebElement newBtnInMobileSlider;

	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement selectDropDown;

	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFile;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement savePicture;
	
	@FindBy(xpath = " //table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]//img")
	WebElement uploadedPicture;
	
	@FindBy (xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td//img")
	List<WebElement> ImageColumn;

	public void clickOnNewBtn() {

		gu.clickOnElement(newBtnInMobileSlider);
	}

	public void clickOnDropDown() {

		gu.toClickValueFromDropDownByValue(selectDropDown, "125");
	}

	public void clickOnChooseFileBtn() throws AWTException, InterruptedException {

		
		gu.fileUpload(chooseFile,System.getProperty("user.dir") + "\\src\\main\\resources\\UploadFiles\\falooda.jpg", driver);
		
		gu.waitForMinimumTime();
		
		gu.clickJavaScriptExecutor(savePicture, driver);
		
	}
	
	public boolean uploadedImageDisplayVerification() {
		
		List<WebElement> ColumnForImagesList= ImageColumn;
		
		return gu.compareAttributeValuesOf2Lists(ColumnForImagesList, "src", "https://groceryapp.uniqassosiates.com/public/uploads/small/1669888912_9a77c67adeee114b2d38.jpg");
		
																	
	}
	
	
	
}
