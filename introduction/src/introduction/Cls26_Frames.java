package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Cls26_Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new FirefoxDriver();
		driver.get("https://jqueryui.com/droppable/");
		
		//switching to iframe by index
		//--------------------------------
		//for that first we have to know howmany iframes present in webpage
		//for that we will use By.tagname and it will return the number tagnames as iframes
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		//There are only 1 iframe.So we can switch to that iframe by using index
		driver.switchTo().frame(0);
		
		//switching to frame by webelement
		//----------------------------------
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		
		//drag and drop
		//----------------
		Actions a= new Actions(driver);
		WebElement source= driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source,target).build().perform();
		
		driver.switchTo().defaultContent();
		
	}

}
