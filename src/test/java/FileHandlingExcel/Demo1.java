package FileHandlingExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		//check file is present or not in desired location
		
		File f = new File("F:\\Soft tech Automation 21st October  Batch\\Data Driven Framework classes\\class 2\\Facebook Test Data.xlsx");
		
		boolean a = f.exists();
		
		System.out.println(a);
		
		//we have to read the file
		
		FileInputStream fis = new FileInputStream(f);
		
		//load the all workbook or all sheets
		//first we have to verify what is Excel sheet type
		//.xlsx or .xls
		//in my framework we are using .xlsx Excel sheet
		//we have to create object of XSSFWorkbook by passing FileInputStream instance
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		//we have to focus on specific sheet by using getSheetAt()
		//by passing sheet index
		
		XSSFSheet sheet = workbook.getSheetAt(1);
		
		//read the specific row and columns data
		
		String b = sheet.getRow(4).getCell(0).getStringCellValue();
		
		System.out.println(b);
		
		//password7
		String c = sheet.getRow(6).getCell(1).getStringCellValue();
		System.out.println(c);
		
		//username10
		String d = sheet.getRow(9).getCell(0).getStringCellValue();
		System.out.println(d);
		
	}

}
