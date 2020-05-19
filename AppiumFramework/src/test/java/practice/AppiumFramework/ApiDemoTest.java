package practice.AppiumFramework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ApiDemoTest extends base{
	@Test
	public void apiDemo() throws IOException, InterruptedException {
		//startServer();
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabilities("ApiDemos");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		//How to scroll down - You can only scroll down by using Android methods
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
		
		
		//service.stop();
	}

}
