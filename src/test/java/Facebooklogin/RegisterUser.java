package Facebooklogin;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 public class RegisterUser {

	@Test(dataProvider="fbdata")
	public void regsiterPage(String fname,String lname,String email, String reemail, String password, String day, String month, String year)
	{
		System.setProperty("webdriver.chrome.driver","F:\\Soft tech Automation 21st October  Batch\\Softwares\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/reg");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(fname);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys(reemail);
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(password);
		
		WebElement bday = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select sel = new Select(bday);
		sel.selectByVisibleText(day);
		
		WebElement bmonth = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select sel1 = new Select(bmonth);
		sel1.selectByVisibleText(month);
		
		WebElement byear = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select sel2 = new Select(byear);
		sel2.selectByVisibleText(year);
		
		driver.close();
	}

	@DataProvider(name="fbdata")
	public Object [][] getData() throws IOException
	{
		ExcelReader excelReader = new ExcelReader("F:\\Soft tech Automation 21st October  Batch\\DataDrivenFramework\\src\\main\\java\\TestdataLayer\\Framework.xlsx");
		Object[][] data = excelReader.getAllSheetData(0);
		return data;
	}
	
}