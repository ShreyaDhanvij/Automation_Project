package MeeshoTestNG;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC18YouTube 
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
  public void TC18YOUTUBE() throws InterruptedException 
  {
	  ((JavascriptExecutor)w).executeScript("window.scrollTo(0,document.body.scrollHeight)");//Scroll to page Down 

			//Click on youtube link
			Thread.sleep(2000);
			WebElement Y=w.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[1]/div/div[4]/div/div[1]/div/a[3]/div"));
			//As the element was overlaping with something
			  JavascriptExecutor js=(JavascriptExecutor)w;
			 js.executeScript("arguments[0].click()", Y);
					
					Thread.sleep(3000);
			//	as it redirects to another tab,window handle required
			//as it redirects to another tab,window handle required
					Set<String> win =w.getWindowHandles();
					Iterator<String> itr=win.iterator();
					String Parent=itr.next();//current
					String Youtube=itr.next();//new opened
					w.switchTo().window(Youtube);
			Thread.sleep(3000);
			String YT=w.getCurrentUrl();
			
			//if url =youtube,then ok
			if(YT.contains("https://www.youtube.com/channel/UCaGHIRKYUYlaI_ZAt2hxpjw")) 
			{
				System.out.println("Result---->YouTube link working fine");
			}
			else 
			{
				System.out.println("Result---->YouTube link  not working");
			}
			w.switchTo().window(Parent);
			w.quit();
  }
 
}
