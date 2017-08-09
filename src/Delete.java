import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Delete {
	
	public static File f;
	public static Workbook wb;
	public static Sheet sh;
	public static Row row;
	public static Cell cell;
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static String xpath;
	public static int kk1;
	
	
	
	
	public static void main(String[] args) throws Exception {
		
		xpath  = ("C:\\Users\\cc305906\\Documents\\Selinium\\Inputs\\DatadrivenTest.xls");
		File f = new File(xpath);
		fis = new FileInputStream(f);
		
		String filetype = xpath.substring(xpath.indexOf("."));

	if (filetype.equalsIgnoreCase(".xlsx"))
	{
		wb = new XSSFWorkbook(fis);
	}
		
	else
	{
		wb = new HSSFWorkbook(fis);
	}
		
		
	int index = wb.getSheetIndex("Sheet1");
	sh = wb.getSheetAt(index);
	
	int noofrows = sh.getLastRowNum()+1;
	for(int i=1; i<noofrows;i++)
	{
	cell = sh.getRow(i).getCell(0);
	String kk = cell.getStringCellValue();
	
	cell = sh.getRow(i).getCell(1);
	 kk1 = (int) cell.getNumericCellValue();
	
	System.out.println(kk);
	System.out.println(kk1);
		
		
	}
fis.close();
f.exists();
	
	

	}
}
