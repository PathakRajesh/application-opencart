package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
	super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']") 
	private WebElement myaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']") 
	private WebElement register;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
    private WebElement loginbtn;
	
	//Action
	
	public void clickMyAccount()
	{
		myaccount.click();
	}
	public void clickMyRegister()
	{
		register.click();
	}
	public void clickLogin()
	{
		loginbtn.click();
	}
	

}
