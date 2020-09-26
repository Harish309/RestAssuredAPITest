package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	@SuppressWarnings("deprecation")
	public ExcelUtil(String excelPath, String sheetName) throws IOException
	{
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
	}

	public static void main(String[] args) throws IOException {

	}

	public static Object getCellData(int rowNum, int colNum) throws IOException
	{
		DataFormatter dF = new DataFormatter();
		Object Value = dF.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		System.out.println(Value);
		return Value;
	}

	public static void getRowCount() throws IOException {

		int rowCount= sheet.getPhysicalNumberOfRows();
		System.out.println("Rows:"+rowCount);
	}

}
