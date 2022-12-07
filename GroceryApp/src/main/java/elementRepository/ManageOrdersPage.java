package elementRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ManageOrdersPage {

	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();

	WaitUtility wu = new WaitUtility();

	public ManageOrdersPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searachForSearchListOrders;

	@FindBy(id = "pt")
	WebElement dropDownForSearchListOrders;

	@FindBy(xpath = "//li[@class='nav-item'][2]//following::a")
	WebElement manageOrderHighLight;

	@FindBy(xpath = "//a[text()='View'][1]")
	WebElement viewBtnInManagersPage;

	@FindBy(xpath = "//span[@id='printpagebutton']//child::a")
	WebElement printBtn;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr/td[1]")
	List<WebElement> tableFirstRow;

	@FindBy(xpath = "//div[@class='col-sm-12']//child::a[1]")
	WebElement searchBtn;

	@FindBy(xpath = "//div[@class='card-body']//child::button[1]")
	WebElement searchBtnForSearchingTable;

	@FindBy (xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr/td[5]")
	List<WebElement> filteredPayementType;

	public void clickOnSerachInMAnageOrderTab() {

		searachForSearchListOrders.click();
	}

	public String selectAValueFromDropDownBtnOnManageOrdersPage() {

		return gu.selectValueFromDropDownAndGetText(dropDownForSearchListOrders, "Cash on Delivery");
	}

	public String switchDriverToAlertAndGetText() throws InterruptedException {
		
		//wu.explicitWaitUtilityForElementVisibility(driver, 5, dropDownForSearchListOrders);
		gu.waitForMinimumTime();
		
		return gu.alertSwitchingAndGetText(driver);
		
	}

	public String hightLightedWorkersTab() {

		return gu.getAttributeOfAnElement(dropDownForSearchListOrders, "class");

	}

	public void clickOnViewBtn() {

		gu.clickOnElement(viewBtnInManagersPage);
	}

	public void clickOnPrintBtn() {

		gu.clickOnElement(printBtn);
	}

	public void clickOnDeleteBtnWithDynamicLoc() throws InterruptedException {

		List<WebElement> columnlist = tableFirstRow;
		WebElement deleteButton;
		
		gu.selectValueFromScroll(0, 500, driver);
		gu.waitForMinimumTime();
		String locator= gu.selectValueFromDynamicTable(columnlist, "388", "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[\"+ (i+1) +\"]//td[7]//child::a[2]//i");
		deleteButton = driver.findElement(By.xpath(locator));
		gu.clickJavaScriptExecutor(deleteButton, driver);
		gu.waitForMinimumTime();
	}
	
/*
 * DO CHECK WITH THE TRAINER
 * Here the value of i is not recogonized even if \ is provided before and after i+1,
 * The desired dynamic xpath is given in the utilities by parametering its
 * attribute, attribute value, and the desired cell/column.
 */
	//----------------------------------
	
	public void deleteAnOrderFromTheTable1() throws InterruptedException {


		List<WebElement> columnlist = tableFirstRow;
		WebElement deleteButton;
		
		gu.selectValueFromScroll(0, 500, driver);
		gu.waitForMinimumTime();
		String locator= gu.ReturnLocatorFromDynSearch(columnlist,"380","//table[@class='table table-bordered table-hover table-sm']//tbody//tr[","]//td[7]//child::a[2]//i");
		deleteButton = driver.findElement(By.xpath(locator));
		gu.clickJavaScriptExecutor(deleteButton, driver);
		
	}
	
	
	
	//-----------------------------------
	
	public void deleteAnOrderFromTheTable() throws InterruptedException {


		List<WebElement> columnlist = tableFirstRow;
		WebElement deleteButton;
		
		gu.selectValueFromScroll(0, 500, driver);
		gu.waitForMinimumTime();
		int rowNumber=gu.selectValueFromDynamicTableDupe2(columnlist, "380");
		String locator= "//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(rowNumber+1)+"]//td[7]//child::a[2]//i";
		deleteButton = driver.findElement(By.xpath(locator));
		gu.clickJavaScriptExecutor(deleteButton, driver);
		
	}
	
	public boolean deletedElementDoesnotExist() {
		
		List<WebElement> orderIDColumnValues = tableFirstRow;
	
		return gu.iterateToFindAStringIsNotPresntInTheList(orderIDColumnValues, "380");
		
		
	}
	
	
	public boolean checkThePayementModeInTheFilteredTable() {

		gu.clickOnElement(searchBtn);

		gu.toClickValueFromDropDownByVisibleText(dropDownForSearchListOrders, "Bank");

		gu.clickOnElement(searchBtnForSearchingTable);

		//return gu.iterateThroughAWebElementListToFindAMatchWithAString(filteredPayementType, "Bank");
		
		List<WebElement> filteredvalues=filteredPayementType;
		return gu.checkElementsInTheListAreTheSame(filteredvalues,"Bank");
	}
	
}


