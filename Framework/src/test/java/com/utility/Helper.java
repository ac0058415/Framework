package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	//This class is for screenshot, handleframes,javascript executor
	
	public static void captureScreenshot(WebDriver driver) {
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(file, new File("./Screenshots/" + getCurrentDate() + ".png"));
			System.out.println("Success: Capturing screenshot");
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot " + e.getMessage());
		}
	}
	
	public static String getCurrentDate() {
		DateFormat format = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		return format.format(date);
		
	}

}
