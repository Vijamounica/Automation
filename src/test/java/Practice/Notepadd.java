package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Notepadd {

	public static void main(String[] args) throws Throwable {
		FileInputStream FIS= new FileInputStream("C:\\Users\\Chinni\\eclipse-workspace\\Javaselenium\\seleniumjava\\Excel\\sheet1.xls.xlsx");
       Workbook wb=WorkbookFactory.create(FIS);
     String G=wb.getSheet("sheet1").getRow(0).getCell(1).getStringCellValue();
     System.out.println(G);
	}

}
