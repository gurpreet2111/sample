package com.selenium.master3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadfileinSelenium {
	
	WebDriver driver;
	@BeforeMethod
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeBrowser(){
		driver.close();
	}
	
	@Test
	public void testUploadfunction()
	{
		driver.get("http://the-internet.herokuapp.com/upload");
		WebElement FU = driver.findElement(By.id("file-upload"));
		String filePath = "C:\\Users\\Lenovo\\Desktop\\New folder\\cucumber1.png";
		FU.sendKeys(filePath);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			
		e.printStackTrace();
		}

		driver.findElement(By.xpath("//*[@id='file-submit']")).click();
		
		String msg = driver.findElement(By.xpath("//*[@id='content']/div/h3")).getText();
		System.out.println("message is "+msg);
		
		Assert.assertEquals(msg, "File Uploaded!");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			
		e.printStackTrace();
		}
		
		
	}

}
