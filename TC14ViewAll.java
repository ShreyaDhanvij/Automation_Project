package MeeshoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC14ViewAll 
{
	WebDriver w=null;
	@BeforeMethod
	public void LaunchBrowser() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shreya\\OneDrive\\Desktop\\Selenium JAR\\chromedriver.exe");
		w=new ChromeDriver();
		w.get("https://meesho.com/");
		w.manage().window().maximize();
	}
  @Test
//TC17:To check View all button in home decore
  public void TC14ViewAll() throws InterruptedException 
  {
	//To scroll
			JavascriptExecutor js=(JavascriptExecutor)w;
			js.executeScript("window.scrollBy(0,350)", "");
			Thread.sleep(3000);
			//Click on view all in home decore
			WebElement viewAll=w.findElement(By.xpath("//span[contains(text(),'VIEW ALL')]"));
			viewAll.click();
			Thread.sleep(3000);
			//click on any result
			Thread.sleep(2000);
			WebElement img9=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div/div/div[4]/div/div[1]/a/div/div[1]/div[1]"));
			img9.click();
			//add to cart
			Thread.sleep(3000);
		WebElement AddToCart9=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[1]/div/div[2]/div[2]/button"));
		AddToCart9.click();
			System.out.println("item added successfully in the cart");
			//Go to homepage
			Thread.sleep(3000);
			w.findElement(By.xpath("//body/div[@id='__next']/div[2]/div[1]/div[1]/div[1]")).click();
			w.quit();

  }
 

}
