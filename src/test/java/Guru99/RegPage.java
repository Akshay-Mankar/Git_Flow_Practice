package Guru99;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegPage {
	@Test(dataProvider="Guru99")
	public void registerUser(String fname, String lname, String phoneno, String email, String address, String city, String state, String postalcode, String country, String uname, String passwd, String conpasswd)
	{
		System.setProperty("webdriver.chrome.driver","F:\\Soft tech Automation 21st October  Batch\\Softwares\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.name("firstName")).sendKeys(fname);
		driver.findElement(By.name("lastName")).sendKeys(lname);
		driver.findElement(By.name("phone")).sendKeys(phoneno);
		driver.findElement(By.name("userName")).sendKeys(email);
		driver.findElement(By.name("address1")).sendKeys(address);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(state);
		driver.findElement(By.name("postalCode")).sendKeys(postalcode);
		
		WebElement country1 = driver.findElement(By.name("country"));
		Select sel = new Select(country1);
		sel.selectByVisibleText(country);
		
		driver.findElement(By.name("email")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(passwd);
		driver.findElement(By.name("confirmPassword")).sendKeys(conpasswd);
		driver.findElement(By.name("submit")).click();

		
		
	}
	
	@DataProvider(name="Guru99")
	public String[][] getData()
	{
		String [][] data = new String [1][12];
		
		data[0][0] = "Rajdeep";
		data[0][1] = "Karpe";
		data[0][2] = "7778961356";
		data[0][3] = "rkplayer2525@gmail.com";
		data[0][4] = "Pune";
		data[0][5] = "Pune";
		data[0][6] = "Maharashtra";
		data[0][7] = "411052";
		data[0][8] = "INDIA";
		data[0][9] = "rkplayer2525@gmail.com";
		data[0][10] = "rkplayer@12345";
		data[0][11] = "rkplayer@12345";
		
		
		return data;
	}

	
}
