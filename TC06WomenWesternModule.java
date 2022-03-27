package MeeshoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC06WomenWesternModule
{WebDriver w=null;
@BeforeMethod
public void LaunchBrowser() 
{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shreya\\OneDrive\\Desktop\\Selenium JAR\\chromedriver.exe");
	w=new ChromeDriver();
	w.get("https://meesho.com/");
	w.manage().window().maximize();
}
  @Test
//TC09:To check women western module
  public void TC06WomenWestern() throws InterruptedException
  {
	//MouseOver Womenn western model
			Actions a=new Actions(w);
			WebElement WomentWestern=w.findElement(By.xpath("//span[contains(text(),'Women Western')]"));
			a.moveToElement(WomentWestern).build().perform();
			//click on dresses
			WebElement Dresses=w.findElement(By.linkText("Dresses"));
			Dresses.click();
			Thread.sleep(2000);
			//if redirected page contains dresses,then ok
			WebElement D=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div/div/div[1]"));
			Thread.sleep(1000);
			if(D.getText().contains("Women")) 
			{
				System.out.println("Result---->Women western redirected to correct page");
			}
			else 
			{
				System.out.println("Result---->Women western redirected to incorrect page");
			}
			//Click on any results
			Thread.sleep(2000);
			WebElement img2=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div/div/div[4]/div/div[1]/a/div"));
			img2.click();
			//Select size
			Thread.sleep(2000);
			WebElement size=w.findElement(By.xpath("//body/div[@id='__next']/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/span[1]"));
			size.click();
			//add to cart	
			WebElement AddToCart2=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[1]/div/div[2]/div[2]/button/div"));
			AddToCart2.click();
			System.out.println("item added successfully in the cart");
			w.quit();
  }
 
}
