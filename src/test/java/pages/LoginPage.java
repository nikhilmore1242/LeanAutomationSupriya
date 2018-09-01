package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage
{
	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//input[@id='ap_email']") WebElement username;
	@FindBy(xpath="//input[@id='continue']") WebElement continueButton;
	@FindBy(xpath="//input[@id='ap_password']") WebElement password;
	@FindBy(xpath="//input[@id='signInSubmit']") WebElement loginButton;
	//@FindBy(xpath="//a/span[text()='Sign Out']") WebElement signOut;
	public void loginApplication(String user,String pass)
	{
		System.out.println("entered login page");
		username.sendKeys(user);
		
		System.out.println("username accepted");
		continueButton.click();
		
		password.sendKeys(pass);
		System.out.println("password accepted");
		loginButton.click();
		
	}
	
	/*public void verifySignOutLink()
	{
		String text=signOut.getText();
		System.out.println(text);
		Assert.assertEquals(text,"Sign Out","sign out link not verified properly.");
		
		
		
	}*/
}

	
	
