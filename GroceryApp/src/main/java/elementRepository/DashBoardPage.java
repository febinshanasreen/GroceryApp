package elementRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class DashBoardPage {

	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();

	public DashBoardPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	WebElement dashboardTab;
	
	@FindBy (xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page'][@class='small-box-footer']")
	WebElement moreInfoManageOrderTab;
	
	public String displayTabName() {
		return (gu.getElementText(dashboardTab));

	}
	
	public void clickOnMoreinfoManageTab() {
		
		gu.clickOnElement(moreInfoManageOrderTab);
	}
	
	public List<String> getHeadingTableValuesAsString() {

		return (gu.listOfStringToCovertFromWebElementToString(driver,
				"//table[@class='table table-bordered table-hover table-sm']//thead//tr//th"));

	}
	
	public List<String> realTableHeadingValuesare(){
		
		List<String> list= new ArrayList<String>();
		list.add("Title");
		list.add("Description");
		list.add("Image");
		list.add("Page");
		list.add("Action");
		
		return list;
	}
	
	
	public boolean compareTwoLists() {
		
		List<String> actual = getHeadingTableValuesAsString();
		
		List<String> expected= realTableHeadingValuesare();
		
		return gu.compare2StringList(actual, expected);
			
	}
}
