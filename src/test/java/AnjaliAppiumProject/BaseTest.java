package AnjaliAppiumProject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
//	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		// Android driver, ios driver
		// Appium code -> Appium server -> mobile
				
		// to start appium programmatically
		service = new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe")).withAppiumJS(new File("C:\\Users\\anjali.chander\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4728).build();
		service.start();
		
		// create an object
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Nexus 4 API 34");
		options.setPlatformName("Android");
		options.setPlatformVersion("11.0");
		// options.setApp("C:\\Users\\anjali.chander\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\student-app-dev-20230831.3.apk");
//		 options.setApp("C:\\Users\\anjali.chander\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		options.setApp("C:\\Users\\anjali.chander\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\General-Store.apk");		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4728"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void longPressAction(WebElement elementLongPress) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) elementLongPress).getId(), "duration", 2000));
	}
	
	public void ScrollAction(String elementScroll) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementScroll + "\"));"));
		Thread.sleep(2000);		
	}
	
	public void ScrollToEndAction() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					"left", 100, "top", 100, "width", 200, "height", 200,
					"direction", "down",
					"percent", 3.0
					));
		} while(canScrollMore);
	}
	
	public void swipeAction(WebElement elementSwipe, String direction) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) elementSwipe).getId(), "direction", direction, "percent", 0.75));	
	}
	
//	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
}
