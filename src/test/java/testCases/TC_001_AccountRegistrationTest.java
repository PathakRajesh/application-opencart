package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistration;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	
	
	@Test(groups={"regression","master"})
	public void verifyaccountregistration()
	{
		logger.info("*****TC_001_AccountRegistrationTest****");
		
		logger.debug("Application logs..");
		try
		{
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		logger.info("..Click on MyAccountlink..");
		
		
		hp.clickMyRegister();
		logger.info("..Click on MyRegiseration link..");
		
		logger.info("Entering Customer details..");
		AccountRegistration regpage=new AccountRegistration(driver);
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setlastname(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com"); //randomly generate the email
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.checkBox();
		regpage.continueclk();
		logger.info("Clicked on continue...");
		
		String confmsg=regpage.getConfirmationMsg();
		
		logger.info("..Validating confirmation message..");
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("test passed..");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("test failed..");
			Assert.fail();
		}
		
		
		}
		catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail();
		}
		
		logger.info("..Finished TC_001_AccountRegistrationTest..");
	}

}
