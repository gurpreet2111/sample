package com.master.selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleMouseHover {
	
	WebDriver driver;
	@BeforeMethod
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeBrowser(){
		driver.close();
	}

	@Test
	public void handleMouseOverOnClick()
	{
		driver.get("https://www.americangolf.eu/");
		WebElement golfClubs = driver.findElement(By.xpath("//*[@id='header-navigation']/div[1]/ul/li[2]/a"));
		
		Actions action = new Actions(driver);
		action.moveToElement(golfClubs).build().perform();
		/*try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='CLUBS_1']/ul/li[2]/ul/li[1]/a")))).click();
		
	//	driver.findElement(By.xpath("//*[@id='CLUBS_1']/ul/li[2]/ul/li[1]/a")).click();
	}

}
