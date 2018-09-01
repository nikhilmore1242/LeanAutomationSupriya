package factory;

import java.io.IOException;

import dataprovider.Exceldataprovider;
import dataprovider.configDataProvider;

public class DataProviderFactory 
{

	public static configDataProvider getConfig()
	{
		configDataProvider config=new configDataProvider();
		return config;
	}

	public static Exceldataprovider getExcel() throws IOException
	{
		System.out.println("entered get excel method");
		Exceldataprovider excel=new Exceldataprovider();
		return excel;
	}
}
