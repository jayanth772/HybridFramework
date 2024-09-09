package dataProvider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {
	
	@DataProvider(name="LoginDataSet")
	public static Object[][] getData() {
		Object[][] arr = ExcelReader.getDatafromSheet("Login");
		return arr;
	}

}
