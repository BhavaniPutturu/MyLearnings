package marathon.day3;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromOppExcel {
	public static String[][] getDataFromExcel(String fileName, int sheetIndex) throws IOException
	{
			String fn = "./Excel/" + fileName +".xlsx";
			//set the path of  workbook
			XSSFWorkbook workBook = new XSSFWorkbook(fn);				
			//get into sheet
			XSSFSheet sheetAt = workBook.getSheetAt(sheetIndex);				
			//get into row value
			int rowCount = sheetAt.getLastRowNum();			
			//get column count
			short colCount = sheetAt.getRow(1).getLastCellNum();
			String[][] data = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++)
			{
				for (int j = 0; j < colCount; j++) 
				{			
					Cell cell = sheetAt.getRow(i).getCell(j);
					//add the value to data array
					data[i-1][j] = cell.getStringCellValue();
				}
			}
			workBook.close();
			return data;
					
	}
}
