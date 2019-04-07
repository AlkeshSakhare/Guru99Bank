package com.guru99.demo.TestPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.demo.TestBase.TestBase;
import com.guru99.demo.Utility.TestUtility;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//input[@type='text'][@name='uid']")
	@CacheLookup
	WebElement useridTxt;

	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	WebElement passwordTxt;

	@FindBy(xpath = "//input[@name='btnLogin']")
	@CacheLookup
	WebElement loginBtn;

	@FindBy(xpath = "//*[@name='btnReset']")
	@CacheLookup
	WebElement resetBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public ManagerPage login() {
		TestUtility.sendKeysClear(useridTxt, userid);
		TestUtility.sendKeysClear(passwordTxt, password);
		TestUtility.buttonClickAngular(loginBtn);
		return new ManagerPage();
	}

	public void loginByInput(String userid, String password) {
		TestUtility.sendKeysClear(useridTxt, userid);
		TestUtility.sendKeysClear(passwordTxt, password);
		TestUtility.buttonClickAngular(loginBtn);
	}

	public void loginByInput1(String userid, String password) {
		TestUtility.sendKeysByJS(useridTxt, userid);
		TestUtility.sendKeysByJS(passwordTxt, password);
		TestUtility.clickElementByJS(loginBtn);
	}

	public void loginByInput2(String userid, String password) {
		TestUtility.flash(useridTxt);
		useridTxt.sendKeys(userid);
		TestUtility.flash(passwordTxt);
		passwordTxt.sendKeys(password);
		TestUtility.flash(loginBtn);
	}

	public String[] reset(String userid, String password) {
		TestUtility.sendKeysClear(useridTxt, userid);
		TestUtility.sendKeysClear(passwordTxt, password);
		TestUtility.buttonClickAngular(resetBtn);
		String data[] = { useridTxt.getText(), passwordTxt.getText() };
		return data;
	}

}
