package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id="email") WebElement uname;
	@FindBy(id="pass") WebElement pass;
	@FindBy(id="u_0_b") WebElement loginButton;
	
	public void loginToFacebook(String username, String password) {
		
		uname.sendKeys(username);
		pass.sendKeys(password);
		loginButton.click();
		waitForSometime();
	}
	
	private void waitForSometime() {
		try {
			System.out.println("Sleeping for 5 secs");
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
