package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	private WebDriver driver;

	public void setDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public WebDriver getDriver() {
		return driver;
	}
}
