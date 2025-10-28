package testScript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenshotUtilities;

public class Base {
	
	public WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	
	@Parameters("browser")
	
	public void initializeBrowser(String browser) throws Exception
	{
		
	
	//	driver = new ChromeDriver();
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("FireFox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			throw new Exception("Browser not defined!!!!!!");
		}
			
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
	}
	
	@AfterMethod(alwaysRun = true)
	
	public void windowCloseAndQuit(ITestResult iTestResult ) throws IOException
	{
	// driver.close();
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtilities scrShot = new ScreenshotUtilities(); // creating obj
			scrShot.getScreenShot(driver, iTestResult.getName());
		}
	 driver.quit();
	 
	}

}
