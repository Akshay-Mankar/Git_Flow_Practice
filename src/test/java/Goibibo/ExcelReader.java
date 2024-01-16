package Goibibo;

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
		FileInputStream fis = new FileInputStream(new File(path));
		workbook = new XSSFWorkbook(fis);
	}
	
	public int getRowCount(int sheetindex)
	{
		return workbook.getSheetAt(sheetindex).getLastRowNum()+1;
	}
	
	public int getColumnCount(int sheetindex)
	{
		return workbook.getSheetAt(sheetindex).getRow(0).getLastCellNum();
	}
	
	public Object getSpecificSheetData(int sheetindex, int rows, int cells)
	{
		
		XSSFCell cell = workbook.getSheetAt(sheetindex).getRow(rows).getCell(cells);
		if(cell==null) //to check the zero value or null value from the website
		{
			return " ";
		}
		else
		{
			if(cell.getCellType()==XSSFCell.CELL_TYPE_STRING)
			{
				return cell.getStringCellValue();
			}
			else if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
			{
				return cell.getRawValue();
			}
			else if(cell.getCellType()==XSSFCell.CELL_TYPE_BOOLEAN)
			{
				return cell.getBooleanCellValue();
			}
			else
			{
				return cell.getErrorCellString();
			}
			
		}
			
	}
	
	public Object[][] getAllSheetData(int sheetindex)
	{
		int row = getRowCount(sheetindex);
		int column = getColumnCount(sheetindex);
		
		Object [][] data = new Object[row][column];
		
		
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < column; j++)
			{
				data[i][j] = getSpecificSheetData(sheetindex, i , j);
			}
		}
		
		return data;
	}
	
}
