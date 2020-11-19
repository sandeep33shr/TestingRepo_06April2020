package pkg1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InsurerPayment {

	public static WebDriver driver = null;
//	public static String polnum= T3.dynamicHashMap.get(Pol1);
	public static String polnum= "ERG/GH/028783";
	public static String env = T3.env;
	public static FileInputStream fis;
	public static Properties prop = null;
	
	{
		prop = new Properties();

		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\Properties_new.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	public static WebElement getElement(String locator) {

		WebElement element = driver.findElement(By.cssSelector(locator));

		return element;

	}

	public void IP(WebDriver driver,String polNum,String insurerCode){
		
		
		getElement(prop.getProperty("lnkFinance")).click();
		getElement(prop.getProperty("lnkPayment")).click();
		getElement(prop.getProperty("fldIPAccountCode")).sendKeys(insurerCode);
		getElement(prop.getProperty("btnIPOK")).click();
		UtilityMethods.selectByIndex(driver, "#ctl00_cntMainBody_ddlBranch", 0);	
		getElement(prop.getProperty("btnIPFind")).click();
		
		
		
	}
	
}
