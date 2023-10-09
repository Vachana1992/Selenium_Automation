package introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class Cls3_Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "/Volumes/Mac Vol A/Selenium_Learn/geckodriver");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//code for implicit wait
		
		driver.get(" https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");// ID Locator
		driver.findElement(By.name("inputPassword")).sendKeys("abc");//name locator
		driver.findElement(By.className("signInBtn")).click();//classname locator
		
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());//Css selector locator-this code may not work if the implicit wait (line 19) is not there.
		
		driver.findElement(By.linkText("Forgot your password?")).click();//linktext locator
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Rahul");//xpath locator
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("rahulshettyacademy@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("rahulshettyacaemy123@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("rahulshetty980@gmail.com");//xpath with parent-child index
		
		
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9765678987");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("9876543210");//parent-child traverse in css selctor
		driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).clear();
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234567890");//parent-child traverse xpath
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		//System.out.println(driver.findElement(By.xpath("//p[@class='infoMsg']")).getText());
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();//parent-child traverse with index
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");//css selector by regular expression(contains attribute value as pass)
		//driver.findElement(By.xpath("//input[contains(@class,'pass')]")).sendKeys("rahulshettyacademy");//xpath by regular expression(contains attribute value as pass)
		Thread.sleep(1000);
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		//driver.quit();
	}

}
