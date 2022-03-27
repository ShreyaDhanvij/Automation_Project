package MeeshoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC12Electronics 
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
//TC15:To check ELECTRONICS module
  public void TC12Electronics() throws InterruptedException
  {
	//MouseOver ELECTRONICS model
			Actions a=new Actions(w);
			WebElement ELECTRONICS=w.findElement(By.xpath("//span[contains(text(),'Electronics')]"));
			a.moveToElement(ELECTRONICS).build().perform();
			//Click on SMARTWATCHES
			WebElement SmarctWatch=w.findElement(By.xpath("//p[contains(text(),'Smartwatches')]"));
			SmarctWatch.click();
			Thread.sleep(2000);
			//if redirected page contains Smart,then ok
			WebElement D=w.findElement(By.xpath("//h1[contains(text(),'Smart Watches')]"));
			if(D.getText().contains("Smart")) 
			{
				System.out.println("Result---->ELECTRONICS redirected to correct page");
			}
			else 
			{
				System.out.println("Result---->ELECTRONICS redirected to incorrect page");
			}
			//click on any result
			Thread.sleep(2000);
			WebElement img8=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div/div/div[4]/div/div[1]/a/div/div[1]/div[1]"));
			img8.click();
			//add to cart
			Thread.sleep(3000);
		WebElement AddToCart8=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[1]/div/div[2]/div[2]"));
			AddToCart8.click();
			System.out.println("item added successfully in the cart");
			w.quit();
  }
  
}
