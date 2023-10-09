package introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Cls6_navigationANDbrowsersettingMaximize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "/Volumes/Mac Vol A/Selenium_Learn/geckodriver");
		WebDriver driver=new FirefoxDriver();
		
		//screen maximize-browser setting
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		//navigation
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		//driver.navigate().back();
		//driver.navigate().forward();

	}

}
