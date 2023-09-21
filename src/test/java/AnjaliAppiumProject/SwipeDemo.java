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

public class SwipeDemo extends BaseTest {
	@Test
	public void SwipeDemoTest() throws MalformedURLException, InterruptedException {
		// gestures section - 6 - long press, scroll
		ScrollAction("Views");
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
//		ScrollAction("Gallery");
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();
		WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")), "true");
		
		// swipe
		swipeAction(firstImage,"left");
		
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImagView)[1]")), "false");

		// Apply waits
		// Thread.sleep(2000);
	}

}

