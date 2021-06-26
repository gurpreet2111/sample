package com.master.selenium2;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleMultipleWindows {
	
WebDriver driver;
	@BeforeMethod
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://www.facebook.com/r.php");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeBrowser(){
		driver.close();
	}

	
	public void handleFacebook()
	{
		driver.get("https://www.facebook.com/r.php");
		String mainPageWindow=driver.getWindowHandle();
		System.out.println("Main page window "+mainPageWindow);
		
		driver.findElement(By.linkText("Forgotten account?")).click();
		String forgetAccount = driver.getWindowHandle();
		System.out.println("frget account link "+forgetAccount);

	}
	
	
	@Test
	public void handleMultiTabs()
	{
		driver.get("https://www.jobserve.com/in/en/Job-Search/");
		driver.findElement(By.id(""));
		
		Set<String> windowsID = driver.getWindowHandles();
		
		Iterator<String> itr = windowsID.iterator();
		
		String mainPageID = itr.next();
		String jobPageID = itr.next();
		
		driver.switchTo().window(jobPageID);
		String Heading = driver.findElement(By.id("")).getText();
		System.out.println(Heading);
		driver.close();
		
		driver.switchTo().window(mainPageID);
		driver.findElement(By.id("")).sendKeys("");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
