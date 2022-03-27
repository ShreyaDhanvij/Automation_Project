package MeeshoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC05WomenEthenicModule
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
  public void TC05WomenEthenic() throws InterruptedException 
  {//Mouseover Women ethnic section
		Actions a=new Actions(w);
		WebElement WE=w.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div/div[1]/span"));
		a.moveToElement(WE).build().perform();

		//Click on georgette sarees
		Thread.sleep(2000);
		WebElement Georgette=w.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div/div[2]/div/div[2]/a[5]/p"));
		Georgette.click();
		//to scroll vertically
		JavascriptExecutor js = (JavascriptExecutor)w;
		js.executeScript("window.scrollBy(0,250)", "");

		Thread.sleep(3000);
		String text=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div/div/div[1]/div/h1")).getText();
		//If directed page contains "Saree",then ok else wrong
		if(text.contains("Sarees")) 
		{
			System.out.println("Result---> Women Ethenic redirected to correct page");			
		}
		else 
		{
			System.out.println("Result---> Women Ethenic redirected to incorrect pag");
		}
		Thread.sleep(4000);
		//click on any result
		Thread.sleep(2000);
		WebElement img1=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div/div/div[4]/div/div[1]/a"));
		img1.click();

		//angles of product

		switch(1) //this 1 needs to be changed if the there are more than 1 angle given in product
		{

		//Click on 4th img
		case 4:Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[1]/div/div[1]/div/div/div/div[4]/div/img")).click();

		//Click on 3rd img
		case 3:Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[1]/div/div[1]/div/div/div/div[3]/div/img")).click();

		//Click on 2nd img
		case 2 :Thread.sleep(1000);
		w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[1]/div/div[1]/div/div/div/div[2]/div/img")).click();

		//Click on 1st img
		case 1 : Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[1]/div/div[1]/div/div/div/div/div")).click();
		break;

		}
		

		//Click on view shop
		Thread.sleep(2000);
		WebElement ViewShop=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[2]/div[4]/div/div[1]/div[2]/button"));
		ViewShop.click();
		Thread.sleep(3000);
		w.navigate().back();//on result page
		//Click on Add to cart
		Thread.sleep(2000);
		WebElement Add=w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[1]/div/div[2]/div[2]"));
		
		
		System.out.println("item added successfully in the cart");
		//Click on more information about product

Thread.sleep(2000);
				WebElement info=w.findElement(By.xpath("//span[contains(text(),'More Information')]"));
				info.click();

				//if opened info pop up contains "Information",then ok
				Thread.sleep(1000);
				WebElement I=w.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div"));
				if(I.getText().contains("INFORMATION")) 
				{
					System.out.println("Result-----> More information page working fine");
				}
				else 
				{
					System.out.println("Result-----> More information page not working "); 
				}
				//Click on X(cross)
				Thread.sleep(2000);
				WebElement close=w.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/svg"));
				close.click();

				System.out.println(w.getCurrentUrl());	
		Thread.sleep(2000);
		w.quit();
  }
 
}
