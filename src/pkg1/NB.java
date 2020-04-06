package pkg1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
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

public class NB {

                public static void main(String[] args) throws InterruptedException, AWTException {

                                String path = System.getProperty("user.dir");
                                System.setProperty("webdriver.chrome.driver", path + "//ChromeDriver//chromedriver.exe");
                                WebDriver driver = new ChromeDriver();
                                driver.get("https://ssppureportal-devt.ssp-development.com/Pure.Portal/LoginPlatform.aspx");

                                driver.manage().window().maximize();
                                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                                driver.findElement(By.id("signupEmail")).sendKeys("admin@redinsurance.com");
                                driver.findElement(By.id("signupPassword")).sendKeys("Password@2018");
                                driver.findElement(By.id("login_button")).click();
                                driver.findElement(By.id("ctl00_cntMainBody_txtClientCode")).sendKeys("BMW1");
                                driver.findElement(By.xpath("//a[@id='ctl00_cntMainBody_btnSearch']")).click();
                                driver.findElement(By.xpath("//a[@id='ctl00_cntMainBody_grdvSearchResults_ctl02_lnkDetails']")).click();
                                WebElement prod = driver.findElement(By.id("ctl00_cntMainBody_ctrlNewQuoteImproved_ddlProductlst"));
                                Select sel = new Select(prod);
                                sel.selectByVisibleText("HIUA Phase 1 GLU");
                                driver.findElement(By.xpath("//a[@id='ctl00_cntMainBody_ctrlNewQuoteImproved_btnNewQuote']")).click();
                                Actions action = new Actions(driver);
                                /*action.sendKeys(Keys.PAGE_UP).build().perform();
                                Thread.sleep(2000);*/
                                WebElement bSource =  driver.findElement(By.cssSelector("#ctl00_cntMainBody_POLICYHEADER__ANALYSISCODE"));
                                bSource.click();
                                Select bs = new Select(bSource);
                                bs.selectByVisibleText("Yellow Pages");
                                Thread.sleep(1000);
                                
                                WebElement TParty =
                                  driver.findElement(By.cssSelector("#ctl00_cntMainBody_ddlThirdParty"));
                                  TParty.click(); Select TP = new Select(TParty); TP.selectByIndex(2);
                                
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
                                

                                // DATA CAPTURE SCREEN

                                driver.switchTo().frame("dqjIframe");
                                driver.switchTo().frame("QMIframe");
                                
                                // 1st tab
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_0_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_INSURED"))
                                                                .sendKeys("Sandeep");
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_0_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_TRADING_NAME"))
                                                                .sendKeys("Sandeep");
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_0_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_TELEPHONE_NUM"))
                                                               .sendKeys("1234567890");
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_0_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_CONTACT_NAME"))
                                                                .sendKeys("Sandeep Sharma");
                                WebElement CS = driver.findElement(By.cssSelector("#C1__Screen_SSd_90_0_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_COMPANY_STATUS"));
                                Select s0 = new Select(CS);
                                s0.selectByVisibleText("Limited Company (LTD)");
                                 
                                JavascriptExecutor js = (JavascriptExecutor) driver;  
                                js.executeScript("document.getElementById('C1__C1__QUE_BA23D49FD83824B31924').value='B37 7YE';");
                               // driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31924")).sendKeys("B37 7YE");
                                driver.findElement(By.cssSelector("#C1__C1__BUT_BA23D49FD83824B32484")).click();
                              
                                WebElement CorrespondenceAddress = driver.findElement(By.xpath("//*[@id=\"C1__C1__QUE_BA23D49FD83824B31964\"]"));
                                System.out.println("Correspondence element found");
                                
                                WebDriverWait wait = new WebDriverWait(driver,5);
                                
                                boolean status= wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(CorrespondenceAddress)));
                                System.out.println(status);
                                WebElement CorrespondenceAddressRefreshed = driver.findElement(By.xpath("//*[@id=\"C1__C1__QUE_BA23D49FD83824B31964\"]"));
                                System.out.println("Select element refreshed found");
                                
                                
                                Select addressOption = new Select(CorrespondenceAddressRefreshed);
                                System.out.println("Select object created");
                                
                                addressOption.selectByVisibleText("Unit 2020 The Crescent Birmingham Business Park Birmingham United Kingdom");
                                Thread.sleep(3000);
                                driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_0_T")).click();

                                // 2nd tab

                                Thread.sleep(2000);
                                WebElement cType = driver.findElement(By.cssSelector("#C1__Screen_SSd_90_1_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_rISK_DETAILS_COVER_TYPE"));
                                Select coverType = new Select(cType);
                                coverType.selectByVisibleText("Guest House");
                                Thread.sleep(1000);
                                // action.sendKeys(Keys.TAB).build().perform();
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_1_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_AT_THIS_PREMISES"))
                                                                .sendKeys("5");
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_1_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_GENERAL_DETAILS_ELSEWHERE"))
                                                                .sendKeys("5");
                                driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31924"))
                                                                .sendKeys("B37 7YE");
                                Thread.sleep(3000);
                                
                                driver.findElement(By.cssSelector("#C1__C1__BUT_BA23D49FD83824B32484")).click();
                                                       
                                WebElement RiskAddress = driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31964"));
                                System.out.println("Risk address element found");
                                
                                boolean statusRisk= wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(RiskAddress)));
                                System.out.println(statusRisk);
                                
                                WebElement RiskAddressRefreshed = driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31964"));
                                System.out.println("Risk element refreshed found");
                                Select addressOption2 = new Select(RiskAddressRefreshed);
                                addressOption2.selectByVisibleText("Unit 2020 The Crescent Birmingham Business Park Birmingham United Kingdom");
                                Thread.sleep(3000);
                                driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_1_T")).click();                                                                                                
                                
                                // 3rd tab
                                Thread.sleep(2000);
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_2_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_GOOD_STATE_OF_rEPAIR_0"))
                                                                .click();
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_2_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_AGE_OF_BUILDING"))
                                                                .sendKeys("2010");
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_2_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_ARE_ALL_THE_WALLS_0"))
                                                                .click();
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_2_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_ARE_ALL_rOOFS_0"))
                                                                .click();
                                //driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_2_T")).click();
                                Thread.sleep(3000);
                                
                                
                                //navigate back to 1st tab and enter postcode
                                driver.findElement(By.cssSelector("#C1__Back-Screen_SSd_90_2_T")).click();
                                Thread.sleep(2000);
                                driver.findElement(By.cssSelector("#C1__Back-Screen_SSd_90_1_T")).click();
                                Thread.sleep(2000);
                               
                                //enter postcode again tab 1 
                                driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31924")).sendKeys("B37 7YE");
                                System.out.println("Entered postcode again");
                                
                                driver.findElement(By.cssSelector("#C1__C1__QUE_4ABA2D83CE3F6B8189114")).click();
                                System.out.println(driver.findElement(By.cssSelector("#C1__C1__QUE_4ABA2D83CE3F6B8189114")).getText());
                                Thread.sleep(3000);
                                driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_0_T")).click();
                                System.out.println("Click continue screen1");
                                Thread.sleep(3000);
                                System.out.println("Navigated to Risk Screen");

                                //enter postcode again tab2
                                
                                driver.findElement(By.cssSelector("#C1__C1__QUE_BA23D49FD83824B31924")).sendKeys("B37 7YE");
                           //     System.out.println("Entered postcode again risk screen");
                                driver.findElement(By.cssSelector("#C1__C1__QUE_4ABA2D83CE3F6B8189114")).click();
                            //    System.out.println(driver.findElement(By.cssSelector("#C1__C1__QUE_4ABA2D83CE3F6B8189114")).getText());
                                Thread.sleep(3000);
                                driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_1_T")).click();   
                                Thread.sleep(3000);
                              //  System.out.println("Continue clicked risk screen");
                                
                                // 3rd tab
                                Thread.sleep(2000);
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_2_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_GOOD_STATE_OF_rEPAIR_0"))
                                                                .click();
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_2_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_AGE_OF_BUILDING"))
                                                                .sendKeys("2010");
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_2_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_ARE_ALL_THE_WALLS_0"))
                                                                .click();
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_2_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_ARE_ALL_rOOFS_0"))
                                                                .click();
                                driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_2_T")).click();
                                
                                // 4th tab
                                
                                
                                Thread.sleep(3000);
                                driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_3_T")).click();
                                // 5th tab
                                Thread.sleep(2000);
                                WebElement SOS = driver.findElement(By.cssSelector("#C1__Screen_SSd_90_4_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUBSIDENCE_ASSESSMENT_STATE_OF_SITE"));
                                Select s4 = new Select(SOS);
                                s4.selectByVisibleText("Gently sloping");

                                WebElement foundation = driver.findElement(By.cssSelector("#C1__Screen_SSd_90_4_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUBSIDENCE_ASSESSMENT_FOUNDATIONS"));
                                Select s5 = new Select(foundation);
                                s5.selectByVisibleText("Piled foundations");
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_4_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUBSIDENCE_ASSESSMENT_WATERCOURSES_0"))
                                                                .click();
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_4_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUBSIDENCE_ASSESSMENT_CLIFFS_0"))
                                                                .click();
                                driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_4_T")).click();
                                // 6th tab
                                Thread.sleep(2000);
                                driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_5_T")).click();
                                Thread.sleep(2000);
                                driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_6_T")).click();
                                Thread.sleep(2000);
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_7_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_TURNOVER"))
                                                                .sendKeys("2000");
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_7_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_BUILDING_CONSTRUCTION_LETTING_BEDROOMS"))
                                                                .sendKeys("2");

                                // 6A tab
                                driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_7_T")).click();

                                // 7th Tab

                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_8_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUMS_INSURED_GH_TOTAL_WINE"))
                                                                .sendKeys("2000");
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_8_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUMS_INSURED_GH_TOTAL_COMPUTER"))
                                                                .sendKeys("2000");
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_8_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUMS_INSURED_GH_FROZEN_FOOD"))
                                                                .sendKeys("5000");
                                Thread.sleep(2000);
                                driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_8_T")).click();
                                // 8th tab
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_9_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUMS_INSURED_GH_INCCIT"))
                                                                .sendKeys("2000");
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_9_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUMS_INSURED_GH_INCCIS"))
                                                                .sendKeys("2000");
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_9_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUMS_INSURED_GH_MAKE_MODEL_SAFE"))
                                                                .sendKeys("5000");
                                Thread.sleep(2000);
                                driver.findElement(By.cssSelector("#C1__Continue-Screen_SSd_90_9_T")).click();
                                Thread.sleep(2000);
                                driver.findElement(By.cssSelector("#C1__Screen_SSd_90_10_T__DATA_SET_rISK_OBJECTS_Component_HIUAGH_POLICY_BINDER_Component_SUMS_INSURED_HH_BUILDINGS"))
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
                                System.out.println("Quote Result Page");
                }

}

