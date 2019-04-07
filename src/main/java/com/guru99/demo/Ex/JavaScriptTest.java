package com.guru99.demo.Ex;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.demo.TestBase.TestBase;
import com.guru99.demo.TestPage.LoginPage;
import com.guru99.demo.Utility.TestUtility;

public class JavaScriptTest extends TestBase {
	LoginPage loginPage;

	public JavaScriptTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test
	public void test() {
		try {
			loginPage.loginByInput1(userid, password);
			if (driver.getPageSource().contains(userid)) {
				TestUtility.showMessage("Notice", "Login passed");
				TestUtility.captureScreen("test");
				Assert.assertTrue(true);
			} else {
				TestUtility.showMessage("ERROR", "Login failed");
				TestUtility.captureScreen("test");
				Assert.assertTrue(false);
			}
		} catch (Exception ex) {
			TestUtility.showMessage("ERROR", "Login failed");
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
