package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBases.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TC001_AccountRegistraionTest extends BaseClass{
	
	
	@Test(groups= {"Regression", "Master"})
	public void verify_account_registration() {
		
		logger.info("*****Starting Test case Execution");
		
		try {
		
		HomePage hp = new HomePage(driver); 
		hp.clickmyAccount();
		logger.info("Click on my account link");
		
		hp.clickRegister();
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		regPage.setName("Dhruval");
		regPage.setLastName("Joshi");
		regPage.setEmail("dhruveeee12345@gmail.com");
		regPage.setTelephone("123456789");
		
		//string password
		regPage.setPassword("abc123$");
		regPage.setCNpassword("abc123$");
		
		regPage.setPolicy();
		regPage.clickContinue();
		
		String confmsg = regPage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
			logger.info("Inside if msg");
		}
		
		else {
			
			logger.error("Test failed");
			logger.debug("debug error");
			Assert.assertTrue(false);
		}}
		catch(Exception e){
			
			Assert.fail();
			
		}
		
		logger.info("Finished Accnt registration");
		
	}
	
	public String randomeString() {
		
	
		String generatedstring = RandomStringUtils.randomAlphanumeric(5, 6);
		return generatedstring;
	}

}
