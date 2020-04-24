package com.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utility.BrowserFactory;
import com.utility.ConfigDataProvider;
import com.utility.ExcelDataProvider;
import com.utility.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports reporter;
	
	@BeforeSuite
	public void setUpExcel() {
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider(); 
		ExtentHtmlReporter report = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/" + Helper.getCurrentDate() + ".html"));
		System.out.println("Reports path -- "+ System.getProperty("user.dir")+"\\Reports\\" + Helper.getCurrentDate() + ".html");
		reporter = new ExtentReports();
		reporter.attachReporter(report);
	}
	
	
	@BeforeClass
	public void setUp() {
		driver = BrowserFactory.openBrowser(driver, config.getTestURL(), config.getBrowser());
	}
	
	@AfterClass
	public void closeDriver() {
		System.out.println("Closing Driver");
		BrowserFactory.quitBrowser(driver);
	}


	@AfterMethod
	public void captureScreenshotOnFailure(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			System.out.println("Failure: Capturing screenshot");
			Helper.captureScreenshot(driver);
		}
		reporter.flush();
		System.out.println("Printing html report");		
	}

}
