package com.sportyshoe.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest{

	public static WebDriver driver;

	@BeforeSuite
	public void Open_Browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:9010/");
		
	}

	@AfterSuite
	public void close_Browser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}


}