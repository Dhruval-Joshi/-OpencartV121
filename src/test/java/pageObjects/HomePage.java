package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage extends BasePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}

@FindBy(xpath = "//span[text()= 'My Account']")
WebElement linkmyAccount;

@FindBy(xpath = "//a[text()= 'Register']")
WebElement linkRegister;

@FindBy(xpath = "//a[text()='Login']")
WebElement linkLogin;

public void clickmyAccount() {
	linkmyAccount.click();
}

public void clickRegister() {
	linkRegister.click();
}

public void clickLogin() {
	linkLogin.click();
}
}
