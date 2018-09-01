package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldataprovider 
{
	XSSFWorkbook wb;
	public Exceldataprovider() throws IOException
	{
		
		File src=new File("./ApplicationTestData/4B934C00.xlsx");
		//File src=new File("./ApplicationTestData/AppData.xlsx");
		try
		{
			
			System.out.println("entered exceldataprovider method");
			//File src=new File("./ApplicationTestData/AppData.xlsx");
			FileInputStream fis=new FileInputStream(src);
		     wb=new XSSFWorkbook(fis);		
			 System.out.println("entered exceldataprovider end");
			
		} catch (Exception e) 
		{
			System.out.println("exception is: "+e.getMessage());
		}	
	}
	public String getData(int sheetindex,int row,int column)
	{
		System.out.println("entered get data method.");
		String data=wb.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();
		System.out.println(data);
		return data;
	}
	/*public String getData(String sheetName,int row,int column)
	{
		String data=wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		
		return data;
	}*/



}
