package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteToExcelNewRow {

	public static void main(String[] args) throws IOException {
		//step1: convert physical file into java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");

		//step2:Open Workbook
		Workbook wb = WorkbookFactory.create(fis);
        
		//step3: GO to specific sheet
		Sheet sh = wb.getSheet("Sheet1");
		
		//step4: Create a Row       // Get ROW
		Row r =sh.createRow(5);     //Row r = sh.getRow(5);
		
		//step5 : Create cell       //step5 : Create cell
		Cell c =r.createCell(0);    //Cell c =r.createCell(1);
		                           
		
		//step6 :Write data        //step6 :Write data
	    c.setCellValue("course");  //c.setCellValue("Automation");
		
		//step7: save data to excel
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
        wb.write(fos);
         
        //step 8: close Excel
        wb.close();
		
		
	}

}
