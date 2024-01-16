package ExcelFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo2 {

	@Test(dataProvider = "fbdata")
	public void registerPage(String fname, String lname, String email, String conemail) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","F:\\Soft tech Automation 21st October  Batch\\Softwares\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/reg");
		
		driver.findElement(By.name("firstname")).sendKeys(fname);
		driver.findElement(By.name("lastname")).sendKeys(lname);
		driver.findElement(By.name("reg_email__")).sendKeys(email);
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys(conemail);
		Thread.sleep(3000);
		driver.quit();

	}

	@DataProvider(name = "fbdata")
	public Object[][] getData() throws IOException {
		// Read Data From Excel Sheet
		File f = new File("F:\\Soft tech Automation 21st October  Batch\\Data Driven Framework classes\\class 3\\Book1.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rows = sheet.getLastRowNum() + 1;
		
		System.out.println(rows);
		
		int cells = sheet.getRow(0).getLastCellNum();
		
		System.out.println(cells);
		
		// convert Captured values into Object[][] array.
				Object[][] data = new Object[rows][cells];
		
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cells; j++)
			{
				data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			
		}
		
		return data;

	}
}


//how to right click on element 

// first we locate the webElement using findElement method()
//WebElement wb = driver.findElement(By.id(""));

//then we create an Actions class instance where we pass the Webdriver instance
// Actions act = new Actions(driver);

//then using Actions class instance we call contextClick() method to right click on webelement
// act.contextClick().build().perform();

