package practice.AppiumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {
	public static AndroidDriver<AndroidElement> driver;
	
	/*
	public static AppiumDriverLocalService service;
	public AppiumDriverLocalService startServer()
	{
		///need add some dependancies in pom.xml
		boolean serverFlag = checkIfServerIsRunning(4723);
		if (!serverFlag) {
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		return service;
		}
		
		return service;
	}
	
	*/
	
public static void startEmulator() throws IOException, InterruptedException
{
	Runtime.getRuntime().exec(System.getProperty("user.dir")+"/src/main/java/Resources/startEmulator.sh");
	Thread.sleep(6000);
}


	public static boolean checkIfServerIsRunning(int port)
	{
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			//IF control comes here then it means that the port is in use
			isServerRunning = true;
			
		} finally {
			serverSocket = null;
			
		}
		
		return isServerRunning;
		
	}
	
	
	
	
	
	
	public static AndroidDriver<AndroidElement>  Capabilities(String appName) throws IOException, InterruptedException {
		//because returned data type is android driver 
		// TODO Auto-generated method stub

		//can use system.getproperty to locate the working space of current session
		//locating the global property file to fis
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/practice/AppiumFramework/global.properties");
		//set a property file
		Properties prop = new Properties();
		//loading the global.properties as a property file
		prop.load(fis);
		
		
		
		File f = new File("src");
		//can use the stored appName from the global propery
		File fs = new File(f,(String) prop.get(appName));
		
		//can use the stored device from the global property
		//String device = (String)prop.get("device");
		String device = System.getProperty("deviceName");
		if (device.contains("Emulator"))
		{
			startEmulator();
			
		}
		
		
		
		
		
		//appium
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		//cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, cap);
		return driver;
		
	}
	
	//making the device take screenshots
	public static void getScreenshot(String s) throws IOException
	{
		File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File("/Users/jesse/Desktop/Screenshot/appiumScreenshot/"+s+".png"));
		
	}
	

}
