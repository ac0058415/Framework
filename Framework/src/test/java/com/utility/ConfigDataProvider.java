package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties property;
	
	public ConfigDataProvider() {
		
		File file = new File("./Config/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			property = new Properties();
			property.load(fis);
		}
		catch (Exception e) {
			System.out.println("Unable to read Config file: " + e.getMessage());
		}
	}
	
	public String getBrowser() {
		return property.getProperty("Browser");
	}
	
	public String getTestURL() {
		return property.getProperty("testURL");
	}
	
}
