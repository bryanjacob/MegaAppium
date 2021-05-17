package GetMega.MegaAppium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FacebookLogin {
	String accountName; 
	String password;
	
	
	@Parameters({"accounts", "password"})
	public void account(String account, String pwd) {
		accountName = account; 
		password = pwd;
		
	}
	
	public void Login (AndroidDriver<WebElement> driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		
		
		driver.findElementById("m_login_email").sendKeys(accountName);
		
		driver.findElementById("m_login_password").sendKeys(password);
		
		driver.findElement(By.name("login"));
	}
	
	

}
