package com.liveproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	
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
	public void loginRediff()
	{
		driver.get("https://www.rediff.com/");
		
		driver.findElement(By.xpath("//*[@class='moneyicon relative']")).click();
		
		driver.findElement(By.linkText("Sign In")).click();
		
		driver.findElement(By.name("email-id")).sendKeys("aroragurpreet03@gmail.com");
		driver.findElement(By.name("passwd")).sendKeys("Test@1234");
		
		driver.findElement(By.id("loginsubmit")).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//*[@id='portfolioAddClose']")).click();
		
		driver.findElement(By.xpath("//*[@id='username']/a")).isDisplayed();
		
	}


}
