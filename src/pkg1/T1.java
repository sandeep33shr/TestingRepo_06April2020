package pkg1;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class T1 {
	public static WebDriver driver = null;
	public static Map<String, String> dynamicHashMap = null;
    public static String PolNum = null;
	public static String Pol1 = null;
	public static String postcode = "B37 7ye";
	public static String clientcode= "sharmaqa";
	public static String coverStartDate = "02/07/2020";
	public static String coverStartTime = "10:30:06";
	public static String dynamicDate ="no";
	public static Properties prop = null;
	public static FileInputStream fis;
	public static String env = "dev2";

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

	public void newBusiness() throws InterruptedException {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "//ChromeDriver//chromedriver.exe");
		driver = new ChromeDriver();
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
	}else if(env.equals("red1")){
		driver.get(prop.getProperty("SITurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("admin@systest.com");
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
		getElement(prop.getProperty("fldClientCode")).sendKeys(clientcode);
		driver.findElement(By.xpath(prop.getProperty("btnSearch_X"))).click();
		driver.findElement(By.xpath(prop.getProperty("btnSelect_X"))).click();
		UtilityMethods.selectByVisibleText(driver, "#ctl00_cntMainBody_ctrlNewQuoteImproved_ddlProductlst",
				"HIUA Phase 1 GLU");
		driver.findElement(By.xpath(prop.getProperty("btnNewQuote_X"))).click();
		// New Business
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_UP).build().perform();
		
		UtilityMethods.selectByIndex(driver, "select#ctl00_cntMainBody_POLICYHEADER__BRANCH", 0);
		UtilityMethods.selectByIndex(driver, "#ctl00_cntMainBody_POLICYHEADER__DEPARTMENT", 2);
		UtilityMethods.selectByIndex(driver, "#ctl00_cntMainBody_ddlPolicyHeaderSubTeam", 1);
		UtilityMethods.selectByIndex(driver, "#ctl00_cntMainBody_POLICYHEADER__ANALYSISCODE", 2);
		if(!env.equals("sa")) {
		UtilityMethods.selectByIndex(driver, "#ctl00_cntMainBody_ddlThirdParty", 2);
		}
		if(env.equals("red1")) {	
		driver.findElement(By.cssSelector("#ctl00_cntMainBody_btnHandler")).click();
		driver.switchTo().frame("TB_iframeContent");
		driver.findElement(By.id("ctl01_cntMainBody_btnSearch")).click();
		driver.findElement(By.cssSelector("#ctl01_cntMainBody_grdvSearchResults_ctl03_btnSelect")).click();
		driver.switchTo().defaultContent(); 
		Thread.sleep(2000);
		}
		
		if (dynamicDate.equals("yes")) {
		  driver.findElement(By.cssSelector(prop.getProperty("fldCoverStartDate"))).
		  clear();
		  driver.findElement(By.cssSelector(prop.getProperty("fldCoverStartDate"))).
		  sendKeys(coverStartDate);
		  
		 /* driver.findElement(By.cssSelector(prop.getProperty("fldCoverStartTime"))).
		  clear();
		  driver.findElement(By.cssSelector(prop.getProperty("fldCoverStartTime"))).
		  sendKeys(coverStartTime);*/
		}
		//UtilityMethods.selectByIndex(driver, "#ctl00_cntMainBody_POLICYHEADER__FREQUENCY", 2);
		  
		 
		action.sendKeys(Keys.PAGE_UP).build().perform();
		screenShot(driver, "PolicyHeader");
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		screenShot(driver, "PolicyHeaderDown");
		action.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("tabCompliance_X"))).click();
		// Compliance screen
		UtilityMethods.selectByVisibleText(driver, "#ctl00_cntMainBody_TYPE_OF_SALE", "Advised");
		UtilityMethods.selectByVisibleText(driver, "#ctl00_cntMainBody_METHOD_OF_SALE", "Non Distance");
		//driver.findElement(By.id("ctl00_cntMainBody_ddlUnderwriter")).sendKeys("UnderWriter");
		UtilityMethods.selectByIndex(driver, prop.getProperty("drpUnderwriter"), 1);
		UtilityMethods.selectByVisibleText(driver, "#ctl00_cntMainBody_ddlTermsAgreed", "No");
		driver.findElement(By.id(prop.getProperty("btnNextCompliance_ID"))).click();

		// DATA CAPTURE SCREEN

		driver.switchTo().frame("dqjIframe");
		driver.switchTo().frame("QMIframe");

		// 1st tab
//		getElement(prop.getProperty("fldInsured")).sendKeys("Sandeep");
		getElement(prop.getProperty("fldTradingName")).sendKeys("Sandeep");
	//	getElement(prop.getProperty("fldTelephoneNum")).sendKeys("09811923111");
		getElement(prop.getProperty("fldContactName")).sendKeys("Sandeep");
		UtilityMethods.selectByVisibleText(driver, prop.getProperty("drpCompStatus"), "Limited Company (LTD)");
		getElement(prop.getProperty("fldTurnOver_GD")).sendKeys("100000");
		/*getElement(prop.getProperty("fldPostCode")).clear();
		getElement(prop.getProperty("fldPostCode")).sendKeys("B37 7YE");
		driver.findElement(By.cssSelector("#C1__C1__BUT_BA23D49FD83824B32484")).click();
		Thread.sleep(5000);
		WebElement line1 = driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31964"));
		line1.click();
		Select l1 = new Select(line1);
		l1.selectByIndex(12);
		Thread.sleep(2000);*/
		getElement(prop.getProperty("btnNext1stScreen")).click();
		// 2nd tab
		waitForElement(prop.getProperty("drpCoverType"));
		// Thread.sleep(2000);
		WebElement cType = getElement(prop.getProperty("drpCoverType"));
		Select coverType = new Select(cType);
		coverType.selectByVisibleText("Guest House");
		Thread.sleep(1000);
		getElement(prop.getProperty("fldPremises")).sendKeys("5");
		getElement(prop.getProperty("fldElseWhere")).sendKeys("5");
		driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31924")).sendKeys(postcode);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#C1__C1__BUT_BA23D49FD83824B32484")).click();
		Thread.sleep(4000);
		WebElement tab2 = driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31964"));
		tab2.click();
		Select l2 = new Select(tab2);
		l2.selectByIndex(12);
		Thread.sleep(3000);
		getElement(prop.getProperty("btnNext2ndScreen")).click();
		if((env.equals("red1")) ||(env.equals("yellow"))){
			Thread.sleep(3000);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31924")).clear();
			driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31924")).sendKeys("LA1 1LA");
			driver.findElement(By.cssSelector("#C1__C1__QUE_4ABA2D83CE3F6B8189114")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_GENDETS_1_T")).click();
			//getElement(prop.getProperty("btnNext2ndScreen")).click();
		}
		// 3rd tab
		Thread.sleep(2000);
		getElement(prop.getProperty("chkStateOfRepair")).click();
		getElement(prop.getProperty("fldAgeOfBuilding")).sendKeys("2010");
		getElement(prop.getProperty("chkWalls")).click();
		getElement(prop.getProperty("chkRoofs")).click();
		Thread.sleep(4000);
		getElement(prop.getProperty("btnBack3rdScreen")).click();
		Thread.sleep(3000);
		getElement(prop.getProperty("btnBack2ndScreen")).click();
		Thread.sleep(4000);
		getElement(prop.getProperty("fldPostCode")).clear();
		getElement(prop.getProperty("fldPostCode")).sendKeys(postcode);
		getElement(prop.getProperty("fldCounty")).click();
		Thread.sleep(2000);
		getElement(prop.getProperty("btnNext1stScreen")).click();
		Thread.sleep(5000);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(3000);
		getElement(prop.getProperty("fldPostCode")).clear();
		getElement(prop.getProperty("fldPostCode")).sendKeys(postcode);
		getElement(prop.getProperty("fldCounty")).click();
		getElement(prop.getProperty("btnNext2ndScreen")).click();
		Thread.sleep(2000);
		getElement(prop.getProperty("chkStateOfRepair")).click();
		getElement(prop.getProperty("fldAgeOfBuilding")).sendKeys("2010");
		getElement(prop.getProperty("chkWalls")).click();
		getElement(prop.getProperty("chkRoofs")).click();
		Thread.sleep(2000);
		getElement(prop.getProperty("btnNext3rdScreen")).click();
		// 4th tab
		Thread.sleep(2000);
		getElement(prop.getProperty("btnNext4thScreen")).click();
		// 5th tab
		Thread.sleep(2000);
		UtilityMethods.selectByVisibleText(driver, prop.getProperty("drpStateOfSite"), "Gently sloping");
		UtilityMethods.selectByVisibleText(driver, prop.getProperty("drpFoundation"), "Piled foundations");
		getElement(prop.getProperty("chkWaterCourse")).click();
		getElement(prop.getProperty("chkCliffs")).click();
		getElement(prop.getProperty("btnNext5thScreen")).click();
		// 6th tab
		Thread.sleep(2000);
		getElement(prop.getProperty("btnNext6thScreen")).click();
		Thread.sleep(2000);
		// 7th tab
		getElement(prop.getProperty("btnNext7thScreen")).click();
		Thread.sleep(2000);
		// 8th tab
		getElement(prop.getProperty("fldTurnOver")).sendKeys("300000");
		getElement(prop.getProperty("fldBedRooms")).sendKeys("5");
		getElement(prop.getProperty("btnNext8thScreen")).click();
		Thread.sleep(2000);
		// 9th Tab
		getElement(prop.getProperty("fldTotalWine")).sendKeys("2000");
		getElement(prop.getProperty("fldTotalComputer")).sendKeys("2000");
		getElement(prop.getProperty("fldFrozenFood")).sendKeys("5000");
		getElement(prop.getProperty("btnNext9thScreen")).click();
		Thread.sleep(2000);
		// 10th tab
		getElement(prop.getProperty("fldINCCIT")).sendKeys("150000");
		getElement(prop.getProperty("fldINCCIS")).sendKeys("2000");
		getElement(prop.getProperty("fldModelSafe")).sendKeys("5000");
		getElement(prop.getProperty("btnNext10thScreen")).click();
		Thread.sleep(2000);
		// 11th tab

	/*	getElement(prop.getProperty("fldHHBuildings")).sendKeys("100000");
		getElement(prop.getProperty("fldContent")).sendKeys("70000");*/
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
		Thread.sleep(80000);

		
		   action.sendKeys(Keys.PAGE_DOWN).build().perform();
		 waitForElement(prop.getProperty("drpAddOnSection"));
		  getElement(prop.getProperty("drpAddOnSection")).click();
		  Thread.sleep(2000);
		  getElement(prop.getProperty("btnAddAddOn")).click();
		  Thread.sleep(4000);
		/*  action.sendKeys(Keys.PAGE_DOWN).build().perform();
		  action.sendKeys(Keys.PAGE_DOWN).build().perform();
		  getElement(prop.getProperty("btnAddAddOn")).click();*/
		  action.sendKeys(Keys.PAGE_UP).build().perform(); Thread.sleep(2000);
		  action.sendKeys(Keys.PAGE_UP).build().perform(); Thread.sleep(4000);
		  screenShot(driver, "QuoteDisplay-Add-On included_1");
		  action.sendKeys(Keys.PAGE_UP).build().perform();
		  action.sendKeys(Keys.PAGE_DOWN).build().perform(); screenShot(driver,
		  "QuoteDisplay-Add-On included_2");
		  action.sendKeys(Keys.PAGE_UP).build().perform(); Thread.sleep(2000);
		 
		getElement(prop.getProperty("btnSave")).click();
		
		
		
		
		
		
		

		// SOC Screen ***************

		String coverFromDateTime = getElement(prop.getProperty("lblcoverFromDateTime")).getText();
		String coverEndDateTime = getElement(prop.getProperty("lblcoverEndDateTime")).getText();
		screenShot(driver, "SOC");
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		screenShot(driver, "SOC_1_");
		getElement(prop.getProperty("btnConfirm")).click();
		Thread.sleep(3000);
		
		  Alert alert1 = driver.switchTo().alert(); alert1.accept();
		  driver.switchTo().defaultContent();
		 
		String PolicyNum = driver.findElement(By.xpath("//*[@id=\"secure_TransactionConfirmation\"]/div[2]/div/h4"))
				.getText();
		// String PolicyNum =
		// driver.findElement(By.xpath("//*[@id='ctl00_cntMainBody_lblPageheader']")).getText();

		String[] pol = PolicyNum.split(" ");
		PolNum = pol[9];
		dynamicHashMap = new HashMap<String, String>();
		dynamicHashMap.put(Pol1, PolNum);
		System.out.println("Policy Number is : " + " " + dynamicHashMap.get(Pol1) + "   " + "CoverFromDateTime   "
				+ coverFromDateTime + "  CoverEndDateTime is  " + coverEndDateTime);
		screenShot(driver, "TransactionConfirmation");
		//driver.findElement(By.id("linkinfoSection")).click();
		Thread.sleep(2000);
		// driver.findElement(By.id("ctl00_SideInfo_ClientInfoCtrl_hypCompanyName")).click();
		//driver.findElement(By.id("ctl00_SideInfo_ClientInfoCtrl_hypClientName")).click();
	}

	public void searchTransactions() throws InterruptedException {

		getElement(prop.getProperty("lnkFinance")).click();
		getElement(prop.getProperty("lnkTransactions")).click();
		getElement(prop.getProperty("tabReference")).click();
		getElement(prop.getProperty("fldPolicyNumber")).sendKeys(dynamicHashMap.get(Pol1));
		getElement(prop.getProperty("btnFind")).click();
		Thread.sleep(5000);
		screenShot(driver, "SearchTransactions");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		screenShot(driver, "SearchTransactions_1");

	}

	
	public static void main(String args[]) throws InterruptedException {

		T1 t1 = new T1();
		t1.newBusiness();
		t1.searchTransactions();
		MTA m = new MTA();
		try {
			m.mtaByPolNum();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
