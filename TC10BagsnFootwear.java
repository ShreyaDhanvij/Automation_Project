package MeeshoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC10BagsnFootwear 
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
  public void TC10BagsnFootwear() throws InterruptedException
  {
	//MouseOver BAGS AND FOOTWEAR model
			Actions a=new Actions(w);
			WebElement BF=w.findElement(By.xpath("//span[contains(text(),'Bags & Footwear')]"));
			a.moveToElement(BF).build().perform();
			//Click on BELLIES
			WebElement Bellies=w.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div/div[12]/div/div[1]/a[2]/p"));
			Bellies.click();
			Thread.sleep(2000);
			//if redirected page contains belly,then ok
			WebElement D=w.findElement(By.xpath("//h1[contains(text(),'Belly Shoes')]"));
			if(D.getText().contains("Belly")) 
			{
				System.out.println("Result---->BAGS AND FOOTWEAR redirected to correct page");
			}
			else 
			{
				System.out.println("Result---->BAGS AND FOOTWEAR redirected to incorrect page");
			}
			//click on any result
			Thread.sleep(2000);
			WebElement img6=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div/div/div[4]/div/div[1]/a/div/div[1]/div[1]"));
			img6.click();
			//add to cart
			Thread.sleep(2000);
			WebElement AddToCart6=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[1]/div/div[2]/div[2]"));
			AddToCart6.click();
			System.out.println("item added successfully in the cart");
			w.quit();
  }
 
}
