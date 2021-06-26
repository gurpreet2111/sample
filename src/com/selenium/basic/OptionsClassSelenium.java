package com.selenium.basic;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OptionsClassSelenium {
	
	
	public void sampleOptionBinary()
	{
		//open specific version of chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		
		co.setBinary("C:\\Users\\Lenovo\\Downloads\\chrome.exe");
		
		WebDriver driver = new ChromeDriver(co);
		
		driver.get("https://google.com");
		
	}
	
	
	public void acceptCertificate()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
		
		ChromeOptions co = new ChromeOptions();
		
		co.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.cacert.org/");
	}
	
	
	public void setProxy()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
	
		Proxy prox = new Proxy();
		prox.setProxyAutoconfigUrl("https://proxy.chercher.tech");
		
		co.setProxy(prox);
		
		WebDriver driver = new ChromeDriver(co);
		
		
	}
	
	
	
	public void OpenHeadLess()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
	ChromeOptions co = new ChromeOptions();
	co.setHeadless(true);
	
	WebDriver driver = new ChromeDriver(co);
	driver.manage().window().maximize();
	
	driver.get("http://www.cacert.org/");
	
	String pageTitle = driver.getTitle();
	Assert.assertEquals(pageTitle, "Welcome to CAcert.org");
		
	}
	
	
	public void setArguments()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--disable-infobars");
		co.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://www.bigbasket.com/");
		//driver.get("https://www.bing.com/?toWww=1&redig=4911296404BE4A6DB4F4757705877173");
		
		

		
	}
	
	
	public void handleUnhandledAlert()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		
		co.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		co.addArguments("--disable-infobars");
		co.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://www.bigbasket.com/");
		//driver.get("https://www.bing.com/?toWww=1&redig=4911296404BE4A6DB4F4757705877173");
		
		}

	
	@Test
	public void setPageLoadstrategy()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		
		co.setPageLoadStrategy(PageLoadStrategy.EAGER);
		
		WebDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://www.bigbasket.com/");
		//driver.get("https://www.bing.com/?toWww=1&redig=4911296404BE4A6DB4F4757705877173");
		
		}
}
