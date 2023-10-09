package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Cls5_childTochild_Traverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "/Volumes/Mac Vol A/Selenium_Learn/geckodriver");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//div/button[1]/following-sibling::button[1]")).click();//sibling to sibling traverse
		System.out.println(driver.findElement(By.xpath("//div/button[1]/following-sibling::button[1]")).getText());
		
		//child to parent traverse
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
	}

}
