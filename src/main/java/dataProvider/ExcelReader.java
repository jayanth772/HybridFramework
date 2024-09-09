package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	static XSSFWorkbook wb;
	
	public static Object[][] getDatafromSheet(String sheetname) {
		
		System.out.println("******Loading data from excel**************");
		
		Object [][] arr=null;
		
		try {
			wb = new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/testdata/TestData.xlsx")));
			//wb = new XSSFWorkbook(new FileInputStream(new File("./testdata/TestData.xlsx")));
		    
			XSSFSheet sheet = wb.getSheet(sheetname);
			
			int row = sheet.getPhysicalNumberOfRows();
			
			int columns = sheet.getRow(0).getPhysicalNumberOfCells();
			
			arr = new Object[row-1][columns];
			
			for(int i=1;i<row;i++) {
				
				for(int j=0;j<columns;j++) {
					
					arr[i-1][j] = getData(sheetname, i, j);
					
				}
			}
			
			wb.close();
			
		}catch(FileNotFoundException e) {
			
			System.out.println("Could not find the file "+e.getMessage());
		}
		catch (IOException e) {
			
			System.out.println("Could not load the file "+e.getMessage());
		}
		
		return arr;
	}
	
	public static String getData(String sheet, int row, int column) {
		
		XSSFCell cell =  wb.getSheet(sheet).getRow(row).getCell(column);
		
		String data="";
		
		if(cell.getCellType()==CellType.STRING) {
			
			data = cell.getStringCellValue();
			
		}
		else if (cell.getCellType()==CellType.NUMERIC) {
			double cellinDouble = cell.getNumericCellValue();
			data = String.valueOf(cellinDouble);
			
		}
		else if(cell.getCellType()==CellType.BLANK) {
		 data="";
	}
	
		return data;
	}
	
	
	

}
