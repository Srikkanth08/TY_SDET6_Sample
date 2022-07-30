package IdeyaLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChildFrame 
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://demoqa.com/nestedframes");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		
		//Switch To frame Child frame
		WebElement Frame = driver.findElement(By.xpath("//body[text()='Parent frame']"));
		WebElement Frame1 = driver.findElement(By.xpath("//p[text()='Child Iframe']"));
		driver.switchTo().frame(Frame1);
		Thread.sleep(3000);
//		Select sel = new Select(Frame1);
//		System.out.println(sel.getText());

	}
}
