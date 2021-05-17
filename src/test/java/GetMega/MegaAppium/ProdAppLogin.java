package GetMega.MegaAppium;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;

public class ProdAppLogin extends ProdKobitonBase {

	@Test(enabled = true)
	public void Login() throws Exception {

		AppiumExtentReports ar 			= new AppiumExtentReports();
		ExtentReports 		extent   	= ar.setUp();
		String 				onePlus6T 	= "94e8173f";
		String 				onePlus5T   = "1951095c";
		
		
		AndroidDriver<WebElement>   driver;
		WebDriverWait 				wait;
		String 						deviceName;
		
		

		ExtentTest Logintest 			= extent.createTest("Login");


		try {

		
			driver 			= CapabilitiesForOnePlus6T();
		
			
			
			deviceName 		= driver.getCapabilities().getCapability("deviceName").toString();
			wait   			= new WebDriverWait(driver, 100);
			
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
						
			
			//Explicit wait for 'Continue with Facebook' button to be displayed
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.mega.app:id/btn_login"))).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//driver.findElement(By.id("com.mega.app:id/btn_login")).click();
			

			
			//Click 'Continue with Facebook' button
			Logintest.info("Tapped on 'Continue with Facebook' button");
			
			
			
			//Input keys for webview facebook login
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[contains(@resource-id, 'm_login_email')]")));
			driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'm_login_email')]").sendKeys("yinid5555@gmail.com");
			driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'm_login_password')]").sendKeys("light@10");
			driver.findElementByXPath("//android.view.View[contains(@resource-id, 'u_0_4')]").click();
			
			
			
			//Confirm login
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[contains(@resource-id, 'u_0_1')]"))).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			
			
			//No Contests Handling
			/*
			 * if (driver.findElements(By.id("com.mega.app:id/btn_reload")).size() > 0) {
			 * driver.findElement(By.id("com.mega.app:id/btn_reload")).click(); }
			 */
			
			System.out.println(deviceName);
			
			
			
			//confirm location
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[contains(@resource-id, 'com.mega.app:id/btn_action')]"))).click();
			Logintest.info("Tapped on'Allow Location access' button");
			
			
			
			//Location device prompt handling
			if (deviceName.equals(onePlus6T)) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[contains(@text,'ALLOW ONLY WHILE USING THE APP')]"))).click();
			}
			else if (deviceName.equals(onePlus5T)) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[contains(@text,'ALLOW')]"))).click();
			}
			else {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[contains(@text, 'Allow only while using the app')]"))).click();
			}
			
			/*
			
			//Consolidated Permission handling
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[contains(@text, 'Allow access')]"))).click();
			Logintest.info("Tapped on'Allow access' button in consolidated permission screen");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[contains(@text, 'ALLOW')]"))).click();
			Logintest.info("Allowed Contacts sync access");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[contains(@text, 'ALLOW')]"))).click();
			Logintest.info("Allowed microphone access");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[contains(@text, 'ALLOW')]"))).click();
			Logintest.info("Allowed camera access");
			
			*/
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//Prompts Handling
			if (driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id, 'com.mega.app:id/tv_will_do_it_later')]")).size() > 0) {
				driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'com.mega.app:id/tv_will_do_it_later')]").click();
	        }
			
			
			//Explicit wait for the homepage to load after login
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mega.app:id/tv_balance")));
			Logintest.info("Redirected to Home screen");
			
			
			
			Logintest.pass("Successfully logged in");
			
			
			//control passed to Wallet Sanity class
			ProdWalletSanity pw = new ProdWalletSanity();
			pw.SitTable(driver, extent);
			 

		} 
		
		catch (NoSuchElementException e) {

			Logintest.fail("NoSuchElementException");
			extent.flush();

		}
		
		catch (TimeoutException e) {

			Logintest.fail("Timeout");
			extent.flush();

		}
		
		catch (WebDriverException e) {
			Logintest.fail("WebDriverException");
			extent.flush();
		}
		
		catch (Exception e) {

			System.out.print(e);
		}
		
		


	}

}
