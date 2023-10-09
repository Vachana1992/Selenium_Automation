package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Cls13_enableAnddisable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Only when user clicks roundtrip return date calender should be enabled, But here
		//when user click oneway the return calender enabled is true. So we are using another method insted of isenabled
		
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
	    
       if(driver.findElement(By.xpath("//span[@id='spclearDate']")).getAttribute("style").contains("display: block;"))
       {
    	   Assert.assertTrue(true);
    	   System.out.println("return date enabled");
       }
       else
       {
    	   Assert.assertTrue(false);
    	   System.out.println("return date not enabled");
       }
		
	}

}
