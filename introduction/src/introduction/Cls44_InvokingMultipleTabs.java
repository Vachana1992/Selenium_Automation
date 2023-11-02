package introduction;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Cls44_InvokingMultipleTabs {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver =new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//OPEN A NEW WINDOW
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> handles= driver.getWindowHandles();
		Iterator<String> it= handles.iterator();
		String parentId= it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
		driver.get("https://rahulshettyacademy.com/");
		String coursename= driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(1).getText();
		driver.switchTo().window(parentId);
		WebElement name= driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(coursename);
		
		//Taking screenshot
		File file= name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		
		//Get height and width of the web element
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
		
		
	}
	

}
