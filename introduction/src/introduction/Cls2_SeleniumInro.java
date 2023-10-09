package introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Cls2_SeleniumInro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "/Volumes/Mac Vol A/Selenium_Learn/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	    driver.close();
	   

	}

}
