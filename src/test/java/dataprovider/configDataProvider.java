package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class configDataProvider
{
	Properties pro;
	public configDataProvider()
	{
		File src=new File("./configuration/config.properties");
		try 
		{
			FileInputStream fis=new FileInputStream(src);
		    pro=new Properties();
			pro.load(fis);
		} 
		catch (Exception e) 
		{
			System.out.println("exception is: "+e.getMessage());
		}
	}
	
	public String getApplicationurl()
	{
		String url=pro.getProperty("url");
		return url;
	}
	public String getChromePath()
	{
		String url=pro.getProperty("chromePath");
		return url;
	}
	public String getIEPath()
	{
		String url=pro.getProperty("IEPath");
		return url;
	}
}
