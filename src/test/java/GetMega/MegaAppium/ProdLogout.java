package GetMega.MegaAppium;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;

public class ProdLogout extends ProdKobitonBase {
	
	//@Test(enabled = true)
	public void Logout(AndroidDriver<WebElement> driver, ExtentReports extent) {
		
		
		WebDriverWait 	wait = new WebDriverWait(driver, 50);
		ExtentTest 		LogoutTest = extent.createTest("Logout");
		
		try {
					
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			
			//Explicit wait for ham icon to be displayed
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[contains(@resource-id, 'com.mega.app:id/iv_hamburger_menu')]")));
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
			
			
			//Click Profile icon
			driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id, 'com.mega.app:id/iv_hamburger_menu')]").click();
			LogoutTest.info("Tapped on hamburger side menu icon");
    
			
			
			//Click Logout
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@resource-id, 'com.mega.app:id/tv_logout')]")));
			driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'com.mega.app:id/tv_logout')]").click();
			LogoutTest.info("Clicked on Logout button in side menu");
		
			
			
			//Confirm logout via bottom sheet
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[contains(@resource-id, 'com.mega.app:id/btn_cancel')]")));
			driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'com.mega.app:id/btn_cancel')]").click();
			
			
			
			//Explicit wait for 'Continue with Facebook' button to be displayed
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mega.app:id/btn_login")));
			LogoutTest.pass("Successfully logged out");
			
			
			
			
			extent.flush();
			
		} catch (NoSuchElementException e) {

			LogoutTest.fail("NoSuchElementException");
			extent.flush();

		} 
		
		catch (TimeoutException e) {

			LogoutTest.fail("NoSuchElementException");
			extent.flush();

		} 
		
		catch (WebDriverException e) {
			LogoutTest.fail("WebDriverException");
			extent.flush();
		}
		
		
		catch (Exception e) {
			LogoutTest.fail("Error");
			extent.flush();
		}
		
		
	}
		
}
