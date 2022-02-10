package readata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {
public ArrayList<String> getData(String testcasename) throws IOException {
	ArrayList<String> a =new ArrayList<String>();;
	FileInputStream fis = new FileInputStream("../ExcelDriven/Exceldata.xlsx");
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	int sheetnos = wb.getNumberOfSheets();
	for (int i = 0; i < sheetnos; i++) {
		if (wb.getSheetName(i).equalsIgnoreCase("Sheet1")) {
			XSSFSheet sheet = wb.getSheetAt(i);

			Iterator<Row> rows = sheet.rowIterator();
			Row firstrow = rows.next();
			Iterator<Cell> ce = firstrow.iterator();
			int k = 0;
			int column = 0;
			while (ce.hasNext()) {
				Cell value = ce.next();
				if (value.getStringCellValue().equalsIgnoreCase(testcasename)) {
					column = k;
				}
				k++;
			}
			System.out.println(column);
			
			while (rows.hasNext()) {
				Row r=rows.next();
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename)) {
					Iterator<Cell> cv = r.cellIterator();
					while (cv.hasNext()) {
						Cell c = cv.next();
						if(c.getCellType() == CellType.STRING) {
							a.add(c.getStringCellValue());
							
						}
						else {
							a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							
						}
						
					}
				}
			}

		}
	}
return a;
}
	public static void main(String[] args) throws IOException {

	}

}
