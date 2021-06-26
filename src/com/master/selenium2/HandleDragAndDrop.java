package com.master.selenium2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleDragAndDrop {
	
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

//	@Test
	public void performDrag()
	{
		driver.get("https://jqueryui.com/");
		driver.findElement(By.linkText("Draggable")).click();
		driver.switchTo().frame(0);
		
		WebElement drag = driver.findElement(By.id("draggable"));
		Actions act = new Actions(driver);
		act.dragAndDropBy(drag, 50, 50).build().perform();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//@Test
	public void testDragDrop()
	{
		driver.get("https://jqueryui.com/");
		driver.findElement(By.linkText("Droppable")).click();
		driver.switchTo().frame(0);
		
		WebElement src = driver.findElement(By.id("draggable"));
		
		WebElement tgt = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(src, tgt).build().perform();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void customDragDrop()
	{
		driver.get("https://jqueryui.com/");
		driver.findElement(By.linkText("Droppable")).click();
		driver.switchTo().frame(0);
		
		WebElement src = driver.findElement(By.id("draggable"));
		
		WebElement tgt = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		
		act.clickAndHold(src).moveToElement(tgt).release(tgt).build().perform();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
