package pkg1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class UtilityMethods {
	
	
	

	public static void selectByIndex(WebDriver driver,String locator , int index) {
		WebElement element =driver.findElement(By.cssSelector(locator));
		Select sel = new Select(element);
		sel.selectByIndex(index);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void selectByVisibleText(WebDriver driver,String locator , String text) {
		
		WebElement element =driver.findElement(By.cssSelector(locator));
		
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
