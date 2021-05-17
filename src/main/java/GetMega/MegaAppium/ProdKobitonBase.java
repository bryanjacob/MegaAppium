package GetMega.MegaAppium;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ProdKobitonBase {
	
public static AndroidDriver<WebElement> driver;
	
	public static AndroidDriver<WebElement> CapabilitiesForPixel() throws IOException {


		String kobitonServerUrl = "https://bryanjacob:f4ee91d3-99cf-485e-9f93-cb7a4d742f29@api.kobiton.com/wd/hub";
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// The generated session will be visible to you only. In case you want this session available for other users, please assign this device to specific group. 
		capabilities.setCapability("sessionName", "OnboarderFix_Release");
		capabilities.setCapability("sessionDescription", "");
		capabilities.setCapability("deviceOrientation", "portrait");
		capabilities.setCapability("captureScreenshots", true);
		// The maximum size of application is 500MB
		// By default, HTTP requests from testing library are expired
		// in 2 minutes while the app copying and installation may
		// take up-to 30 minutes. Therefore, you need to extend the HTTP
		// request timeout duration in your testing library so that
		// it doesn't interrupt while the device is being initialized.
		capabilities.setCapability("app", "kobiton-store:v216955");
		
		capabilities.setCapability("deviceGroup", "KOBITON");
		// For deviceName, platformVersion Kobiton supports wildcard
		// character *, with 3 formats: *text, text* and *text*
		// If there is no *, Kobiton will match the exact text provided
		capabilities.setCapability("deviceName", "Pixel 3a");
		capabilities.setCapability("platformVersion", "11");
		capabilities.setCapability("platformName", "Android");  

		driver = new AndroidDriver<WebElement>(new URL(kobitonServerUrl), capabilities);
		Location loc = new Location(27.2046, 77.4977, 0);
		driver.setLocation(loc);
		return driver;
	}
	
	
	public static AndroidDriver<WebElement> CapabilitiesForOnePlus6T() throws IOException {


		String kobitonServerUrl = "https://bryanjacob:f4ee91d3-99cf-485e-9f93-cb7a4d742f29@api.kobiton.com/wd/hub";
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("sessionName", "Release_5.5.7");
		capabilities.setCapability("sessionDescription", "");
		capabilities.setCapability("deviceOrientation", "portrait");
		capabilities.setCapability("captureScreenshots", true);
		// The maximum size of application is 500MB
		// By default, HTTP requests from testing library are expired
		// in 2 minutes while the app copying and installation may
		// take up-to 30 minutes. Therefore, you need to extend the HTTP
		// request timeout duration in your testing library so that
		// it doesn't interrupt while the device is being initialized.
		capabilities.setCapability("app", "kobiton-store:v219964");
		
		// The given group is used for finding devices and the created session will be visible for all members within the group.
		capabilities.setCapability("groupId", 1756); // Group: Android
		capabilities.setCapability("deviceGroup", "KOBITON");
		// For deviceName, platformVersion Kobiton supports wildcard
		// character *, with 3 formats: *text, text* and *text*
		// If there is no *, Kobiton will match the exact text provided
		capabilities.setCapability("deviceName", "OnePlus6T");
		capabilities.setCapability("platformVersion", "10");
		capabilities.setCapability("platformName", "Android");   

		driver = new AndroidDriver<WebElement>(new URL(kobitonServerUrl), capabilities);
		Location loc = new Location(27.2046, 77.4977, 0);
		driver.setLocation(loc);
		return driver;
	}
	

	public static AndroidDriver<WebElement> CapabilitiesForOnePlus5T() throws IOException {


		String kobitonServerUrl = "https://bryanjacob:f4ee91d3-99cf-485e-9f93-cb7a4d742f29@api.kobiton.com/wd/hub";
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// The generated session will be visible to you only. In case you want this session available for other users, please assign this device to specific group. 
		capabilities.setCapability("sessionName", "Release_OnePlus5T");
		capabilities.setCapability("sessionDescription", "");
		capabilities.setCapability("deviceOrientation", "portrait");
		capabilities.setCapability("captureScreenshots", true);
		// The maximum size of application is 500MB
		// By default, HTTP requests from testing library are expired
		// in 2 minutes while the app copying and installation may
		// take up-to 30 minutes. Therefore, you need to extend the HTTP
		// request timeout duration in your testing library so that
		// it doesn't interrupt while the device is being initialized.
		capabilities.setCapability("app", "kobiton-store:v210608");
		
		capabilities.setCapability("deviceGroup", "KOBITON");
		// For deviceName, platformVersion Kobiton supports wildcard
		// character *, with 3 formats: *text, text* and *text*
		// If there is no *, Kobiton will match the exact text provided
		capabilities.setCapability("deviceName", "OnePlus5T");
		capabilities.setCapability("platformVersion", "9");
		capabilities.setCapability("platformName", "Android"); 
		
		driver = new AndroidDriver<WebElement>(new URL(kobitonServerUrl), capabilities);
		Location loc = new Location(27.2046, 77.4977, 0);
		driver.setLocation(loc);
		return driver;
}
	

}
