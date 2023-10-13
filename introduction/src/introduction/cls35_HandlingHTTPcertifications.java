package introduction;



import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class cls35_HandlingHTTPcertifications {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//FirefoxOptions/ChromeOptions/EdgeOptions will help to set the behaviour of the respected browsers
//1.set up ssl certification
		FirefoxOptions options= new FirefoxOptions();
	    options.setAcceptInsecureCerts(true);// when this property sets it will bypass the error msg when a site certificate is failed to load
	    
		WebDriver driver = new FirefoxDriver(options);
		driver.get("http://expired.badssl.com");
		driver.getTitle();
		
		
//More FireFox/ChromeOptions visit- https://chromedriver.chromium.org/capabilities
		
//2. set proxy
		
		Proxy proxy=new Proxy();
		proxy.setHttpProxy("myhttpproxy:3337");
		options.setCapability("proxy", proxy);
		
//3. Blocking  a pop up
		
//		options.setExperimentalOption("excludeSwitches",
//		     Arrays.asList("disable-popup-blocking"));
		
//4. Download to a directory
//		Map<String, Object> prefs = new HashMap<String, Object>();
//		prefs.put("download.default_directory", "/directory/path");
//		options.setExperimentalOption("prefs", prefs);

	}

}
