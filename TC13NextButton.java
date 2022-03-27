package MeeshoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC13NextButton
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
  public void TC13NextButton() throws InterruptedException
  {
	  
	//to scroll vertically
			JavascriptExecutor js=(JavascriptExecutor)w;
			js.executeScript("window.scrollBy(0,250)","");
			//Top Categories to choose from //click on western wear
			WebElement TopCategories= w.findElement(By.xpath("//body/div[@id='__next']/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/img[1]"));
			TopCategories.click();
			Thread.sleep(3000);
			//Scroll upto last of the page
			JavascriptExecutor js1=(JavascriptExecutor)w;
			js1.executeScript("window.scrollBy(0,2550)", "");
			Thread.sleep(3000);
			//click on next
			WebElement next=w.findElement(By.xpath("//span[contains(text(),'NEXT')]"));
			next.click();
			//if redirected page contains Showing 21-40 out of 64010 Products then ok,else wrong
			Thread.sleep(3000);
			WebElement t=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div/div/div[2]/div/div/span[1]"));
			t.getText();
			System.out.println(t.getText());
			//if actual = expected,then next button working fine else stops the execution
			Assert.assertEquals(t.getText(), "Showing 21-40");
			System.out.println("Result---->Next button working fine");
			w.navigate().back();
			w.navigate().back();//Back to homepage
			w.quit();
  }

}
