package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage{

	public AccountRegistration(WebDriver driver) {
	super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstnamefield;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastnamefield;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailfield;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordfield;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement chkagree;
	
	@FindBy(xpath="//button[normalize-space()='Continue']") 
	private WebElement Continuebtn;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	
	//Action
	
	public void setFirstName(String fname)
	{
		firstnamefield.sendKeys(fname);
	}
	public void setlastname(String lname) 
	{
		lastnamefield.sendKeys(lname);
	}
	public void setEmail(String email)
	{
		emailfield.sendKeys(email);
	}
	public void setPassword(String pwd)
	{
		passwordfield.sendKeys(pwd);
	}
	public void checkBox()
	{
		chkagree.click();
	}
	public void continueclk()
	{
		Continuebtn.click();
		
		//sol1 
	//	btnContinue.click();
		
		//sol2 
		//btnContinue.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
					
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//Sol 5
		//btnContinue.sendKeys(Keys.RETURN);
		
		//Sol6  
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		
	}

	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}
	}
	
	

}
