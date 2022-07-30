package Scenario_Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario_7 
{
	@Test
	public void scenario_7() throws InterruptedException, IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bluestone.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='deny-btn']")).click();
		WebElement	sa=driver.findElement(By.xpath("//a[text()='All Jewellery ']"));
		Thread.sleep(2000);
		Actions ac=new Actions(driver);
		ac.moveToElement(sa).perform();
		driver.findElement(By.xpath("//span[text()='Kadas']")).click();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,600)");
		driver.findElement(By.xpath("//img[@class='hc img-responsive center-block']")).click();
        
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> id = handles.iterator();
		String p = id.next();
		String c = id.next();
		Thread.sleep(2000);
		driver.switchTo().window(c);
		JavascriptExecutor jee=(JavascriptExecutor)driver;
		jee.executeScript("window.scrollBy(0,400)");
		driver.findElement(By.xpath("//div[@class='buynow-block col-xs-7']")).click();
		TakesScreenshot	ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		//path+filename+extension
		File dest=new File("D:\\Java Practice\\SDET6_Sample\\Screen Shot\\ErrorMessage.jpg");
		//copy paste
		Files.copy(src, dest);
		//driver.close();
Set<String> handles1 = driver.getWindowHandles();
		
		Iterator<String> di = handles1.iterator();
		
		String c1 = di.next();
		String p1 = di.next();
		Thread.sleep(2000);
		driver.switchTo().window(p);
		driver.close();
		driver.quit();
	}

}
