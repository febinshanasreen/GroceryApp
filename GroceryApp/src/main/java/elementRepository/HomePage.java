package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class HomePage {

	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();

	public HomePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Manage Orders']")
	WebElement manageOrders;

	@FindBy(xpath = "//a[@class='nav-link']//child::p")
	WebElement manageExpense;
	
	@FindBy(xpath = "//p[text()='Mobile Slider']")
	WebElement mobileSliderTab;
	
	@FindBy (xpath = "//p[text()='Manage Product']")
	WebElement manageProductPage;
	
	@FindBy (xpath  ="//p[text()='Manage Users']")
	WebElement manageUsers;
	
	@FindBy (xpath = "//p[text()='Manage Location']")
	WebElement manageLocation;
	
	@FindBy (xpath = "//p[text()='Manage Slider']")
	WebElement manageSlider;

	public void clickOnManageOrdersTab() {

		gu.clickOnElement(manageOrders);
	}

	public void clickOnManageExpenseTab() {

		gu.clickOnElement(manageExpense);

	}

	public void clickOnMobileSliderTab() {

		gu.clickOnElement(mobileSliderTab);
	}

	public void clickOnManageProductPage() {

		gu.clickOnElement(manageProductPage);
	}
	
	public void clickOnManageUsersPage() {
		
		gu.clickOnElement(manageUsers);
	}
	
	public void clickOnManageLocationPage() {
		
		gu.clickOnElement(manageLocation);
	}
	
	public void clickOnManageSliderPage() {
		
		gu.clickOnElement(manageSlider);
	}
}
