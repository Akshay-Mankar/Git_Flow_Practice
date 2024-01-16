package FileHandlingExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("F:\\Soft tech Automation 21st October  Batch\\Data Driven Framework classes\\class 2\\Facebook Test Data.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(1);
		
		int a = sheet.getLastRowNum()+1;
		System.out.println(a);
		
		
		
		
	}

}
