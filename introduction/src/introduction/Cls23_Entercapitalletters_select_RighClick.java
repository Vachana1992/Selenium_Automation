package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Cls23_Entercapitalletters_select_RighClick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver  driver=new FirefoxDriver();
		driver.get("https://www.amazon.ca/");
		//enter capital lettersin searchbox by mousehover
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("Hello").build().perform();
	
		//selct the entire word by doubleclick
		
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("Hello").doubleClick().build().perform();
		
		a.moveToElement(driver.findElement(By.xpath("//div[@class='nav-line-1-container']/span"))).contextClick().build().perform();
	
	}

}
