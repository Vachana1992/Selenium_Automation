package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Cls11_Checkboxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
		driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).click();
		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
		
		//count of check boxes- To find that we have to find the common element in all checkboxes , here it is type
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		Assert.assertEquals(6, driver.findElements(By.xpath("//input[@type='checkbox']")).size());
;	}

}
