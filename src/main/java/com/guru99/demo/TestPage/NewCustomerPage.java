package com.guru99.demo.TestPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.demo.TestBase.TestBase;
import com.guru99.demo.Utility.TestUtility;

public class NewCustomerPage extends TestBase {

	@FindBy(xpath = "//input[@name='name']")
	WebElement customerNameTxt;

	@FindBy(xpath = "//input[@value='m']")
	WebElement maleRadioBtn;

	@FindBy(xpath = "//input[@value='f']")
	WebElement femaleRadioBtn;

	@FindBy(xpath = "//input[@name='dob']")
	WebElement dobDate;

	@FindBy(xpath = "//textarea[@name='addr']")
	WebElement addressTxtArea;

	@FindBy(xpath = "//input[contains(@name,'city')]")
	WebElement cityTxt;

	@FindBy(xpath = "//input[contains(@name,'state')]")
	WebElement stateTxt;

	@FindBy(xpath = "//input[contains(@name,'pinno')]")
	WebElement pinNoTxt;

	@FindBy(xpath = "//input[contains(@name,'telephoneno')]")
	WebElement mobileNoTxt;

	@FindBy(xpath = "//input[contains(@name,'emailid')]")
	WebElement emailIdTxt;

	@FindBy(xpath = "//input[contains(@name,'password')]")
	WebElement passwordTxt;

	@FindBy(xpath = "//input[contains(@name,'sub')]")
	WebElement submitBtn;

	@FindBy(xpath = "//input[contains(@name,'res')]")
	WebElement resetBtn;

	public NewCustomerPage() {
		PageFactory.initElements(driver, this);
	}

	public void addCustomer(String name, String gender, String dob, String address, String city, String state,
			String pin, String mobile, String email, String password) {

		TestUtility.sendKeysClear(customerNameTxt, name);
		if (gender.equalsIgnoreCase("m")) {
			maleRadioBtn.click();
		} else {
			femaleRadioBtn.click();
		}
		TestUtility.sendKeysClear(dobDate, dob);
		TestUtility.sendKeysClear(addressTxtArea, address);
		TestUtility.sendKeysClear(cityTxt, city);
		TestUtility.sendKeysClear(stateTxt, state);
		TestUtility.sendKeysClear(pinNoTxt, pin);
		TestUtility.sendKeysClear(mobileNoTxt, mobile);
		TestUtility.sendKeysClear(emailIdTxt, email);
		TestUtility.sendKeysClear(passwordTxt, password);
		TestUtility.buttonClickAngular(submitBtn);
	}

	public String[] resetForm(String name, String gender, String dob, String address, String city, String state,
			String pin, String mobile, String email, String password) {

		TestUtility.sendKeysClear(customerNameTxt, name);
		if (gender.equalsIgnoreCase("m")) {
			maleRadioBtn.click();
		} else {
			femaleRadioBtn.click();
		}
		TestUtility.sendKeysClear(dobDate, dob);
		TestUtility.sendKeysClear(addressTxtArea, address);
		TestUtility.sendKeysClear(cityTxt, city);
		TestUtility.sendKeysClear(stateTxt, state);
		TestUtility.sendKeysClear(pinNoTxt, pin);
		TestUtility.sendKeysClear(mobileNoTxt, mobile);
		TestUtility.sendKeysClear(emailIdTxt, email);
		TestUtility.sendKeysClear(passwordTxt, password);
		String data1[] = { customerNameTxt.getAttribute("value"), dobDate.getAttribute("value"),
				addressTxtArea.getAttribute("value"), cityTxt.getAttribute("value"), stateTxt.getAttribute("value"),
				pinNoTxt.getAttribute("value"), mobileNoTxt.getAttribute("value"), emailIdTxt.getAttribute("value"),
				passwordTxt.getAttribute("value") };

		for (int i = 0; i < data1.length; i++) {
			System.out.println(i + " Before reset value= " + data1[i]);
		}
		TestUtility.buttonClickAngular(resetBtn);

		String data[] = { customerNameTxt.getAttribute("value"), dobDate.getAttribute("value"),
				addressTxtArea.getAttribute("value"), cityTxt.getAttribute("value"), stateTxt.getAttribute("value"),
				pinNoTxt.getAttribute("value"), mobileNoTxt.getAttribute("value"), emailIdTxt.getAttribute("value"),
				passwordTxt.getAttribute("value") };

		for (int i = 0; i < data.length; i++) {
			System.out.println(i + " before reset value= " + data[i]);
		}

		return data;
	}
}
