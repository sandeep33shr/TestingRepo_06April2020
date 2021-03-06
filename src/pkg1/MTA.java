package pkg1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MTA {
	

	  
	public static WebDriver driver = null;
	public static Map<String, String> dynamicHashMap = null;
	public static String PolNum = null;
	public static String Pol1 = null;
	public static String mTAcoverStartDate = "10/07/2020";
	public static String mTAcoverStartTime = "18:30:06";
	public static String dynamicDate ="no";
	public static Properties prop = null;
	public static FileInputStream fis;
	public static String polnum= T1.dynamicHashMap.get(Pol1);
	//public static String polnum= "ERG/GH/001659";
	public static String status="Current";
	/*public static String fldTurnOver="200000";
	public static String fldBedRooms="2";
	public static String fldINCCIT="100000";*/
	public static String fldTurnOver="400000";
	public static String fldBedRooms="6";
	public static String fldINCCIT="200000";
/*	public static String fldTurnOver="300000";
	public static String fldBedRooms="5";
	public static String fldINCCIT="150000";*/
	public static String env = T1.env;
	
	
	
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
	
	/*
	 * public T1() { prop = new Properties(); try { FileInputStream fis = new
	 * FileInputStream(System.getProperty("user.dir") + "\\Properties.properties");
	 * prop.load(fis);
	 * 
	 * } catch (FileNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); }
	 * 
	 * }
	 */

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

	public void mtaByPolNum() throws InterruptedException, AWTException {
		        
        String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "//ChromeDriver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
     /*   System.setProperty("webdriver.ie.driver", path + "//IEdriver//IEDriverServer.exe");
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
		}else if(env.equals("red1")){
			driver.get(prop.getProperty("SITurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.id("username")).sendKeys("admin@systest.com ");
			driver.findElement(By.id("password")).sendKeys("Password@2020");
		}else if(env.equals("red2")){
			driver.get(prop.getProperty("SITredUrl2"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.id("username")).sendKeys("SSPadmin1@redinsurance.com");
			driver.findElement(By.id("password")).sendKeys("Password@2020");
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
		if((!env.equals("red1")&& (!env.equals("red2")))) {
			driver.findElement(By.id("password")).sendKeys("Password@2018");
			}
		driver.findElement(By.cssSelector("#loginModal > div > div > div.card-footer > button")).click();
  		driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtPolicyNumber")).sendKeys(polnum);
		driver.findElement(By.xpath("//a[@id='ctl00_cntMainBody_btnSearch']")).click();
		driver.findElement(By.xpath("//a[@id='ctl00_cntMainBody_grdvSearchResults_ctl02_lnkDetails']")).click();
		driver.findElement(By.cssSelector("a[href='#tabpolicies']")).click();
		driver.findElement(By.cssSelector("#ctl00_cntMainBody_ClientQuotesPolicies_txtPolicyNo")).sendKeys(polnum);
     	driver.findElement(By.cssSelector("a#ctl00_cntMainBody_ClientQuotesPolicies_btnSearch")).click();
     	//List<WebElement> QnP= driver.findElements(By.cssSelector("#ctl00_cntMainBody_ClientQuotesPolicies_gvPolicyVersions td:nth-child(7)"));
     	List<WebElement> colStatus= driver.findElements(By.cssSelector("#ctl00_cntMainBody_ClientQuotesPolicies_gvPolicyVersions td:nth-child(9)"));
     	//List<WebElement> pageLinks = driver.findElements(By.cssSelector("#ctl00_cntMainBody_ClientQuotesPolicies_gvPolicyVersions > div > a"));
     	Thread.sleep(1000);
       //	ProjectMethods.clickMTAVersion(driver, colStatus, pageLinks, status);
      	ProjectMethods.clickElementBasedOnText(driver, colStatus, status);
      	screenShot(driver,"mtaPolicyList");
		Thread.sleep(15000);
		try {

			driver.findElement(By.xpath("//*[@id=\"ctl00_cntMainBody_ClientQuotesPolicies_btnChange\"]")).click();
		} catch (StaleElementReferenceException e) {
			driver.findElement(By.xpath("//*[@id=\"ctl00_cntMainBody_ClientQuotesPolicies_btnChange\"]")).click();
		} catch (WebDriverException e1) {
			driver.findElement(By.xpath("//*[@id=\"ctl00_cntMainBody_ClientQuotesPolicies_btnChange\"]")).click();
		}
        Thread.sleep(3000);
		getElement(prop.getProperty("mtaReason")).click();
		
		if (dynamicDate.equals("yes")) {
		  driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtEffectiveDate")).
		  clear();
		  driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtEffectiveDate")).
		  sendKeys(mTAcoverStartDate);
		  
		 /* driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtEffectiveTime")).
		  clear();
		  driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtEffectiveTime")).
		  sendKeys(mTAcoverStartTime);*/
		  
		}
		
		screenShot(driver,"MTAReason");
		driver.findElement(By.cssSelector("a#ctl00_cntMainBody_btnSubmit")).click();

		// DATA CAPTURE SCREEN

		driver.switchTo().frame("dqjIframe");
		driver.switchTo().frame("QMIframe");
		
	
		// 1st tab
		getElement(prop.getProperty("btnNext1stScreen")).click();
		// 2nd tab
		Thread.sleep(2000);
		getElement(prop.getProperty("radiobtnBuilding")).click();
		getElement(prop.getProperty("radiobtnContent")).click();
		getElement(prop.getProperty("btnNext2ndScreen")).click();
		
		// 3rd tab
		Thread.sleep(2000);
		getElement(prop.getProperty("fldAgeOfBuilding")).clear();
		getElement(prop.getProperty("fldAgeOfBuilding")).sendKeys("2012");
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
		getElement(prop.getProperty("fldTurnOver")).clear();
		getElement(prop.getProperty("fldTurnOver")).sendKeys(fldTurnOver);
		getElement(prop.getProperty("fldBedRooms")).clear();
		getElement(prop.getProperty("fldBedRooms")).sendKeys(fldBedRooms);
		getElement(prop.getProperty("btnNext8thScreen")).click();
		Thread.sleep(2000);
		// 9th Tab
		getElement(prop.getProperty("btnNext9thScreen")).click();
		Thread.sleep(2000);
		// 10th tab
		//UtilityMethods.selectByIndex(driver, prop.getProperty("drpPL"), 2);
		getElement(prop.getProperty("fldINCCIT")).clear();
		getElement(prop.getProperty("fldINCCIT")).sendKeys(fldINCCIT);
		getElement(prop.getProperty("fldINCCIS")).clear();
		getElement(prop.getProperty("fldINCCIS")).sendKeys("2000");
		getElement(prop.getProperty("fldModelSafe")).clear();
		getElement(prop.getProperty("fldModelSafe")).sendKeys("5000");
		getElement(prop.getProperty("btnNext10thScreen")).click();
		Thread.sleep(2000);
		// 11th tab
		/*getElement(prop.getProperty("fldHHBuildings")).clear();
		getElement(prop.getProperty("fldHHBuildings")).sendKeys("20000");
		getElement(prop.getProperty("fldContent")).clear();
		getElement(prop.getProperty("fldContent")).sendKeys("40000");*/
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

		Thread.sleep(70000);
		screenShot(driver,"mtaQR");
		Actions action=new Actions(driver);
		 action.sendKeys(Keys.PAGE_DOWN).build().perform();
		 waitForElement(prop.getProperty("drpAddOnSection"));
		 getElement(prop.getProperty("drpAddOnSection")).click();
		 getElement(prop.getProperty("btnRemove")).click();
		 Thread.sleep(4000);
		 getElement(prop.getProperty("fldRevised")).clear();
		 getElement(prop.getProperty("fldRevised")).sendKeys("-100");
		 action.sendKeys(Keys.TAB).build().perform();
		 Thread.sleep(2000);
		 getElement(prop.getProperty("fldCommission")).clear();
		 getElement(prop.getProperty("fldCommission")).sendKeys("-10");
		 action.sendKeys(Keys.TAB).build().perform();
		 Thread.sleep(2000);
		 getElement(prop.getProperty("fldSAComm")).clear();
		 getElement(prop.getProperty("fldSAComm")).sendKeys("-5");
		 action.sendKeys(Keys.TAB).build().perform();
		 Thread.sleep(2000);
		 getElement(prop.getProperty("btnEditBrokerSave")).click();
		 Thread.sleep(3000);
		 action.sendKeys(Keys.PAGE_DOWN).build().perform();
		 getElement(prop.getProperty("btnAddAddOn2")).click();
		 Thread.sleep(3000);
		action.sendKeys(Keys.PAGE_UP).build().perform();
		action.sendKeys(Keys.PAGE_UP).build().perform();
		action.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(3000);
		getElement(prop.getProperty("btnSave")).click();

		//SOC screen
		
		String mtaCoverFromDateTime = driver
				.findElement(By.cssSelector(
						"#Controls_PolicyDetails > div > div.card-body.clearfix > div > div:nth-child(3) > div > p"))
				.getText();

		String mtaCoverEndDateTime = driver
				.findElement(By.cssSelector(
						"#Controls_PolicyDetails > div > div.card-body.clearfix > div > div:nth-child(4) > div > p"))
				.getText();

		driver.findElement(By.cssSelector("#ctl00_cntMainBody_btnBuy")).click();
		Alert alert3 = driver.switchTo().alert();
		alert3.accept();
		driver.switchTo().defaultContent();

		System.out.println("Policy Number is : " + " " + dynamicHashMap.get(Pol1) + "   " + "MTACoverFromDateTime   "
				+ mtaCoverFromDateTime + "  MTACoverEndDateTime is  " + mtaCoverEndDateTime);

		Thread.sleep(4000);
		getElement(prop.getProperty("lnkFinance")).click();
		getElement(prop.getProperty("lnkTransactions")).click();
		getElement(prop.getProperty("tabReference")).click();
		getElement(prop.getProperty("fldPolicyNumber")).sendKeys(dynamicHashMap.get(Pol1));
		getElement(prop.getProperty("btnFind")).click();
		Thread.sleep(5000);
		screenShot(driver, "SearchTransactions");
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		screenShot(driver, "SearchTransactions_1");	 
		 

	}
	


	public static void main(String[] args) {
		MTA m = new MTA();
		try {
			m.mtaByPolNum();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
