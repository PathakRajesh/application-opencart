package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
	super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement txtemailaddress;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement txtpassword;
	
	@FindBy(xpath="//button[normalize-space()='Login']") 
	private WebElement loginbtn;
	
	//Action 
	
	public void setEmailAddress(String email)
	{
		txtemailaddress.sendKeys(email);
	}
	public void setPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	public void loginclk()
	{
		loginbtn.click();
	}
	
	
}



