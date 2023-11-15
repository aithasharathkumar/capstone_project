package com.sportyshoe.testpages;

import org.testng.annotations.Test;

import com.sportyshoe.base.BaseTest;
import com.sportyshoe.pages.CartPage;
import com.sportyshoe.pages.HomePage;
import com.sportyshoe.pages.LoginPage;
import com.sportyshoe.pages.PlaceOrderPage;
import com.sportyshoe.pages.RegistrationPage;

public class SportyShoePageTest extends BaseTest{
	
	HomePage homePage;
	RegistrationPage registrationPage;
	LoginPage loginPage;
	CartPage cartPage;
	PlaceOrderPage placeOrderPage;
	
	@Test(priority = 1)
	public void User_Registration() throws InterruptedException {
		homePage=new HomePage(driver);
		registrationPage=new RegistrationPage(driver);
		Thread.sleep(2000);
		homePage.click_register_link();
		Thread.sleep(4000);
		registrationPage.giveName("Admin");
		Thread.sleep(2000);
		registrationPage.giveEmail("admin@gmail.com");
		Thread.sleep(2000);
		registrationPage.givePassword("admin123");
		Thread.sleep(2000);
		registrationPage.click_Submit();
		
		}
	
	@Test(priority = 2)
	public void User_Login() throws InterruptedException {
		loginPage=new LoginPage(driver);
		loginPage.logout();
		loginPage.give_email("admin@gmail.com");
		Thread.sleep(4000);
		loginPage.give_password("admin123");
		loginPage.click_login();
		
	}
	
	@Test(priority = 3)
	public void Add_To_Cart() throws InterruptedException {
		Thread.sleep(2000);
		cartPage=new CartPage(driver);
		cartPage.add_To_Cart();
		Thread.sleep(2000);
		cartPage.print_successMessage();
	}
	
	@Test(priority = 4)
	public void Place_Order() throws InterruptedException {
		Thread.sleep(3000);
		placeOrderPage=new PlaceOrderPage(driver);
		cartPage.click_home();
		Thread.sleep(3000);
		cartPage.click_Cart();
		Thread.sleep(3000);
		cartPage.click_PlaceOrder();
		Thread.sleep(3000);
		placeOrderPage.Print_success_Message();
	}

	
}
