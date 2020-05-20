package practice.AppiumFramework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.CheckoutPage;
import pageObjects.FormPage;

public class Econmerce_totalValidation extends base {
	
	/*@BeforeTest
	public void killAllNodes() throws IOException
	{
		
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		
	}
	*/
	
	
	@Test(dataProvider = "InputData", dataProviderClass = TestData.class)
	public void totalValidation(String input) throws IOException, InterruptedException
	{
		//startServer();
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		
		
		FormPage formpage = new FormPage(driver);
		
		System.out.println("just checking if Git works");
		System.out.println("this is another branch testing");
		System.out.println("this is another branch testing");
		System.out.println("this is another branch testing");
		System.out.println("this is another branch testing");
		System.out.println("this is another branch testing");
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Jesse");
		formpage.getNamefield().sendKeys(input);
		//driver.findElementByXPath("//*[@text='Female']").click();
		formpage.femaleOption.click();
		//driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		formpage.getCountryfield().click();
		
		//d.river.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		Utilities u = new Utilities(driver);
		u.scrollToText("Argentina");
		driver.findElementByXPath("//*[@text='Argentina']").click();
		
		
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		
//scenario 4 check if the sum price is correct		
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		
		Thread.sleep(4000);
		
		int shoeCount = driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
		double sumprice = 0;
		CheckoutPage checkOutPage= new CheckoutPage(driver);
		
		for(int i=0; i< shoeCount; i++) {
			
			String amount1 = checkOutPage.productList.get(i).getText();
			double amount = getAmount(amount1);
			sumprice = sumprice + amount;
		}
		
		
		String total = checkOutPage.totalAmount.getText();
		
		double totalprice = getAmount(total);
		
		System.out.println("sum price is : " + sumprice);
		System.out.println("total price is : " + totalprice);
		
		if(sumprice == totalprice) {
		System.out.println("price matches");
		}
		
		
		
		//service.stop();
	}
	

	
	public static double getAmount(String value) 
	{
		
		return Double.parseDouble(value.substring(1));
		
	}
	
	
}
