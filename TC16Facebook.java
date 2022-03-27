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

public class TC16Facebook
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
  public void TC16Facebook() throws InterruptedException 
  {
	  JavascriptExecutor js=(JavascriptExecutor)w;
		js.executeScript("window.scrollBy(0,3250)", "");


		//click on FB link
		WebElement F=w.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[1]/div/div[4]/div/div[1]/div/a[1]/div"));
		F.click();
		Thread.sleep(2000);
		//as it redirects to another tab,window handle required
		Set<String> win =w.getWindowHandles();
		Iterator<String> itr=win.iterator();
		String Parent=itr.next();//current
		String FB1=itr.next();//new opened

		w.switchTo().window(FB1);
		Thread.sleep(3000);
		System.out.println(w.getTitle());
		//if url =facebook,then ok
		if(w.getTitle().contains("Facebook")) 
		{
			System.out.println("Result---->Facebook link working fine");
		}
		else 
		{
			System.out.println("Result---->Facebook link  not working");
		}
		w.switchTo().window(Parent);
		w.quit();
  }
 
}
