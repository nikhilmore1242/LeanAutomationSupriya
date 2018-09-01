package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.Browserfactory;
import factory.DataProviderFactory;
import pages.HomePage;

public class VerifyHomePage 
{
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		 driver=Browserfactory.getBrowser("Chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationurl());
	}

	@Test
	public void testHomePage()
	{
	
	HomePage home=PageFactory.initElements(driver,HomePage.class);
	String title=home.getApplicationTitle();
	Assert.assertTrue(title.contains("Amazon.in"));
	
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		Browserfactory.closeBrowser(driver);
	}
	
}
