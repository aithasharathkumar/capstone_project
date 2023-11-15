package com.sportyshoe.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sportyshoe.base.BaseTest;

public class LoginPage extends BaseTest {

	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;

	@FindBy(xpath="//button[text()='Login']")
	WebElement login;

	@FindBy(xpath="//input[@id='email']")
	WebElement email;

	@FindBy(xpath="//input[@id='password']")
	WebElement password;



	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public void logout() {
		logout.click();
	}

	public void click_login() {
		login.click();
	}

	public void give_email(String email_value) {
		email.sendKeys(email_value);
	}

	public void give_password(String password_value ) {
		password.sendKeys(password_value);
	}

}
