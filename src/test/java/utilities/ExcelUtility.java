package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	
		public FileInputStream fi;
		public  FileOutputStream fo;
		public  XSSFWorkbook wb;
		public  XSSFSheet ws;
		public  XSSFRow row;
		public  XSSFCell cell;
		public  CellStyle style;
		public String path;
		
		public ExcelUtility(String path) {
			
			this.path = path;
		}
		
		public  int getRowCount ( String xlsheet) throws IOException  {
			
			fi = new FileInputStream(path);
			wb = new XSSFWorkbook (fi);
			ws = wb.getSheet(xlsheet);
			int rowCount = ws.getLastRowNum();
			wb.close();
			fi.close();
			return rowCount;
		}
		
	public int getCellCount (String xlsheet, int rownum) throws IOException  {
			
			fi = new FileInputStream(path);
			wb = new XSSFWorkbook (fi);
			ws = wb.getSheet(xlsheet);
			row = ws.getRow(rownum);
			int CellCount = row.getLastCellNum();
			wb.close();
			fi.close();
			return CellCount;
		}
	
		
	
	public String getCellData( String xlsheet,int rownum, int column) throws IOException
	{
	
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook (fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(column);
		
		String data;
		try
		{
			DataFormatter Formatter = new DataFormatter();
			data = Formatter.formatCellValue(cell);
		}
		catch(Exception e)
		{
			data ="";
		}
		wb.close();
		fi.close();
		return data;
		
	}
	
	

	

}
