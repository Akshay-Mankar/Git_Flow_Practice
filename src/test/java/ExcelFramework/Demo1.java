package ExcelFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo1 {

	@Test(dataProvider = "fbdata")
	public void registerPage(String fname, String lname) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","F:\\Soft tech Automation 21st October  Batch\\Softwares\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/reg");
		driver.findElement(By.name("firstname")).sendKeys(fname);
		driver.findElement(By.name("lastname")).sendKeys(lname);
		//driver.findElement(By.name("reg_email__")).sendKeys(email);
		//driver.findElement(By.name("reg_email_confirmation__")).sendKeys(conemail);
		Thread.sleep(3000);
		driver.quit();
	}

	@DataProvider(name = "fbdata")
	public Object[][] getData() throws IOException {
		// Read Data From Excel Sheet
		File f = new File("F:\\Soft tech Automation 21st October  Batch\\Data Driven Framework classes\\class 3\\Framework.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String a = sheet.getRow(0).getCell(0).getStringCellValue();
		String b = sheet.getRow(0).getCell(1).getStringCellValue();
		String c = sheet.getRow(1).getCell(0).getStringCellValue();
		String d = sheet.getRow(1).getCell(1).getStringCellValue();

		// convert Captured values into Object[][] array.
		Object[][] data = new Object[2][2];

		data[0][0] = a;
		data[0][1] = b;
		
		data[1][0] = c;
		data[1][1] = d;
	

		return data;

	}
}
