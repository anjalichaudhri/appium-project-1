package AnjaliAppiumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.net.MalformedURLException;
import java.net.URL;
public class AppiumBasics2 extends BaseTest{
	public WebDriver wdriver;
	AndroidDriver driver;
	private static AppiumBasics2 appiumBasics2 = null;
//	public AppiumDriverLocalService service;
	private AppiumBasics2() {
		
	}
	
	public static AppiumBasics2 AppiumBasics2()
    {
        // To ensure only one instance is created
        if (appiumBasics2 == null) {
            appiumBasics2 = new AppiumBasics2();
        }
        return appiumBasics2;
    }
	
	@Test
	public void Launchbrowser() throws MalformedURLException {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		wdriver = new FirefoxDriver();
		wdriver.get("https://www.ebay.com/");
//		driver.quit();
	}
	
	public void searchProduct() throws InterruptedException {
		Thread.sleep(4000);
		wdriver.findElement(By.id("gh-ac")).sendKeys("JBL Speakers");
		wdriver.findElement(By.id("gh-btn")).click();
		Thread.sleep(2000);
		wdriver.findElement(By.linkText("Daily Deals")).click();
	}
	
	public void Navigate() throws InterruptedException {
		Thread.sleep(4000);
		wdriver.navigate().to("https://www.youtube.com/");
		Thread.sleep(2000);
		wdriver.navigate().back();
		System.out.println("The title of the page is " + wdriver.getTitle());
	}
	
	public void closeBrowser() {
		wdriver.quit();
	}
	
	public void WifiSettingsName() throws MalformedURLException {
		// ConfigureAppium();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 6 API 31");
		options.setApp("C:\\Users\\anjali.chander\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");		
//		options.setAppPackage("com.grapeseed.student.test");
//		options.setAppActivity("com.gsstudentapp.MainActivity");
		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		// automation code
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
//		driver.findElement(By.id("android:id/checkbox")).click();
//		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
////		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
////		Assert.assertEquals(alertTitle, "WiFi settings");
//		driver.findElement(By.id("android:id/edit")).sendKeys("Anjali");
//		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
//		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
	
	public void tearDown() {
		driver.quit();
//		service.stop();
	}
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AppiumBasics2 ab2 = AppiumBasics2.AppiumBasics2();
		
		ab2.Launchbrowser();
		ab2.WifiSettingsName();
		ab2.searchProduct();
		ab2.Navigate();
		ab2.closeBrowser();
//		ab2.tearDown();
	}
}
