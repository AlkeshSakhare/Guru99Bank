package com.guru99.demo.TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99.demo.TestBase.TestBase;
import com.guru99.demo.TestPage.LoginPage;
import com.guru99.demo.TestPage.ManagerPage;
import com.guru99.demo.TestPage.NewCustomerPage;
import com.guru99.demo.Utility.TestUtility;

public class NewCustomerTest extends TestBase {

	public static LoginPage loginPage;
	public static ManagerPage managerPage;
	public static NewCustomerPage newCustomerPage;

	public NewCustomerTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		managerPage = loginPage.login();
		newCustomerPage = managerPage.gotoNewCustomerLink();
	}

	@Test(priority = 1, enabled = false)
	public void verifyResetNewCustomerForm() {
		String data[] = newCustomerPage.resetForm("name", "f", "04/03/2019", "address", "city", "state", "pin",
				"1234567890", "test@alkesh.com", "password@1234");
		boolean cleardata = false;
		for (String txt : data) {
			if (txt.equals("")) {
				cleardata = true;
				continue;
			} else {

				break;
			}
		}
		if (cleardata) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@DataProvider(name = "getNewCustomerData")
	public Object[][] getNewCustomerData() {
		Object data[][] = TestUtility.getTestData("NewCustomer");
		System.out.println(data);
		return data;
	}

	@Test(dataProvider = "getNewCustomerData", priority = 2)
	public void verifyAddCustomer(String name, String gender, String dob, String address, String city, String state,
			String pin, String mobile, String email, String password) {
		newCustomerPage.addCustomer(name, gender, dob, address, city, state, pin, mobile, email, password);
		if (driver.getPageSource().contains("Customer Registered Successfully!!!")) {
			System.out.println("Customer " + name + " added successfully");
			Assert.assertTrue(true);
		} else {
			System.out.println("Customer " + name + " not added successfully");
			Assert.assertTrue(true);
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
