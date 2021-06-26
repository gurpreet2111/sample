package com.liveproject;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AddDeleteStockInPortfolio {
	
	@Test
	public void addStockTest(){
	
/*
	WebDriver driver;
	@BeforeSuite
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void testCreatePortfolio()
	{
		driver.get("https://www.rediff.com/");
		
		driver.findElement(By.xpath("//*[@class='moneyicon relative']")).click();
		
		driver.findElement(By.linkText("Sign In")).click();
		
		driver.findElement(By.name("email-id")).sendKeys("aroragurpreet03@gmail.com");
		driver.findElement(By.name("passwd")).sendKeys("Test@1234");
		
		driver.findElement(By.id("loginsubmit")).sendKeys(Keys.ENTER);
		
	//selecting portfolio
WebElement dropdown = driver.findElement(By.id("portfolioid"));
Select sl = new Select(dropdown);

sl.selectByVisibleText("rock");

//add stocks
driver.findElement(By.id("addStock")).click();
driver.findElement(By.id("addstockname")).sendKeys("Nestle India Ltd.");

//1st method to enter date
driver.findElement(By.id("stockAddDate")).sendKeys("12-03-2018");

//2nd method to enter date
selectDateiNCalendar("13/06/2017");
}*/
	selectDateInCalendar("12/01/2019");
	
}
	public void selectDateInCalendar(String date)
	{
		Date currentDate = new Date();
		
		System.out.println(currentDate);
	}
	


}


