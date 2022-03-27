package MeeshoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC08Men
{WebDriver w=null;
@BeforeMethod
public void LaunchBrowser() 
{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shreya\\OneDrive\\Desktop\\Selenium JAR\\chromedriver.exe");
	w=new ChromeDriver();
	w.get("https://meesho.com/");
	w.manage().window().maximize();
}
	//TC11:To check MEN module
  @Test
  public void TC08Men() throws InterruptedException
  {

		//MouseOver men model
		Actions a=new Actions(w);
		WebElement men=w.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div/div[7]/span"));
		a.moveToElement(men).build().perform();
		//click on men kurta
		WebElement MenKurta=w.findElement(By.xpath("//p[contains(text(),'Men Kurtas')]"));
		MenKurta.click();
		Thread.sleep(2000);
		//if redirected page contains kurta,then ok
		WebElement D=w.findElement(By.xpath("//h1[contains(text(),'Kurtas For Men')]"));
		if(D.getText().contains("Kurtas")) 
		{
			System.out.println("Result---->Men redirected to correct page");
		}
		else 
		{
			System.out.println("Result---->Men redirected to incorrect page");
		}
		//click on any result
		Thread.sleep(2000);
		WebElement img4=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div/div/div[4]/div/div[1]/a/div/div[1]/div[1]"));
		img4.click();
		//add to cart
		Thread.sleep(2000);
	WebElement AddToCart4=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[1]/div/div[2]/div[2]/button"));
		AddToCart4.click();
		System.out.println("item added successfully in the cart");
		Thread.sleep(1000);
		w.quit();
  }
  
}
