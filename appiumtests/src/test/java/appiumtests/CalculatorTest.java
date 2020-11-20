 package appiumtests;
//Creating simple testing functions with Java in Appium
//Ricky Marchant

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CalculatorTest {
	static AppiumDriver<MobileElement> driver;
	public static void main(String[] args) 
	{
		try
		{
			openCalculator();
		} catch (Exception exp)
		{
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	//set up Calculator capability settings.
	public static void openCalculator() throws Exception
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "SAMSUNG-SM-G930V");
		cap.setCapability("udid", "b786264c");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.0.0");
		cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		cap.setCapability("automationName", "UiAutomator2");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		System.out.println("Application started!!! : ");
		addTwoElementsCheck();
		multiplyAndSubtractCheck();
	}
	
	//Add method. Currently result will be 8. Should be set up as a test later on.
	public static void addTwoElementsCheck()
	{
		MobileElement firstOperand = driver.findElementById("com.sec.android.app.popupcalculator:id/bt_02");
		MobileElement additionSign = driver.findElementById("com.sec.android.app.popupcalculator:id/bt_add");
		MobileElement secondOperand = driver.findElementById("com.sec.android.app.popupcalculator:id/bt_06");
		MobileElement equalSign = driver.findElementById("com.sec.android.app.popupcalculator:id/bt_equal");
		
		firstOperand.click();
		additionSign.click();
		secondOperand.click();
		equalSign.click();
		
		MobileElement result = driver.findElementByClassName("android.widget.EditText");
		
		String res = result.getText();
		System.out.println("\n Result for addTwoElementsCheck is : " + res);
		System.out.println("Completeted...");
	}
	
	//Multiplying AND subtracting method. Currently yields 16.
	public static void multiplyAndSubtractCheck()
	{
		MobileElement firstOperand = driver.findElementById("com.sec.android.app.popupcalculator:id/bt_07");
		MobileElement multiplySign = driver.findElementById("com.sec.android.app.popupcalculator:id/bt_mul");
		MobileElement secondOperand = driver.findElementById("com.sec.android.app.popupcalculator:id/bt_03");
		MobileElement subtractSign = driver.findElementById("com.sec.android.app.popupcalculator:id/bt_sub");
		MobileElement thirdOperand = driver.findElementById("com.sec.android.app.popupcalculator:id/bt_05");
		MobileElement equalSign = driver.findElementById("com.sec.android.app.popupcalculator:id/bt_equal");
		
		firstOperand.click();
		multiplySign.click();
		secondOperand.click();
		subtractSign.click();
		thirdOperand.click();
		equalSign.click();
		
		MobileElement result = driver.findElementByClassName("android.widget.EditText");
		
		String res = result.getText();
		System.out.println("\n Result for multiplyAndSubtractCheck method is : " + res);
		System.out.println("Completeted...");
	}

}
