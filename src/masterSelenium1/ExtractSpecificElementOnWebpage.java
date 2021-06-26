package masterSelenium1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtractSpecificElementOnWebpage {
	
	WebDriver driver;
	
	
	@BeforeMethod
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://edition.cnn.com/");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}

	
	@Test
	public void extract()
	{
		WebElement New = driver.findElement(By.xpath("//*[@id='intl_homepage1-zone-2']/div[5]/div/div[1]"));
		
		List<WebElement> news = New.findElements(By.tagName("a"));
		
System.out.println("number of links "+news.size());
		
		for(WebElement n : news)
		{
			
			String text = n.getText();
			
			if(!text.isEmpty())
			{
				System.out.println(text);
			}
		}
	}
	
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
}
