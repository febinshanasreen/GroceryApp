package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class GeneralUtilities {

//Login

	public void loginData(WebElement element, String value) {

		element.sendKeys(value);

	}

	public void passWordData(WebElement element, String value) {

		element.sendKeys(value);

	}

	public void inputValueToATextField(WebElement element, String value) {

		element.sendKeys(value);

	}

//To Wait for a minimum delay

	public void waitForMinimumTime() throws InterruptedException {

		Thread.sleep(2000);
	}

//To click on an element

	public void clickOnElement(WebElement element) {

		element.click();
	}

//To Get text of an element 

	public String getElementText(WebElement element) {
		String text = element.getText();

		return text;
	}

//To Get a value of dropdown as a text of an element 

	public String selectValueFromDropDownAndGetText(WebElement element, String value) {
		Select slctObj = new Select(element);
		slctObj.selectByValue(value);
		WebElement SlctedElmt = slctObj.getFirstSelectedOption();
		String text = SlctedElmt.getText();
		return text;
	}

	public void toClickValueFromDropDownByValue(WebElement element, String value) {
		Select slctObj = new Select(element);
		slctObj.selectByValue(value);
	}

	public void toClickValueFromDropDownByVisibleText(WebElement element, String VisibleText) {
		Select slctObj = new Select(element);
		slctObj.selectByVisibleText(VisibleText);
	}

//To Check an element is selected or not

	public boolean elementSelectedOrNot(WebElement element) {

		boolean result = element.isSelected();

		return result;
	}

//To Check an element is Enabled or not

	public boolean elementEnabledOrNot(WebElement element) {

		boolean result = element.isEnabled();

		return result;
	}

//To Check an element is Displayed or not

	public boolean elementDisplayedOrNot(WebElement element) {

		boolean result = element.isDisplayed();

		return result;
	}

//To get the attribute value

	public String getAttributeOfAnElement(WebElement element, String value) {

		String text = element.getAttribute(value);

		return text;

	}
	
//To get the attribute value

		public String getCSSValue(WebElement element, String value) {

			String text = element.getCssValue(value);

			return text;

		}

//For alert Switching

	public void alertSwitching(WebDriver driver) {

		driver.switchTo().alert();

	}

	public void alertSwitchingAndAccept(WebDriver driver) {

		driver.switchTo().alert().accept();

	}
	
	public void alertSwitchingAndDismiss(WebDriver driver) {

		driver.switchTo().alert().dismiss();

	}

//For alert Switching and getText

	public String alertSwitchingAndGetText(WebDriver driver) {

		String text = driver.switchTo().alert().getText();

		return text;
	}

//Utitly for JS Scroll

	public void scrollJavaScriptExecutor(int horizontal, int vertical, WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + horizontal + "," + vertical + ")");
	}

//Utitly for JS Clcik

	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

//To Upload a File

	public void fileUpload(WebElement element, String filePath, WebDriver driver) throws AWTException {

		Actions obj = new Actions(driver);

		obj.moveToElement(element).click().perform();

		StringSelection locationOfFile = new StringSelection(filePath);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(locationOfFile, null);

		Robot robot = new Robot();
		robot.delay(250);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.delay(250);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.delay(250);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

//Iteration through a list of WebElements to check presence of a string 

	public boolean iterateThroughAWebElementListToFindAMatchWithAString(List<WebElement> listname, String value) {

		boolean flag = false;
		for (int i = 0; i < listname.size(); i++) {

			if (listname.get(i).getText().equals(value))
			{
				flag = true;
			}
		}
		return flag;
	}
	
//Iteration through a list  of webelements to check absence of a String
	
	public boolean iterateToFindAStringIsNotPresntInTheList(List<WebElement> listname, String value) {
	
	boolean flag = false;
	for (int i = 0; i < listname.size(); i++) {

		if (!listname.get(i).getText().equals(value))
		{
			flag = true;
		}
	}
	return flag;
	
	}
	
//Size of a list
	
	public Integer sizeOfAList(List<WebElement> listname) {
		
		int count= listname.size();
		return count;
	}
	
	
	
//Dynamic Table values

	public String selectValueFromDynamicTable(List<WebElement> listOfColumn, String value, String locator) {
		String elementLocator = null;
		for (int i = 0; i < listOfColumn.size(); i++) {
			if (listOfColumn.get(i).getText().equals(value)) {
				elementLocator = locator;

				break;
			}
		}
		return elementLocator;
	}

//Return row Value from dynamic table
	
	public Integer selectValueFromDynamicTableDupe2(List<WebElement> listOfColumn, String value) {
		int rowNumber = 0;
		for (int i = 0; i < listOfColumn.size(); i++) {
			if (listOfColumn.get(i).getText().equals(value)) {
			rowNumber=i;
			}
		}
		return rowNumber;
	}	
	
//Return String from Dynamic table search
	
	public String ReturnLocatorFromDynSearch(List<WebElement> listOfColumn, String value, String FirstHalf,String SecondHalf) {
		String elementLocator = null;
		for (int i = 0; i < listOfColumn.size(); i++) {
			if (listOfColumn.get(i).getText().equals(value)) {
				elementLocator = FirstHalf +(i+1) + SecondHalf;

				break;
			}
		}
		return elementLocator;
	}

//Matching string condition
	
	public String checkForequalance(String value, String value1, String value2) {
		String expected=null;
		if(value.equals(value1)) {
			 expected=value1;
		}
		
		else if(value.equals(value2)) {
			expected=value2; 
		}
		
		return expected;
	}
	

//Converting a List of WebElements into a List of String

	public List<String> listOfStringToCovertFromWebElementToString(WebDriver driver, String locatorPath) {
		List<WebElement> listOfWebElements = driver.findElements(By.xpath(locatorPath));
		List<String> listOfStringsConvertedFromWebElements = new ArrayList<String>();
		for (int i = 0; i < listOfWebElements.size(); i++) {

			String listnew = listOfWebElements.get(i).getText();

			listOfStringsConvertedFromWebElements.add(listnew);

			// listOfStringsConvertedFromWebElements.add(listOfWebElements.get(i).getText());

		}

		return listOfStringsConvertedFromWebElements;

	}

//Compare 2 Lists
	
	public boolean compare2StringList(List<String> list1, List<String> list2) {

		boolean flag = false;
		for (int i = 0; i < list1.size(); i++) {

			if (list1.get(i).equals(list2.get(i))) {
				flag = true;
			}
		}
		return flag;

	}

//image display verification using img-src attribute value

	public boolean compareAttributeValuesOf2Lists(List<WebElement> listname, String value1, String value2) {

		boolean flag=false;
		for(int i=0;i<listname.size();i++) {
			
		
			if( listname.get(i).getAttribute(value1).equals(value2));
			{
				flag=true;
				
			}
		}
		return flag;
	}
	
//Check values in the list are the same
	
	public boolean checkElementsInTheListAreTheSame(List<WebElement> listName, String firstValue ) {
	
	//String firstValue= listName.get(0).getText();
	
	for (int i = 0; i < listName.size(); i++) {

		if (!listName.get(i).getText().equals(firstValue))
		{
			return false;
		}
	}
	return true;
	}
	
//TypeCasting String to Numeric
	
	public int returnNumericFromString(WebElement element) {
	
	String s= element.getText();

	int number = Integer.parseInt(s);
	
	return number;
	
	}
}	


	

