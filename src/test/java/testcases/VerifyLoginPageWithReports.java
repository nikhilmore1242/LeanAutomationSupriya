package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.Browserfactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;


public class VerifyLoginPageWithReports 
{
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	
	@BeforeMethod
	public void setup()
	{
		report=new ExtentReports("./Reports/LoginPageReport.html",true);
		logger=report.startTest("verify the login page");
		 driver=Browserfactory.getBrowser("Chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationurl());
		logger.log(LogStatus.INFO,"Application is up and running.");
	}

	@Test
	public void testHomePage() throws Exception
	{
	
	HomePage home=PageFactory.initElements(driver,HomePage.class);
	String title=home.getApplicationTitle();
	Assert.assertTrue(title.contains("Amazon.in"));
	logger.log(LogStatus.PASS,"Home page loaded and verified.");
	home.clickonYourAmazon();
	logger.log(LogStatus.INFO,"Click on sign out link.");
	LoginPage login=PageFactory.initElements(driver,LoginPage.class);
	login.loginApplication(DataProviderFactory.getExcel().getData(0,0,0),DataProviderFactory.getExcel().getData(0,0,1));
	logger.log(LogStatus.INFO,"Login to Application.");
	//login.verifySignOutLink();
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		Browserfactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}
	
}
