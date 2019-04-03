package com.guru99.demo.TestPage;

import org.openqa.selenium.support.PageFactory;

import com.guru99.demo.TestBase.TestBase;
import com.guru99.demo.Utility.TestUtility;

public class ManagerPage extends TestBase {

	public ManagerPage() {
		PageFactory.initElements(driver, this);
	}

	public NewCustomerPage gotoNewCustomerLink() {
		TestUtility.buttonClickAngular(newCustomerBtn);
		return new NewCustomerPage();
	}

}
