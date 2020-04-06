package pkg1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class test {

	public static FileInputStream fs;
	public static FileOutputStream fileOut = null;
	private static XSSFWorkbook workbook = null;
	private static XSSFSheet sheet = null;
	private static XSSFRow row = null;
	private static XSSFCell cell = null;

	public static String readExcel(String path) {
		// path = "C:\\Users\\sandeep.sharma\\Desktop\\TestCases1.xlsx";

		try {
			fs = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			workbook = new XSSFWorkbook(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				System.out.print(cell.getStringCellValue());
				System.out.print("--");

			}
			System.out.println();
			

		}
		
		try {
			fs.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cell.getStringCellValue();
	}

}

/*
 * @Test public static void readExcelFile() throws FileNotFoundException,
 * IOException { FileInputStream fs = new
 * FileInputStream("C:\\Users\\sandeep.sharma\\Desktop\\TestCases1.xlsx");
 * 
 * XSSFWorkbook workbook = new XSSFWorkbook(fs); XSSFSheet sheet=
 * workbook.getSheetAt(0); Iterator<Row> rowIterator = sheet.iterator();
 * while(rowIterator.hasNext()) { Row row=rowIterator.next(); Iterator<Cell>
 * cellIterator =row.cellIterator(); while(cellIterator.hasNext()) { Cell cell =
 * cellIterator.next(); System.out.print(cell.getStringCellValue());
 * System.out.print("--");
 * 
 * } System.out.println();
 * 
 * 
 * } fs.close(); }
 * 
 * @Test public static void readTxtFile() throws FileNotFoundException,
 * IOException { FileReader fr = new FileReader("Foo.txt"); BufferedReader br =
 * new BufferedReader(fr); String a=br.readLine(); while (a!=null) {
 * System.out.println(a); a=br.readLine(); } br.close(); }
 * 
 * @Test public static void writeTxtFile() throws FileNotFoundException {
 * PrintWriter pw = new PrintWriter(new FileOutputStream("Foo.txt", true));
 * pw.println('a'); pw.println(100); pw.println("Hello"); pw.println(true);
 * pw.flush(); pw.close(); }
 * 
 * }
 */
