package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Helper 
{
	public static String captureScreenShot(WebDriver driver,String screenshotName)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String destination="D:\\ws_maven\\testing1\\screenshots\\"+screenshotName+System.currentTimeMillis()+".png";
		try {
			Files.copy(src,new File(destination));
		} catch (IOException e)
		{
			System.out.println("Failed to capture Screenshots"+e.getMessage());
		}
		return destination;
		
		
	}

}
