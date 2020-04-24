package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCaseWithoutFramework {

	@Test
	public void openFacebook() {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Personal\\Study\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("email")).sendKeys("acmits@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Anupam@11");
		driver.findElement(By.id("u_0_b")).click();
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.quit();
	}
}
