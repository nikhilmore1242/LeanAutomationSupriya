package testing1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.rowset.internal.Row;

public class excelsheetmaven {
	public void excelread()throws IOException{
		try{
			File src=new File("D:\\EXCEL sheet\\excel_one_123.xlsx");
			FileInputStream fis=new FileInputStream(src);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sh1= wb.getSheetAt(0);
			
            int rowcount=sh1.getLastRowNum()-sh1.getFirstRowNum();
			
			for(int i=0;i<rowcount+1;i++)
			{
				XSSFRow row=sh1.getRow(i);

				for(int j=0;j<row.getLastCellNum();j++)
				{
		
					Cell cell=row.getCell(j);

					switch(cell.getCellType()){
					
					case Cell.CELL_TYPE_STRING:
						System.out.println(cell.getStringCellValue());
				        String string_value=cell.getStringCellValue();
						break;
					case Cell.CELL_TYPE_NUMERIC:
						System.out.println(cell.getNumericCellValue());
						double number_value=cell.getNumericCellValue();
						break;
					}
					String firstname=sh1.getRow(i).getCell(j).getStringCellValue();
					System.out.println(firstname);
					
				
				}
				
			}
		}
			
			catch(Exception e)
			{
			 System.out.println(e.getMessage());
			}
	}
	 public void getcelldata(int rownum, int colnum)
	    {
	    	System.out.println(rownum);
	    	System.out.println(colnum);
	    	
	    }
	public static void main(String[] args) throws IOException {
		excelsheetmaven abc=new excelsheetmaven();
		abc.excelread();
		//System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		//driver.get("file:///D:/Task1/signup.html");

		
			//String abc="female";
			//String abc1="English";
			//driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(name);
			//driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(name);
			//driver.findElement(By.xpath("//input[@id='gender' and @value='"+ abc +"']")).click();
			//WebElement countrybox = driver.findElement(By.id("country"));
			//Select selbox = new Select(countrybox);
			//selbox.selectByIndex(name);
			//driver.findElement(By.xpath("//input[@id='language' and @value='"+ abc1 +"']")).click();
			//driver.findElement(By.xpath("//input[@id='emailid']")).sendKeys(name);
			//driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys(name);
	

	}

}
