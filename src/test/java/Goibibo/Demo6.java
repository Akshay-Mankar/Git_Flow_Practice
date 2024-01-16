package Goibibo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Demo6 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","F:\\Soft tech Automation 21st October  Batch\\Softwares\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		
		WebElement source = driver.findElement(By.xpath("//span[text()='From']/following-sibling::p"));
		source.click();
		
		Actions act = new Actions(driver);
		
		act.click(source).sendKeys("Mumbai").keyDown(Keys.ENTER)
		.sendKeys("Pune").keyDown(Keys.ENTER).keyUp(Keys.ENTER).
		build().perform();
		
		//driver.findElement(By.xpath("//span[text()='From']/following-sibling::input")).sendKeys("Mumbai");
		
	}
}
