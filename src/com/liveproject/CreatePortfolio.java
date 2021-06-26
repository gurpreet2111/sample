package com.liveproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreatePortfolio {
	
	WebDriver driver;
	@BeforeSuite
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	/*
	@AfterMethod
	public void closeBrowser(){
		driver.close();
	}*/
	
	
	@Test(priority=1)
	public void testCreatePortfolio()
	{
driver.get("https://www.rediff.com/");
		
		driver.findElement(By.xpath("//*[@class='moneyicon relative']")).click();
		
		driver.findElement(By.linkText("Sign In")).click();
		
		driver.findElement(By.name("email-id")).sendKeys("aroragurpreet03@gmail.com");
		driver.findElement(By.name("passwd")).sendKeys("Test@1234");
		
		driver.findElement(By.id("loginsubmit")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("createPortfolio")).click();
		driver.findElement(By.name("create")).clear();
		driver.findElement(By.name("create")).sendKeys("joy");
		//driver.findElement(By.name("Submit")).click();
		
		driver.findElement(By.xpath("//*[@id='createPortfolioButton']")).click();
		
		driver.findElement(By.xpath("//*[@id='username']/a")).isDisplayed();

	}
	
	//@Test
	public void testPortfoliioVerification()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement dropdown = driver.findElement(By.xpath("//*[@id='portfolioid']"));
		
		
		Select dropdownSelect = new Select(dropdown);
		
		String text = dropdownSelect.getFirstSelectedOption().getText();
		
		Assert.assertEquals(text, "happy");
	}

	
	public void waitForElement(String xpath, String elementValue)
	{
		
	}
	
	@Test
	public void deletePortfolio() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='deletePortfolio']")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}
}
