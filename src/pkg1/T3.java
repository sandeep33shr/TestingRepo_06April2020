package pkg1;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class T3 {
	public static WebDriver driver = null;
	public static Map<String, String> dynamicHashMap = null;
	public static String PolNum = null;
	public static String Pol1 = null;
	public static String SA = "no";
	public static String browser = "chrome";
	public static String PCWorking = "yes";
	public static String scheme = "manual";
	public static String clientcode = "SHARMAs003";
	public static String coverStartDate = "02/07/2020";
	public static String coverStartTime = "10:30:06";                                       
	public static String dynamicDate = "no";
	public static String paynow = "yes";
	public static String partPayment = "yes";	
	public static String partAmount = "200";
	public static Properties prop = null;
	public static FileInputStream fis;
	public static String env = "blue";

	/*
	 * {
	 * 
	 * prop = new Properties();
	 * 
	 * try { fis = new FileInputStream(System.getProperty("user.dir") +
	 * "\\Properties_new.properties"); } catch (FileNotFoundException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } try { prop.load(fis); }
	 * catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

	public T3() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\Properties_new.properties");
			prop.load(fis);

		} catch (FileNotFoundException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) { // TODO Auto-generated catch block
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

	public static void waitForElementToBeClickable(String locator) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));

	}

	public void newBusiness() throws InterruptedException {
		String path = System.getProperty("user.dir");

		if (browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver", path + "//IEdriver//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", path + "//ChromeDriver//chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		
		
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		if (env.equals("yellow")) {
			driver.get(prop.getProperty("SITyellowURL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.id("username")).sendKeys("admin@yellowinsurance.com");
		} else if (env.equals("red")) {
			driver.get(prop.getProperty("SITredUrl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.id("username")).sendKeys("admin@redinsurance.com");		} else if (env.equals("red1")) {
			driver.get(prop.getProperty("SITurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.id("username")).sendKeys("admin@systest.com");
			driver.findElement(By.id("password")).sendKeys("Password@2020");
		} else if (env.equals("red2")) {
			driver.get(prop.getProperty("SITredUrl2"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.id("username")).sendKeys("SSPadmin1@redinsurance.com");
			driver.findElement(By.id("password")).sendKeys("Password@2020");
		} else if (env.equals("blue")) {
			driver.get(prop.getProperty("Dev2URL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.id("username")).sendKeys("admin@blueinsurance.com");
		} else if (env.equals("vm31")) {
			driver.get(prop.getProperty("vm31URL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			if (browser.equals("IE")) {
				driver.findElement(By.id("overridelink")).click();
				Thread.sleep(1000);
			}
			/*driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys("admin@blueinsurance.com");*/
		} else {
			driver.get(prop.getProperty("Dev2URL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.id("username")).sendKeys("subagent@blueinsurance.com");
		}
		if ((!env.equals("red1") && (!env.equals("red2")))) {
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("Password@2018");
		}

		driver.findElement(By.cssSelector("#loginModal > div > div > div.card-footer > button")).click();
		getElement(prop.getProperty("fldClientCode")).sendKeys(clientcode);
		driver.findElement(By.xpath(prop.getProperty("btnSearch_X"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("btnSelect_X"))).click();
		for (int i = 0; i <= 10; i++) {
			UtilityMethods.selectByVisibleText(driver, "#ctl00_cntMainBody_ctrlNewQuoteImproved_ddlProductlst",
					"HIUA Phase 1 GLU");
			driver.findElement(By.xpath(prop.getProperty("btnNewQuote_X"))).click();
			// New Business
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_UP).build().perform();

			UtilityMethods.selectByIndex(driver, "select#ctl00_cntMainBody_POLICYHEADER__BRANCH", 0);
			action.sendKeys(Keys.TAB).build().perform();
			
			try {
				UtilityMethods.selectByIndex(driver, "select#ctl00_cntMainBody_POLICYHEADER__BUSINESSTYPE", 1);
			} catch (StaleElementReferenceException e) {
				UtilityMethods.selectByIndex(driver, "select#ctl00_cntMainBody_POLICYHEADER__BUSINESSTYPE", 1);
			}
			/*
			 * UtilityMethods.selectByIndex(driver,
			 * "#ctl00_cntMainBody_POLICYHEADER__DEPARTMENT", 2);
			 * UtilityMethods.selectByIndex(driver,
			 * "#ctl00_cntMainBody_ddlPolicyHeaderSubTeam", 1);
			 * UtilityMethods.selectByIndex(driver,
			 * "#ctl00_cntMainBody_POLICYHEADER__ANALYSISCODE", 2);
			 */
			if (!env.equals("sa") && (SA.equalsIgnoreCase("yes"))) {
				UtilityMethods.selectByIndex(driver, "#ctl00_cntMainBody_ddlThirdParty", 1);
			}else{
				UtilityMethods.selectByIndex(driver, "#ctl00_cntMainBody_ddlThirdParty", 0);
			}
			if (env.equals("red1")) {
				driver.findElement(By.cssSelector("#ctl00_cntMainBody_btnHandler")).click();
				driver.switchTo().frame("TB_iframeContent");
				driver.findElement(By.id("ctl01_cntMainBody_btnSearch")).click();
				driver.findElement(By.cssSelector("#ctl01_cntMainBody_grdvSearchResults_ctl03_btnSelect")).click();
				driver.switchTo().defaultContent();
				Thread.sleep(2000);
			}

			if (dynamicDate.equals("yes")) {
				driver.findElement(By.cssSelector(prop.getProperty("fldCoverStartDate"))).clear();
				driver.findElement(By.cssSelector(prop.getProperty("fldCoverStartDate"))).sendKeys(coverStartDate);

				/*
				 * driver.findElement(By.cssSelector(prop.getProperty("fldCoverStartTime"))).
				 * clear();
				 * driver.findElement(By.cssSelector(prop.getProperty("fldCoverStartTime"))).
				 * sendKeys(coverStartTime);
				 */
			}
	

			action.sendKeys(Keys.PAGE_UP).build().perform();
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			action.sendKeys(Keys.PAGE_UP).build().perform();
			Thread.sleep(1000);
			driver.findElement(By.xpath(prop.getProperty("tabCompliance_X"))).click();
			// Compliance screen
			UtilityMethods.selectByVisibleText(driver, "#ctl00_cntMainBody_TYPE_OF_SALE", "Advised");
			UtilityMethods.selectByVisibleText(driver, "#ctl00_cntMainBody_METHOD_OF_SALE", "Non Distance");
			UtilityMethods.selectByIndex(driver, prop.getProperty("drpUnderwriter"), 2);
			UtilityMethods.selectByVisibleText(driver, "#ctl00_cntMainBody_ddlTermsAgreed", "No");
			driver.findElement(By.id(prop.getProperty("btnNextCompliance_ID"))).click();

			// DATA CAPTURE SCREEN

			driver.switchTo().frame("dqjIframe");
			driver.switchTo().frame("QMIframe");

			// 1st tab General Details

			getElement(prop.getProperty("fldTradingName")).sendKeys("Sandeep");

			getElement(prop.getProperty("fldContactName")).sendKeys("Sandeep");
			UtilityMethods.selectByVisibleText(driver, prop.getProperty("drpCompStatus"), "Limited Company (LTD)");
			getElement(prop.getProperty("fldTurnOver_GD")).sendKeys("100000");
			getElement(prop.getProperty("btnNext1stScreen")).click();
			Thread.sleep(3000);

			// 2nd tab Policy Cover..................
			getElement(prop.getProperty("radiobtnBuilding")).click();
			getElement(prop.getProperty("radiobtnContent")).click();
			Thread.sleep(2000);
			UtilityMethods.selectByIndex(driver, prop.getProperty("drpCountry"), 1);
			// Thread.sleep(2000);
			driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31924")).sendKeys("B37 7ye");
			// Thread.sleep(2000);

			if (PCWorking.equals("yes")) {
				driver.findElement(By.cssSelector("#C1__C1__BUT_BA23D49FD83824B32484")).click();
				Thread.sleep(5000);
				WebElement tab2 = driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31964"));
				tab2.click();
				Select l2 = new Select(tab2);
				l2.selectByIndex(12);
			} else {

				T3.waitForElementToBeClickable(prop.getProperty("fldAddressLine1"));
				getElement(prop.getProperty("fldAddressLine1")).sendKeys("KingsCourt");
				Thread.sleep(2000);
				getElement(prop.getProperty("fldAddressLine2")).sendKeys("BusinessPark");
				Thread.sleep(1000);
				getElement(prop.getProperty("fldAddressLine3")).sendKeys("Birmingham");
				getElement(prop.getProperty("fldCounty")).sendKeys("Warwickshire");
			}
			// Thread.sleep(3000);
			getElement(prop.getProperty("radiobtnRepair")).click();
			Thread.sleep(1000);
			getElement(prop.getProperty("fldAgeOfBuilding")).sendKeys("2010");
			Thread.sleep(1000);
			getElement(prop.getProperty("fldPremises")).sendKeys("5");
			Thread.sleep(1000);
			getElement(prop.getProperty("fldElseWhere")).sendKeys("5");
			getElement(prop.getProperty("btnNext2ndScreen")).click();
			Thread.sleep(2000);
			if (PCWorking.equals("yes")) {
				action.sendKeys(Keys.PAGE_DOWN).build().perform();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31924")).clear();
				driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31924")).sendKeys("B37 7YE");
				driver.findElement(By.cssSelector("#C1__C1__QUE_4ABA2D83CE3F6B8189114")).click();
				Thread.sleep(2000);
				getElement(prop.getProperty("btnNext2ndScreen")).click();
			}

			// 3rd tab Building construction

			Thread.sleep(1000);
			getElement(prop.getProperty("chkWalls")).click();
			Thread.sleep(1000);
			getElement(prop.getProperty("chkRoofs")).click();
			Thread.sleep(2000);
			getElement(prop.getProperty("btnNext3rdScreen")).click();
			// 4th tab Premises Equipment
			Thread.sleep(2000);
			getElement(prop.getProperty("btnNext6thScreen")).click();
			// 5th tab-Additional Info
			Thread.sleep(2000);
			getElement(prop.getProperty("fldBedRooms")).sendKeys("5");
			getElement(prop.getProperty("btnNext8thScreen")).click();
			// 6th tab - SUm Insured
			Thread.sleep(2000);
			getElement(prop.getProperty("fldGHBuildings")).sendKeys("100000");
			UtilityMethods.selectByIndex(driver, prop.getProperty("drpGHContent"), 2);
			/*
			 * getElement(prop.getProperty("chkContentLimit")).click(); Thread.sleep(2000);
			 */
			getElement(prop.getProperty("fldTotalWine")).sendKeys("2000");
			getElement(prop.getProperty("fldTotalComputer")).sendKeys("2000");
			/*
			 * getElement(prop.getProperty("chkFrozenFood")).click(); Thread.sleep(2000);
			 */
			getElement(prop.getProperty("fldFrozenFood")).sendKeys("5000");
			/*
			 * getElement(prop.getProperty("chkCashLimit")).click(); Thread.sleep(2000);
			 */
			getElement(prop.getProperty("fldINCCIT")).sendKeys("150000");
			getElement(prop.getProperty("fldINCCIS")).sendKeys("2000");
			getElement(prop.getProperty("fldModelSafe")).sendKeys("5000");
			Thread.sleep(2000);
			getElement(prop.getProperty("btnNext9thScreen")).click();
			Thread.sleep(3000);
			// 7th tab
			getElement(prop.getProperty("btnNext16thScreen")).click();

			// Quote Manager Page**************

			Thread.sleep(20000);
			if(scheme.equalsIgnoreCase("manual")){
				List<WebElement> schemeName= driver.findElements(By.cssSelector("#C1__TBL_CE78B7D13414C653635890 td:nth-child(2)"));
				ProjectMethods.clickElementBasedOnText(driver, schemeName, "Demo Manual");
				Thread.sleep(6000);
				getElement(prop.getProperty("btnManualQuote")).click();
				Thread.sleep(3000);
				getElement(prop.getProperty("fldGrossPremium")).clear();
				getElement(prop.getProperty("fldGrossPremium")).sendKeys("500");
				action.sendKeys(Keys.TAB).build().perform();
				Thread.sleep(1500);
				getElement(prop.getProperty("fldManualPolicyNumber")).sendKeys("MQB001");
				getElement(prop.getProperty("btnCalculate")).click();
				Thread.sleep(3000);
				getElement(prop.getProperty("btnSaveOverride")).click();
				Thread.sleep(8000);
				
			}
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			
			getElement(prop.getProperty("drpAddOnSection")).click();
			Thread.sleep(2000);
			/*List<WebElement> a = driver.findElements(By.className("addon-label"));
			for (WebElement name1 : a) {
				String b = name1.getText();
				boolean isBlank;
				isBlank = (b == null || b.length() == 0);
				if (isBlank == false) {
					System.out.println(b);

					if (b.equalsIgnoreCase("KeyCare Cover")) {
						getElement(prop.getProperty("btnAddAddOnKeyCare")).click();
						break;
					} else if (b.equalsIgnoreCase("Excess Protection (Strategic-XS Protection)")) {
						getElement(prop.getProperty("btnAddAddOnExcess")).click();
						break;
					} else if (b.equalsIgnoreCase("MTA ADDON")) {
						getElement(prop.getProperty("btnAddMTAAddon")).click();
						break;
					} else if (b.equalsIgnoreCase("Testaddon2")) {
						getElement(prop.getProperty("btnAddTestAddOn2")).click();
						break;
					} else {
						getElement(prop.getProperty("btnAddonNext")).click();
					}
				}
			}*/
			/*
			 * for(WebElement name:a) { System.out.println(name.getText());
			 * if(name.getText().equalsIgnoreCase("KeyCare Cover")) {
			 * getElement(prop.getProperty("btnAddAddOnKeyCare")).click(); break; }else
			 * if(name.getText().
			 * equalsIgnoreCase("Excess Protection (Strategic-XS Protection)")) {
			 * getElement(prop.getProperty("btnAddAddOnExcess")).click(); break; }else
			 * if(name.getText().equalsIgnoreCase("MTA ADDON")) {
			 * getElement(prop.getProperty("btnAddMTAAddon")).click(); break; }else {
			 * getElement(prop.getProperty("btnAddonNext")).click(); } }
			 */

			
			  getElement(prop.getProperty("btnAddKeyCare")).click(); Thread.sleep(4000);
			  driver.findElement(By.tagName("body")).sendKeys(Keys.HOME);
			  action.sendKeys(Keys.PAGE_DOWN).build().perform();
			  
			  if(SA.equalsIgnoreCase("yes")){
				  getElement(prop.getProperty("btnEditTPComm")).click(); Thread.sleep(4000);
				  getElement(prop.getProperty("fldCommAmount")).clear();
				  getElement(prop.getProperty("fldCommAmount")).sendKeys("6");
				  action.sendKeys(Keys.TAB).build().perform();
				  Thread.sleep(2000);
				  getElement(prop.getProperty("btnSaveTPComm")).click();
				  
			  }
			 
			  		 
			/*try {
			getElement(prop.getProperty("btnAddKeyCare")).click();
			}catch(ElementNotVisibleException e) {
						
				getElement(prop.getProperty("btnAddMTAAddon")).click();
			}
			Thread.sleep(4000);
			  driver.findElement(By.tagName("body")).sendKeys(Keys.HOME);
			  action.sendKeys(Keys.PAGE_DOWN).build().perform();*/
				Thread.sleep(4000);

			getElement(prop.getProperty("btnSave")).click();

			// SOC Screen ***************

			String coverFromDateTime = getElement(prop.getProperty("lblcoverFromDateTime")).getText();
			String coverEndDateTime = getElement(prop.getProperty("lblcoverEndDateTime")).getText();
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			screenShot(driver, "SOC_1_");

			if (paynow.equals("yes")) {
				getElement(prop.getProperty("rdoPaynow")).click();
				getElement(prop.getProperty("btnConfirm")).click();
				UtilityMethods.selectByVisibleText(driver, prop.getProperty("drpMediatype"), "Cash");
				UtilityMethods.selectByIndex(driver, prop.getProperty("drpBank"), 2);

				if (partPayment.equals("yes")) {
					getElement(prop.getProperty("fldAmount")).click();
					getElement(prop.getProperty("fldAmount")).clear();
					getElement(prop.getProperty("fldAmount")).sendKeys(Keys.CONTROL + "a");
					getElement(prop.getProperty("fldAmount")).sendKeys(Keys.DELETE);
					getElement(prop.getProperty("fldAmount")).sendKeys(partAmount);
					screenShot(driver, "partPayment");

				}
				getElement(prop.getProperty("btnOK")).click();

			} else {
				getElement(prop.getProperty("btnConfirm")).click();
			}

			Thread.sleep(3000);

			boolean aleartpresent = UtilityMethods.isAlertPresent(driver);
			if (aleartpresent == true) {

				Alert alert1 = driver.switchTo().alert();
				alert1.accept();
				driver.switchTo().defaultContent();

			}
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
			driver.findElement(By.id("linkinfoSection")).click();
			Thread.sleep(2000);
			// driver.findElement(By.id("ctl00_SideInfo_ClientInfoCtrl_hypCompanyName")).click();
			driver.findElement(By.id("ctl00_SideInfo_ClientInfoCtrl_hypClientName")).click();
		}
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

		T3 t3 = new T3();
		t3.newBusiness();
		t3.searchTransactions();
		T3_MTA m = new T3_MTA();
		try {
			m.mtaByPolNum();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
