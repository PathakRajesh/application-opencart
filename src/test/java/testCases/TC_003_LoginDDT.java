package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{
	
	/*Data is valid  - login success - test pass  - logout
	Data is valid -- login failed - test fail

	Data is invalid - login success - test fail  - logout
	Data is invalid -- login failed - test pass
	*/
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verifyloginddt(String email,String password,String exp)
	{
		logger.info("**** Starting TC_003_LoginDDT *****");
		
		try
		{
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		//Login Page
		LoginPage lp=new LoginPage(driver);
		lp.setEmailAddress(email);
		lp.setPassword(password);
		lp.loginclk();
		
		
		//MyAccountpage
		
		MyAccountPage accountpage=new MyAccountPage(driver);
		boolean targetmsg=accountpage.isMyAccountPageExists();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetmsg==true)
			{
				accountpage.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetmsg==true)
			{
				accountpage.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
	}
	catch(Exception e)
	{
		Assert.fail("An exception occurred: " + e.getMessage());
	}
		
	logger.info("**** Finished TC_003_LoginDDT *****");
}
		
	}


