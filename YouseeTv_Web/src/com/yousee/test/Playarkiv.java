package com.yousee.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.yousee.common.Common;
import com.yousee.common.ReadInput;
import com.yousee.controller.Execute_Driver;

public class Playarkiv {

	@Test
	public static void playArkiv() throws IOException, InterruptedException{
		
		WebDriver driver=Execute_Driver.browserSelection();	
		
		ExtentReports report;
		ExtentTest logger;
		 
		//WebDriver driver;
		//System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
		
		report=new ExtentReports("F:\\Automation\\Nishant\\YouseeReport\\YoseeReport.html",true);
		logger=report.startTest("Verify Yousee Login");
		//WebDriver driver = new FirefoxDriver();
		logger.log(LogStatus.PASS, "Browser started");
		//Common com = new Common();
		//com.takeScreenshot(driver,1);
		//logger.addScreenCapture("F:\\Automation\\Nishant\\YouseeReport\\screenshot1.png");
		String url = ReadInput.readExcel(1, 1);
		String userId = ReadInput.readExcel(1, 2);
		String password = ReadInput.readExcel(1, 3);
		
		driver.get(url);
		logger.log(LogStatus.PASS, "Yousee Application is up and running");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(new String[] { userId });
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(new String[] { password });
		driver.findElement(By.xpath("//button[@id='login-button']")).click();
		driver.manage().window().maximize();
		logger.log(LogStatus.PASS, "Login SuccessFul");
		Common.takeScreenshot(driver, 4);
		String image1=logger.addScreenCapture("F:\\Automation\\Nishant\\YouseeReport\\Screenshot4.png");
		logger.log(LogStatus.PASS, "Video Played",image1);
		//Common.takeScreenshot(driver, 4);
		
		report.endTest(logger);
		report.flush();
		//driver.findElement(By.xpath("//span[contains(tesxt(),'Film')]")).click();
		Thread.sleep(5000);
		logger=report.startTest("Select Arkiv");
		driver.findElement(By.xpath("//a[contains(text(),'Kanaler i arkiv')]")).click();
		logger.log(LogStatus.PASS, "Arkiv selected");
		report.endTest(logger);
		report.flush();
		//driver.findElement(By.xpath("//*[@id='mount']/div/div[3]/div[2]/div[3]/div/a/span[2]")).click();
		Thread.sleep(3000);
		logger=report.startTest("Play Video");
		//driver.findElement(By.xpath("//div[contains(text(),'asset__mouse-over')]")).click();
		try {
			driver.findElement(By.className("asset__mouse-over")).click();
			
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Video content not found");
			Common.takeScreenshot(driver, 1);
			Common.takeScreenshot(driver,2);
			Common.takeScreenshot(driver,3);
			report.endTest(logger);
			report.flush();
			System.exit(0);
			//Test
		}
		
		try {
			driver.findElement(By.xpath("//*[@id='synopsis__status__center']")).click();
			
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Video could not be played");
			Common.takeScreenshot(driver, 1);
			Common.takeScreenshot(driver,2);
			Common.takeScreenshot(driver,3);
			report.endTest(logger);
			report.flush();
			System.exit(0);
		}
		
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='synopsis__status__center']")).click();
		//Common common = new Common();
		//driver.get("http://google.co.in");
		//Common.takeScreenshot(driver, 1);
		
		//takeScreenshot(driver,1);
		Common.takeScreenshot(driver, 1);
		Common.takeScreenshot(driver,2);
		Common.takeScreenshot(driver,3);
		
		String image=logger.addScreenCapture("F:\\Automation\\Nishant\\YouseeReport\\Screenshot1.png");
		logger.log(LogStatus.FAIL, "Video Played",image);
		report.endTest(logger);
		report.flush();
		
	}
}
