package introduction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;


public class Cls34_Assignment8 {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("https://qaclickacademy.com/practice.php/");
		
		//auto-suggestive drop down-
		//1.Search Ind, Once india find click it by mouse
		//2. Verify india is selected
		
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys("Ind");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys(Keys.DOWN);
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys(Keys.DOWN);
		System.out.println(driver.findElement(By.cssSelector("#autocomplete")).getAttribute("value"));

	}

}
