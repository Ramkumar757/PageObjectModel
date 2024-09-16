package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name ="LoginData")
	public String[][] getData() throws IOException {
		
		String path =".\\testData\\OpenCartTestLoginData.xlsx";
		ExcelUtility exUtil = new ExcelUtility(path);
		int totalCols = exUtil.getCellCount("loginData", 1);
		int totalRows = exUtil.getRowCount("loginData");
		String[][] LoginData = new String[totalRows][totalCols];
		
		for(int i=1 ;i<=totalRows;i++) {
			for(int j=0 ;j<totalCols;j++) {
				LoginData[i-1][j] =exUtil.getCellData("loginData", i, j);
			}
		}
		
		return LoginData;
	}

}
