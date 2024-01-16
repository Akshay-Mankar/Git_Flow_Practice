package Facebooklogin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	XSSFWorkbook workbook;
	public ExcelReader(String path) throws IOException
	{
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		workbook = new XSSFWorkbook(fis);
	}
	
	public int getTotalRowCount(int sheetIndex)
	{
		XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
		int rows = sheet.getRow(0).getFirstCellNum() + 1;
		return rows;
	}
	
	public int getTotalCellCount(int sheetIndex)
	{
		XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
		int cells = sheet.getRow(0).getLastCellNum();
		return cells;
	}
	
	public Object getSpecificSheetData(int sheetindex, int row, int cell)
	{
		XSSFCell cells = workbook.getSheetAt(sheetindex).getRow(row).getCell(cell);
		if(cells==null) //to check the zero value or null value from the website
		{
			return " ";
		}
		else
		{
			if(cells.getCellType()==XSSFCell.CELL_TYPE_STRING)
			{
				return cells.getStringCellValue();
			}
			else if(cells.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
			{
				return cells.getRawValue();
			}
			else if(cells.getCellType()==XSSFCell.CELL_TYPE_BOOLEAN)
			{
				return cells.getBooleanCellValue();
			}
			else
			{
				return cells.getErrorCellString();
			}
			
		}
		
	}
	
	public Object [][] getAllSheetData(int sheetIndex)
	{
		int rows = getTotalRowCount(sheetIndex);
		int cells = getTotalCellCount(sheetIndex);
		
		Object[][] data = new Object[rows][cells];
		for(int i = 0 ; i < rows ; i++)
		{
			for(int j = 0; j < cells; j++)
			{
				data[i][j] = getSpecificSheetData(sheetIndex, i, j);
			}
		}
		
		return data;
	}
}
