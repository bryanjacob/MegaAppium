package GetMega.MegaAppium;

import static org.testng.Assert.assertTrue;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ProdSideMenuNavigation extends ProdKobitonBase {
	
	WebDriverWait 		wait = new WebDriverWait(driver, 50);


	public void SitTable(AndroidDriver<WebElement> driver, ExtentReports extent) throws Exception {
		
		ExtentTest SideMenuSanity = extent.createTest("Side Menu Navigation Sanity");
		
		try {
			
			//click ham menu
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mega.app:id/iv_hamburger_menu"))).click();
			
			
			//PROFILE
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, 'PROFILE')]"))).click();
			  SideMenuSanity.info("Tapped on PROFILE");
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  SideMenuSanity.info("Activity invoked [PROFILE] : " +driver.currentActivity());
			 
			 /* 
			 * boolean isProfileDisplayed =
			 * driver.findElement(By.id("com.mega.app:id/iv_profile")).isDisplayed();
			 * if(isProfileDisplayed) { SideMenuSanity.info("Profile picture is displayed");
			 * } else { SideMenuSanity.info("Profile picture not displayed"); }
			 * 
			 * 
			 * boolean isUsernameDisplayed =
			 * driver.findElement(By.id("com.mega.app:id/user_name_text")).isDisplayed();
			 * if(isUsernameDisplayed) { SideMenuSanity.info("Username is displayed"); }
			 * else { SideMenuSanity.info("Username not displayed"); }
			 * 
			 * 
			 * boolean isLocationDisplayed =
			 * driver.findElement(By.id("com.mega.app:id/location_text")).isDisplayed();
			 * if(isLocationDisplayed) { SideMenuSanity.info("Location is displayed"); }
			 * else { SideMenuSanity.info("Location not displayed"); }
			 */
			
			
			driver.navigate().back();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mega.app:id/iv_hamburger_menu"))).click();
			
			
			
			//WALLET
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, 'WALLET')]"))).click();
			SideMenuSanity.info("Tapped on WALLET");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			SideMenuSanity.info("WALLET Activity invoked: " + driver.currentActivity());
			
			
			boolean isWalletDisplayed = driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Wallet')]")).isDisplayed();
			if(isWalletDisplayed) {
				SideMenuSanity.info("Navigated to Wallet");
			}
			else
			{
				SideMenuSanity.info("Navigation to Wallet failed");
			}
			driver.navigate().back();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mega.app:id/iv_hamburger_menu"))).click();
			
			
			
			
			//MY LEADERBOARD
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, 'MY LEADERBOARD')]"))).click();
			SideMenuSanity.info("Tapped on MY LEADERBOARD");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			SideMenuSanity.info("MY LEADERBOARD Activity invoked: " + driver.currentActivity());
			driver.navigate().back();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mega.app:id/iv_hamburger_menu"))).click();
			
			
			
			//REWARDS
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, 'REWARDS')]"))).click();
			SideMenuSanity.info("Tapped on REWARDS");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			SideMenuSanity.info("REWARDS Activity invoked: " + driver.currentActivity());
			driver.navigate().back();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mega.app:id/iv_hamburger_menu"))).click();
			
			
			
			//CHAT WITH US
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, 'CHAT WITH US')]"))).click();
			SideMenuSanity.info("Tapped on CHAT WITH US");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			SideMenuSanity.info("CHAT WITH US Activity invoked: " + driver.currentActivity());
			driver.navigate().back();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mega.app:id/iv_hamburger_menu"))).click();
			
			
			
			//FAQ
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[contains(@text, 'FAQ')]")));
			SideMenuSanity.info("FAQ is clickable");
			
			
			
			//ABOUT US
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[contains(@text, 'ABOUT US')]")));
			SideMenuSanity.info("ABOUT US is clickable");
			
			
			
			//PRIVACY
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[contains(@text, 'PRIVACY')]")));
			SideMenuSanity.info("PRIVACY is clickable");
			
			
			
			//T&C
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[contains(@text, 'T&C')]")));
			SideMenuSanity.info("T&C is clickable");
			
			
			
			driver.navigate().back();
			SideMenuSanity.pass("Side menu navigation verified");
			
			
			//control passed to Table Sanity
			ProdTableSanity pt = new ProdTableSanity();
			pt.SitTable(driver, extent);
			
			
		}
		catch (NoSuchElementException e) {
			SideMenuSanity.fail("NoSuchElementException");
			extent.flush();

		} 
		
		catch (TimeoutException e) {
			SideMenuSanity.fail("TimeoutException");
			extent.flush();

		}
		
		catch (WebDriverException e) {
			SideMenuSanity.fail("WebDriverException");
			extent.flush();
		}
		
		
		catch (Exception e) {
			System.out.print(e);

		}
	
		
		
	}

}
