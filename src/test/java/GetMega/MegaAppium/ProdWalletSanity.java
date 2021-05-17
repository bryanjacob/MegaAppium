package GetMega.MegaAppium;

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

import io.appium.java_client.android.AndroidDriver;

public class ProdWalletSanity extends ProdKobitonBase {

	WebDriverWait 		wait = new WebDriverWait(driver, 50);
	Wait<WebDriver> 	fluentWait;

	public void SitTable(AndroidDriver<WebElement> driver, ExtentReports extent) throws Exception {
		
		ExtentTest WalletSanity = extent.createTest("Wallet Sanity");
		
		try {
			
	
			//access wallet
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mega.app:id/tv_balance"))).click();
			WalletSanity.info("Tapped on Wallet icon");
			
			
			//tap on add cash button
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mega.app:id/btn_action"))).click();
			WalletSanity.info("Tapped on add cash button");
			
			
			//tap on pill one button in Add cash UI
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mega.app:id/tv_pill_one"))).click();
			WalletSanity.info("Tapped on pill one button");
			
			
			//tap on change payment mode button
			driver.findElement(By.id("com.mega.app:id/paymentModeChangeBtnTv")).click();
			WalletSanity.info("Tapped on change payment mode");
			
			
			//select Netbanking
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, 'NetBanking')]"))).click();
			WalletSanity.info("Selected NetBanking");
		
			
			//clicked on add cash button
			driver.findElement(By.id("com.mega.app:id/addMoneyBtn")).click();
			WalletSanity.info("Tapped on Add Cash button");
			
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			
			//clicked on close button in payment gateway
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@text, 'x')]")));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			
			for (int i = 0; i<5 ; i++) {
				driver.navigate().back();
			}
		
			WalletSanity.pass("Proceeded to payment gateway UI and tapped on close button");
			
		
			
			//Explicit wait for the homepage to load after login
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mega.app:id/tv_balance")));
			
			
			//control passed to ProdSideMenuNavigation
			ProdSideMenuNavigation pw = new ProdSideMenuNavigation();
			pw.SitTable(driver, extent);
			
			
			
		
		
		} catch (NoSuchElementException e) {
			WalletSanity.fail("NoSuchElementException");
			extent.flush();

		} 
		
		catch (TimeoutException e) {
			WalletSanity.fail("TimeoutException");
			extent.flush();

		}
		
		catch (WebDriverException e) {
			WalletSanity.fail("WebDriverException");
			extent.flush();
		}
		
		
		catch (Exception e) {
			System.out.print(e);

		}
		
		
		
	}	
}
