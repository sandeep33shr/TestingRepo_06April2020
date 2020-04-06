package pkg1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.Wait;

public class SQMProduct2 {

	
	public static void main(String[] args) throws InterruptedException {

		/*
		 * DesiredCapabilities cap = new DesiredCapabilities();
		 * cap.setBrowserName("chrome"); cap.setPlatform(Platform.WINDOWS);
		 */
		/*
		 * ChromeOptions options = new ChromeOptions(); options.merge(cap);
		 */

		/*
		 * String hubURL= "http://192.168.73.155/wd/hub"; // WebDriver driver = new
		 * RemoteWebDriver(new URL(hubURL),options); WebDriver driver = new
		 * RemoteWebDriver(cap);
		 */

		String path = System.getProperty("user.dir");
		// System.out.println(path);
		System.setProperty("webdriver.chrome.driver", path + "//ChromeDriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ssppureportal-devt.ssp-development.com/Pure.PortalDev2/login.aspx");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.findElement(By.id("signupEmail")).sendKeys("admin@blueinsurance.com");
		driver.findElement(By.id("signupPassword")).sendKeys("Password@2018");
		driver.findElement(By.id("login_button")).click();
		// Alert alert=driver.switchTo().alert();
		// alert.accept();
		// driver.switchTo().defaultContent();

		driver.findElement(By.id("ctl00_cntMainBody_txtClientCode")).sendKeys("sharmaqa");

		driver.findElement(By.xpath("//a[@id='ctl00_cntMainBody_btnSearch']")).click();

		driver.findElement(By.xpath("//a[@id='ctl00_cntMainBody_grdvSearchResults_ctl02_lnkDetails']")).click();

		for (int i = 0; i <= 3; i++) {
			WebElement prod = driver.findElement(By.id("ctl00_cntMainBody_ctrlNewQuoteImproved_ddlProductlst"));
			Select sel = new Select(prod);
			sel.selectByVisibleText("HIUA Phase 1 GLU");
			driver.findElement(By.xpath("//a[@id='ctl00_cntMainBody_ctrlNewQuoteImproved_btnNewQuote']")).click();

			// New Business

			// Policy Header screen
			/*
			 * driver.findElement(By.xpath("//a[@id='ctl00_cntMainBody_btnLeadInsurer']/i"))
			 * .click();
			 * 
			 * driver.switchTo().frame("TB_iframeContent");
			 * 
			 * driver.findElement(By.id("ctl01_cntMainBody_txtReinsurerCode")).sendKeys(
			 * "ABCTEC"); driver.findElement(By.id("ctl01_cntMainBody_btnSearch")).click();
			 * driver.findElement(By.id(
			 * "ctl01_cntMainBody_grdvSearchResults_ctl02_btnSelect")).click();
			 * driver.switchTo().defaultContent(); Thread.sleep(2000);
			 * 
			 * JavascriptExecutor jse = (JavascriptExecutor) driver;
			 * jse.executeScript("window.scrollBy(0,250)", "");
			 */

			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_UP).build().perform();
			/*
			 * WebElement BType =
			 * driver.findElement(By.id("ctl00_cntMainBody_POLICYHEADER__BUSINESSTYPE"));
			 * Select BT = new Select(BType); BT.selectByVisibleText("Direct Business");
			 */
			Thread.sleep(2000);

			/*
			 * WebElement TParty =
			 * driver.findElement(By.cssSelector("#ctl00_cntMainBody_ddlThirdParty"));
			 * TParty.click(); Select TP = new Select(TParty); TP.selectByIndex(2);
			 */

			/*
			 * driver.findElement(By.cssSelector(
			 * "#ctl00_cntMainBody_POLICYHEADER__COVERSTARTDATE")).clear();
			 * driver.findElement(By.cssSelector(
			 * "#ctl00_cntMainBody_POLICYHEADER__COVERSTARTDATE")) .sendKeys("04/12/2019");
			 * driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtCoverStartTime")).
			 * clear();
			 * driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtCoverStartTime")).
			 * sendKeys("10:30:06");
			 */

			/*
			 * WebElement frequency = driver.findElement(By.cssSelector(
			 * "#ctl00_cntMainBody_POLICYHEADER__FREQUENCY")); frequency.click(); Select
			 * freq = new Select(frequency); freq.selectByVisibleText("Biannually");
			 * action.sendKeys(Keys.TAB).build().perform();
			 */

			action.sendKeys(Keys.PAGE_UP).build().perform();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[text()='Compliance']")).click();

			// Compliance screen

			WebElement TOS = driver.findElement(By.id("ctl00_cntMainBody_TYPE_OF_SALE"));
			Select s1 = new Select(TOS);
			s1.selectByVisibleText("Advised");
			WebElement MOS = driver.findElement(By.id("ctl00_cntMainBody_METHOD_OF_SALE"));
			Select s2 = new Select(MOS);
			s2.selectByVisibleText("Non Distance");
			driver.findElement(By.id("ctl00_cntMainBody_txtUnderwriter")).sendKeys("UnderWriter");
			WebElement TA = driver.findElement(By.id("ctl00_cntMainBody_ddlTermsAgreed"));
			Select s3 = new Select(TA);
			s3.selectByVisibleText("No");
			driver.findElement(By.id("ctl00_cntMainBody_btnNext")).click();

			System.out.println("Title-->" + driver.getTitle());

			// DATA CAPTURE SCREEN

			driver.switchTo().frame("dqjIframe");
			driver.switchTo().frame("QMIframe");
			// 1st tab
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_0_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_INSURED"))
					.sendKeys("Sandeep");
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_0_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_TRADING_NAME"))
					.sendKeys("Sandeep");
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_0_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_TELEPHONE_NUM"))
					.sendKeys("1234567890");
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_0_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_CONTACT_NAME"))
					.sendKeys("Sandeep Sharma");
			WebElement CS = driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_0_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_COMPANY_STATUS"));
			Select s0 = new Select(CS);
			s0.selectByVisibleText("Limited Company (LTD)");
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_0_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_Component_ADDRESS_CNT_ADDRESS_LINE1"))
					.sendKeys("Line1");
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_0_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_Component_ADDRESS_CNT_ADDRESS_LINE2"))
					.sendKeys("Line2");
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_0_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_Component_ADDRESS_CNT_ADDRESS_LINE3"))
					.sendKeys("Line3");
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_0_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_Component_ADDRESS_CNT_ADDRESS_LINE4"))
					.sendKeys("Line4");
						driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_0_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_Component_ADDRESS_CNT_POSTCODE"))
					.sendKeys("LA1 1LA");
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_0_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_Component_ADDRESS_CNT_COUNTRYCODE"))
					.sendKeys("gbr");
			driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_0_T")).click();

			// 2nd tab

			Thread.sleep(2000);
			WebElement cType = driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_1_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_rISK_DETAILS_COVER_TYPE"));
			Select coverType = new Select(cType);
			coverType.selectByVisibleText("Guest House");
			Thread.sleep(1000);
			// action.sendKeys(Keys.TAB).build().perform();
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_1_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_AT_THIS_PREMISES"))
					.sendKeys("5");
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_1_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_ELSEWHERE"))
					.sendKeys("5");
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_1_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_rISK_DETAILS_Component_ADDRESS_CNT_ADDRESS_LINE1"))
					.sendKeys("Line1");
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_1_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_rISK_DETAILS_Component_ADDRESS_CNT_ADDRESS_LINE2"))
					.sendKeys("Line2");
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_1_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_rISK_DETAILS_Component_ADDRESS_CNT_ADDRESS_LINE3"))
					.sendKeys("Line3");
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_1_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_rISK_DETAILS_Component_ADDRESS_CNT_ADDRESS_LINE4"))
					.sendKeys("Line4");
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_1_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_rISK_DETAILS_Component_ADDRESS_CNT_POSTCODE"))
					.sendKeys("LA1 1LA");
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_1_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_rISK_DETAILS_Component_ADDRESS_CNT_COUNTRYCODE"))
					.sendKeys("gbr");
			driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_1_T")).click();
			// 3rd tab
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_2_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_GOOD_STATE_OF_rEPAIR_0"))
					.click();
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_2_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_AGE_OF_BUILDING"))
					.sendKeys("2010");
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_2_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_ARE_ALL_THE_WALLS_0"))
					.click();
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_2_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_ARE_ALL_rOOFS_0"))
					.click();
			driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_2_T")).click();
			// 4th tab
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_3_T")).click();
			// 5th tab
			Thread.sleep(2000);
			WebElement SOS = driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_4_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUBSIDENCE_ASSESSMENT_STATE_OF_SITE"));
			Select s4 = new Select(SOS);
			s4.selectByVisibleText("Gently sloping");

			WebElement foundation = driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_4_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUBSIDENCE_ASSESSMENT_FOUNDATIONS"));
			Select s5 = new Select(foundation);
			s5.selectByVisibleText("Piled foundations");
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_4_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUBSIDENCE_ASSESSMENT_WATERCOURSES_0"))
					.click();
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_4_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUBSIDENCE_ASSESSMENT_CLIFFS_0"))
					.click();
			driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_4_T")).click();
			// 6th tab
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_5_T")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_6_T")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_7_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_TURNOVER"))
					.sendKeys("2000");
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_7_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_LETTING_BEDROOMS"))
					.sendKeys("2");

			// 6A tab
			driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_7_T")).click();

			// 7th Tab

			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_8_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUMS_INSURED_GH_TOTAL_WINE"))
					.sendKeys("2000");
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_8_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUMS_INSURED_GH_TOTAL_COMPUTER"))
					.sendKeys("2000");
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_8_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUMS_INSURED_GH_FROZEN_FOOD"))
					.sendKeys("5000");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_8_T")).click();
			// 8th tab
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_9_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUMS_INSURED_GH_INCCIT"))
					.sendKeys("2000");
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_9_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUMS_INSURED_GH_INCCIS"))
					.sendKeys("2000");
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_9_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUMS_INSURED_GH_MAKE_MODEL_SAFE"))
					.sendKeys("5000");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_9_T")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_10_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUMS_INSURED_HH_BUILDINGS"))
					.sendKeys("10000");
			driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_10_T")).click();
			Thread.sleep(2000);

			driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_11_T")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_12_T")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_13_T")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_14_T")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_15_T")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_16_T")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_17_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_OVERRIDE_BUILDINGS_FLAT"))
					.sendKeys("10000");
			driver.findElement(By.cssSelector(
					"#C1__Screen_SSd_90_17_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_OVERRIDE_CONTENTS_FLAT"))
					.sendKeys("5000");
			driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_17_T")).click();

			// Quote Manager Page**************

			Thread.sleep(5000);

			driver.switchTo().frame("myIframe");
			driver.switchTo().frame("QMIframe");
			driver.findElement(By.cssSelector("#C1__BUT_CE78B7D13414C653641573")).click();
			// SOC Screen ***************

			String coverFromDateTime = driver.findElement(By.cssSelector(
					"#Controls_PolicyDetails > div > div.card-body.clearfix > div > div:nth-child(3) > div > p"))
					.getText();

			String coverEndDateTime = driver.findElement(By.cssSelector(
					"#Controls_PolicyDetails > div > div.card-body.clearfix > div > div:nth-child(4) > div > p"))
					.getText();
			driver.findElement(By.cssSelector("#ctl00_cntMainBody_btnBuy")).click();
			Alert alert1 = driver.switchTo().alert();
			alert1.accept();
			driver.switchTo().defaultContent();
			String PolicyNum = driver.findElement(By.xpath("//*[@id=\"secure_TransactionConfirmation\"]/div[2]/div/h4"))
					.getText();
			// String PolicyNum =
			// driver.findElement(By.xpath("//*[@id='ctl00_cntMainBody_lblPageheader']")).getText();

			String[] pol = PolicyNum.split(" ");
			String PolNum = pol[9];
			Map<String, String> dynamicHashMap = new HashMap();
			String Pol1 = null;
			dynamicHashMap.put(Pol1, PolNum);
			System.out.println("Policy Number is : " + " " + dynamicHashMap.get(Pol1) + "   " + "CoverFromDateTime   "
					+ coverFromDateTime + "  CoverEndDateTime is  " + coverEndDateTime);
			driver.findElement(By.id("linkinfoSection")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("ctl00_SideInfo_ClientInfoCtrl_hypCompanyName")).click();

			/******************** MTA ********************/

			for (int j = 1; j <= 4; j++) {

				driver.findElement(By.cssSelector("a[href='#tabpolicies']")).click();
				driver.findElement(By.cssSelector("#ctl00_cntMainBody_ClientQuotesPolicies_txtPolicyNo"))
						.sendKeys(PolNum);

				driver.findElement(By.cssSelector("a#ctl00_cntMainBody_ClientQuotesPolicies_btnSearch")).click();
				Thread.sleep(5000);
				try {
					driver.findElement(By.xpath("//*[@id=\"ctl00_cntMainBody_ClientQuotesPolicies_btnChange\"]"))
							.click();
				} catch (StaleElementReferenceException e) {
					driver.findElement(By.xpath("//*[@id=\"ctl00_cntMainBody_ClientQuotesPolicies_btnChange\"]"))
							.click();
				}
				// driver.findElement(By.cssSelector("a#ctl00_cntMainBody_ClientQuotesPolicies_btnChange")).click();
				driver.findElement(By.cssSelector("#rdoMTAReasonList")).click();
				driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtEffectiveDate")).clear();
				driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtEffectiveDate")).sendKeys("01/01/2020");
				driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtEffectiveTime")).clear();
				driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtEffectiveTime")).sendKeys("12:12:12");
				driver.findElement(By.cssSelector("a#ctl00_cntMainBody_btnSubmit")).click();
				/*
				 * driver.findElement(By.cssSelector("a[title='Action Menu']")).click();
				 * driver.findElement(By.cssSelector(
				 * "a#ctl00_cntMainBody_MultiRisk1_grdvRisk_ctl02_lnkbtnEdit")).click();
				 */
				/*
				 * if (j == 0) { driver.findElement(By.cssSelector(
				 * "#pb-container-checkbox-GENERAL_DETAILS-NEGATIVEPREMIUM > span.goog-checkbox.goog-checkbox-unchecked"
				 * )) .click();
				 * 
				 * 
				 * Thread.sleep(1000); }
				 */
				// driver.findElement(By.cssSelector("#pb-container-checkbox-GENERAL_DETAILS-INCLUDEBRKFEEPOS
				// > span.goog-checkbox.goog-checkbox-undetermined")).click();
				/*
				 * driver.findElement(By.cssSelector(
				 * "#pb-container-checkbox-GENERAL_DETAILS-INCLUDEBRKFEENEG > span.goog-checkbox.goog-checkbox-undetermined"
				 * )) .click(); driver.findElement(By.cssSelector(
				 * "#pb-container-integer-GENERAL_DETAILS-BRKFEENEGCOUNT > div > input:nth-child(2)"
				 * )) .sendKeys("2");
				 */
				driver.findElement(By.cssSelector("#ctl00_cntMainBody_btnNextTop")).click();
				Thread.sleep(5000);
				driver.switchTo().frame("myIframe");
				driver.switchTo().frame("QMIframe");
				driver.findElement(By.cssSelector("#C1__BUT_CE78B7D13414C653641573")).click();

				String mtaCoverFromDateTime = driver.findElement(By.cssSelector(
						"#Controls_PolicyDetails > div > div.card-body.clearfix > div > div:nth-child(3) > div > p"))
						.getText();

				String mtaCoverEndDateTime = driver.findElement(By.cssSelector(
						"#Controls_PolicyDetails > div > div.card-body.clearfix > div > div:nth-child(4) > div > p"))
						.getText();

				driver.findElement(By.cssSelector("#ctl00_cntMainBody_btnBuy")).click();
				Alert alert3 = driver.switchTo().alert();
				alert3.accept();
				driver.switchTo().defaultContent();

				System.out.println(
						"Policy Number is : " + " " + dynamicHashMap.get(Pol1) + "   " + "MTACoverFromDateTime   "
								+ mtaCoverFromDateTime + "  MTACoverEndDateTime is  " + mtaCoverEndDateTime);

				/*
				 * driver.findElement(By.id("linkinfoSection")).click(); Thread.sleep(2000);
				 * driver.findElement(By.id("ctl00_SideInfo_ClientInfoCtrl_hypCompanyName")).
				 * click();
				 */
				System.out.println("MTA done" + j);

			}

		}

	}

}
