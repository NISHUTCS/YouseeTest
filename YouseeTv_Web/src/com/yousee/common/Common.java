package com.yousee.common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Common {

	
	public static void takeScreenshot(WebDriver driver, int index) throws IOException{
		
		//driver.get("http://google.co.in");
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("F:\\Automation\\Nishant\\YouseeReport\\Screenshot"+index+".png"));
		//("G:\\SeleniumScreenshot\\screenshot"+index+".png"));
	}
}