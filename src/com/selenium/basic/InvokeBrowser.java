package com.selenium.basic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class InvokeBrowser {
	
	WebDriver driver = null;
	
	@Parameters("browser")
	@BeforeMethod
	public void openBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}else{
			System.out.println("invalid browser");
		}
	}
	@AfterMethod()
	public void quitBrowser(){
		driver.quit();
	}
	
	@Test
	public void verifyTitle()
	{
		String URL = "https://www.facebook.com/";
		driver.get(URL);
		
		String pageTitle = driver.getTitle();
		System.out.println("actual page title "+pageTitle);
		
		Assert.assertEquals(pageTitle, "Facebook – log in or sign up");
	}

}
