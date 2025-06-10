package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	 public LoginPage(WebDriver driver){
		 
		 super(driver);
		 
	 }
	 
@FindBy(xpath = "//input[@id='input-email']")
 WebElement textEmail;

@FindBy(xpath = "//input[@id='input-password']")
WebElement textPassword;

@FindBy(xpath="//input[@value='Login']" )
WebElement loginButton;

public void setEmail(String Email) {
	textEmail.sendKeys(Email);
}

public void setPassword(String password) {
	textPassword.sendKeys(password);
	
}

public void clickButton() {
	loginButton.click();
}
}
