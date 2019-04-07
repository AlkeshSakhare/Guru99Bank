package com.guru99.demo.TestPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.demo.TestBase.TestBase;
import com.guru99.demo.Utility.TestUtility;

public class ManagerPage extends TestBase {

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

	public ManagerPage() {
		PageFactory.initElements(driver, this);
	}

	public NewCustomerPage gotoNewCustomerLink() {
		TestUtility.buttonClickAngular(newCustomerBtn);
		return new NewCustomerPage();
	}
}
