
package com.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author CHANDAN KR. MALHOTRA
 * This class contains parameterized methods to open the browser by passing browser name and URL.
 */

public class BrowserFactory extends TestBase{
	
	public static WebDriver startBrowser(String browsername) {
		if(browsername.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browsername.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		//driver.get(url);
		
		driver.manage().window().maximize();

		return driver;
	}

}
