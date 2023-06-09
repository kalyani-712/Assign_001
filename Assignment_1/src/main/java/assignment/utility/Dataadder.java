package assignment.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Dataadder {
	

	public static String TESTDATA_SHEET_PATH = (System.getProperty("user.dir")+"\\Test Data\\Mobile_TestData.xlsx");
	
	public static Object[][] getTestData(String sheetName) throws Exception {
			
			FileInputStream file = null;
			try{
				file = new FileInputStream(TESTDATA_SHEET_PATH);
			}catch (FileNotFoundException e){
				e.printStackTrace();
			}
			
			Workbook book = WorkbookFactory.create(file);
			
			
		    org.apache.poi.ss.usermodel.Sheet sheet = book.getSheet(sheetName);
			Object[][] data = new Object[((org.apache.poi.ss.usermodel.Sheet) sheet).getLastRowNum()][((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(0).getLastCellNum()];
			for (int i = 0; i < sheet.getLastRowNum();i++){
				for(int k = 0; k < sheet.getRow(0).getLastCellNum();k++){
					data[i][k] = sheet.getRow(i +1).getCell(k).toString();
                    System.out.println(data[i][k]);
				}
			}
			return data;	

   }
}
