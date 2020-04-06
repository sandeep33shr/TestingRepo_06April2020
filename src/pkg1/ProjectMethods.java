package pkg1;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectMethods {
	
	public static void clickElementBasedOnText(WebDriver driver,List<WebElement> ele,String input) {
		
		List<WebElement> polType= ele;
		
		for(WebElement temp:polType) {
		String temp1=temp.getText();
		if(temp1.equals(input)) {
			temp.click();
		}
					
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
	
	


