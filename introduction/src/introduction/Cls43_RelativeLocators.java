package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Cls43_RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver= new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement labelName= driver.findElement(with(By.tagName("label")).above(driver.findElement(By.name("name"))));
        System.out.println(labelName.getText());
        
        WebElement pwd= driver.findElement(By.id("exampleInputPassword1"));
        String labelNameBelow= driver.findElement(with(By.tagName("label")).below(pwd)).getText();
        System.out.println(labelNameBelow);
        
        WebElement dobLabel= driver.findElement(By.cssSelector("label[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dobLabel)).click();
        
        WebElement RightLabel= driver.findElement(By.className("form-check-label"));
        driver.findElement(with(By.tagName("input")).toLeftOf(RightLabel)).click();
        
        WebElement leftlabel= driver.findElement(By.id("inlineRadio1"));
        String rightText= driver.findElement(with(By.tagName("label")).toRightOf(leftlabel)).getText();
        System.out.println(rightText);
	}

}
