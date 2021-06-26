package com.master.selenium2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleAlerts {
	
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
	public void handleJavaScriptAlerts()
	{
	 driver.get("https://www.rediff.com/");
driver.findElement(By.xpath("//a[@title='Lightning fast free email']")).click();
driver.findElement(By.id("login1")).sendKeys("sonia");
driver.findElement(By.name("proceed")).click();
try {
	Thread.sleep(4000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
Alert alt = driver.switchTo().alert();
System.out.println("Text alert is "+alt.getText());

alt.accept();
driver.findElement(By.linkText("Forgot Password?")).click();
//driver.findElement(By.id("password")).sendKeys("pass");

}

}
