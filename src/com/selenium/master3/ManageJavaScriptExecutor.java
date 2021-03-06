package com.selenium.master3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ManageJavaScriptExecutor {
	
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
	public void testJavaScriptExecutor()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.location='https://www.rediff.com/'");
		
		String pageTitle = (String) js.executeScript("return document.title");
		
	Assert.assertEquals(pageTitle, "Rediff.com: News | Rediffmail | Stock Quotes | Shopping");
	
//	WebElement signInBtn = driver.findElement(By.linkText("Sign in"));
	//js.executeScript("arguments[0].click();",signInBtn);
	
	//WebElement userNme=driver.findElement(By.xpath("//*[@id='login1']"));
	//js.executeScript("arguments[0].value='soni'",userNme);
	
	//js.executeScript("window.scrollBy(0,3000)");
	
	WebElement termsLink = driver.findElement(By.linkText("Terms of use"));
	js.executeScript("arguments[0].scrollIntoView(true)",termsLink);
			try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
