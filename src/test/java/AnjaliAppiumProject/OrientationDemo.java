package AnjaliAppiumProject;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class OrientationDemo extends BaseTest {
	@SuppressWarnings("deprecation")
	@Test
	public void OrientationTest() throws MalformedURLException, InterruptedException {
		
		// App package(i.e. full app name i.e., AnjaliAppiumProject) and App Activity(each page of a mobile app is an activity e.g. Start Page, Drag and Drop Page,Gallery page, WiFi settings page).
		// adb shell dumpsys window | find "mCurrentFocus" - command to get App activity
//				io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies - anything after forward slash is activity name and before that is package name.
		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);

		driver.findElement(By.id("android:id/checkbox")).click();
		// Landscape mode
		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
	
		driver.setClipboardText("Anjali");
//		driver.findElement(By.id("android:id/edit")).sendKeys("Anjali");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		// Apply waits
		Thread.sleep(2000);
	}

}

