package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 

import utilities.GeneralUtilities;

public class ManageExpensePage {

	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();

	public ManageExpensePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//div[@class='col-sm-12']//child::a")
	WebElement newTitle;
	
	@FindBy (xpath = "//input[@id='name']")
	WebElement title;
	
	@FindBy (xpath = "//div[@class='card-footer center']//child::button")
	WebElement save;
	
	@FindBy (xpath ="//p[text()='Expense Category']")
	WebElement expenseCategory;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td")
	List<WebElement> expenseCategoryData;
	
	@FindBy (xpath = "//div[@class='alert alert-success alert-dismissible']//child::h5")
	WebElement titleAdditionSuccessAlert;
	
	@FindBy (xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement titleAdditionFailureAlert;
	
	public void clickOnNew() {
		
		newTitle.click();
	}
	
	public void EnterValueOfTitle(String value) {
		
		gu.inputValueToATextField(title, value);
		
	}
	
	public void clickOnSave() {
		save.click();
	}
	
	public void clickOnExpenseCategory() {
		
		gu.clickOnElement(expenseCategory);
	}
	
	public String itemAdditionSuccessAlertText() {
		
		return gu.getElementText(titleAdditionSuccessAlert);
		
	}
	
	public String itemAdditionFailureAlertText() {
		
		return gu.getElementText(titleAdditionFailureAlert);
		
	}
							/*
							 * These lines of code to check wehter the data contains a specific value or not
							 * 
							 * @Test
							  public void verify(){
								  
								  lp = new LoginPage(driver);
								  hP=new HomePage(driver);
								  mEP=new ManageExpensePage(driver);
								  
								  lp.enterLoginCredential();
								  lp.clickOnSignInButton();
								  hP.clickOnManageExpenseTab();
								  mEP.clickOnExpenseCategory();
								  mEP.clickOnNew();
								  mEP.checkItemALreadyExistORNot("Raisins");
								  
								}
							 
								/*
								 * public void checkItemALreadyExistORNot(String value) {
								 * List<WebElement> list = expenseCategoryData;
								 * for(int i =0;i<=list.size();i++) {
								 * String s= list.get(i).getText();
								 * if(s.equals(value)) {
								 * System.out.println("Already exist");
								 * }
								 * else
								 * System.out.println("New");
								 * }
								 * }
								 */
									
		
		
	public boolean valueDesiredIsPresentInTheListOrNot(String value) {

		List<WebElement> columnlist = expenseCategoryData;
		
		return gu.iterateThroughAWebElementListToFindAMatchWithAString(columnlist, value);
	
	}
}
