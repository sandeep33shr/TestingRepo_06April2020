package pkg1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HIUA_SIT {
	
	public static String coverStartDate = "15/02/2020";
	public static String coverStartTime = "10:30:06";

	public static void main(String[] args) throws InterruptedException {
        
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "//ChromeDriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ssppureportal-devt.ssp-development.com/Pure.Portal/login.aspx");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		driver.findElement(By.id("username")).sendKeys("admin@redinsurance.com");
		driver.findElement(By.id("password")).sendKeys("Password@2018");
		driver.findElement(By.cssSelector("#loginModal > div > div > div.card-footer > button")).click();
		driver.findElement(By.id("ctl00_cntMainBody_txtClientCode")).sendKeys("ABSCOMP");
		driver.findElement(By.xpath("//a[@id='ctl00_cntMainBody_btnSearch']")).click();
		driver.findElement(By.xpath("//a[@id='ctl00_cntMainBody_grdvSearchResults_ctl02_lnkDetails']")).click();
		UtilityMethods.selectByVisibleText(driver, "#ctl00_cntMainBody_ctrlNewQuoteImproved_ddlProductlst", "HIUA Phase 1 GLU");
		driver.findElement(By.xpath("//a[@id='ctl00_cntMainBody_ctrlNewQuoteImproved_btnNewQuote']")).click();
		UtilityMethods.selectByIndex(driver, "#ctl00_cntMainBody_POLICYHEADER__ANALYSISCODE", 0);
		UtilityMethods.selectByIndex(driver, "select#ctl00_cntMainBody_POLICYHEADER__BRANCH", 0);
		UtilityMethods.selectByIndex(driver, "#ctl00_cntMainBody_POLICYHEADER__DEPARTMENT", 2);
		UtilityMethods.selectByIndex(driver, "#ctl00_cntMainBody_ddlPolicyHeaderSubTeam", 2);
		driver.findElement(By.cssSelector("#ctl00_cntMainBody_btnHandler")).click();
		driver.switchTo().frame("TB_iframeContent");
		driver.findElement(By.id("ctl01_cntMainBody_btnSearch")).click();
		driver.findElement(By.cssSelector("#ctl01_cntMainBody_grdvSearchResults_ctl04_btnSelect")).click();
		driver.switchTo().defaultContent(); Thread.sleep(2000);
		UtilityMethods.selectByIndex(driver, "#ctl00_cntMainBody_ddlThirdParty", 3);
	
	/*	driver.findElement(By.cssSelector("#ctl00_cntMainBody_POLICYHEADER__COVERSTARTDATE")).clear();
		driver.findElement(By.cssSelector("#ctl00_cntMainBody_POLICYHEADER__COVERSTARTDATE"))
				.sendKeys(coverStartDate);
		driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtCoverStartTime")).clear();
		driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtCoverStartTime")).sendKeys(coverStartTime);*/
		

		action.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Compliance']")).click();

		// Compliance screen

		UtilityMethods.selectByVisibleText(driver,"#ctl00_cntMainBody_TYPE_OF_SALE", "Advised");
		UtilityMethods.selectByVisibleText(driver,"#ctl00_cntMainBody_METHOD_OF_SALE", "Non Distance");
		driver.findElement(By.id("ctl00_cntMainBody_txtUnderwriter")).sendKeys("UnderWriter");
		UtilityMethods.selectByVisibleText(driver,"#ctl00_cntMainBody_ddlTermsAgreed", "No");
		
		
		//Renewal tab
		driver.findElement(By.xpath("//*[@id=\"MainDetail-control\"]/div/ul/li[3]/a")).click();
		UtilityMethods.selectByVisibleText(driver,"#ctl00_cntMainBody_POLICYHEADER__RENEWALMETHOD", "Renewal Method3");
		UtilityMethods.selectByVisibleText(driver,"#ctl00_cntMainBody_POLICYHEADER__STOPREASON", "Bank details fraud");
		driver.findElement(By.id("ctl00_cntMainBody_btnNext")).click();

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
				.sendKeys("9876332211");
		driver.findElement(By.cssSelector(
				"#C1__Screen_SSd_90_0_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_CONTACT_NAME"))
				.sendKeys("Sandeep Sharma");
		WebElement CS = driver.findElement(By.cssSelector(
				"#C1__Screen_SSd_90_0_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_COMPANY_STATUS"));
		Select s0 = new Select(CS);
		s0.selectByVisibleText("Limited Company (LTD)");

		driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31924")).sendKeys("B37 7ye");

		driver.findElement(By.cssSelector("#C1__C1__BUT_BA23D49FD83824B32484")).click();
		Thread.sleep(5000);
		WebElement line1 =
	    driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31964"));
		line1.click();	
		 Select l1 = new Select(line1); l1.selectByIndex(12);
		  Thread.sleep(2000);
		 
		driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_0_T")).click();
		Thread.sleep(2000);
		// 2nd tab
		WebElement cType = driver.findElement(By.cssSelector(
				"#C1__Screen_SSd_90_1_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_rISK_DETAILS_COVER_TYPE"));
		Select coverType = new Select(cType);
		coverType.selectByVisibleText("Guest House");
		Thread.sleep(1000);

		driver.findElement(By.cssSelector(
				"#C1__Screen_SSd_90_1_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_AT_THIS_PREMISES"))
				.sendKeys("5");
		driver.findElement(By.cssSelector(
				"#C1__Screen_SSd_90_1_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_ELSEWHERE"))
				.sendKeys("5");

		Thread.sleep(3000);
		
		  driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31924")).
		  sendKeys("B37 7ye"); Thread.sleep(3000);
		  driver.findElement(By.cssSelector("#C1__C1__BUT_BA23D49FD83824B32484")).click
		  (); Thread.sleep(3000); WebElement tab2 =
		  driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31964"));
		  tab2.click(); Select l2 = new Select(tab2); l2.selectByIndex(12);
		 
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_1_T")).click();
		// 3rd tab
		Thread.sleep(4000);
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
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#C1__Back-Screen_SSd_90_2_T")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#C1__Back-Screen_SSd_90_1_T")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31924")).sendKeys("B37 7ye");
		driver.findElement(By.cssSelector("#C1__C1__QUE_4ABA2D83CE3F6B8189114")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_0_T")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31924")).sendKeys("B37 7ye");
		driver.findElement(By.cssSelector("#C1__C1__QUE_4ABA2D83CE3F6B8189114")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_1_T")).click();
        Thread.sleep(3000);
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
		Thread.sleep(2000);

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
				.sendKeys("300000");
		driver.findElement(By.cssSelector(
				"#C1__Screen_SSd_90_7_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_LETTING_BEDROOMS"))
				.sendKeys("5");

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
				.sendKeys("200000");
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
		driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_17_T")).click();

	}

}
