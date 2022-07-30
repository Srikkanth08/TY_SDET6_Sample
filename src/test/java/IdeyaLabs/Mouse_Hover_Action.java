package IdeyaLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouse_Hover_Action
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("http://demowebshop.tricentis.com/");
		
		Thread.sleep(2000);
		WebElement moreAddr = driver.findElement(By.xpath("//a[text()='Register']"));
		Thread.sleep(2000);
		Actions ac = new Actions(driver);
		ac.moveToElement(moreAddr).perform();
		Thread.sleep(2000);
		ac.click();
	}
}
