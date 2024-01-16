package ExcelFramework;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Demo4 {

	@Test(dataProvider = "registerdata")
	public void registerPage(String fname, String lname, String phone, String email, String address, String city,
			String state, String pcode, String country, String uname, String pass, String cpass)
			throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","F:\\Soft tech Automation 21st October  Batch\\Softwares\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.guru99.com/test/newtours/register.php");
		driver.findElement(By.name("firstName")).sendKeys(fname);
		driver.findElement(By.name("lastName")).sendKeys(lname);
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.name("userName")).sendKeys(email);
		driver.findElement(By.name("address1")).sendKeys(address);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(state);
		driver.findElement(By.name("postalCode")).sendKeys(pcode);
		WebElement wb = driver.findElement(By.name("country"));
		new Select(wb).selectByVisibleText(country);
		
		
		
		driver.findElement(By.name("email")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("confirmPassword")).sendKeys(cpass);
		Thread.sleep(5000);
		driver.findElement(By.name("submit")).click();
		
		
		driver.quit();

		
	}

	@DataProvider(name = "registerdata")
	public Object[][] getData() throws IOException {

		Demo3 obj = new Demo3("F:\\Soft tech Automation 21st October  Batch\\Data Driven Framework classes\\class 3\\Book2.xlsx");

		Object[][] data = obj.getAllSheetData(0);

		return data;
	}

}
