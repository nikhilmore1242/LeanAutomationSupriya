package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.Browserfactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;


public class VerifyLoginPage 
{
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		 driver=Browserfactory.getBrowser("Chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationurl());
	}

	@Test
	public void testHomePage() throws Exception
	{
	
	HomePage home=PageFactory.initElements(driver,HomePage.class);
	String title=home.getApplicationTitle();
	Assert.assertTrue(title.contains("Amazon.in"));
	
	home.clickonYourAmazon();
	System.out.println("entered amazon");
	LoginPage login=PageFactory.initElements(driver,LoginPage.class);
	System.out.println("aaaaaa");
	login.loginApplication(DataProviderFactory.getExcel().getData(0,0,0),DataProviderFactory.getExcel().getData(0,0,1));
	//login.verifySignOutLink();
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		Browserfactory.closeBrowser(driver);
	}
	
}
