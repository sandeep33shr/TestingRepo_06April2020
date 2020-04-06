package pkg1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SQMProduct {
	
	public static String coverStartDate = "03/01/2020";
	public static String coverStartTime = "10:30:06";
	public static String mTAcoverStartDate = "13/12/2019";
	public static String mTAcoverStartTime = "10:30:06";
	public static String URL="http://vm-hland-qa03/Pure.Portal/Login.aspx";
	//public static String URL="http://vm-s4b-blddpy31/Pure.Portal/login.aspx";

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
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.findElement(By.id("signupEmail")).sendKeys("admin@redinsurance.com");
		driver.findElement(By.id("signupPassword")).sendKeys("Password@2018");
		driver.findElement(By.id("login_button")).click();
		// Alert alert=driver.switchTo().alert();
		// alert.accept();
		// driver.switchTo().defaultContent();

		driver.findElement(By.id("ctl00_cntMainBody_txtClientCode")).sendKeys("SSPTEST");

		driver.findElement(By.xpath("//a[@id='ctl00_cntMainBody_btnSearch']")).click();
		driver.findElement(By.xpath("//a[@id='ctl00_cntMainBody_grdvSearchResults_ctl02_lnkDetails']")).click();

		for (int i = 0; i <= 3; i++) {
			WebElement prod = driver.findElement(By.id("ctl00_cntMainBody_ctrlNewQuoteImproved_ddlProductlst"));
			Select sel = new Select(prod);
			sel.selectByVisibleText("SQM Test Product");
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

			WebElement TParty = driver.findElement(By.cssSelector("#ctl00_cntMainBody_ddlThirdParty"));
			TParty.click();
			Select TP = new Select(TParty);
			TP.selectByIndex(2);

			/*driver.findElement(By.cssSelector("#ctl00_cntMainBody_POLICYHEADER__COVERSTARTDATE")).clear();
			driver.findElement(By.cssSelector("#ctl00_cntMainBody_POLICYHEADER__COVERSTARTDATE"))
					.sendKeys(coverStartDate);*/
			driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtCoverStartTime")).clear();
			driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtCoverStartTime")).sendKeys(coverStartTime);

		/*	WebElement frequency = driver.findElement(By.cssSelector("#ctl00_cntMainBody_POLICYHEADER__FREQUENCY"));
			frequency.click();
			Select freq = new Select(frequency);

			freq.selectByVisibleText("Biannually");
			action.sendKeys(Keys.TAB).build().perform();*/

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
			// General Details screen

			driver.findElement(By.cssSelector("input#ctl00_cntMainBody_GENERAL_DETAILS__address_cnt_TxtLookup_Street"))
					.sendKeys("Line1");

			driver.findElement(
					By.cssSelector("input#ctl00_cntMainBody_GENERAL_DETAILS__address_cnt_TxtLookup_Locality"))
					.sendKeys("Line2");
			driver.findElement(By.cssSelector("input#ctl00_cntMainBody_GENERAL_DETAILS__address_cnt_TxtLookup_Town"))
					.sendKeys("Line3");
			driver.findElement(By.cssSelector("input#ctl00_cntMainBody_GENERAL_DETAILS__address_cnt_TxtLookup_County"))
					.sendKeys("County");
			driver.findElement(
					By.cssSelector("input#ctl00_cntMainBody_GENERAL_DETAILS__address_cnt_TxtLookup_Postcode"))
					.sendKeys("LA1 1LA");

			/*
			 * // Clicking checkbox that display text field driver.findElement(By.
			 * cssSelector("#pb-container-checkbox-GENERAL_DETAILS-INCLUDEBRKFEEPOS > span.goog-checkbox.goog-checkbox-unchecked"
			 * )).click(); Thread.sleep(2000); //identifying textfield WebElement element=
			 * driver.findElement(By.
			 * cssSelector("#pb-container-integer-GENERAL_DETAILS-BRKFEEPOSCOUNT > div > input:nth-child(2)"
			 * )); // WebElement element=driver.findElement(By.
			 * cssSelector("#pb-container-integer-GENERAL_DETAILS-BRKFEEPOSCOUNT > div > input:nth-child(2)"
			 * )); WebDriverWait wait = new WebDriverWait(driver, 1);
			 * wait.until(ExpectedConditions.visibilityOf(element));
			 * 
			 * JavascriptExecutor jse = (JavascriptExecutor)driver;
			 * jse.executeScript("arguments[0].value='11111111';", element);
			 * action.sendKeys(Keys.TAB).build().perform();
			 */

			/*
			 * driver.findElement(By.
			 * cssSelector("#pb-container-checkbox-GENERAL_DETAILS-INCLUDEBRKFEENEG > span.goog-checkbox.goog-checkbox-unchecked"
			 * )).click(); driver.findElement(By.
			 * cssSelector("#pb-container-integer-GENERAL_DETAILS-BRKFEENEGCOUNT > div > input:nth-child(2)"
			 * )).sendKeys("1");
			 */

			// driver.findElement(By.cssSelector("#pb-container-checkbox-GENERAL_DETAILS-INCLUDEINSURERFEE
			// > span.goog-checkbox.goog-checkbox-unchecked.goog-checkbox-hover")).click();

			driver.findElement(By.cssSelector("input#ctl00_cntMainBody_btnNext")).click();

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
		/*	Alert alert = driver.switchTo().alert();
			alert.accept();
			driver.switchTo().defaultContent();*/
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
				Thread.sleep(10000);
				try {
				driver.findElement(By.xpath("//*[@id=\"ctl00_cntMainBody_ClientQuotesPolicies_btnChange\"]")).click();
				}catch(StaleElementReferenceException e) {
					
					driver.findElement(By.xpath("//*[@id=\"ctl00_cntMainBody_ClientQuotesPolicies_btnChange\"]")).click();
				}
				// driver.findElement(By.cssSelector("a#ctl00_cntMainBody_ClientQuotesPolicies_btnChange")).click();
				driver.findElement(By.cssSelector("#rdoMTAReasonList")).click();
				driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtEffectiveDate")).clear();
				driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtEffectiveDate")).sendKeys(mTAcoverStartDate);
				driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtEffectiveTime")).clear();
				driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtEffectiveTime")).sendKeys(mTAcoverStartTime);
				driver.findElement(By.cssSelector("a#ctl00_cntMainBody_btnSubmit")).click();
			/*	driver.findElement(By.cssSelector("a[title='Action Menu']")).click();
				driver.findElement(By.cssSelector("a#ctl00_cntMainBody_MultiRisk1_grdvRisk_ctl02_lnkbtnEdit")).click();*/
				/*if (j == 0) {
					driver.findElement(By.cssSelector(
							"#pb-container-checkbox-GENERAL_DETAILS-NEGATIVEPREMIUM > span.goog-checkbox.goog-checkbox-unchecked"))
							.click();
					

					Thread.sleep(1000);
				}*/
				// driver.findElement(By.cssSelector("#pb-container-checkbox-GENERAL_DETAILS-INCLUDEBRKFEEPOS
				// > span.goog-checkbox.goog-checkbox-undetermined")).click();
			/*	driver.findElement(By.cssSelector(
						"#pb-container-checkbox-GENERAL_DETAILS-INCLUDEBRKFEENEG > span.goog-checkbox.goog-checkbox-undetermined"))
						.click();
				driver.findElement(By.cssSelector(
						"#pb-container-integer-GENERAL_DETAILS-BRKFEENEGCOUNT > div > input:nth-child(2)"))
						.sendKeys("2");*/
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
				Alert alert1 = driver.switchTo().alert();
				alert1.accept();
				driver.switchTo().defaultContent();
				
				System.out.println("Policy Number is : " + " " + dynamicHashMap.get(Pol1) + "   " + "MTACoverFromDateTime   "
						+ mtaCoverFromDateTime + "  MTACoverEndDateTime is  " + mtaCoverEndDateTime);

				/*driver.findElement(By.id("linkinfoSection")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("ctl00_SideInfo_ClientInfoCtrl_hypCompanyName")).click();*/
				System.out.println("MTA done" + j);

			}

		}

	}

}
