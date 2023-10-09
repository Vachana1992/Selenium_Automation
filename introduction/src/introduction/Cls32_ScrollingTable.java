package introduction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Cls32_ScrollingTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice");
		//window level scrolling
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		//table scroll
		
		js.executeScript("document.querySelector(\".tableFixHead\").scrolltop=5000 ");
		
		
		//sum the amount in the 4th coulmn/sum amount
		
		List<WebElement> values= driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int sum=0;
        for(int i=0;i<values.size();i++) {
        	sum=sum+Integer.parseInt(values.get(i).getText());
        }
		System.out.println(sum);
		
		//Extract the total amount and compare
        String amountInPage= driver.findElement(By.cssSelector(".totalAmount")).getText();
        String[] splitAmt= amountInPage.split(":");
         int totalamt= Integer.parseInt(splitAmt[1].trim());
        	
        	Assert.assertEquals(totalamt, sum);
        	
        	//Adding and getting total price in left table
        	js.executeScript("document.querySelector(\'#product\').scrolltop=5000");
        	List<WebElement> prices= driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/td[3]"));
        	int total=0;
        	for(int i=0;i<prices.size();i++) {
        		total=total+Integer.parseInt(prices.get(i).getText());
        		
            }
        	System.out.println(total);
        	}
      		
        	}
        	
        	


	


