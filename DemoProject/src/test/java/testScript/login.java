package testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class login extends Base{

	@Test
	public void verifyTheUserIsAbleToLoginUsingValidCredentials()
	{
		String user_name = "admin";
		String pwd = "admin";
		
		WebElement username = driver.findElement(By.xpath("//input[@name= 'username']"));
		username.sendKeys(user_name);
		WebElement password = driver.findElement(By.xpath("//input[@name= 'password']"));
		password.sendKeys(pwd);
		WebElement signIn = driver.findElement(By.xpath("//button[text() = 'Sign In']"));
		signIn.click();
		
		WebElement dashboard = driver.findElement(By.xpath("//p[text() = 'Dashboard']"));
		boolean visibility = dashboard.isDisplayed();
		Assert.assertTrue(visibility);
	}
	
	@Test
	public void verifyTheUserIsUnableToLoginwithInvalidUsernameandValidPassword()
	{
		String user_name = "hello";
		String pwd = "admin";
		
		WebElement username = driver.findElement(By.xpath("//input[@name= 'username']"));
		username.sendKeys(user_name);
		WebElement password = driver.findElement(By.xpath("//input[@name= 'password']"));
		password.sendKeys(pwd);
		WebElement signIn = driver.findElement(By.xpath("//button[text() = 'Sign In']"));
		signIn.click();
		
		WebElement alerts = driver.findElement(By.xpath("//button[@data-dismiss= 'alert']"));
		boolean alert = alerts.isDisplayed();
		Assert.assertTrue(alert);
	}

	@Test
	public void verifyTheUserIsUnableToLoginwithValidUsernameandInvalidPassword()
	{
		String user_name = "admin";
		String pwd = "welcome";
		
		WebElement username = driver.findElement(By.xpath("//input[@name= 'username']"));
		username.sendKeys(user_name);
		WebElement password = driver.findElement(By.xpath("//input[@name= 'password']"));
		password.sendKeys(pwd);
		WebElement signIn = driver.findElement(By.xpath("//button[text() = 'Sign In']"));
		signIn.click();
		
		WebElement alerts = driver.findElement(By.xpath("//button[@data-dismiss= 'alert']"));
		boolean alert = alerts.isDisplayed();
		Assert.assertTrue(alert);
	}
	
	@Test
	public void verifyTheUserIsUnableToLoginwithInValidUsernameandInvalidPassword()
	{
		String user_name = "hello";
		String pwd = "welcome";
		
		WebElement username = driver.findElement(By.xpath("//input[@name= 'username']"));
		username.sendKeys(user_name);
		WebElement password = driver.findElement(By.xpath("//input[@name= 'password']"));
		password.sendKeys(pwd);
		WebElement signIn = driver.findElement(By.xpath("//button[text() = 'Sign In']"));
		signIn.click();
		
		WebElement alerts = driver.findElement(By.xpath("//button[@data-dismiss= 'alert']"));
		boolean alert = alerts.isDisplayed();
		Assert.assertTrue(alert);
	}
}
