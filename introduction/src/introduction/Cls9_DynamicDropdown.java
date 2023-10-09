package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Cls9_DynamicDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Two ways of selecting dynamic dropdown
		
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//1. Selecting dynmaic dropdown using indexes
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		

//		driver.findElement(By.xpath("//a[@value='BLR']")).click(); //Selecting dynmaic dropdown using indexes
//		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); //Selecting dynmaic dropdown using indexes
		
		
		//2. Selecting dynmaic dropdown using parent-child relationship xpath
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

	}

}
