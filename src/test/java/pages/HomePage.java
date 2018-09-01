package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage
{
	WebDriver driver;
	
	public HomePage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//a[text()='Your Amazon.in']") WebElement yourAmazon;
	@FindBy(xpath="//span[text()='Hello. Sign in']") WebElement SignIn;
	@FindBy(xpath="//a[text()='Amazon Pay']") WebElement AmazonPay;
	@FindBy(xpath="//a[@href='https://www.amazon.in/gp/cart/view.html?ref=nav_cart']") WebElement Cart;
	
	public void clickonYourAmazon()
	{
		yourAmazon.click();
	}
	public void clickonSignIn()
	{
		SignIn.click();
	}
	public void clickonAmazonPay()
	{
		AmazonPay.click();
	}
	public void clickonCart()
	{
		Cart.click();
	}
	
	public String getApplicationTitle(){
		return driver.getTitle();
	}
	
	
	
	
	
	
	
	
}
