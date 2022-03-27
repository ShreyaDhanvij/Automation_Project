package MeeshoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC11HomeNKitchen
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
//TC14:To check HOME AND KITCHEN module
  public void TC12HomeNKitchen() throws InterruptedException 
  {
	//MouseOver HOME AND KITCHEN model
			Actions a=new Actions(w);
			WebElement HomeKitchen=w.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div/div[13]"));
			a.moveToElement(HomeKitchen).build().perform();
			//Click on homeDecore
			
			WebElement homeDecore=w.findElement(By.xpath("//p[contains(text(),'All Home Decor')]"));
			
			Thread.sleep(2000);
			homeDecore.click();
			Thread.sleep(2000);
			//if redirected page contains Home,then ok
			WebElement D=w.findElement(By.xpath("//h1[contains(text(),'Home Decor')]"));
			if(D.getText().contains("Home")) 
			{
				System.out.println("Result---->HOME AND KITCHEN redirected to correct page");
			}
			else 
			{
				System.out.println("Result---->HOME AND KITCHEN redirected to incorrect page");
			}
			//click on any result
			Thread.sleep(2000);
			WebElement img7=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div/div/div[4]/div/div[1]/a/div"));
			img7.click();
			//add to cart
			Thread.sleep(2000);
			WebElement AddToCart7=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[1]/div/div[2]/div[2]/button"));
			AddToCart7.click();
			System.out.println("item added successfully in the cart");
			w.quit();
  }
 
}
