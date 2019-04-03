package com.guru99.demo.TestBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.guru99.demo.Utility.WebEventListener;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties properties;
	public static String browser;
	public static String url;
	public static String userid;
	public static String password;
	public static NgWebDriver ngWebDriver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() {

		properties = new Properties();
		try {
			properties.load(new FileReader(
					System.getProperty("user.dir") + "/src/main/java/com/guru99/demo/Config/config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PageFactory.initElements(driver, this);
	}

	public void initialization() {
		browser = properties.getProperty("browser");
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		}
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		url = properties.getProperty("url");
		userid = properties.getProperty("userid");
		password = properties.getProperty("password");
		driver.get(url);
	}

	@FindBy(xpath = "//a[contains(.,'New Customer')]")
	public WebElement newCustomerBtn;

	@FindBy(xpath = "//a[contains(.,'Edit Customer')]")
	WebElement editCustomerBtn;

	@FindBy(xpath = "//a[contains(.,'New Account')]")
	WebElement newAccountBtn;

	@FindBy(xpath = "//a[contains(.,'Edit Account')]")
	WebElement editAccountBtn;

	@FindBy(xpath = "//a[contains(.,'Delete Account')]")
	WebElement deleteAccountBtn;

	@FindBy(xpath = "//a[contains(.,'Deposit')]")
	WebElement depostiBtn;

	@FindBy(xpath = "//a[contains(.,'Withdrawal')]")
	WebElement withdrawalBtn;

	@FindBy(xpath = "//a[contains(.,'//a[contains(.,'Fund Transfer')]')]")
	WebElement fundTransferBtn;

	@FindBy(xpath = "//a[contains(.,'Change Password')]")
	WebElement changePasswordBtn;

	@FindBy(xpath = "//a[contains(.,'Balance Enquiry')]")
	WebElement balanceEnquiryBtn;

	@FindBy(xpath = "//a[contains(.,'Mini Statement')]")
	WebElement miniStatementBtn;

	@FindBy(xpath = "//a[contains(.,'Customised Statement')]")
	WebElement customisedStatementBtn;

	@FindBy(xpath = "//a[contains(.,'Log out')]")
	WebElement logoutBtn;
}
