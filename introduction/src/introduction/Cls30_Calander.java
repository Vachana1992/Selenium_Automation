package introduction;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Cls30_Calander {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//click april 23rd
		
		
		
		//click the date box
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		
		//list all the dates with a common locator
		List<WebElement> dates= driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
		
		//iterate all the date list
		for(int i=0;i<driver.findElements(By.xpath("//td[@data-handler='selectDay']")).size();i++) {
			
			//check among the list any date equals 23rd
			if(driver.findElements(By.xpath("//td[@data-handler='selectDay']")).get(i).getText().equals("23")){
				
				//if 23rd finds, then click that date
				driver.findElements(By.xpath("//td[@data-handler='selectDay']")).get(i).click();
				break;
			}
		}
	}

}
