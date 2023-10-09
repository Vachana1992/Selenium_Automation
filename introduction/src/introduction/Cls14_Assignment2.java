package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Cls14_Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Vachana");
		driver.findElement(By.name("email")).sendKeys("vachan@yahoo.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("123");
		driver.findElement(By.cssSelector("input#exampleCheck1")).click();
		
		WebElement opt= driver.findElement(By.id("exampleFormControlSelect1"));
		Select option=new Select(opt);
		option.selectByIndex(1);
		
		driver.findElement(By.xpath("//input[@id='inlineRadio2']")).click();
		
		driver.findElement(By.name("bday")).sendKeys("1993-03-02");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
		String msg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		System.out.println(msg);
		
	}

}
