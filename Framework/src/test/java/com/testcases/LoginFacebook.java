package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.BaseClass;
import com.pages.LoginPage;
import com.utility.BrowserFactory;
import com.utility.Helper;

public class LoginFacebook extends BaseClass {

	@Test
	public void loginFacebook() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginToFacebook(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		System.out.println("Logged in");
		Helper.captureScreenshot(driver);
	}

}
