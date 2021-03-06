package com.finacus.WebPortal;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Yoayumovil extends YoayumovilXpath {

	private static final String DECLINE = null;
	public static URL url;
	public static DesiredCapabilities capabilities;
	public static AndroidDriver<MobileElement> driver;
	private AndroidDriver d;

	@BeforeSuite
	public void setUp() throws MalformedURLException 
	{
		try
		{			
			capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "V2025");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
			capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			capabilities.setCapability("APP_PACKAGE","com.finacus.yoayumoviluat");
			capabilities.setCapability("APP_ACTIVITY","crc645eda2270212ad276.SplashActivity");

			d = new AndroidDriver<MobileElement>(url,capabilities);
			//d.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			//d.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
			d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Launch Yoayumoviluat");	
		}

		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Setup Completed");
		}	
	}
	@Test (priority=1)
	public void LoginTCLogin() throws InterruptedException 
	{
 
		Thread.sleep(300);

		d.findElement(By.className(LoginPin)).sendKeys("1111");
		System.out.println("Enter Login PIN");

		d.findElement(By.className(Loginbutton)).click();
		System.out.println("Click on Login Button");

		Thread.sleep(300);
	}

	@AfterSuite
	public void tearDown() 
	{
		d.quit();
	}
}
