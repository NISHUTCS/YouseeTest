package com.yousee.controller;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.yousee.common.ReadInput;
import com.yousee.driver.Driver;

public class Execute_Driver {
	public static WebDriver driver=null;
	public static WebDriver browserSelection() throws IOException{
		
		
		
		String browser = ReadInput.readExcel(1, 4);
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\Automation\\Nishant\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			//return driver;
		} else if(browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			//return driver;
		}else if(browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "F:\\Automation\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			//return driver;
			}
		return driver;
	}
	
}
