
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//to be updated
public class ExcelDataDriven {
	
	public static File f;
	public static Workbook wb;
	public static Sheet sh;
	public static Row rw;
	public static Cell cell;
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static String xlpath;

public static void main(String[] args) throws Exception {
	
xlpath = ("C://Users//cc305906//Documents//Selinium//Inputs//ABSA.xls");

f= new File(xlpath);
fis = new FileInputStream(f);

String entenstion = xlpath.substring(xlpath.indexOf("."));

if (entenstion.equals("xlsx"))
{
	wb = new XSSFWorkbook(fis);
}

else
{
	wb = new HSSFWorkbook(fis);
}

int index = wb.getSheetIndex("sheet1");
sh = wb.getSheetAt(0);
int noofrows = sh.getLastRowNum()+1;
for(int i =1; i<noofrows; i++)
{
	cell = sh.getRow(i).getCell(0);
	String a = cell.getStringCellValue();
	
	cell = sh.getRow(i).getCell(1);
	if cell.equals(Numeric)
	double b = cell.getNumericCellValue();
	
	cell = sh.getRow(i).getCell(2);
	String c = cell.getStringCellValue();
	
	System.out.println(a);
	System.out.println(b);
	System.out.println(c);
	
	rw = sh.getRow(i);
	cell = rw.createCell(4);
	cell.setCellValue("Success");
	
	fos = new FileOutputStream(f);
	wb.write(fos);
	fos.flush();
	fos.close();
	
			
	
	
}
fis.close();
f.exists();





}

}
