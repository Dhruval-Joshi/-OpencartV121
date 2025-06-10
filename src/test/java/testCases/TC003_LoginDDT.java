package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBases.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
		@Test(dataProvider= "LoginData", dataProviderClass= DataProviders.class, groups="Datadriven")
	public void verifyLogin(String email,String password, String exp) {
			
		logger.info("****Strating Test case TC_003_DDT*********");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickmyAccount();
		Thread.sleep(2000);
		hp.clickLogin();
		
		//login
		LoginPage Ip = new LoginPage(driver);
		Ip.setEmail(email);
		Ip.setPassword(password);
		Ip.clickButton();  
		
		//MyAccountPage
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExist();
		Assert.assertEquals(true, targetPage);
		
	
	if(exp.equalsIgnoreCase("valid")) {
		
		if(targetPage == true)
		{
			logger.info("login successful***");
			macc.clickLogut();
			Assert.assertTrue(true);
		
		}
		else 
		{
			Assert.assertTrue(false);
		}
	}
	
	if(exp.equalsIgnoreCase("invalid")) {
		
		if(targetPage == true)
		{
			macc.clickLogut();
			logger.info("login successful invalid***");
			Assert.assertTrue(false);
		}
		else 
		{
			Assert.assertTrue(true);
		}
	} 
		}catch(Exception e) {
			
			Assert.fail();
		}
	logger.info("**********Finished TC 003 DDT************");
	}
		 
	}


