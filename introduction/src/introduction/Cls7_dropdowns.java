package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class Cls7_dropdowns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//as per the version 4.6.0 we don't need System.setproperty. Instead of this we have a new jar called SeleniumManager
		//and it will automatically detect the driver for the system. 
		WebDriver driver= new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//dropdown with select tag -static
		
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select dropdown= new Select(staticDropdown);
		dropdown.selectByIndex(3);//select dropdown by index(select tag-static)
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("AED");//Select dropdown by visible text(select-static)
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");//select drop down by value(select tag-static)
		System.out.println(dropdown.getFirstSelectedOption().getText());
		

	}

}
