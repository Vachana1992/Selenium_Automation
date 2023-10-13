package introduction;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Cls40_SoftAssertion {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver= new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice");

		SoftAssert a= new SoftAssert();
		
		List<WebElement> links= driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		
		for(WebElement link:links) {

			String url= link.getAttribute("href");
			HttpURLConnection conn= (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			
			int respCode= conn.getResponseCode();
			System.out.println(respCode);
			//Hard Assert
			//Assert.assertTrue(respCode<400, "The Link with Text "+link.getText()+"is broken with responseCode "+respCode);
			
			//Soft Assert applies here
			a.assertTrue(respCode<400, "The Link with Text "+link.getText()+"is broken with responseCode "+respCode);
	}
		a.assertAll();

	}

}
