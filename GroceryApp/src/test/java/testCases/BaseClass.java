package testCases;


import utilities.CaptureScreenshot;

import org.testng.annotations.BeforeMethod;


import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {

	WebDriver driver;
	public static Properties prop;

	public static void testLink() throws IOException {

		prop = new Properties();

		FileInputStream fIP = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\config.properties");
		prop.load(fIP);
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() throws IOException {

		

		testLink();
		
		System.setProperty(prop.getProperty("ChromeDriverKey"),
				System.getProperty("user.dir") + "\\src\\main\\resources\\DriverFiles\\chromedriver.exe");

		driver = new ChromeDriver();
		
		driver.get(prop.getProperty("BaseURL"));

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

	}

	/*
	 * @Parameters ("browser") public void beforeMethod(String BrowserDriverName)
	 * throws IOException {
	 * 
	 * testLink();
	 * 
	 * if(BrowserDriverName.equals("chrome")) {
	 * 
	 * System.setProperty(prop.getProperty("ChromeDriverKey"),
	 * System.getProperty("user.dir") +
	 * "\\src\\main\\resources\\DriverFiles\\chromedriver.exe");
	 * 
	 * driver=new ChromeDriver(); }
	 * 
	 * else if(BrowserDriverName.equals("edge")) {
	 * 
	 * System.setProperty(prop.getProperty("EdgeDriverKey"),
	 * System.getProperty("user.dir") +
	 * "\\src\\main\\resources\\DriverFiles\\msedgedriver.exe");
	 * 
	 * driver=new EdgeDriver(); }
	 * 
	 * else if(BrowserDriverName.equals("firefox")) {
	 * 
	 * System.setProperty(prop.getProperty("GeckoDriverKey"),
	 * System.getProperty("user.dir") +
	 * "\\src\\main\\resources\\DriverFiles\\geckodriver.exe");
	 * 
	 * driver=new FirefoxDriver(); }
	 * 
	 * 
	 * driver.get(prop.getProperty("BaseURL"));
	 * 
	 * driver.manage().window().maximize();
	 * 
	 * driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000)); }
	 * 
	 * 
	 */

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult iTestResult) throws IOException {

		/*
		 * Listener() - it monitors the events occuring when each line of code is
		 * executed. There are nearly 25 types in use we use ITestResult iTestResult
		 */
		if (iTestResult.getStatus() == ITestResult.FAILURE) {

			CaptureScreenshot cS = new CaptureScreenshot();
			cS.captureFailureScreenShot(driver, iTestResult.getName());
		}

		driver.close();

	}

}
