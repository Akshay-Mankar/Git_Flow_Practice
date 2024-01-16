package ExcelFrameWork1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Demo3 {
XSSFWorkbook workbook;
XSSFSheet sheet;
	
public Demo3(String path) throws IOException {
	File f = new File(path);
	FileInputStream fis = new FileInputStream(f);
	workbook = new XSSFWorkbook(fis);	
}

public int getTotalRowCount(int sheetindex) {
	XSSFSheet sheet = workbook.getSheetAt(sheetindex);
	int rows = sheet.getLastRowNum() + 1;
	return rows;
}

public int getTotalColumnCount(int sheetindex) {
	XSSFSheet sheet = workbook.getSheetAt(sheetindex);
	int cells = sheet.getRow(0).getLastCellNum();
	return cells;
}

public Object getSpecificSheetData(int sheetindex, int row, int cell) {
	sheet = workbook.getSheetAt(sheetindex);
	XSSFCell cells = sheet.getRow(row).getCell(cell);
	if (cells.getCellType() == XSSFCell.CELL_TYPE_STRING) 
	{
		return sheet.getRow(row).getCell(cell).getStringCellValue();
	} 
	else if(cells.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
	{
		return sheet.getRow(row).getCell(cell).getNumericCellValue();
	}
	else if(cells.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN)
	{
		return sheet.getRow(row).getCell(cell).getBooleanCellValue();
	}
	else
	{
		return sheet.getRow(row).getCell(cell).getRawValue();
	}
	
}

public Object[][] getAllSheetData(int sheetIndex) {
	int rows = getTotalRowCount(sheetIndex);
	int cell = getTotalColumnCount(sheetIndex);

	Object[][] data = new Object[rows][cell];

	for (int i = 0; i < rows; i++) {
		for (int j = 0; j < cell; j++) {
			data[i][j] = getSpecificSheetData(sheetIndex, i, j);

		}

	}

	return data;

}

	
}