package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelfile_Utility {
	public String readDatafromExcel(String sheetname,int rownum, int cellnum) throws Throwable {
	FileInputStream fis=new FileInputStream(Iconstant_utility.excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		String value=wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		return value;
		
	}

}
