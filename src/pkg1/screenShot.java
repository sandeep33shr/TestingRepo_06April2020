package pkg1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenShot {
	
	
	public static void screenShot1(WebDriver driver){
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	// Now you can do whatever you need to do with it, for example copy somewhere
	try {
		FileUtils.copyFile(scrFile, new File("c:\\temp\\"+System.currentTimeMillis()+".png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
