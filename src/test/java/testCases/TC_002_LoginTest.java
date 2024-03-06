package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test(groups={"sanity","master"})
	public void verifyLogin()
	{
		
		logger.info("***Starting the TC-002_LoginTest ***");
		logger.debug("Capturing application debug logs....");
		try
		{
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("click on Myaccount link...");
		
		hp.clickLogin();
		logger.info("click on login link under myaccount...");
		
		//Login Page
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering valid email and password...");
		lp.setEmailAddress(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.loginclk();
		logger.info("click on login button...");
		
		//MyAccountpage
		
		MyAccountPage accountpage=new MyAccountPage(driver);
		boolean targetmsg=accountpage.isMyAccountPageExists();
		
		if(targetmsg==true)
		{
			logger.info("Test is Passed....");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
			logger.info("Test is failed....");
		}
		}
		 catch(Exception e)
		{
			 Assert.fail();
		}
		logger.info("***finished the TC-002_LoginTest ***");
		}
	
	}
		


