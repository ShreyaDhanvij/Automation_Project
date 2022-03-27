package MeeshoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC02Registration 
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
//REGISTER MODULE
  public void TC02Registration() throws InterruptedException
  {
	  Actions a=new Actions(w);
		//mouseover profile
		WebElement Profile= w.findElement(By.xpath("//*[text()=\"Profile\"]"));
		a.moveToElement(Profile).build().perform();
		//Click on signup
		WebElement signup=w.findElement(By.xpath("//*[text()=\"Sign Up\"]"));
		signup.click();

		Thread.sleep(1000);
		//Enter phone num for OTP generation
		WebElement O=w.findElement(By.xpath("//input[@type='tel']"));
		Thread.sleep(1000);
		O.sendKeys("9028367857");//with valid data
		//click on "send OTP"
		w.findElement(By.xpath("//span[contains(text(),'Send OTP')]")).click();
		Thread.sleep(20000);
		w.navigate().refresh();
		Thread.sleep(2000);
		WebElement pr=w.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[3]/div[5]"));
		a.moveToElement(pr).build().perform();
		WebElement P=w.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[3]/div[5]/div/div/div[1]/div/div[2]"));
      String HU=P.getText();
		if(HU.contains("Hello User")) 
		{
			System.out.println("Result---->Registration successful");
		}
		else 
		{
			System.out.println("Result---->Registration Unsuccessful");
		}
		//logout
		WebElement logout=w.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[3]/div[5]/div/div/div[4]/span"));
		logout.click();
		System.out.println("Result---->Logout successful");
		Thread.sleep(2000);
	  w.quit();
	  Thread.sleep(2000);
  }
  
}
