package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By signOut = By.xpath("//button[text()='Sign out']");
	
	By welcomemsg = By.xpath("//h4");
	
	public void clickOnSignout()
	{
		driver.findElement(signOut).click();
	}
	
	public String getWelcomeMsg()
	{
		return driver.findElement(welcomemsg).getText();
	}
	
	

}
