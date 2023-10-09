package introduction;

import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Cls28_Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Find the count of the links in the webpage
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.qaclickacademy.com/practice.php");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		
		//Find the count of the links in the footer section only
		//For that we have to create a new scope
		//so instead of driver I create a new webelement for footer only
		
		WebElement footerDriver=driver.findElement(By.id("gf-BIG"));//Limiting webdriver scope
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		
		//Get the count of the links in the 1st column of the footer
		
		WebElement columnDriver=  footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size());
        
        //Click on each link in the column and check if the pages are opening
        
        
        for(int i=1;i<columnDriver.findElements(By.tagName("a")).size();i++) {
        	
        	//need to click every link and it has to be open in seperate windows otherwise stale element error should be shown
        	///for that we use key fn
        	
        	String clickOnLinkTab= Keys.chord(Keys.COMMAND,Keys.ENTER);
        	
        	columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
        	Thread.sleep(5000L);
        	
        	 }
        //Getting title of each child tab
        Set<String> windows= driver.getWindowHandles();
    	Iterator<String> it= windows.iterator();
    	while(it.hasNext()) {
    	driver.switchTo().window(it.next());
    	System.out.println(driver.getTitle());
    	}
    	
    	
	}

}
