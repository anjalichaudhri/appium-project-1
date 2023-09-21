package AnjaliAppiumProject;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class WebBasics {
	public WebDriver wdriver;
	AndroidDriver driver;
	@Test
	public void Launchbrowser() throws MalformedURLException {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		wdriver = new FirefoxDriver();
		wdriver.get("https://www.ebay.com/");
//		driver.quit();
	}
	
	public void WifiSettingsName() throws MalformedURLException {
		// App Setup
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 6 API 31");
		options.setApp("C:\\Users\\anjali.chander\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");		
		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		
		// automation code		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
	}
	
	public void closeBrowser() {
		wdriver.quit();
	}
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		WebBasics ab2 = new WebBasics();
		
		ab2.Launchbrowser();
		ab2.WifiSettingsName();
		ab2.closeBrowser();
	}
}
