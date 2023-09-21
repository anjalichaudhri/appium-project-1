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

public class ScrollDemo extends BaseTest {
	@Test
	public void ScollDemoTest() throws MalformedURLException, InterruptedException {
		// gestures section - 6 - long press, scroll
		ScrollAction("Views");
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//have prior idea about the element
		// driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\");"));
		
		// no prior idea whether element exist or not.
		ScrollToEndAction();
		
		// Apply waits
		// Thread.sleep(2000);
	}

}

