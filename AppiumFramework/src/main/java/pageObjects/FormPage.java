package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {

	public FormPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	public WebElement femaleOption;

	@AndroidFindBy(id= "com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countrySelection;
	
	
	//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));")
	public WebElement findArgentina;
	
	
	//this method allows logging - recommended if you wish logging for the test accounts
	public WebElement getNamefield()
	{
		System.out.println("Trying to find the Name field");
		return nameField;
	}
	
	public WebElement getCountryfield()
	{
		System.out.println("Trying to find the Country field");
		return countrySelection;
	}
	
	
}
