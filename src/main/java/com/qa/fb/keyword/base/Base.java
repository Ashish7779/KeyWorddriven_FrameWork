package com.qa.fb.keyword.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.qa.fb.keyword.util.utility;

public class Base {
	
	public static WebDriver driver;
	public Properties properties;

	public WebDriver init_driver(String browserName) {
		if (browserName.equals("chrome")) 
			 System.setProperty("webdriver.chrome.driver","D:\\Chromedriver\\chromedriver.exe");
			if (properties.getProperty("headless").equals("yes")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			} else {
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(utility.PAGE_LOAD_TIME, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(utility.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
			return driver;
		}
	
		



	public Properties init_properties() {
		properties = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream("D:\\Eclips1\\KeyWordDrivenFW\\src\\main\\java\\com\\qa\\fb\\keyword\\config\\config.properties");
		
			properties.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
