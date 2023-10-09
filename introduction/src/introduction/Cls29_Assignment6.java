package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Cls29_Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new FirefoxDriver();
		driver.get("http://www.qaclickacademy.com/practice.php");
		WebElement checkboxDriver= driver.findElement(By.id("checkbox-example"));
		//System.out.println(checkboxDriver.findElements(By.tagName("input")).size());
		checkboxDriver.findElement(By.id("checkBoxOption2")).click();
		String labelName= checkboxDriver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();
		driver.findElement(By.id("dropdown-class-example")).click();
		WebElement staticdropdown=driver.findElement(By.id("dropdown-class-example"));
		Select dropdown=new Select(staticdropdown);
		dropdown.selectByVisibleText(labelName);
		driver.findElement(By.id("name")).sendKeys(labelName);
		driver.findElement(By.id("confirmbtn")).click();
		if(driver.switchTo().alert().getText().contains(labelName)) {
		driver.switchTo().alert().accept();
		System.out.println("success");
		}
		else {
			driver.switchTo().alert().dismiss();
			System.out.println("failed!");
		}
		
		
		
	}

}
