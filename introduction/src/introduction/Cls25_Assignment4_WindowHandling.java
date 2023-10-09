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

public class Cls25_Assignment4_WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[@target='_blank']"))).click().build().perform();

		Set<String> windows= driver.getWindowHandles();
		Iterator<String> it =windows.iterator();
		String parentid= it.next();
		String childid=it.next();
		driver.switchTo().window(childid);
		WebDriverWait w= new WebDriverWait(driver,Duration.ofMillis(7000));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='example']/h3")));
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
		driver.switchTo().window(parentid);
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
		
		
}
}