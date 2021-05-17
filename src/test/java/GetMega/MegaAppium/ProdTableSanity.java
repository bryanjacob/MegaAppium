package GetMega.MegaAppium;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
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
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class ProdTableSanity extends ProdKobitonBase {
	
	WebDriverWait 		wait = new WebDriverWait(driver, 80);;
	Wait<WebDriver> 	fluentWait;
	TouchAction 		touchAction = new TouchAction(driver);;
	String				casualCategory = "casual";
	Long 				density;
	
	

	//@Test(enabled = true)
	public void SitTable(AndroidDriver<WebElement> driver, ExtentReports extent) throws Exception {
	
		
		ExtentTest SitTable = extent.createTest("CARROM: Sit-in Table");
		
		try {
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			//Intialising fluentwait
			fluentWait = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(100))
							.pollingEvery(Duration.ofSeconds(10))
							.ignoring(NoSuchElementException.class);
					

			
			//Select Casual from Bottom Nav Bar
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, 'Casual')]"))).click();
			
			
			//Extent Log
			SitTable.info("Tapped on Casual tab");
			
			density = driver.getDisplayDensity();
			
			
			
			//Prompts Handling
			if (driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id, 'com.mega.app:id/tv_will_do_it_later')]")).size() > 0) {
				driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'com.mega.app:id/tv_will_do_it_later')]").click();
	        }
			
			
			
			//Casual Card - Play Button Click
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"PLAY\").instance(0))").click();
		     
			
			//Extent Log
			SitTable.info("Tapped on PLAY button");
			
			
			
			//Find Table button click
			fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[contains(@text, 'Find Tables')]"))).click();
			SitTable.info("Navigated to the Contest details page");
			
			
			
			//Extent Log
			SitTable.info("Tapped on 'Find Table' button");	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/content")));
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			
			
			SitTable.info("Joined Table");	
			SitTable.pass("Successfully Sit-in Table");
			
	
			SwitchTable(driver, extent);
		


		} catch (NoSuchElementException e) {

			SitTable.fail("NoSuchElementException");
			extent.flush();

		} 
		
		catch (TimeoutException e) {

			SitTable.fail("TimeoutException");
			extent.flush();

		}
		
		catch (WebDriverException e) {
			SitTable.fail("WebDriverException");
			extent.flush();
		}
		
		
		catch (Exception e) {

			System.out.print(e);

		}
	}
	
	
	public void SwitchTable(AndroidDriver<WebElement> driver, ExtentReports extent) {
		
		boolean 		hamMenuNotSelected, hamMenuNotSelectedAfterSwitch;
		int				xCoordinates, yCoordinates;
		int				xCoordFrmDensity, yCoordFrmDensity;
			
		
			ExtentTest SwitchTable  		= extent.createTest("CARROM: Switch Table");
			xCoordFrmDensity				= Math.toIntExact(24 * density/100);
			yCoordFrmDensity				= Math.toIntExact(44 * density/100);
			xCoordinates 					= 99;
			yCoordinates 					= 183;
			hamMenuNotSelected 				= true; 
			hamMenuNotSelectedAfterSwitch 	= true;
		
		
		try {
			
			SwitchTable.info("Joined Table");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			
			
			//Tapping X,Y coordinates until ham menu is selected.			
			do {
				
				touchAction.tap(PointOption.point(xCoordinates, yCoordinates)).perform();
				
				if ((driver.findElements(By.id("com.mega.app:id/iv_close")).size() > 0)) {
					
					if ((driver.findElement(By.id("com.mega.app:id/tv_switch")).isEnabled())) {
						hamMenuNotSelected = false;
					}
					else 
					{
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElement(By.id("com.mega.app:id/iv_close")).click(); 
					}
				}
				
			} while(hamMenuNotSelected);
			SwitchTable.info("Tapped on Hamburger Menu icon");
			
			
			
			//Switch button click
			driver.findElement(By.id("com.mega.app:id/tv_switch")).click();
	
			
			
			//Extent Log
			SwitchTable.info("Tapped on Switch Button within Hamburger menu");
			
			
			
			//Click on round details - table arrow icon
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mega.app:id/btn_join"))).click();
			
			
			
			//Extent Log
			SwitchTable.info("Tapped on Join button for the first table displayed in Table List");
			
			
			
			//Click on Leave button with 'Are you sure?' bottom sheet
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mega.app:id/btn_yes_leave"))).click();
		
			
			
			//Extent Log
			SwitchTable.info("Tapped on Leave button");
			
			
			//To verify the game bundle loading is complete and user has joined table
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/content")));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			
			
			//Tapping X,Y coordinates until ham menu is selected.				
			do {
				
				touchAction.tap(PointOption.point(xCoordinates, yCoordinates)).perform();
				
				if ((driver.findElements(By.id("com.mega.app:id/iv_close")).size() > 0)) {
					hamMenuNotSelectedAfterSwitch = false;
				}
				
			}while(hamMenuNotSelectedAfterSwitch);
			
			
			
			//Extent Log
			SwitchTable.info("Switched and Joined Table");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
			
			//Tapped on ham menu and then clicked on exit button
			driver.findElement(By.id("com.mega.app:id/tv_exit")).click();
			
			
			
			//Extent Log
			SwitchTable.pass("Switched and joined new table");
					
		
				
			//control passed to RummyTableSanity class
			ProdRummyTableSanity poS = new ProdRummyTableSanity();
			poS.rummySitTable(driver, extent);
				
					 
					
		} catch (NoSuchElementException e) {

			SwitchTable.fail("NoSuchElementException");
			extent.flush();

		} 
		
		catch (TimeoutException e) {

			SwitchTable.fail("Timeout");
			extent.flush();

		}
		
		catch (WebDriverException e) {
			SwitchTable.fail("WebDriverException");
			extent.flush();
		}
		
		catch (Exception e) {

			System.out.print(e);
			
		}
		
	}

}
