package introduction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Cls31_CalanderwithMonthandyear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		driver.findElement(By.xpath("//span[@class='ng-tns-c58-10 ui-calendar']/input")).click();
		//click the month
				while(!driver.findElement(By.xpath("//div[@class='ui-datepicker-title ng-tns-c58-10']/span[@class='ui-datepicker-month ng-tns-c58-10 ng-star-inserted']")).getText().contains("January")) {
					
					driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all ng-tns-c58-10 ng-star-inserted']")).click();
				}
		
		List<WebElement> dates= driver.findElements(By.xpath("//td[@class='ng-tns-c58-10 ng-star-inserted']"));
		int count= driver.findElements(By.xpath("//td[@class='ng-tns-c58-10 ng-star-inserted']")).size();

		for(int i=0;i<count;i++) {
			if(driver.findElements(By.xpath("//td[@class='ng-tns-c58-10 ng-star-inserted']")).get(i).getText().equals("23")) {
				driver.findElements(By.xpath("//td[@class='ng-tns-c58-10 ng-star-inserted']")).get(i).click();
				break;
			}
			
		}
	}

}
