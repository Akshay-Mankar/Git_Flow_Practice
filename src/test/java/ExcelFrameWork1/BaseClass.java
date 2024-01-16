package ExcelFrameWork1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class BaseClass {

	@Test(dataProvider = "registerUser")
	public void regUser(String title, String name, String surname, String address1, String address2, String city,String country, String state,
			String nationality, String pincode, String email, String phoneno, String mobileno, String question,  
			String answer, String userid, String passwd, String conpasswd) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","F:\\Soft tech Automation 21st October  Batch\\Softwares\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://copyright.gov.in/UserRegistration/frmNewUser.aspx");
		driver.manage().window().maximize();
		WebElement title1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlTitle"));
		Select sel1 = new Select(title1);
		sel1.selectByVisibleText(title);
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtFName")).sendKeys(name);
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtLName")).sendKeys(surname);
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtAddress")).sendKeys(address1);
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtAddress2")).sendKeys(address2);
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtCity")).sendKeys(city);
		
		WebElement country1 = driver.findElement(By.name("ctl00$ContentPlaceHolder1$ddlCountry"));
		Select sel2 = new Select(country1);
		sel2.selectByVisibleText(country);
		
		WebElement state1 = driver.findElement(By.name("ctl00$ContentPlaceHolder1$ddlState"));
		Select sel3 = new Select(state1);
		sel3.selectByVisibleText(state);		
		
		//driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlDistrict")).sendKeys(district);
		
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtNationality")).sendKeys(nationality);
		
		WebElement pincode1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPinCode"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + pincode + "'", pincode1);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtEmail")).sendKeys(email);
		
		WebElement phoneno1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPhoneNumber"));
		js.executeScript("arguments[0].value='" + phoneno + "'", phoneno1);
		
		WebElement mobileno1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtMobileNum"));
		js.executeScript("arguments[0].value='" + mobileno + "'", mobileno1);
		
		
		
		WebElement question1 = driver.findElement(By.name("ctl00$ContentPlaceHolder1$ddlQuestions"));
		Select sel4 = new Select(question1);
		sel4.selectByVisibleText(question);
		
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtAnswer")).sendKeys(answer);
		driver.findElement(By.xpath("//label[text()='General User']")).click();
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtUserId")).sendKeys(userid);
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtPassword")).sendKeys(passwd);
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtConfirmPwd")).sendKeys(conpasswd);
		Thread.sleep(5000);
		driver.quit();
	}
	
	@DataProvider(name = "registerUser")
	public Object [][] getData() throws IOException
	{
		Demo3 obj = new Demo3("F:\\Soft tech Automation 21st October  Batch\\DataDrivenFramework\\src\\main\\java\\TestdataLayer\\Book3.xlsx");

		Object[][] data = obj.getAllSheetData(0);
		return data;
	}
}
