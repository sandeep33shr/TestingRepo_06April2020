package pkg1;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SQM_Anupam {
	/*  public static String portalUrl = "https://systest.broking-dev.ssp-development.com/Pure.Portal/LoginPlatform.aspx" ;
    public static String UID = "admin@systest.com";
    public static String PWD = "Password@2020"; */
    
  /*  public static String portalUrl = "https://ssppureportal-devt.ssp-development.com/Pure.PortalY/loginplatform.aspx" ;
    public static String UID = "admin@blueinsurance.com";
    public static String PWD = "Password@2018";  */
    
    public static String portalUrl = "https://ssppureportal-devt.ssp-development.com/Pure.PortalY/loginplatform.aspx" ;
   // public static String portalUrl = "https://ssppureportal-devt.ssp-development.com/Pure.PortalDev2/loginplatform.aspx" ;
    
    public static String UID = "admin@yellowinsurance.com";
   // public static String UID = "admin@blueinsurance.com";
    public static String PWD = "Password@2018";  
     
        public static void main(String[] args) throws InterruptedException, AWTException {

                    String path = System.getProperty("user.dir");
                    System.setProperty("webdriver.chrome.driver", path + "//ChromeDriver//chromedriver.exe");
                    WebDriver driver = new ChromeDriver();
                    
                    driver.get(portalUrl);

                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                    driver.findElement(By.id("username")).sendKeys(UID);
                    driver.findElement(By.id("password")).sendKeys(PWD);
                    driver.findElement(By.cssSelector("#loginModal > div > div > div.card-footer > button")).click();
                    
                    driver.findElement(By.id("ctl00_cntMainBody_txtClientCode")).sendKeys("Demos");
                    driver.findElement(By.xpath("//a[@id='ctl00_cntMainBody_btnSearch']")).click();
                    driver.findElement(By.xpath("//a[@id='ctl00_cntMainBody_grdvSearchResults_ctl02_lnkDetails']")).click();
               for( int i=0;i<=50;i++)  {  
                    WebElement prod = driver.findElement(By.id("ctl00_cntMainBody_ctrlNewQuoteImproved_ddlProductlst"));
                                                 
                    Select sel = new Select(prod);
                    sel.selectByVisibleText("HIUA Phase 1 GLU");
                    driver.findElement(By.xpath("//a[@id='ctl00_cntMainBody_ctrlNewQuoteImproved_btnNewQuote']")).click();
                    Actions action = new Actions(driver);
                
               WebElement bSource =  driver.findElement(By.cssSelector("#ctl00_cntMainBody_POLICYHEADER__ANALYSISCODE"));
                    bSource.click();
                    Select bs = new Select(bSource);
                    bs.selectByVisibleText("Direct Business"); 
                    Thread.sleep(2000);
               
                    WebElement bType =  driver.findElement(By.cssSelector("#ctl00_cntMainBody_POLICYHEADER__BUSINESSTYPE"));
                    bType.click();
                    Select bt = new Select(bType);
                    bt.selectByVisibleText("Direct Business"); 
                    Thread.sleep(2000);
            
  //Select Branch     
                    WebElement bBranch =  driver.findElement(By.cssSelector("#ctl00_cntMainBody_POLICYHEADER__BRANCH"));
                    bBranch.click();
                    Select bb = new Select(bBranch);
                   //bb.selectByVisibleText("Barmingahm"); 
                  bb.selectByIndex(0);
                    Thread.sleep(1000);  
                    
 WebElement TParty =
driver.findElement(By.cssSelector("#ctl00_cntMainBody_ddlThirdParty"));
TParty.click();
Select TP = new Select(TParty); 
TP.selectByIndex(0);   
   
                    action.sendKeys(Keys.PAGE_UP).build().perform();
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//a[text()='Compliance']")).click();

                    // Compliance screen

                    WebElement TOS = driver.findElement(By.id("ctl00_cntMainBody_TYPE_OF_SALE"));
                    Select s1 = new Select(TOS);
                    s1.selectByVisibleText("Advised");
                    WebElement MOS = driver.findElement(By.id("ctl00_cntMainBody_METHOD_OF_SALE"));
                    Select s2 = new Select(MOS);
                    s2.selectByVisibleText("Non Distance");
                    driver.findElement(By.id("ctl00_cntMainBody_ddlUnderwriter")).sendKeys("UnderWriter");
                    WebElement TA = driver.findElement(By.id("ctl00_cntMainBody_ddlTermsAgreed"));
                    Select s3 = new Select(TA);
                    s3.selectByVisibleText("No");
                    driver.findElement(By.id("ctl00_cntMainBody_btnNext")).click();
                    

                    // DATA CAPTURE SCREEN

                    driver.switchTo().frame("dqjIframe");
                    driver.switchTo().frame("QMIframe");
                    
                    // 1st tab
                   // driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_0_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_INSURED"))
                     //                               .sendKeys("Sandeep");
                    
                    driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_0_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_TRADING_NAME"))
                                                    .sendKeys("Sandeep");
                    /*driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_0_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_TELEPHONE_NUM"))
                                                   .sendKeys("1234567890");*/
                    driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_0_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_CONTACT_NAME"))
                                                    .sendKeys("Sandeep Sharma");
                    WebElement CS = driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_0_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_COMPANY_STATUS"));
                    Select s0 = new Select(CS);
                    s0.selectByVisibleText("Limited Company (LTD)");

                    Thread.sleep(2000);
                    driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_GENDETS_0_T")).click();  

                    // 2nd tab

                    Thread.sleep(2000);
                    WebElement cType = driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_1_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_rISK_DETAILS_COVER_TYPE"));
                    Select coverType = new Select(cType);
                    coverType.selectByVisibleText("Guest House");
                    Thread.sleep(1000);
                 
                    driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_1_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_AT_THIS_PREMISES"))
                                                    .sendKeys("5");
                    driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_1_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_ELSEWHERE"))
                                                    .sendKeys("5");
                 
//  New                       
                    driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31924")).sendKeys("B37 7YE");
                    Thread.sleep(3000);
                    driver.findElement(By.cssSelector("#C1__C1__BUT_BA23D49FD83824B32484")).click();
                    Thread.sleep(5000);
                    WebElement tab2 = driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31964"));
                    tab2.click();
                    Select l2 = new Select(tab2);
                    l2.selectByIndex(12);
                    Thread.sleep(3000);
                   //    End                       
                    driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_GENDETS_1_T")).click();   
                    
                    Thread.sleep(3000);
                    action.sendKeys(Keys.PAGE_DOWN).build().perform();
                    Thread.sleep(2000);
                    
                    driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31924")).clear();
                    
                    driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31924")).sendKeys("LA1 1LA");
                    
                    driver.findElement(By.cssSelector("#C1__C1__QUE_4ABA2D83CE3F6B8189114")).click();
                    Thread.sleep(3000);
                  driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_GENDETS_1_T")).click();

                                      // 3rd tab
                    
                                        
                    
                    Thread.sleep(2000);
                    driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_2_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_GOOD_STATE_OF_rEPAIR_0"))
                                                    .click();
                    driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_2_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_AGE_OF_BUILDING"))
                                                    .sendKeys("2010");
                    Thread.sleep(2000);
                    driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_2_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_ARE_ALL_THE_WALLS_0"))
                                                    .click();
                    driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_2_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_ARE_ALL_rOOFS_0"))
                                                    .click();
                    //driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_GENDETS_2_T")).click();
                    
                    Thread.sleep(4000);
          //navigate back to 2nd tab and enter postcode
                    driver.findElement(By.cssSelector("#C1__Back-Screen_SSd_GENDETS_2_T")).click();
                                                       
                    Thread.sleep(4000);
             
           //enter postcode again tab2
                    driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31924")).clear();
                    driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31924")).sendKeys("B37 7YE");
                    Thread.sleep(3000);
             //       System.out.println("Entered postcode again risk screen");
                    driver.findElement(By.cssSelector("#C1__C1__QUE_4ABA2D83CE3F6B8189114")).click();
                   // System.out.println(driver.findElement(By.cssSelector("#C1__C1__QUE_4ABA2D83CE3F6B8189114")).getText());
                    Thread.sleep(3000);
                    driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_GENDETS_1_T")).click();   
                    Thread.sleep(3000);
                  //  System.out.println("Continue clicked risk screen");
                    
                    // 3rd tab
                    Thread.sleep(2000);
                    driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_2_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_GOOD_STATE_OF_rEPAIR_0"))
                                                    .click();
                    driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_2_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_AGE_OF_BUILDING"))
                                                    .sendKeys("2010");
                    driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_2_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_ARE_ALL_THE_WALLS_0"))
                                                    .click();
                    driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_2_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_ARE_ALL_rOOFS_0"))
                                                    .click();
                    driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_GENDETS_2_T")).click();
                    
                    // 4th tab
                    
                    
                    Thread.sleep(3000);
                    driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_GENDETS_3_T")).click();
                    // 5th tab
                    Thread.sleep(2000);
                    WebElement SOS = driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_4_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUBSIDENCE_ASSESSMENT_STATE_OF_SITE"));
                    Select s4 = new Select(SOS);
                    s4.selectByVisibleText("Gently sloping");

                    WebElement foundation = driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_4_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUBSIDENCE_ASSESSMENT_FOUNDATIONS"));
                    Select s5 = new Select(foundation);
                    s5.selectByVisibleText("Piled foundations");
                    driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_4_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUBSIDENCE_ASSESSMENT_WATERCOURSES_0"))
                                                    .click();
                    driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_4_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUBSIDENCE_ASSESSMENT_CLIFFS_0"))
                                                    .click();
                    driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_GENDETS_4_T")).click();
                    // 6th tab
                    Thread.sleep(2000);
                    driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_GENDETS_5_T")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_GENDETS_6_T")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_7_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_TURNOVER"))
                                                    .sendKeys("2000");
                    driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_7_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_LETTING_BEDROOMS"))
                                                    .sendKeys("2");

                    // 6A tab
                    driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_GENDETS_7_T")).click();

                    // 7th Tab

                    driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_8_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUMS_INSURED_GH_TOTAL_WINE"))
                                                    .sendKeys("2000");
                    driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_8_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUMS_INSURED_GH_TOTAL_COMPUTER"))
                                                    .sendKeys("2000");
                    driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_8_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUMS_INSURED_GH_FROZEN_FOOD"))
                                                    .sendKeys("5000");
                    Thread.sleep(2000);
                    driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_GENDETS_8_T")).click();
                    // 8th tab
                    driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_9_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUMS_INSURED_GH_INCCIT"))
                                                    .sendKeys("2000");
                    driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_9_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUMS_INSURED_GH_INCCIS"))
                                                    .sendKeys("2000");
                    driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_9_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUMS_INSURED_GH_MAKE_MODEL_SAFE"))
                                                    .sendKeys("5000");
                    Thread.sleep(2000);
                    driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_GENDETS_9_T")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.cssSelector("#C1__Screen_SSd_GENDETS_10_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUMS_INSURED_HH_BUILDINGS"))
                                                     .sendKeys("10000");
                    driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_GENDETS_10_T")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_GENDETS_11_T")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_GENDETS_12_T")).click();
                   Thread.sleep(2000);
                    driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_GENDETS_13_T")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_GENDETS_14_T")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_GENDETS_15_T")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_GENDETS_16_T")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_GENDETS_17_T")).click();
                  //  System.out.println("Quote Result Page");
                    
                    Thread.sleep(30000);
                    driver.findElement(By.cssSelector("#C1__BUT_CE78B7D13414C653641573")).click();
                    Thread.sleep(3000);
                    driver.findElement(By.cssSelector("#ctl00_cntMainBody_btnBuy")).click();
                    String PolicyNum = driver.findElement(By.xpath("//*[@id=\"secure_TransactionConfirmation\"]/div[2]/div/h4"))
        					.getText();
        			String[] pol = PolicyNum.split(" ");
        			String PolNum = pol[9];
        			Map<String, String> dynamicHashMap = new HashMap();
        			String Pol1 = null;
        			dynamicHashMap.put(Pol1, PolNum);
        			System.out.println("Policy Number is : " + " " + dynamicHashMap.get(Pol1));
        			driver.findElement(By.cssSelector("#confirmBox > button.yes")).click();
               }
                    
    }

	
	}
