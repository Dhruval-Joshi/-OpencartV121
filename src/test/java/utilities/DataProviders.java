package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "LoginData")
	public String [][] getData() throws IOException{
		
		String path = ".\\testData\\TestDataEmail.xlsx "; //taking xl file from test Data
		
		ExcelUtility xlutil = new ExcelUtility(path); //rceating an object for xlutility
		
		int totalrow = xlutil.getRowCount("Sheet1");
		int totalcolumn = xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]=new String [totalrow][totalcolumn];
		
		for(int i =1; i<=totalrow; i++) {

			for(int j =0; j<totalcolumn; j++) {
				
				logindata[i-1][j]= xlutil.getCellData("Sheet1", i, j);
			}
		}
		
		return logindata;
		
	}

}
