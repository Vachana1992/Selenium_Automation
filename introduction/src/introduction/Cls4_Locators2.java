package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Cls4_Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "/Volumes/Mac Vol A/Selenium_Learn/geckodriver");
		WebDriver driver=new FirefoxDriver();
		
		
		String pwd= getPassword(driver);
		String username="rahul";
		driver.get(" https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(username);
		driver.findElement(By.name("inputPassword")).sendKeys(pwd);
		driver.findElement(By.className("signInBtn")).click();
		
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+username+",");
		System.out.println(driver.findElement(By.tagName("p")).getText());
//		String text1= driver.findElement(By.xpath("//div[@class='login-container']/p")).getText();
//		System.out.println(text1);
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		
//		driver.findElement(By.xpath("//button[@class='logout-btn']")).click();//xpath
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();//xpath by usig text
		

		
		
	}
	

	public static  String getPassword( WebDriver driver) throws InterruptedException
	{
		driver.get(" https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Reset Login']")).click();
		String passwordText= driver.findElement(By.className("infoMsg")).getText();
		String[] PasswordArray = passwordText.split(" ");
		String password= PasswordArray[4].substring(1, 19);
		return password;

	}
}
