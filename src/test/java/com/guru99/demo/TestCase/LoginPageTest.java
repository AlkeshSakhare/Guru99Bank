package com.guru99.demo.TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.demo.TestBase.TestBase;
import com.guru99.demo.TestPage.LoginPage;
import com.guru99.demo.Utility.TestUtility;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test
	public void verifyReset() {
		TestUtility.startTcLogger("verifyReset");
		String data[] = loginPage.reset(userid, password);
		if (data[0].equals("") && data[1].equals("")) {
			Assert.assertTrue(true);
			logger.info("verifyReset Passed");
		} else {
			try {
				TestUtility.captureScreen("verifyReset");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(false);
			logger.info("verifyReset Failed");
		}
		TestUtility.endTcLogger("verifyReset");
	}

	@Test
	public void verifyLogin() {
		TestUtility.startTcLogger("verifyLogin");
		loginPage.login();
		if (driver.getPageSource().contains(userid)) {
			Assert.assertTrue(true);
			logger.info("verifyLogin Passed");
		} else {
			try {
				TestUtility.captureScreen("verifyLogin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(false);
			logger.info("verifyLogin Failed");
		}
		TestUtility.endTcLogger("verifyLogin");
	}

	@AfterMethod
	public void tearDown() {
		logger.info("Closing browser");
		driver.quit();
	}
}
