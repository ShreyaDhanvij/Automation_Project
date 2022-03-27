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

public class TC17InstaGram
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
public void TC17INSTA() throws InterruptedException 
{
	 ((JavascriptExecutor)w).executeScript("window.scrollTo(0,document.body.scrollHeight)");//Scroll to page Down 
	//Click on instagram link
	Thread.sleep(2000);
	WebElement I=w.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[1]/div/div[4]/div/div[1]/div/a[2]/div"));
	
	//As the element was overlaping with something
	  JavascriptExecutor js=(JavascriptExecutor)w;
	 js.executeScript("arguments[0].click()", I);
	Thread.sleep(3000);
	//as it redirects to another tab,window handle required
	
	Set<String> win =w.getWindowHandles();
	Iterator<String> itr=win.iterator();
	String Parent=itr.next();//current
	String insta=itr.next();//new opened
	w.switchTo().window(insta);
	//if url =insta,then ok
	String IURL=w.getCurrentUrl();
	if(IURL.contains("instagram")) 
	{
		System.out.println("Result---->Instagram link working fine");
	}
	else 
	{
		System.out.println("Result---->Instagram link not working");
	}
	w.switchTo().window(Parent);
	w.quit();
	
}

}
