package introduction;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Cls39_BrokenLinksWithIteration {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver= new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice");

		List<WebElement> links= driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		
		for(WebElement link:links) {

			String url= link.getAttribute("href");
			HttpURLConnection conn= (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			
			int respCode= conn.getResponseCode();
			if(respCode>400) {
				System.out.println("The link with text " +link.getText()+" is broken with responsecode "+ respCode);
				Assert.assertTrue(false);
			}
		}
	}

}
