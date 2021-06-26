package com.selenium.basic;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class New2 {

		
		static WebDriver driver;

		public static void main(String[] array) throws Exception{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		driver.manage().window().maximize();

		// Apply Implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		
		//downcast driver to Taaskscreenshots interface duw to hirechey architecture
		
		TakesScreenshot ts = (TakesScreenshot)driver;
	File src =	ts.getScreenshotAs(OutputType.FILE);
	//String path = "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\Screenshots\\second.png";
	
//	System.currentTimeMillis()
	String path = "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\Screenshots\\"+System.currentTimeMillis()+".png";


	File dest = new File(path);
	
	FileUtils.copyFile(src, dest);

	}

	//	OutputType” is an interface which provides you options to take screenshot in different type such as FILE, BASE64, BYTES and class. FILE is mostly used.
}
