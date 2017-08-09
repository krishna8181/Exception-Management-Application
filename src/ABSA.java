

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ABSA {
	
	public static WebDriver driver;

@Test(dataProvider = "testdata")
public void login(String a, String b, String c, String d, String e)
{
	System.out.println(a);
	
	
}



	
@DataProvider (name = "testdata")
public static Object[] [] readexcel() throws Exception, IOException {
	
	File f = new File("C:/Users/cc305906/Documents/Selinium/Inputs/ABSA.xls");
	Workbook wb = Workbook.getWorkbook(f);
	Sheet sh = wb.getSheet(0);
	int row = sh.getRows();
	int column = sh.getColumns();
	
	String input [] [] = new String [row][column];
	for(int i =1; i<row;i++)
	{
		for(int j =0; j<column;j++)
		{
		Cell c = sh.getCell(j,i);
		input [i][j] = c.getContents();

		}
	}
	return input;
	


	}

}
