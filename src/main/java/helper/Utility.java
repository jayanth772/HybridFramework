package helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

public class Utility {
	
	public static WebElement highlightElement(WebDriver driver,WebElement element) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].setAttribute('style','background:yellow; border:2px solid red')",element);
		
		waitforseconds(1);
		
		js.executeScript("arguments[0].setAttribute('Style','border:2px solid white;')",element);
		
		return element;
		
	}
	
	public static WebElement highlightElement(WebDriver driver,By locator) {
		
		WebElement element=driver.findElement(locator);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].setAttribute('style','background:yellow; border:2px solid red')",element);
		
		waitforseconds(1);
		
		js.executeScript("arguments[0].setAttribute('Style','border:2px solid white;')",element);
		
		return element;
		
	}
	
	public static Alert waitforalert(WebDriver driver) {
		
		Alert alt=null;
		
		for(int i=0;i<=15;i++) {
			try {
				alt=driver.switchTo().alert();
				break;
			} catch (NoAlertPresentException e) {
				System.out.println("No Alert Found- Waiting for ALert");
				waitforseconds(1);
			} 
		}
		
		return alt;
	}
	public static Alert waitforalert(WebDriver driver,int time) {
		
		Alert alt=null;
		
		for(int i=0;i<=time;i++) {
			try {
				alt=driver.switchTo().alert();
				break;
			} catch (NoAlertPresentException e) {
				System.out.println("No Alert Found- Waiting for ALert");
				waitforseconds(1);
			} 
		}
		
		return alt;
	}
	
	public static void waitforseconds(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (Exception e) {
			
		}
	}
	
	public static String capturescreenshotInbase64(WebDriver driver)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		String base64 = ts.getScreenshotAs(OutputType.BASE64);
		return base64;
		
	}
	
	public static void capturescreenshot(WebDriver driver) {
		try {
			FileHandler.copy(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),new File("./MyScreenshot1.png"));
			}
			catch(IOException e) {
				System.out.println(e.getMessage());
			}
	}
	
	public static String getCurrentTime() {
		String date=new SimpleDateFormat("HH-mm-ss_dd_MM_yyyy").format(new Date());
		
		return date;
	}
	
	public static void capturescreenshotwithtime(WebDriver driver) {
		try {
			FileHandler.copy(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),new File("./Screenshots/Screenshot_"+getCurrentTime().replace(":", "-") +".png"));
			}
			catch(IOException e) {
				System.out.println(e.getMessage());
			}
	}
	
	
	

}
