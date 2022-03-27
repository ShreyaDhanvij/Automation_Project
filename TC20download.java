package MeeshoTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TC20download

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
  public void t1apple() throws InterruptedException {
	  
	  Actions a=new Actions(w);
		WebElement Dwnld=w.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[3]/div[1]/span"));
		a.moveToElement(Dwnld).build().perform();

		

		Thread.sleep(1000);
		//Click on "get it on Mac store"
				WebElement AppStore=w.findElement(By.xpath("//body/div[@id='__next']/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/a[1]"));
				AppStore.click();//Should direct Mac App Store

		//Window Handling  
		Set<String> win=w.getWindowHandles();
		Iterator<String> itr=win.iterator();
		String Parent=itr.next();//hp
		String Child=itr.next();//apple
		//String Child1=itr.next();//gplay
		w.switchTo().window(Child);
		System.out.println(w.getTitle());//apple

		//If directed page contains"Meesho:Online Shopping on the App Store",MAC working fine
		if (w.getTitle().contains("Meesho:Online Shopping on the App Store")) 
		{
			System.out.println("Result---->MAC Working fine");
		}
		else
		{
			System.out.println("Result---->MAC not Working"); 
		}
		w.switchTo().window(Parent);
		Thread.sleep(3000);
		w.quit();
		
  }
 
 
 

	//-------------------------------------------//CLOSE BROWSER//--------------------------------------------//


}
