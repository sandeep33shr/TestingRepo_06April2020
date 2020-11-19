package pkg1;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectMethods {
	
	public static int index;
	
	public static void clickElementBasedOnText(WebDriver driver,List<WebElement> ele,String input) {
		
		List<WebElement> polType= ele;
		
		for(WebElement temp:polType) {
		String temp1=temp.getText();
		if(temp1.equals(input)) {
			temp.click();
		}
					
		}
		
	}
	
	public static void getRowIndexAsPerTheTableData(WebDriver driver,List<WebElement> tableRowElements,String input) throws Exception {
		try {
			index = -1;
			
				for (int i = 0; i < tableRowElements.size(); i++) {
				if (tableRowElements.get(i).getText().toUpperCase().contains(input.toUpperCase())) {
					index = i;
					break;
				}
			}
			if (index < 0)
				throw new Exception(input + " data is not found in the table.");
		} catch (NoSuchElementException e) {
			
		}
	}

	/**
	 * To click on the button as per the index selected by method
	 * getRowIndexAsPerTheTableData.
	 *
	 * @param pathType       the path type
	 * @param path           the path
	 * @param driver         the driver
	 * @param extentedReport the extented report
	 * @param screenshot     the screenshot
	 * @throws Exception the exception
	 */
	public static void clickButtonAsPerRowIndex(WebDriver driver,List<WebElement> tableButtonElements,String input) {
		try {
					if (index >= 0)
				tableButtonElements.get(index).click();
		} catch (NoSuchElementException e) {
			
		}
	}
		
	
	
public static void clickMTAVersion(WebDriver driver,List<WebElement> ele,List<WebElement> ele1,String input) {
		
		List<WebElement> polType= ele;
		List<WebElement> links= ele1;
		System.out.println(links.size());
		if (links.size()==0) {
			
			
			for(WebElement temp:polType) {
				String temp1=temp.getText();
				if(temp1.equals(input)) {
					temp.click();
				}
							
				}
			
			
			
			
		}else if (links.size()>=0)	{
			
			for(WebElement link :links) {
				link.click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String temp2=null;
				for(WebElement temp:polType) {
					try {
					 temp2=temp.getText();
					}catch(StaleElementReferenceException e){
						for(WebElement temp1:polType) {
							 temp2=temp1.getText();
							System.out.println(temp2);
					}
					
					if(temp2.equals(input)) {
						temp.click();
					}
								
					}
			}
		}
		
	
		
				
		}
		
}








	}
	
	


