package masterSelenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyWebElementPresence {
	
WebDriver driver = null;
	
	@BeforeMethod
	public void open()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/button/");
		

}


@AfterMethod
public void close()
{
	driver.quit();
}


@Test
public void verifyElementDisplay()
{
	driver.findElement(By.linkText("Toggle")).click();
	
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
	
	WebElement TH = driver.findElement(By.xpath("//*[@id='effect']/h3"));
	Assert.assertTrue(TH.isDisplayed());
	System.out.println("display status is "+TH.isDisplayed());
	
	
	
}

}