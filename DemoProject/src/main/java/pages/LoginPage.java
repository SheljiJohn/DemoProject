package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath="//input[@name= 'username']") WebElement username; //@FindBy used to locate elements
	@FindBy(xpath="//input[@name= 'password']") WebElement password;
	@FindBy(xpath="//button[text() = 'Sign In']") WebElement signIn;
	@FindBy(xpath="//p[text() = 'Dashboard']") WebElement dashboard;
	@FindBy(xpath="//button[@data-dismiss= 'alert']") WebElement alerts;
	
	public WebDriver driver; 																																					//which will be passed from the test class. the page object needs a WebDriver to interact with the browser.It allows all methods in the loginpage to use the same driver instance that the test created.
	
	public LoginPage(WebDriver driver)                                                                                                                                 // accepts a webDriver instance(from test class).The constructor of the loginpage class that takes a WebDriver parameter. the test code creates the WebDriver and passes it into the page object so the page can use the same browser instance. this avoids creating new browser inside the page.the page object depends on a WebDriver; the constructor inject it.
	{
		this.driver = driver; 																																								//assigns the constructor parameter driver to the page object's instance field. page object's methods can use this.driver to interact with elements.ensures the page object and test share the exact same WebDriver session.
		PageFactory.initElements(driver, this); 																														//initializes all @FindBy elements using PageFactory.initElement().
	}

	public void enterTheUserName(String username2)
	{
		username.sendKeys(username2);
	}
	
	public void enterThePassword(String password2)
	{
		password.sendKeys(password2);
	}
	
	public void clickOnSignIn()
	{
		signIn.click();
	}
	
	
	public boolean isHomePageLoaded()
	{
		return dashboard.isDisplayed();
	}
	
	public boolean isAlertDisplayed()
	{
		return alerts.isDisplayed();
	}
	

}
