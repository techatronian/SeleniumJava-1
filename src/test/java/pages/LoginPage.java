package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;

public class LoginPage {

	private WebDriver driver;
	private static Logger log;
	
	public LoginPage(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;
		PageFactory.initElements(driver, this);
	}
	
	//Page Objects
	@FindBy(id="Email")
	private WebElement Email_field;
	@FindBy(id="Password")
	private WebElement Password_field;
	@FindBy(className="buttons")
	private WebElement Login_button;
	
	//Page Methods
	public LoginPage EnterEmail(String email) {
		Email_field.clear();
		Email_field.sendKeys(email);
		log.info(email+" :username is successfully entered");
		return new LoginPage(driver, log);
	}
	
	public LoginPage EnterPassword(String password) {
		Password_field.clear();
		Password_field.sendKeys(password);
		log.info(password+" :password is successfully entered");
		return new LoginPage(driver,log);
	}
	
	public DashboardPage ClickLogin() {
		Login_button.click();
		log.info("Login button is clicked");
		return new DashboardPage(driver);
	}
	
}
