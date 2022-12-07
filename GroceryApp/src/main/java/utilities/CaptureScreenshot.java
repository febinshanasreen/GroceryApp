package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenshot {

	
	public void captureFailureScreenShot(WebDriver driver, String name) throws IOException {
		  //Interface & method for Capture Screenshot 
		  TakesScreenshot scrShot =(TakesScreenshot)driver;
		  File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//screenshot will store in temporary path
		  

		 
		  File f1=new File(System.getProperty("user.dir")+"\\OutputScreenshots");//Generating folder using Java
		  
		  								/*File f1=new File(System.getProperty("user.dir")
		  								 * the above code set the path by java itself
		  								 * "\\OutputScreenshots");
		  								 * This can be appended by users wish
		  								 */
		  if (!f1.exists()){
			    f1.mkdirs();// mkdir --> will create folder using java
			}
		  
		  String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//date time capture using java
			 
		  
		  File finalDestination=new File(System.getProperty("user.dir")+ "\\OutputScreenshots\\" + name + "_" + timeStamp + ".png");
		  FileHandler.copy(screenShot, finalDestination);//copy screenshot from temp path to project folder
		  
	  }

}
