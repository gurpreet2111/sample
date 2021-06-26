package com.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWait {
	
	WebDriver driver = null;

	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("C:\\Users\\Lenovo\\Desktop\\New folder\\ExplicitWait.html");
		
		
		
	}
	
	
	public void verifyyAlert()
	{
		WebElement alertBtn = driver.findElement(By.id("alert"));
		alertBtn.click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.alertIsPresent());
		
		driver.switchTo().alert().accept();
	}
	
	public void verifyElementClickable()
	{
	
		driver.findElement(By.id("display-other-button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("hidden"))));
	}
	
	public void verifyElementSelected()
	{
		driver.findElement(By.id("checkbox")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.xpath("//input[@type='checkbox']"))));
		
	}
	
	
	public void verifyPresentText()
	{
		driver.findElement(By.id("populate-text")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//h2[@class='target-text']")), "Selenium Webdriver"));
		
	}
	@Test
	public void verifyElementVisibility()
	{
		driver.findElement(By.id("display-other-button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hidden")));
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
		
	}

	
}
