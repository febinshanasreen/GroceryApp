package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	
//Explicit wait ElementToBeClickable
	
	public void explicitWaitUtilityForElementToBeClickable(WebDriver driver, long seconds, WebElement element) {
			
		WebDriverWait waitforclient= new WebDriverWait(driver, Duration.ofSeconds(seconds));
		waitforclient.until(ExpectedConditions.elementToBeClickable(element));
		
	}

//Explicit wait Till Alert is present
	
	public void explicitWaitUtilityForElementForAlertToBePresent(WebDriver driver, long seconds, WebElement element) {
		
		WebDriverWait waitforclient= new WebDriverWait(driver, Duration.ofSeconds(seconds));
		waitforclient.until(ExpectedConditions.alertIsPresent());
		
	}

//Explicit wait Element Text Presence
	
	public void explicitWaitUtilityForElementTextToBePresent(WebDriver driver, long seconds, WebElement element,String elementText) {
		
		WebDriverWait waitforclient= new WebDriverWait(driver, Duration.ofSeconds(seconds));
		waitforclient.until(ExpectedConditions.textToBePresentInElement(element,elementText));
		
	}
	
//Explicit wait Element Visibiltiy
	
	public void explicitWaitUtilityForElementVisibility(WebDriver driver, long seconds, WebElement element) {
		
		WebDriverWait waitforclient= new WebDriverWait(driver, Duration.ofSeconds(seconds));
		waitforclient.until(ExpectedConditions.visibilityOf(element));
		
	}
	

	
}
