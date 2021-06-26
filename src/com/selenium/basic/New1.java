package com.selenium.basic;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;


public class New1 {
	
	
		public static void main(String[] array) throws Exception{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		driver.manage().window().maximize();

		// Apply Implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		
	File src =	driver.getScreenshotAs(OutputType.FILE);
	String path = "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\Screenshots\\first.png";
	File dest = new File(path);
	
	FileUtils.copyFile(src, dest);
		
		
		}
}

