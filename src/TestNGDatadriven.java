import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class TestNGDatadriven {
	
	public static WebDriver driver;
	public static Workbook wb;
	public static Sheet sh;
	public static Row row ;
	public static Cell cell;
	public static File f;
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static String xlpath;
	public static int nofrows;
	public static String mailid;
	public static String password;
	public static String active;
	public static String result;
	public static String error;
	
	

	

	@BeforeMethod
	public void readexcel() throws Exception{
		
	xlpath = ("C:\\Users\\cc305906\\Documents\\Selinium\\Inputs\\Input_Data1.xlsx");
	File f = new File(xlpath);

	fis = new FileInputStream(f);
	
	String extention = xlpath.substring(xlpath.indexOf("."));
	if (extention.equalsIgnoreCase(".xlsx"))
	{
		wb = new XSSFWorkbook(fis);
	}
	else
	{
		wb = new HSSFWorkbook(fis);
	}
	
	int index = wb.getSheetIndex("Sheet1");
	sh = wb.getSheetAt(index);
	
	 nofrows = sh.getLastRowNum()+1;
		
	}
	
	@AfterMethod
	public void close() throws Exception
	{
	
		fis.close();
		//f.exists();

	}
	
	
	@Test
	public void allocatedata() throws Exception
	{
		
		for(int i =1; i<nofrows; i++)
		{
	     cell = sh.getRow(i).getCell(0);
		 mailid = cell.getStringCellValue();
		 cell = sh.getRow(i).getCell(1);
		 password = cell.getStringCellValue();
	
		
		 
		 
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\cc305906\\Documents\\Selinium\\geckodriver.exe");
		 driver = new FirefoxDriver ();
		 driver.get("https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Portal%3AFeatured+content");
		 driver.findElement(By.id("wpName1")).sendKeys(mailid);
		 driver.findElement(By.id("wpPassword1")).sendKeys(password);
		 
		 
			// for the first login button
			try
			{	
				driver.findElement(By.xpath(ObjectReposiroty.wikiauto_loginbutton_xpath)).click();	
					error = driver.findElement(By.xpath(ObjectReposiroty.wikiauto_error_msg_xpath)).getText();
				//System.out.println(error);
			}
			catch (Exception e)
			{	
				//System.out.println("security do not  exists");
				
			}
		
			// after three attempts the below button will be displayed
				
			try
			{	
				driver.findElement(By.xpath(ObjectReposiroty.wikiauto_newlogin_xpath)).click();	
				 error = "password invalid";
				System.out.println(error);
			}
			catch (Exception e)
			{	
				System.out.println("security check  exists");
				
			}
		 
		// String k = driver.findElement(By.xpath("//html/body/div[3]/div[4]/div[3]/div/div[2]/form/div[1]/div/p")).getText();

		 row = sh.getRow(i);
		 System.out.println(i);
		 cell = row.createCell(2);
		 cell.setCellValue(error);
		 
		 fos = new FileOutputStream(f);
		 wb.write(fos);
		 fos.flush();
		 fos.close();
		driver.close();
	
	}	

	}
	
	}
	



