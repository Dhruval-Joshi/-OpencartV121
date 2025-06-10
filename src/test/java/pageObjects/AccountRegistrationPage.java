package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver){
		
		super(driver);
		
	}
	
@FindBy(xpath = "//input[@id='input-firstname']")
WebElement txtFirstName;

@FindBy(xpath = "//input[@id='input-lastname']")
WebElement txtLastName;

@FindBy(xpath = "//input[@id='input-email']")
WebElement txtEmail;

@FindBy(xpath = "//input[@id='input-telephone']")
WebElement txtTelephone;

@FindBy(xpath = "//input[@id='input-password']")
WebElement txtPassword;

@FindBy(xpath = "//input[@id='input-confirm']")
WebElement txtCNpassword;

@FindBy(xpath = "//input[@value='0']")
WebElement checksub;

@FindBy(xpath = "//input[@name='agree']")
WebElement checkpolicy;

@FindBy(xpath = "//input[@value='Continue']")
WebElement btncontinue;

@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;

public void setName(String fname) {
	txtFirstName.sendKeys(fname);
}

public void setLastName(String lname) {
	txtLastName.sendKeys(lname);
}

public void setEmail(String email) {
	txtEmail.sendKeys(email);
}

public void setTelephone(String tel) {
	txtTelephone.sendKeys(tel);
}

public void setPassword(String password) {
	txtPassword.sendKeys(password);
}

public void setCNpassword(String password) {
	txtCNpassword.sendKeys(password);
}

public void setPolicy() {
	checkpolicy.click();
}

public void clickContinue() {
	
	btncontinue.submit();
	
}

public String getConfirmationMsg() {
	
	try {
		return(msgConfirmation.getText());
	}
	catch(Exception e) {
		return(e.getMessage());
	}
}


}




