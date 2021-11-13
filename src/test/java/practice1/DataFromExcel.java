package practice1;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;


public class DataFromExcel {

	
	
	public ArrayList<String> data(String testcasename) throws IOException {
		
		ArrayList<String> a =new ArrayList<String>();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\sruthi reddy\\Desktop\\logindetails (1).xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// get the count of sheets then loop to sheets and get the sheet required
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				Iterator<Row> rows = sheet.iterator();
			Row firstrow=	rows.next();
			
			Iterator<Cell> cells = firstrow.iterator();
			int k=0;
			int column=0;
			while(cells.hasNext()) {
				Cell value= cells.next();
				if(value.getStringCellValue().equalsIgnoreCase("Testcase")) {
					column=k;	
				}
				k++;
			}
			System.out.println(column);	
			while(rows.hasNext()) {
				Row r= rows.next();
				
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename)) {
					Iterator<Cell> cv = r.cellIterator();
					while(cv.hasNext()) {
						Cell c= cv.next();
						if(c.getCellType()==CellType.STRING) {
							a.add(c.getStringCellValue());
							
						}
						else {
							a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
						}
				//a.add(cv.next().getStringCellValue());
						
					}
				}
				
			}
			
			}

		}
//identify the test case column
		//once identified scan the entire column identify the required field eg,purchase form the excel what we have given
		//after scan the entire row of it
	
	
	
	
	
	return a;
	


	}
		
	
	public static void main(String[] args) throws IOException {
		
		DataFromExcel d = new DataFromExcel();
	ArrayList  data1= 	d.data("profile");
	System.out.println(data1.get(0));
	System.out.println(data1.get(1));
	System.out.println(data1.get(2));
	

	}	
}
