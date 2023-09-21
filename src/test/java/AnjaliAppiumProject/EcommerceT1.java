package AnjaliAppiumProject;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.URL;

public class EcommerceT1 extends BaseTest {
	@Test
	public void FillFormTest() throws MalformedURLException, InterruptedException {
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 6 API 31");
		options.setApp("C:\\Users\\anjali.chander\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\General-Store.apk");
//		options.setAppPackage("com.grapeseed.student.test");
//		options.setAppActivity("com.gsstudentapp.MainActivity");
		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Anjali ANjali");
		Thread.sleep(5000);
		driver.hideKeyboard();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/text1")).click();
		Thread.sleep(2000);		
//		String elementTillScroll = "Argentina";
//		ScrollAction(elementTillScroll);
//		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Albania']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//		Thread.sleep(1000);
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");
		Thread.sleep(10000);
		driver.quit();
	}
}
