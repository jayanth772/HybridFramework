package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By user = By.id("email1");
	
	By pass = By.name("password1");
	
	By signinbutton = By.xpath("//button[text()='Sign in']");
	
	By loginHeader = By.xpath("//h2[text()='Sign In']");
	
	public void loginToApplication(String username, String password) {
		driver.findElement(user).sendKeys(username);
		driver.findElement(pass).sendKeys(password);
		driver.findElement(signinbutton).click();
		
	}
	
	public boolean isSignInPresent()
	{
		return driver.findElement(loginHeader).isDisplayed();
	}
	

}
