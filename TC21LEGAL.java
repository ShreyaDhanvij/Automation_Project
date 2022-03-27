package MeeshoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC21LEGAL 
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
  public void TC21LegalnPolicies() throws InterruptedException 
  {//cLICK ON LEGAL AND POLICIES

	  ((JavascriptExecutor)w).executeScript("window.scrollTo(0,document.body.scrollHeight)");//Scroll to page Down 
		
	  Thread.sleep(2000);
	  WebElement LP=w.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[1]/div/div[3]/div[1]/a/span"));
	 //As the element was overlaping with something
	  JavascriptExecutor js=(JavascriptExecutor)w;
	 js.executeScript("arguments[0].click()", LP);
	  
	
		Thread.sleep(3000);
		
		String page=w.getCurrentUrl();
		if(page.contains("legal")) 
		{
			System.out.println("Result---->Legal button working fine");
		}
		else 
		{
			System.out.println("Result---->Legal button not working");
		}
		w.navigate().back();
		System.out.println(w.getCurrentUrl());//homepage
		w.quit();
  }
  
}
