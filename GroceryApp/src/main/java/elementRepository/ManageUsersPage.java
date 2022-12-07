package elementRepository;

import java.util.List;

import org.checkerframework.dataflow.qual.TerminatesExecution;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ManageUsersPage {

	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu=new WaitUtility();

	public ManageUsersPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> FirstColumn;
	
	@FindBy (xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[14]//span")
	WebElement paswordDisplayed;
	
	@FindBy (xpath = "//div[@class='col-xs-12 col-sm-12']//child::span")
	List<WebElement> passwordList;
	
	public boolean clickOnShowPasswordSymbol() throws InterruptedException {
		
		List<WebElement> columnlist = FirstColumn;
		WebElement showPaswdButton;
		
		gu.selectValueFromScroll(0, 500, driver);
		gu.waitForMinimumTime();
		String locator= gu.ReturnLocatorFromDynSearch(columnlist, "Sruthi Harikrishnan", "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[", "]//td[3]//i");
		showPaswdButton = driver.findElement(By.xpath(locator));
		gu.clickJavaScriptExecutor(showPaswdButton, driver);
		
		boolean displayed= paswordDisplayed.isDisplayed();
		return displayed;
		
	}
	

	public void checkForRepetivePasswords() {
		
		List<WebElement> listOfPasswords= passwordList;
		
		
	}
	
	
}
