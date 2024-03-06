package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")  //My account page heading
	private WebElement msgHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") 
	private WebElement logoutbtn;
	
	//Action
	
	public boolean isMyAccountPageExists()    //my account page heading Status
	{
		try
		{
		return (msgHeading.isDisplayed());
		}catch (Exception e) {
		return (false);
	}
	}
	
	public void clickLogout()
	{
		logoutbtn.click();
	}

}
