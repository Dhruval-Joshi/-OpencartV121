package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBases.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	
	public void verify_login() {
		
		logger.info("********strarting TC_login_002****");
		
		try {
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickmyAccount();
		hp.clickLogin();
		
		//login
		LoginPage Ip = new LoginPage(driver);
		Ip.setEmail(p.getProperty("email"));
		Ip.setPassword(p.getProperty("password"));
		Ip.clickButton();  
		
		//MyAccountPage
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExist();
		Assert.assertEquals(true, targetPage);
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("******TC Finished***********");
		
	}

}
