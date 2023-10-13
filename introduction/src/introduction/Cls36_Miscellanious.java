package introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Cls36_Miscellanious {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new FirefoxDriver();
		
		//maximize the window
		
		driver.manage().window().maximize();
		driver.get("https://google.com");
		
		//delete all cookie
		driver.manage().deleteAllCookies();
		
		//delete a cookie
		
		driver.manage().deleteCookieNamed("session cookie");
		
		
		
	}

}
