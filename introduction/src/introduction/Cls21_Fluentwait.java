package introduction;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cls21_Fluentwait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
//		WebDriverWait w=new WebDriverWait(driver,Duration.ofMillis(7000));
//		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
//		System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText());
	
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(30L))
			       .pollingEvery(Duration.ofSeconds(5L))
			       .ignoring(NoSuchElementException.class);

			   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			    	 if(driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed()){
			    	 
			       return driver.findElement(By.xpath("//div[@id='finish']/h4"));
			   }
			    	 else{
			    		 return null;
			    	 }
			     }
			   });
			   System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText());
	
	}
	
	
	

}
