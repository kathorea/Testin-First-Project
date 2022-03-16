package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility
{
	public static void screenshot(WebDriver driver,String testID) throws IOException, InterruptedException
	{
		
		Thread.sleep(2000);
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
		LocalDateTime now=LocalDateTime.now();
		System.out.println(dtf.format(now));
		
		TakesScreenshot g=(TakesScreenshot)driver;
		File source=g.getScreenshotAs(OutputType.FILE);
		File Destination=new File("F:\\New Folder\\ScreenShot\\"+testID+dtf.format(now)+".jpg");
		FileHandler.copy((File)source, Destination);
	}
		
	public static String getdataFromExcel(String sheet ,int Row,int Cell) throws EncryptedDocumentException, IOException 
	{
		String path="C:\\Users\\DELL\\Desktop\\Testsheet.xlsx";
		FileInputStream file=new FileInputStream(path);
//		String data=WorkbookFactory.create(file).getSheet(sheet).getRow(Row).getCell(Cell).getStringCellValue();
		
		String data=("");
		Workbook a=WorkbookFactory.create(file);
		try
		{
			data=WorkbookFactory.create(file).getSheet(sheet).getRow(Row).getCell(Cell).getStringCellValue();
		}
		catch(IllegalStateException e)
		{
			double number=a.getSheet(sheet).getRow(Row).getCell(Cell).getNumericCellValue();
			long n=(long)number;
			data=Long.toString(n);
		}
		return data;
	}
}
	

