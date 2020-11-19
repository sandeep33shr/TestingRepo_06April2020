package pkg1;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
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

public class RubyGH {

	public static WebDriver driver = null;
	public static Map<String, String> dynamicHashMap = null;
	public static String PolNum = null;
	public static String Pol1 = null;
	public static String coverStartDate = "25/04/2020";
	public static String coverStartTime = "10:30:06";
	public static Properties prop = null;
	public static FileInputStream fis;
	public static String mTAcoverStartDate = "25/04/2020";
	public static String mTAcoverStartTime = "18:30:06";
	public static String polnum = "AFG_GH_000057";
	public static String status = "Current";
	public static String buildSI="150000";
	public static String contentSI = "20000";
	public static int index=6;
	public static String postcode = "BA27PB";
	//public static String product = "Guest Houses";
	public static String product="Holiday Homes Group";
	//public static String product="Staff Accomodation";
	{

		prop = new Properties();

		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\RubyGH.properties");
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

	public void newBusiness() throws InterruptedException {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "//ChromeDriver//chromedriver.exe");
		driver = new ChromeDriver();
		/*
		 * System.setProperty("webdriver.ie.driver", path +
		 * "//IEdriver//IEDriverServer.exe"); driver = new InternetExplorerDriver();
		 */
		driver.get(prop.getProperty("rubyURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("admin@rubyinsurance.com");
		driver.findElement(By.id("password")).sendKeys("Password@2018");
		driver.findElement(By.cssSelector("#loginModal > div > div > div.card-footer > button")).click();
		getElement(prop.getProperty("fldClientCode")).sendKeys("tech");
		driver.findElement(By.xpath(prop.getProperty("btnSearch_X"))).click();
		driver.findElement(By.xpath(prop.getProperty("btnSelect_X"))).click();
		UtilityMethods.selectByVisibleText(driver, "#ctl00_cntMainBody_ctrlNewQuoteImproved_ddlProductlst", product);
		driver.findElement(By.xpath(prop.getProperty("btnNewQuote_X"))).click();
		// New Business
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_UP).build().perform();
		// UtilityMethods.selectByIndex(driver,
		// "#ctl00_cntMainBody_POLICYHEADER__ANALYSISCODE", 0);
		// UtilityMethods.selectByIndex(driver,
		// "select#ctl00_cntMainBody_POLICYHEADER__BRANCH", 1);
		// UtilityMethods.selectByVisibleText(driver,
		// prop.getProperty("drpBusinessType"), "Direct Business");
		// UtilityMethods.selectByIndex(driver,
		// "#ctl00_cntMainBody_POLICYHEADER__ANALYSISCODE", 2);
		
		UtilityMethods.selectByIndex(driver, "#ctl00_cntMainBody_ddlThirdParty", 1);

		
		/*  driver.findElement(By.cssSelector(prop.getProperty("fldCoverStartDate"))).
		  clear();
		  driver.findElement(By.cssSelector(prop.getProperty("fldCoverStartDate"))).
		  sendKeys(coverStartDate);*/
		  
		/*  driver.findElement(By.cssSelector(prop.getProperty("fldCoverStartTime"))).
		  clear();
		  driver.findElement(By.cssSelector(prop.getProperty("fldCoverStartTime"))).
		  sendKeys(coverStartTime);*/
		 

		/*
		 * WebElement frequency = driver.findElement(By.cssSelector(
		 * "#ctl00_cntMainBody_POLICYHEADER__FREQUENCY")); frequency.click(); Select
		 * freq = new Select(frequency); freq.selectByVisibleText("Biannually");
		 * action.sendKeys(Keys.TAB).build().perform();
		 * 
		 * action.sendKeys(Keys.PAGE_UP).build().perform();
		 */
		/*
		 * screenShot(driver, "PolicyHeader");
		 * action.sendKeys(Keys.PAGE_DOWN).build().perform(); screenShot(driver,
		 * "PolicyHeaderDown"); action.sendKeys(Keys.PAGE_UP).build().perform();
		 */
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("tabCompliance_X"))).click();
		// Compliance screen
		UtilityMethods.selectByVisibleText(driver, "#ctl00_cntMainBody_TYPE_OF_SALE", "Advised");
		UtilityMethods.selectByVisibleText(driver, "#ctl00_cntMainBody_METHOD_OF_SALE", "Non Distance");
		driver.findElement(By.id("ctl00_cntMainBody_txtUnderwriter")).sendKeys("Argenta");
		UtilityMethods.selectByVisibleText(driver, "#ctl00_cntMainBody_ddlTermsAgreed", "No");
		driver.findElement(By.id(prop.getProperty("btnNextCompliance_ID"))).click();

		// DATA CAPTURE SCREEN

		driver.switchTo().frame("dqjIframe");
		driver.switchTo().frame("QMIframe");

		// 1st tab
		getElement(prop.getProperty("fldInsured")).sendKeys("Sandeep");
		getElement(prop.getProperty("fldTradingName")).sendKeys("Sandeep");
		getElement(prop.getProperty("fldContactName")).sendKeys("Sandeep");

		UtilityMethods.selectByVisibleText(driver, prop.getProperty("drpCompStatus"), "Limited Company (LTD)");
		if (!product.equals("Staff Accomodation")) {
		getElement(prop.getProperty("chkCumbria")).click();
		}
		getElement(prop.getProperty("chkERN")).click();
		Thread.sleep(2000);
		getElement(prop.getProperty("fldPostCode")).sendKeys(postcode);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#C1__C1__BUT_BA23D49FD83824B32484")).click();
		Thread.sleep(4000);
		WebElement line1 = driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31964"));
		line1.click();
		Select l1 = new Select(line1);
		l1.selectByIndex(1);
		Thread.sleep(2000);
		UtilityMethods.selectByIndex(driver, prop.getProperty("drpCurrentInsurer"), 1);
		getElement(prop.getProperty("fldTurnOverAmount")).sendKeys("25000");
		getElement(prop.getProperty("btnNext1stScreen")).click();
		// 2nd tab
		Thread.sleep(2000);
		getElement(prop.getProperty("btnContinue2ndScreen")).click();
		// 3rd tab
		Thread.sleep(10000);
		getElement(prop.getProperty("btnContinue3rdScreen")).click();
		// 4th tab
		Thread.sleep(2000);
		if (product.equals("Holiday Homes Group")) {
			UtilityMethods.selectByIndex(driver, prop.getProperty("drpHomeUsed"), 1);
		}
		getElement(prop.getProperty("chkTerrorism")).click();
		getElement(prop.getProperty("fldPostCode")).sendKeys(postcode);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#C1__C1__BUT_BA23D49FD83824B32484")).click();
		Thread.sleep(3000);
		WebElement line2 = driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31964"));
		line2.click();
		Select l2 = new Select(line2);
		l2.selectByIndex(1);
		Thread.sleep(2000);
		if (product.equals("Guest Houses")) {
			UtilityMethods.selectByIndex(driver, prop.getProperty("drpStateOfRepair"), 1);
			getElement(prop.getProperty("fldYOC")).sendKeys("1950");
		}
		getElement(prop.getProperty("fldElseWhere")).sendKeys("10");
		getElement(prop.getProperty("fldThisPremise")).sendKeys("10");
		getElement(prop.getProperty("btnContinue4thScreen")).click();
		// 5th tab
		Thread.sleep(4000);
		getElement(prop.getProperty("chkExposeTimbler")).click();
		Thread.sleep(2000);
		getElement(prop.getProperty("btnBack5thScreen")).click();
		getElement(prop.getProperty("btnBack4thScreen")).click();
		getElement(prop.getProperty("btnBack3rdScreen")).click();
		getElement(prop.getProperty("btnBack2ndScreen")).click();

		Thread.sleep(2000);
		getElement(prop.getProperty("fldPostCode")).sendKeys(postcode);
		getElement(prop.getProperty("fldCounty")).click();
		getElement(prop.getProperty("btnNext1stScreen")).click();
		Thread.sleep(2000);
		getElement(prop.getProperty("btnContinue2ndScreen")).click();
		Thread.sleep(12000);
		getElement(prop.getProperty("btnContinue3rdScreen")).click();
		Thread.sleep(2000);
		getElement(prop.getProperty("fldPostCode")).sendKeys(postcode);
		getElement(prop.getProperty("fldCounty")).click();
		Thread.sleep(1000);
		getElement(prop.getProperty("btnContinue4thScreen")).click();
		Thread.sleep(2000);
		if ((product.equals("Holiday Homes Group"))||product.equals("Staff Accomodation")) {
			UtilityMethods.selectByIndex(driver, prop.getProperty("drpStateOfRepair5th"), 2);
			getElement(prop.getProperty("fldYOC5th")).sendKeys("1950");

		}
		getElement(prop.getProperty("chkExposeTimbler")).click();
		getElement(prop.getProperty("btnContinue5thScreen")).click();
		// 6th tab
		Thread.sleep(3000);
		getElement(prop.getProperty("chkSubsudence")).click();
		Thread.sleep(3000);
		getElement(prop.getProperty("btnContinue6thScreen")).click();
		Thread.sleep(2000);
		// 7th tab
		if (product.equals("Guest Houses")) {
			getElement(prop.getProperty("chkResideOnPremise")).click();
		}		
		getElement(prop.getProperty("btnContinue7thScreen")).click();
		Thread.sleep(2000);
		
		// 8th tab
		if (product.equals("Guest Houses")) {
			getElement(prop.getProperty("chkMarquees")).click();
			getElement(prop.getProperty("chkFoodPreparation")).click();
			getElement(prop.getProperty("chkentertainment")).click();
			getElement(prop.getProperty("fldBedrooms")).sendKeys("10");
			getElement(prop.getProperty("btnContinue8thScreen")).click();
			Thread.sleep(2000);
		
		// 9th Tab
		
			getElement(prop.getProperty("fldBuilding")).sendKeys("250000");
			UtilityMethods.selectByIndex(driver, prop.getProperty("drpContent"), 5);
			getElement(prop.getProperty("fldTotalSpecified")).sendKeys("25000");
			if (product.equals("Guest Houses")) {
			getElement(prop.getProperty("chkPortablePossessions")).click();
			}
			Thread.sleep(2000);
			getElement(prop.getProperty("btnContinue9thScreen")).click();
			Thread.sleep(2000);
			// 10th tab

			getElement(prop.getProperty("chkCashLimit")).click();
			Thread.sleep(2000);
			getElement(prop.getProperty("btnContinue10thScreen")).click();
			Thread.sleep(2000);
		}

		// 11th screen
		if (product.equals("Holiday Homes Group")) {
			getElement(prop.getProperty("fldImprovements")).sendKeys("250000");
			getElement(prop.getProperty("fldContentSI")).sendKeys("100000");
			getElement(prop.getProperty("chkContent")).click();
			getElement(prop.getProperty("btnContinue11thScreen")).click();
		}
//12th screen
		if (product.equals("Staff Accomodation")){
			
			getElement(prop.getProperty("fldTenantsSI")).sendKeys("250000");
			getElement(prop.getProperty("fldLandlordSI")).sendKeys("25000");
			UtilityMethods.selectByIndex(driver, prop.getProperty("drpBusiness"), 2);
			getElement(prop.getProperty("chkDirectEmployement")).click();
			getElement(prop.getProperty("chkStandardExcess")).click();
			getElement(prop.getProperty("btnContinue12thScreen")).click();
		}
		// Quote Manager Page**************
		Thread.sleep(20000);

		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		  waitForElement(prop.getProperty("drpAddOnSection"));
		  getElement(prop.getProperty("drpAddOnSection")).click();
		  Thread.sleep(2000);
		  getElement(prop.getProperty("btnAddAddOn")).click();
		 
		action.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(2000);
		screenShot(driver, "QuoteDisplay-Add-On included_1");
		action.sendKeys(Keys.PAGE_UP).build().perform();
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		screenShot(driver, "QuoteDisplay-Add-On included_2");
		action.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(2000);

		getElement(prop.getProperty("btnSave")).click();

		// SOC Screen ***************

		String coverFromDateTime = getElement(prop.getProperty("lblcoverFromDateTime")).getText();
		String coverEndDateTime = getElement(prop.getProperty("lblcoverEndDateTime")).getText();
		screenShot(driver, "SOC");
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		screenShot(driver, "SOC_1_");
		getElement(prop.getProperty("btnConfirm")).click();
		Thread.sleep(7000);
		/*
		 * Alert alert1 = driver.switchTo().alert(); alert1.accept();
		 * driver.switchTo().defaultContent();
		 */
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
		// driver.findElement(By.id("linkinfoSection")).click();
		/*Thread.sleep(2000);
		// driver.findElement(By.id("ctl00_SideInfo_ClientInfoCtrl_hypCompanyName")).click();
		driver.findElement(By.id("ctl00_SideInfo_ClientInfoCtrl_hypClientName")).click();*/
		
		Thread.sleep(4000);
		driver.quit();
	}

	public void mtaByPolNumGH() throws InterruptedException, AWTException {

		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "//ChromeDriver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		/*
		 * System.setProperty("webdriver.ie.driver", path +
		 * "//IEdriver//IEDriverServer.exe"); driver = new InternetExplorerDriver();
		 */

		driver.get(prop.getProperty("rubyURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("admin@rubyinsurance.com");

		driver.findElement(By.id("password")).sendKeys("Password@2018");
		driver.findElement(By.cssSelector("#loginModal > div > div > div.card-footer > button")).click();
		driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtPolicyNumber")).sendKeys(dynamicHashMap.get(Pol1));
		driver.findElement(By.xpath("//a[@id='ctl00_cntMainBody_btnSearch']")).click();
		driver.findElement(By.xpath("//a[@id='ctl00_cntMainBody_grdvSearchResults_ctl02_lnkDetails']")).click();
		driver.findElement(By.cssSelector("a[href='#tabpolicies']")).click();
		driver.findElement(By.cssSelector("#ctl00_cntMainBody_ClientQuotesPolicies_txtPolicyNo")).sendKeys(dynamicHashMap.get(Pol1));
		driver.findElement(By.cssSelector("a#ctl00_cntMainBody_ClientQuotesPolicies_btnSearch")).click();
		// List<WebElement> QnP=
		// driver.findElements(By.cssSelector("#ctl00_cntMainBody_ClientQuotesPolicies_gvPolicyVersions
		// td:nth-child(7)"));
		List<WebElement> colStatus = driver.findElements(
				By.cssSelector("#ctl00_cntMainBody_ClientQuotesPolicies_gvPolicyVersions td:nth-child(9)"));
		// List<WebElement> pageLinks =
		// driver.findElements(By.cssSelector("#ctl00_cntMainBody_ClientQuotesPolicies_gvPolicyVersions
		// > div > a"));
		Thread.sleep(1000);
		// ProjectMethods.clickMTAVersion(driver, colStatus, pageLinks, status);
		ProjectMethods.clickElementBasedOnText(driver, colStatus, status);
		screenShot(driver, "mtaPolicyList");
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

		/*
		 * driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtEffectiveDate")).
		 * clear();
		 * driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtEffectiveDate")).
		 * sendKeys(mTAcoverStartDate);
		 */

		/*
		 * driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtEffectiveTime")).
		 * clear();
		 * driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtEffectiveTime")).
		 * sendKeys(mTAcoverStartTime);
		 */

		screenShot(driver, "MTAReason");
		driver.findElement(By.cssSelector("a#ctl00_cntMainBody_btnSubmit")).click();

		// DATA CAPTURE SCREEN

		driver.switchTo().frame("dqjIframe");
		driver.switchTo().frame("QMIframe");

		// 1st tab
		getElement(prop.getProperty("btnNext1stScreen")).click();
		// 2nd tab
		Thread.sleep(2000);
		getElement(prop.getProperty("btnContinue2ndScreen")).click();
		// 3rd tab
		Thread.sleep(10000);
		getElement(prop.getProperty("btnContinue3rdScreen")).click();
		// 4th tab
		Thread.sleep(2000);
		getElement(prop.getProperty("btnContinue4thScreen")).click();
		// 5th tab
		Thread.sleep(2000);
		getElement(prop.getProperty("btnContinue5thScreen")).click();
		// 6th tab
		Thread.sleep(2000);
		getElement(prop.getProperty("btnContinue6thScreen")).click();
		Thread.sleep(2000);
		// 7th tab
		getElement(prop.getProperty("btnContinue7thScreen")).click();
		Thread.sleep(2000);
		// 8th tab
		if (!product.equals("Staff Accomodation")) {
		getElement(prop.getProperty("btnContinue8thScreen")).click();
		Thread.sleep(2000);
		}
		// 9th Tab
		if (product.equals("Guest Houses")) {
		getElement(prop.getProperty("fldBuilding")).clear();
		getElement(prop.getProperty("fldBuilding")).sendKeys(buildSI);
		UtilityMethods.selectByIndex(driver, prop.getProperty("drpContent"), index);
		getElement(prop.getProperty("btnContinue9thScreen")).click();
		Thread.sleep(2000);
			
		// 10th tab
		getElement(prop.getProperty("btnContinue10thScreen")).click();
		Thread.sleep(2000);
		}
		//11th tab
		if (product.equals("Holiday Homes Group")) {
			getElement(prop.getProperty("fldImprovements")).clear();
			getElement(prop.getProperty("fldImprovements")).sendKeys(buildSI);
			getElement(prop.getProperty("fldContentSI")).clear();
			getElement(prop.getProperty("fldContentSI")).sendKeys(contentSI);
			getElement(prop.getProperty("chkContent")).click();
			getElement(prop.getProperty("btnContinue11thScreen")).click();
		}
		if (product.equals("Staff Accomodation")) {
			getElement(prop.getProperty("fldTenantsSI")).clear();
			getElement(prop.getProperty("fldTenantsSI")).sendKeys(buildSI);
			getElement(prop.getProperty("fldLandlordSI")).clear();
			getElement(prop.getProperty("fldLandlordSI")).sendKeys(contentSI);
			getElement(prop.getProperty("btnContinue12thScreen")).click();
		}
		// Quote Manager Page**************
		Thread.sleep(20000);
		Actions action =new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		/*
		 * waitForElement(prop.getProperty("drpAddOnSection"));
		 * getElement(prop.getProperty("drpAddOnSection")).click();
		 * getElement(prop.getProperty("btnAddAddOn")).click();
		 */
		action.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		screenShot(driver, "QuoteDisplay-Add-On included_2");
		action.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(2000);
		getElement(prop.getProperty("btnSave")).click();
		
		Thread.sleep(3000);

               // SOC Screen ***************

		getElement(prop.getProperty("btnConfirm")).click();
		Thread.sleep(4000);
		driver.quit();
	}
	
	public void renewalByPolNumGH() throws InterruptedException, AWTException {

		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "//ChromeDriver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		/*
		 * System.setProperty("webdriver.ie.driver", path +
		 * "//IEdriver//IEDriverServer.exe"); driver = new InternetExplorerDriver();
		 */

		driver.get(prop.getProperty("rubyURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("admin@rubyinsurance.com");

		driver.findElement(By.id("password")).sendKeys("Password@2018");
		driver.findElement(By.cssSelector("#loginModal > div > div > div.card-footer > button")).click();
		Thread.sleep(2000);
		getElement(prop.getProperty("lnkPolicy")).click();
		getElement(prop.getProperty("lnkRenewalSelection")).click();
		getElement(prop.getProperty("fldRef")).sendKeys(dynamicHashMap.get(Pol1));
	    getElement(prop.getProperty("btnFindSelection")).click();
	    Thread.sleep(2000);
	    getElement(prop.getProperty("lnkSelect")).click();
	    Thread.sleep(20000);
	    screenShot(driver,"RenewalSelection");
	    waitForElement("#ctl00_RibbonMenu_rptCategory_ctl02_RptCategorySpanText");
	    getElement(prop.getProperty("lnkPolicy")).click();
	    getElement(prop.getProperty("lnkRenewalManager")).click();
	    getElement(prop.getProperty("fldPolNum")).sendKeys(dynamicHashMap.get(Pol1));
	    getElement(prop.getProperty("btnFindRManager")).click();
	    getElement(prop.getProperty("lnkDetails")).click();
	    Thread.sleep(2000);
	    getElement(prop.getProperty("btnInvite")).click();
	    Thread.sleep(3000);
	    getElement(prop.getProperty("btnConfirm")).click();
	  

	    
	}

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		RubyGH obj = new RubyGH();
		try {
			 obj.newBusiness();
	     	obj.mtaByPolNumGH();
			obj.renewalByPolNumGH();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
