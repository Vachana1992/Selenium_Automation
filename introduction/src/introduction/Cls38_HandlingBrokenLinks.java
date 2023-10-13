package introduction;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Cls38_HandlingBrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

		WebDriver driver= new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		
		//get the broken url
		String url= driver.findElement(By.xpath("//a[contains(@href,'brokenlink')]")).getAttribute("href");
		
		//Java method to call the url and get the status code
		
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		
		//get the code
		int respCode = conn.getResponseCode();
		System.out.println(respCode);
	}

}
