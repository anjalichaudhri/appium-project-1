package AnjaliAppiumProject;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest {
	@Test
	public void LongPressElement() throws MalformedURLException, InterruptedException {
		// gestures section - 6 - long press, scroll, swipe
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"));"));
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement elementLongPress = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longPressAction(elementLongPress);
		String menuText = driver.findElement(By.id("android:id/title")).getText();
		
		//Assertions
		Assert.assertEquals(menuText, "Sample menu");
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		// Thread.sleep(2000);
	}

}
