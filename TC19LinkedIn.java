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

public class TC19LinkedIn
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
  public void TC19LinkedIn() throws InterruptedException
  {
	  ((JavascriptExecutor)w).executeScript("window.scrollTo(0,document.body.scrollHeight)");//Scroll to page Down 
		//Click on linkedIn link
		Thread.sleep(2000);
		WebElement Lin=w.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[1]/div/div[4]/div/div[1]/div/a[4]/div"));
		//As the element was overlaping with something
		  JavascriptExecutor js=(JavascriptExecutor)w;
		 js.executeScript("arguments[0].click()", Lin);
		//	as it redirects to another tab,window handle required
		//as it redirects to another tab,window handle required
				Set<String> win =w.getWindowHandles();
				Iterator<String> itr=win.iterator();
				String Parent=itr.next();//current
				String Linkedin=itr.next();//new opened
				w.switchTo().window(Linkedin);
		Thread.sleep(3000);
		System.out.println(w.getTitle());
		//if url =LinkedIn,then ok
		if(w.getTitle().contains("LinkedIn")) 
		{
			System.out.println("Result---->LinkedIn link working fine");
		}
		else 
		{
			System.out.println("Result---->LinkedIn link  not working");
		}
		w.switchTo().window(Parent);
		w.quit();
  }
 
}
