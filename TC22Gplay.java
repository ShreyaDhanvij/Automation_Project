package MeeshoTestNG;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC22Gplay 
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
  
	  public void t2Gplay() throws InterruptedException 
	  {
		  Actions a1=new Actions(w);
			WebElement Dwnld1=w.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[3]/div[1]/span"));
			a1.moveToElement(Dwnld1).build().perform();

		//Click on "get it on google play"
		WebElement GP=w.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[3]/div[1]/div/div/div[1]/a"));
		Thread.sleep(1000);		
		GP.click();//should direct to googlePlay

		//Window Handling  
		Set<String> win=w.getWindowHandles();
		Iterator<String> itr=win.iterator();
		String Parent=itr.next();//hp
		
		String Child1=itr.next();//gplay
		w.switchTo().window(Child1);
		
		System.out.println(w.getTitle());//gplay
		//If directed page contains"Meesho:Online Shopping Apps on Google Play",Gplay working fine
		if (w.getTitle().contains("Meesho: Online Shopping App - Apps on Google Play")) 
		{
			System.out.println("Result---->Gplay Working fine");
		}
		else
		{
			System.out.println("Result---->Gplay not  Working"); 
		}

		w.switchTo().window(Parent);//navigate on homepage
		
		System.out.println(w.getTitle()+"<-----HomePage");
		w.quit();
	  }
  }

