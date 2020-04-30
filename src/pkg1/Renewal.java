package pkg1;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Renewal {

	public static WebDriver driver = null;
	public static Map<String, String> dynamicHashMap = null;
	public static Properties prop = null;
	public static FileInputStream fis;
	public static String polnum= "ERG_GH_024495";
	public static String env = "blue";
	
	
	{
		prop = new Properties();

		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\Properties.properties");
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

	public static void screenShot(WebDriver driver, String testStepsName) {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Now you can do whatever you need to do with it, for example copy somewhere
		try {
			FileUtils.copyFile(scrFile,
					new File("c:\\temp\\Screenshot\\" + testStepsName + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {

			System.out.println("Please correct screenshot path");

		}

	}

	public static void waitForElement(String locator) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
	}
	
	public void renewalByPolNum() throws InterruptedException, AWTException {
        
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "//ChromeDriver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		/*System.setProperty("webdriver.ie.driver", path + "//IEdriver//IEDriverServer.exe");
		driver = new InternetExplorerDriver();*/
		if(env.equals("yellow")){
			driver.get(prop.getProperty("SITyellowURL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.id("username")).sendKeys("admin@yellowinsurance.com");
		}else if(env.equals("red")){
			driver.get(prop.getProperty("SITredUrl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.id("username")).sendKeys("admin@redinsurance.com");
		}else if(env.equals("blue"))
		{
			driver.get(prop.getProperty("Dev2URL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.id("username")).sendKeys("admin@blueinsurance.com");
		}else if(env.equals("vm31"))
		{
			driver.get(prop.getProperty("vm31URL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.id("username")).sendKeys("admin@blueinsurance.com");
		}else 
		{
			driver.get(prop.getProperty("Dev2URL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.id("username")).sendKeys("subagent@blueinsurance.com");
		}
		driver.findElement(By.id("password")).sendKeys("Password@2018");
		driver.findElement(By.cssSelector("#loginModal > div > div > div.card-footer > button")).click();
		
		getElement(prop.getProperty("lnkPolicy")).click();
		getElement(prop.getProperty("lnkRenewalSelection")).click();
		getElement(prop.getProperty("fldRef")).sendKeys(polnum);
	    getElement(prop.getProperty("btnFindSelection")).click();
	    Thread.sleep(2000);
	    getElement(prop.getProperty("lnkSelect")).click();
	    Thread.sleep(20000);
	    screenShot(driver,"RenewalSelection");
	    waitForElement("#ctl00_RibbonMenu_rptCategory_ctl02_RptCategorySpanText");
	    getElement(prop.getProperty("lnkPolicy")).click();
	    getElement(prop.getProperty("lnkRenewalManager")).click();
	    getElement(prop.getProperty("fldPolNum")).sendKeys(polnum);
	    getElement(prop.getProperty("btnFindRManager")).click();
	    getElement(prop.getProperty("lnkDetails")).click();
	    screenShot(driver,"RenSOC");
	    getElement(prop.getProperty("lnkActionMenu")).click();
	    getElement(prop.getProperty("lnkEdit")).click();
	    
	    
	 // DATA CAPTURE SCREEN

	 		driver.switchTo().frame("dqjIframe");
	 		driver.switchTo().frame("QMIframe");

	 		// 1st tab
	 		getElement(prop.getProperty("btnNext1stScreen")).click();
	 		Thread.sleep(2000);
	 		// 2nd tab
	 		getElement(prop.getProperty("btnNext2ndScreen")).click();
	 		// 3rd tab
	 		Thread.sleep(2000);
	 		getElement(prop.getProperty("btnNext3rdScreen")).click();
	 		// 4th tab
	 		Thread.sleep(2000);
	 		getElement(prop.getProperty("btnNext4thScreen")).click();
	 		// 5th tab
	 		Thread.sleep(2000);
	 		getElement(prop.getProperty("btnNext5thScreen")).click();
	 		// 6th tab
	 		Thread.sleep(2000);
	 		getElement(prop.getProperty("btnNext6thScreen")).click();
	 		Thread.sleep(2000);
	 		// 7th tab
	 		getElement(prop.getProperty("btnNext7thScreen")).click();
	 		Thread.sleep(2000);
	 		// 8th tab
	 		getElement(prop.getProperty("btnNext8thScreen")).click();
	 		Thread.sleep(2000);
	 		// 9th Tab
	 		getElement(prop.getProperty("btnNext9thScreen")).click();
	 		Thread.sleep(2000);
	 		// 10th tab
	 	
	 		getElement(prop.getProperty("btnNext10thScreen")).click();
	 		Thread.sleep(2000);
	 		// 11th tab
     		getElement(prop.getProperty("btnNext11thScreen")).click();
	 		Thread.sleep(2000);
	 		// 12th tab
	 		getElement(prop.getProperty("btnNext12thScreen")).click();
	 		// 13th tab
	 		Thread.sleep(2000);
	 		getElement(prop.getProperty("btnNext13thScreen")).click();
	 		Thread.sleep(2000);
	 		getElement(prop.getProperty("btnNext14thScreen")).click();
	 		Thread.sleep(2000);
	 		getElement(prop.getProperty("btnNext15thScreen")).click();
	 		Thread.sleep(2000);
	 		getElement(prop.getProperty("btnNext16thScreen")).click();
	 		Thread.sleep(2000);
	 		getElement(prop.getProperty("btnNext17thScreen")).click();
	 		Thread.sleep(2000);
	 		getElement(prop.getProperty("btnNext18thScreen")).click();
	 		
	 		
	 		// Quote Manager Page**************
	 		Thread.sleep(15000);
	 		//getElement(prop.getProperty("btnSave")).click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		
			Renewal ren= new Renewal();
			ren.renewalByPolNum();
		
		
		
	}

}
