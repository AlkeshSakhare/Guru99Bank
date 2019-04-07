package com.guru99.demo.TestBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.guru99.demo.Utility.WebEventListener;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static Properties properties;
	public static String browser;
	public static String url;
	public static String userid;
	public static String password;
	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static NgWebDriver ngWebDriver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Logger logger;

	public TestBase() {

		properties = new Properties();
		try {
			properties.load(new FileReader(
					System.getProperty("user.dir") + "/src/main/java/com/guru99/demo/Config/config.properties"));
			logger = Logger.getLogger("Guru99 Bank");
			PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/main/resources/log4j.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initialization() {
		browser = properties.getProperty("browser");
		url = properties.getProperty("url");
		userid = properties.getProperty("userid");
		password = properties.getProperty("password");
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
		js = (JavascriptExecutor) driver;
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		logger.info("Opening browser");
		driver.get(url);
	}

}
