package MeeshoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC09BeautynHealth
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
//TC12:To check BEAUTY AND HEALTHmodule

  public void TC09BeautynHealth() throws InterruptedException 
  {
	//MouseOver beauty and health model
			Actions a=new Actions(w);
			WebElement BH=w.findElement(By.xpath("//body/div[@id='__next']/div[2]/div[3]/div[1]/div[9]"));
			a.moveToElement(BH).build().perform();
			//Click on sanitizer
			WebElement sanitizer=w.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div/div[10]/div/div[2]/a[1]/p"));
			sanitizer.click();
			Thread.sleep(2000);
			//if redirected page contains sanitizer,then ok
			WebElement D=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div/div/div[1]"));
			if(D.getText().contains("Hand Sanitizers")) 
			{
				System.out.println("Result---->Beauty & Health redirected to correct page");
			}
			else 
			{
				System.out.println("Result---->Beauty & Health redirected to incorrect page");
			}
			//click on any result
			Thread.sleep(2000);
			WebElement img5=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div/div/div[4]/div/div[1]/a/div/div[1]/div[1]"));
			img5.click();
			//add to cart
			Thread.sleep(2000);
			WebElement AddToCart5=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[1]/div/div[2]/div[2]/button"));
			AddToCart5.click();
			System.out.println("item added successfully in the cart");
			w.quit();
  }
 
}
