package introduction;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cls24_HandlingChildWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver= new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector("a.blinkingText"))).click().build().perform();

		//Get the window handle IDs of all windows we have opened
		Set<String> windows= driver.getWindowHandles();
		//Now iterate the parent and child window IDs
		Iterator<String> it = windows.iterator();//[parentID,ChildID]
		String parentId= it.next();
		String childId= it.next();
		//Now, switch to child window
		driver.switchTo().window(childId);
		//driver.get("https://rahulshettyacademy.com/documents-request");
		WebDriverWait w=new WebDriverWait(driver,Duration.ofMillis(7000));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='im-para red']")));
		//System.out.println(driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split(" ")[4]);
		String emailid = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split(" ")[4];
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(emailid);
		
	}

}
