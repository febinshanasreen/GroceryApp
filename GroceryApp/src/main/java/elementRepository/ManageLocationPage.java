package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ManageLocationPage {

	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();

	WaitUtility wu = new WaitUtility();

	public ManageLocationPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> FirstColumn;
	
	@FindBy (xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[10]//td[5]//a//span")
	WebElement status;
	
	public void meth() {
		
		System.out.println(status.getCssValue("background-color"));
	}

	public WebElement findElemenentLocationOfStatus() throws InterruptedException {

		List<WebElement> columnlist = FirstColumn;
		WebElement statusButton;

		gu.scrollJavaScriptExecutor(0, 500, driver);
		gu.waitForMinimumTime();
		String locator =gu.ReturnLocatorFromDynSearch(columnlist,"belfast","//table[@class='table table-bordered table-hover table-sm']//tbody//tr[","]//td[5]//a//span");
		statusButton = driver.findElement(By.xpath(locator));
		// gu.clickJavaScriptExecutor(statusButton, driver);
		return statusButton;
	}

	public void clickOnStatus() throws InterruptedException {

		WebElement statusBtn = findElemenentLocationOfStatus();
		gu.clickJavaScriptExecutor(statusBtn, driver);
		gu.waitForMinimumTime();
	}
	

	public String getElementBgColor() throws InterruptedException {

		WebElement statusBtn = findElemenentLocationOfStatus();
		String bgColor = gu.getCSSValue(statusBtn, "background-color");
		System.out.println(bgColor);
		return bgColor;

	}
	
	public void expectedColor() throws InterruptedException {
		
		WebElement statusBtn = findElemenentLocationOfStatus();
		String statusBtnColor =gu.getCSSValue(statusBtn, "background-color");
		
	}

	public String getElementText() throws InterruptedException {

		WebElement statusBtn = findElemenentLocationOfStatus();
		String text = gu.getElementText(statusBtn);
		return text;

	}
	

}
