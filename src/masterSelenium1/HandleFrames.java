package masterSelenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleFrames {
	
	WebDriver driver = null;
	
	@Test
	public void handleFrames()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/button/");
		
		driver.findElement(By.linkText("Button")).click();
		
String pk = driver.findElement(By.xpath("//*[@id='content']/h1")).getText();

System.out.println(pk);

driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content']/iframe")));

WebElement fb = driver.findElement(By.xpath("/html/body/div/button"));
Assert.assertEquals(fb.getText(), "A button element");

driver.switchTo().parentFrame();

WebElement ex = driver.findElement(By.xpath("//*[@id='content']/div[1]/h2"));
System.out.println(ex.getText());
driver.quit();


	}

}
