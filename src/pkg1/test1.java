package pkg1;

import java.io.FileNotFoundException;
import java.io.IOException;

public class test1 {
  
	public static String testCase = "LoginTest";
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		String path = "C:\\Users\\sandeep.sharma\\Desktop\\TestCases1.xlsx";
		
		String TCID=test.readExcel(path);
		if (TCID==testCase) {
		String Description=test.readExcel(path);
		}

	}

}
