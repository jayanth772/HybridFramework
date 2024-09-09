package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.CustomDataProvider;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseClass {
	
	@Test(dataProvider = "LoginDataSet",dataProviderClass = CustomDataProvider.class)
	public void login(String user, String pass) {
		
		LoginPage login = new LoginPage(driver);
		
		login.loginToApplication(user, pass);
		
		HomePage home = new HomePage(driver);
		
		Assert.assertTrue(home.getWelcomeMsg().contains("Welcome"));
		
		home.clickOnSignout();
		
		Assert.assertTrue(login.isSignInPresent());
	}

}
