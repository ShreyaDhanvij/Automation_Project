package MeeshoTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC01URLTitle
{
	WebDriver w=null;

	//-------------------------------------------//LauchBrowser//---------------------------------------------//
	@BeforeMethod
	public void LaunchBrowser() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shreya\\OneDrive\\Desktop\\Selenium JAR\\chromedriver.exe");
		w=new ChromeDriver();
		w.get("https://meesho.com/");
		//w.manage().window().maximize();
	}
  @Test
  public void TC01URLTitle() throws InterruptedException 
  {
			String URL=w.getCurrentUrl();

			if (w.getCurrentUrl().contains("meesho.com/")) 
			{
				System.out.println("Result---->URL ok");
			}
			else 
			{
				System.out.println("Result---->URL invalid");
			}
			//Title check

			String Title=w.getTitle();
			System.out.println(Title);
			if(Title.contains("Online Shopping")) 

			{
				System.out.println("Result---->Title ok");
			}           
			else 
			{
				System.out.println("Result---->Title Invalid");
			}
			Thread.sleep(1000);
			w.quit();
  }
  
}
