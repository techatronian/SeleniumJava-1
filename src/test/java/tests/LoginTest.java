package tests;

import java.lang.reflect.Method;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest {

	//initiate driver
	private WebDriver driver;
	private WebDriverWait wait;
	private static Logger log = null;

	@BeforeClass
	public void Initialization() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@BeforeMethod
	public void logger(Method method) {
		log = LoggerFactory.getLogger(method.getName());
	}

	@AfterClass
	public void Termination() {
		driver.quit();
	}

	@Test
	public void Validate_LoginApplication() {
		driver.get("https://admin-demo.nopcommerce.com/admin/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		DashboardPage loginapp = new LoginPage(driver, log).EnterEmail("admin@yourstore.com").EnterPassword("admin")
				.ClickLogin();
		Assert.assertEquals(loginapp.GetDashboardTest(), "Dashboard");
		log.info("Login is Successfull");
	}
}
