package testing1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class signupmaven {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/Task1/signup.html");
		driver.findElement(By.id("firstname")).sendKeys("aaaaaa");
		driver.findElement(By.id("lastname")).sendKeys("bbbbbb");
		driver.findElement(By.id("emailid")).sendKeys("dddddd");
		driver.findElement(By.id("address")).sendKeys("ccccc");
		List<WebElement> rdbtn =  driver.findElements(By.id("gender"));
		for(int i=0;i<rdbtn.size(); i++)
		{
			String rdval= rdbtn.get(i).getAttribute("value");
			if(rdval.equals("female"))
			{
				rdbtn.get(i).click();
			}
		}
		WebElement countrybox = driver.findElement(By.id("country"));
		Select selbox = new Select(countrybox);
		//selbox.selectByValue("1");
		//selbox.selectByVisibleText("India");
		selbox.selectByIndex(2);
		List<WebElement> chkbox=driver.findElements(By.id("language"));
		for(int j=0;j<chkbox.size();j++)
		{
			chkbox.get(j).click();
		}
		driver.findElement(By.name("submit")).click();
		Thread.sleep(1000);
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle="Welcome";
		String msg=driver.findElement(By.tagName("p")).getText();
		System.out.println(msg);
		String expectedMsg="Sign Up Successfully.";
		
		if(actualTitle.equals(expectedTitle)&&msg.equals(expectedMsg))
		{
			System.out.println("successful");
			driver.findElement(By.linkText("Click Here")).click();
			Thread.sleep(1000);
			String actualTitle2=driver.getTitle();
			System.out.println(actualTitle2);
			String expectedTitle2="Login page";
			String msg2=driver.findElement(By.tagName("h1")).getText();
			System.out.println(msg2);
			String expectedMsg2="Login Page";
			if(actualTitle2.equals(expectedTitle2)&&msg2.equals(expectedMsg2))
			{
				System.out.println("successful");
				driver.findElement(By.name("userid")).sendKeys("admin");
				driver.findElement(By.name("pswrd")).sendKeys("admin");
				driver.findElement(By.id("login")).click();
				Thread.sleep(1000);
				String msg3=driver.findElement(By.tagName("p")).getText();
				System.out.println(msg3);
				String expectedMsg3="Welcome, Admin";
				if(msg3.equals(expectedMsg3))
				{
					System.out.println("successful");
					WebElement lout=driver.findElement(By.linkText("Logout"));
					System.out.println(lout.isDisplayed());
					if(lout.isDisplayed()){
						driver.findElement(By.linkText("Logout")).click();
						Thread.sleep(1000);
						
					}
				}
			}
		}
		else{
			System.out.println("error");
		}
		
		}




	}


