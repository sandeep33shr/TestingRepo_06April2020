package pkg1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Collection {

	public static void main(String[] args) throws InterruptedException {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "//ChromeDriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ssppureportal-devt.ssp-development.com/Pure.PortalDev2/login.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("admin@blueinsurance.com");
		driver.findElement(By.id("password")).sendKeys("Password@2018");
		driver.findElement(By.cssSelector("#loginModal > div > div > div.card-footer > button")).click();
		
		driver.findElement(By.cssSelector("#ctl00_RibbonMenu_rptCategory_ctl03_toolbaritem>a")).click();
		driver.findElement(By.cssSelector("#ctl00_RibbonMenu_rptCategory_ctl03_rptSection_ctl02_rptItem_ctl02_A1")).click();
		driver.findElement(By.cssSelector("#ctl00_cntMainBody_btnFind")).click();
		List<WebElement> pages = driver.findElements(By.cssSelector(" #ctl00_cntMainBody_grdvPreBank > div > a"));
		List<WebElement> checkBoxes = driver.findElements(By.cssSelector("#ctl00_cntMainBody_grdvPreBank td:nth-child(1) input[type='checkbox']"));
		
		for(WebElement ele:checkBoxes){
			ele.click();
			Thread.sleep(3000);
				
				
		}
		
		driver.findElement(By.cssSelector("#ctl00_cntMainBody_grdvPreBank_ctl02_chkMarked")).click();

		driver.findElement(By.cssSelector("#ctl00_cntMainBody_txtClientCode")).sendKeys("Bharti001");

		driver.findElement(By.xpath("//a[@id='ctl00_cntMainBody_btnSearch']")).click();
		driver.findElement(By.xpath("//a[@id='ctl00_cntMainBody_grdvSearchResults_ctl02_lnkDetails']")).click();

		for (int i = 0; i <= 100; i++) {

			driver.findElement(By.id("ctl00_cntMainBody_btnCollection")).click();
			WebElement mediaType = driver
					.findElement(By.cssSelector("#ctl00_cntMainBody_PayNow_CollectionItem_GISLookup_MediaType"));
			Select sel = new Select(mediaType);
			sel.selectByVisibleText("Cash");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
			WebElement bank = driver
					.findElement(By.cssSelector("#ctl00_cntMainBody_PayNow_CollectionItem_CollectionItem_BankAccount"));
			Select sel1 = new Select(bank);
			sel1.selectByIndex(3);
			driver.findElement(By.cssSelector("#ctl00_cntMainBody_PayNow_CollectionItem_txtAmount")).click();
			driver.findElement(By.cssSelector("#ctl00_cntMainBody_PayNow_CollectionItem_txtAmount")).clear();
			driver.findElement(By.cssSelector("#ctl00_cntMainBody_PayNow_CollectionItem_txtAmount")).sendKeys(Keys.CONTROL + "a");
			driver.findElement(By.cssSelector("#ctl00_cntMainBody_PayNow_CollectionItem_txtAmount")).sendKeys(Keys.DELETE);
			driver.findElement(By.cssSelector("#ctl00_cntMainBody_PayNow_CollectionItem_txtAmount")).sendKeys("3");
			driver.findElement(By.id("ctl00_cntMainBody_PayNow_CollectionItem_btnOk")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("#ctl00_cntMainBody_CollectionAllocation_btnOk")).click();

			Thread.sleep(3000);
		}

	}
}