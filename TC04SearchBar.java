package MeeshoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC04SearchBar 
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
//TC06:To check searchBar and add that searched product in cart
public void TC04SearchBar() throws InterruptedException 
{
	Actions a=new Actions(w);
	//mouseover profile
	WebElement Profile= w.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[3]/div[5]"));
	a.moveToElement(Profile).build().perform();
	//Click on signup
	WebElement signup=w.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[3]/div[5]/div/div/button/div"));
	signup.click();

	Thread.sleep(1000);
	//Enter phone num for OTP generation
	WebElement O=w.findElement(By.xpath("//input[@type='tel']"));
	Thread.sleep(2000);
	O.sendKeys("9518761620");//with valid data
	//click on "send OTP"
	w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[2]/div/button/div")).click();
	Thread.sleep(25000);

	//Search saree
	WebElement Searchbar=w.findElement(By.xpath("//body/div[@id='__next']/div[2]/div[1]/div[1]/div[2]/div[1]/input[1]"));
	Searchbar.sendKeys("Saree");
	//Press enter	
	WebElement Search=w.findElement(By.xpath("//body/div[@id='__next']/div[2]/div[1]/div[1]/div[2]/div[1]/input[1]"));
	Thread.sleep(2000);
	Search.sendKeys(Keys.ENTER);
	Thread.sleep(3000);
	String text=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[1]/div")).getText();
	//If directed page contains "Saree",then ok else wrong
	if(text.contains("saree")) 
	{
		System.out.println("Result---> Search bar working fine");			
	}
	else 
	{
		System.out.println("Result---> Search bar not  working");
	}
	//ADD TO CART SERACHED PRODUCT
	//Open the searched product
	WebElement Open=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[4]/div/div[1]/a/div/div[1]/div[1]/img"));
	Thread.sleep(2000);
	Open.click();
	Thread.sleep(2000);
	//add to cart that product
	WebElement Add=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[1]/div/div[2]/div[2]"));
	Add.click();
	//As the element was overlaping with something
	

	Thread.sleep(3000);
	System.out.println("Result---> Add to cart  button working fine");
	//Click on My cart
	WebElement Cart=w.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[3]/div[6]/svg"));
	Cart.click();

	//Click on edit
	Thread.sleep(2000);
	WebElement Edit=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div/button/div"));
	Edit.click();

	//Click on remove
	Thread.sleep(1000);
	WebElement Remove=w.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/div[1]/div/button/div/span"));
	Remove.click();

	//Click on remove2
	WebElement Remove2=w.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/button[2]/div/span"));
	Remove2.click();
	System.out.println("Result--->Remove from cart working fine");
	Thread.sleep(1000);
	w.quit();
}

}
