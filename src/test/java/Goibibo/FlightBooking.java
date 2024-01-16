package Goibibo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlightBooking {
	WebDriver driver;
	@Test(dataProvider = "CustomerInforamtion")
	public void flightBooking()
	{
		System.setProperty("webdriver.chrome.driver","F:\\Soft tech Automation 21st October  Batch\\Softwares\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
	}
}
