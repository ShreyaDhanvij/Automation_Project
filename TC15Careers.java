package MeeshoTestNG;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC15Careers 
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
//TC18:To check Careers button 
  public void TC15Careers() throws InterruptedException 
  {
	//To scroll
	  ((JavascriptExecutor)w).executeScript("window.scrollTo(0,document.body.scrollHeight)");//Scroll to page Down 
			WebElement career=w.findElement(By.linkText("Careers"));
			
			Thread.sleep(2000);
			//As the element was overlaping with something
			  JavascriptExecutor js=(JavascriptExecutor)w;
			 js.executeScript("arguments[0].click()", career);
			//as it redirects to another tab,window handle required
			Set<String> win =w.getWindowHandles();
			Iterator<String> itr=win.iterator();
			String Parent=itr.next();//current
			String child=itr.next();//new opened
			w.switchTo().window(child);
			Thread.sleep(3000);
			//"Join us" location
			WebElement J=w.findElement(By.xpath("//body/div[@id='__next']/div[2]/main[1]/section[1]/div[1]/div[1]/p[1]"));
			String Join_us=J.getText();
			Thread.sleep(3000);
			//If redirected page contains join us then ok,else wrong redirection
			if (Join_us.contains("billion")) 
			{
				System.out.println("Result--->Careers button directed to correct page");
			}
			else 
			{
				System.out.println("Result--->Careers button not working properly");
			}

			Thread.sleep(2000);
			Actions a=new Actions(w);
			JavascriptExecutor js1=(JavascriptExecutor)w;
			js1.executeScript("window.scrollBy(0,250)", "");


			//1
			a.moveToElement(w.findElement(By.xpath("//body/div[@id='__next']/div[2]/main[1]/section[4]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[2]"))).build().perform();
			Thread.sleep(1000);
			a.moveToElement(w.findElement(By.xpath("//*[@id=\"operate\"]/div[2]/div/div[1]/div[1]/div[2]/p[1]"))).build().perform();
			Thread.sleep(1000);
			//2
			a.moveToElement(w.findElement(By.xpath("//body/div[@id='__next']/div[2]/main[1]/section[4]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[2]"))).build().perform();
			Thread.sleep(1000);
			a.moveToElement(w.findElement(By.xpath("//*[@id=\"operate\"]/div[2]/div/div[1]/div[1]/div[2]/p[1]"))).build().perform();
			Thread.sleep(1000);
			//3
			a.moveToElement(w.findElement(By.xpath("//body/div[@id='__next']/div[2]/main[1]/section[4]/div[2]/div[1]/div[1]/ul[1]/li[3]/div[2]"))).build().perform();
			Thread.sleep(1000);
			a.moveToElement(w.findElement(By.xpath("//*[@id=\"operate\"]/div[2]/div/div[1]/div[1]/div[2]/p[1]"))).build().perform();
			Thread.sleep(1000);
			//4
			a.moveToElement(w.findElement(By.xpath("//body/div[@id='__next']/div[2]/main[1]/section[4]/div[2]/div[1]/div[1]/ul[1]/li[4]/div[2]"))).build().perform();
			Thread.sleep(1000);
			a.moveToElement(w.findElement(By.xpath("//*[@id=\"operate\"]/div[2]/div/div[1]/div[1]/div[2]/p[1]"))).build().perform();
			Thread.sleep(1000);
			//5
			a.moveToElement(w.findElement(By.xpath("//body/div[@id='__next']/div[2]/main[1]/section[4]/div[2]/div[1]/div[1]/ul[1]/li[5]/div[1]"))).build().perform();
			Thread.sleep(1000);
			a.moveToElement(w.findElement(By.xpath("//*[@id=\"operate\"]/div[2]/div/div[1]/div[1]/div[2]/p[1]"))).build().perform();
			Thread.sleep(1000);
			//6
			a.moveToElement(w.findElement(By.xpath("//body/div[@id='__next']/div[2]/main[1]/section[4]/div[2]/div[1]/div[1]/ul[1]/li[6]/div[1]"))).build().perform();
			Thread.sleep(1000);
			a.moveToElement(w.findElement(By.xpath("//*[@id=\"operate\"]/div[2]/div/div[1]/div[1]/div[2]/p[1]"))).build().perform();
			Thread.sleep(1000);
			//7
			a.moveToElement(w.findElement(By.xpath("//body/div[@id='__next']/div[2]/main[1]/section[4]/div[2]/div[1]/div[1]/ul[1]/li[7]/div[1]"))).build().perform();
			Thread.sleep(1000);
			a.moveToElement(w.findElement(By.xpath("//*[@id=\"operate\"]/div[2]/div/div[1]/div[1]/div[2]/p[1]"))).build().perform();
			Thread.sleep(1000);
			//8
			a.moveToElement(w.findElement(By.xpath("//body/div[@id='__next']/div[2]/main[1]/section[4]/div[2]/div[1]/div[1]/ul[1]/li[8]/div[1]"))).build().perform();
			Thread.sleep(1000);
			a.moveToElement(w.findElement(By.xpath("//*[@id=\"operate\"]/div[2]/div/div[1]/div[1]/div[2]/p[1]"))).build().perform();
			Thread.sleep(1000);

			//To check "tech at meesho" button	
			w.findElement(By.xpath("//a[contains(text(),'Tech at Meesho')]")).click();
			WebElement T=w.findElement(By.linkText("Tech at Meesho"));
			T.click();
			if(w.getCurrentUrl().contains("tech")) 
			{
				System.out.println("Result---->Tech at meesho button working fine");
			}
			else 
			{
				System.out.println("Result---->Tech at meesho button not working");
			}
			//To check "Life at meehso" button   
			Thread.sleep(3000);
			w.findElement(By.xpath("//a[contains(text(),'Life at Meesho')]")).click();
			if(w.getCurrentUrl().contains("https://meesho.io/life")) 
			{
				System.out.println("Result---->Life at meesho button working fine");
			}
			else 
			{
				System.out.println("Result---->Life at meesho button not working");
			}	

			w.switchTo().window(Parent);
			Thread.sleep(2000);
			w.quit();
  }
 
}
