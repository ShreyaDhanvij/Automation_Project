package MeeshoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC03BecomeASupplier 
{
	WebDriver w=null;
	@BeforeMethod
	public void LaunchBrowser() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shreya\\OneDrive\\Desktop\\Selenium JAR\\chromedriver.exe");
		w=new ChromeDriver();
		w.get("https://meesho.com/");
		
	}	
  @Test
  public void TC03BecomeSupplier() 
  {
	 
	
	//Click on Become a supplier
			WebElement Supplier=w.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[3]/div[3]/span"));
			Supplier.click();
			//Check if directed page contains "Start Selling".If yes---ok,if no---problem
			WebElement Selling=w.findElement(By.linkText("Start Selling"));
			String Sell=Selling.getText();
			if(Sell.contains("Start Selling")) 
			{
				System.out.println("Result---->Become a Supplier module working fine");
			}
			else 
			{
				System.out.println("Result---->Become a Supplier module not working ");
			}
			w.navigate().back();//navigate to homepage
			w.quit();
  }
  
}
