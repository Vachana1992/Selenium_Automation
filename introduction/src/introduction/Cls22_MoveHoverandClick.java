package introduction;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Cls22_MoveHoverandClick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.ca/");
		
		//MouseHover actions
		
		Actions a= new Actions(driver);
		
		a.moveToElement(driver.findElement(By.xpath("//div[@class='nav-line-1-container']/span"))).build().perform();
		
		
	}

}
