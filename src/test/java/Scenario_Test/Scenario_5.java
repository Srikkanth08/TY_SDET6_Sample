package Scenario_Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario_5 
{
	@Test
	public void scenario_5() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.bluestone.com");
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[.='Not now']")).click();
		
		WebElement rings = driver.findElement(By.xpath("(//a[@title='Rings'])[1]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(rings).perform();
		driver.findElement(By.xpath("(//a[.='Diamond'])[1]")).click();
		
		Thread.sleep(2000);
		List<WebElement> defaultPrices = driver.findElements(By.xpath("//span[@class='new-price']"));
		
		System.out.println("DefaultPrices");
		for(int i=1; i<defaultPrices.size(); i++)
		{
			System.out.println(defaultPrices.get(i).getText());
		}
		
		Thread.sleep(2000);
		
		WebElement sort = driver.findElement(By.xpath("//span[.=' Popular ']"));
		Actions ac1 = new Actions(driver);
		ac.moveToElement(sort).perform();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Price Low to High ']")).click();
		
		Thread.sleep(2000);
		List<WebElement> sortedPrices = driver.findElements(By.xpath("//span[@class='new-price']"));
		
		System.out.println("Sorted(Low to High) Prices");
		for(int i=1; i<sortedPrices.size(); i++)
		{			
			System.out.println(sortedPrices.get(i).getText());
		}
		
		Thread.sleep(2000);
		
//        for (int i = 0; i<
//        		price.size(); i=i+1) 
//        {
//        System.out.println(price.get(i).getText());          
//        }
		
	}
}
