package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;


public class LoginTest extends Base {

	@Test(groups= {"Regression"},retryAnalyzer=retry.Retry.class,description="login validation")
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException
	{
		//String username = "admin";
	//	String password = "admin";
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickOnSignIn();
		boolean visibilty = loginpage.isHomePageLoaded();
		Assert.assertTrue(visibilty);	
		
	}
	
	@Test
	public void verifyTheUserIsUnableToLoginwithInvalidUsernameandValidPassword() throws IOException
	{
		//String username = "hello";
		//String password = "admin";
		String username = ExcelUtility.getStringData(2, 0, "loginpage");
		String password = ExcelUtility.getStringData(2, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickOnSignIn();
		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert);	
		
	}
	
	@Test
	public void verifyTheUserIsUnableToLoginwithValidUsernameandInvalidPassword() throws IOException
	{
		//String username = "admin";
		//String password = "welcome";
		String username = ExcelUtility.getStringData(3, 0, "loginpage");
		String password = ExcelUtility.getStringData(3, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickOnSignIn();
		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert);
		
	}
	
	@Test
	public void verifyTheUserIsUnableToLoginwithInValidUsernameandInvalidPassword() throws IOException
	{
		//String username = "hello";
		//String password = "welcome";
		String username = ExcelUtility.getStringData(4, 0, "loginpage");
		String password = ExcelUtility.getStringData(4, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickOnSignIn();
		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert);
		
	}

}
