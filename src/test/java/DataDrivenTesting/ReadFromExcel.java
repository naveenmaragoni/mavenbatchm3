package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {
         public static XSSFWorkbook book;
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// step 1: convert physical file into java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		// step 2: open workbook
		 book = new XSSFWorkbook(fis);

		// Workbook wb = WorkbookFactory.create(fis);
		// step 3: Go to the specific sheet
		Sheet sh = book.getSheet("Sheet1");
		// step 4: Go to the specific row
		Row r = sh.getRow(1);
		// step 5: Go to the specific file
		Cell c = r.getCell(1);
		// step 6: fetch data
		System.out.println(c.getStringCellValue());
		// step 7: close Excel
		book.close();
	}

}
