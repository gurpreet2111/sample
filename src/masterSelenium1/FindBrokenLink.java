package masterSelenium1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindBrokenLink {
	
	WebDriver driver = null;
	
	
	@Test
	public void verifyBrokenLink(){
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://edition.cnn.com/");
	
	List<WebElement> links = driver.findElements(By.tagName("a"));
	System.out.println("Number of links on webpage "+links.size());
	
	for(WebElement link : links)
	{
		
		String URL = link.getAttribute("href");
		//System.out.println(link.getText());
		GetLinkStatus.verifyLink(URL);
	}
	System.out.println("Total number of broken Links ");
	GetLinkStatus.getinvalidLinkCount();
	
	driver.quit();
	}

}
