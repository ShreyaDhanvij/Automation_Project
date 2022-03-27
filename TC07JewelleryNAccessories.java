package MeeshoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC07JewelleryNAccessories
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
//TC10:To check Jewellery and accessories module
  public void TC07JewelleryNAccessories() throws InterruptedException
  {
	//MouseOver JewelleryAndAccessories model
			Actions a=new Actions(w);	
			WebElement JA=w.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div/div[5]"));
			a.moveToElement(JA).build().perform();
			//click on bags
			WebElement Bag=w.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div/div[6]/div/div[2]/a[1]/p"));
			Bag.click();
			Thread.sleep(2000);

			//if redirected page contains bags,then ok
			WebElement D=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div/div/div[1]/div/h1"));
			if(D.getText().contains("Ladies Bag")) 
			{
				System.out.println("Result---->Jewellery And Accessorie redirected to correct page");
			}
			else 
			{
				System.out.println("Result---->Jewellery And Accessorie redirected to incorrect page");
			}
			//click on result
			WebElement img3=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div/div/div[4]/div/div[1]/a/div/div[1]/div"));
			img3.click();      
			//add to cart	
			Thread.sleep(2000);
			WebElement AddToCart3=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[1]/div/div[2]/div[2]"));
			AddToCart3.click();
			System.out.println("item added successfully in the cart"); 
			w.quit();
  }
 
}
