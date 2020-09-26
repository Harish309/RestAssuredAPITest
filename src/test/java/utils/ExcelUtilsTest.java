package utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ExcelUtilsTest {

	@SuppressWarnings("static-access")
	public static void main() throws IOException {

		String excelPath = "./data/Data.Xlsx";
		String sheetName = "Sheet1";

		ExcelUtil excel = new ExcelUtil(excelPath, sheetName);
		excel.getRowCount();
		String userName = excel.getCellData(1,0).toString();
		String password =excel.getCellData(1,1).toString();
		String ISBN =excel.getCellData(1,2).toString();
		String UserId =excel.getCellData(1,3).toString();

		System.out.printf(userName,password,ISBN,UserId);

	}
}
