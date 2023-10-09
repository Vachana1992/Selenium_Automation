package introduction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Cls33_Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("https://qaclickacademy.com/practice.php/");
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		js.executeScript("document.querySelector(\"table[name='courses']\")");
		List<WebElement> rows= driver.findElements(By.xpath("//table[@name='courses']/tbody/tr"));
		List<WebElement> columns= driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th"));
		
		int rowsNum= rows.size();
		int colnum=columns.size();
		System.out.println("No of rows in first table "+ rowsNum);
		System.out.println("No of columns in first table "+ colnum);
		
		
		System.out.println(driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[3]")).getText());
			

		
 
	}

}
