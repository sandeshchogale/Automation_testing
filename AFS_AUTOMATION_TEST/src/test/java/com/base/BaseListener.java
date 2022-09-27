package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestListener;

import com.page.LoginControllerPage;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseListener implements ITestListener{
	
	public static WebDriver driver;
	private static final Logger LOG = LogManager.getLogger(BaseListener.class);
	
	public  WebDriver initializeDriver() {
		Properties properties = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream("D:\\AfsConfig\\Testing\\data.properties");
			properties.load(inputStream);
			
			String browser = properties.getProperty("browser");
			LOG.info("initializeDriver() browser ={}",browser);
			
			String jarPath = properties.getProperty("jar.path");
			LOG.info("initializeDriver() jar.path ={}",jarPath);
 			System.setProperty(browser,  jarPath);
		
			String baseUrl = properties.getProperty("application.url");
			LOG.info("initializeDriver() application.url ={}",baseUrl);
			
			if (browser.contains("Webdriver.Edge")) {
				driver = new EdgeDriver();
			} else if (browser.contains("webdriver.chrome")) {
				driver = new ChromeDriver();
			} else if (browser.contains("Webdriver.FireFox")) {
				driver = new FirefoxDriver();
			} else if (browser.contains("Webdriver.IE")) {
				driver = new InternetExplorerDriver();
			}
			
			driver.get(baseUrl);
			LOG.info("Base WebDriver initializeDriver()----");
		} catch (Exception e) {
	        LOG.error("Base WebDriver initializeDriver() ={}",e.getCause());
		}
		return driver;
	}

	public void FailedScreenshot(String testMethodName) {
		LOG.info("failedScreenshot");
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		String timeStamp = d.toString().replace(":", "_").replace(" ", "_");
		String path = getScreenShotLocation();
		try {
			//FileHandler.copy(source, new File(path + testMethodName + timeStamp +".png"));
			FileUtils.copyFile(source, new File(path + testMethodName + timeStamp +".png"));
		} catch (IOException e) {
			 LOG.error("ERORR Base WebDriver initializeDriver()----");
		}
	}
	
	public void SucessScreenshot(String testMethodName) {
		LOG.info("sucessScreenshot");
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		String timeStamp = d.toString().replace(":", "_").replace(" ", "_");
		String path = getScreenShotLocation();
		try {
			//FileHandler.copy(source, new File(path + testMethodName + timeStamp +".png"));
			FileUtils.copyFile(source, new File(path + testMethodName + timeStamp +".png"));
		} catch (IOException e) {
			 LOG.error("ERORR SucessScreenshot = {}",e.getCause());
		}
	}
	
	public String getRportsPath(String controllerName) {
		LOG.info("reportsPath");
		String path = getReportsLocation();
		Date d = new Date();
		String timeStamp = d.toString().replace(":", "_").replace(" ", "_");
		String retPath="";
		try {
			retPath= path + controllerName +"_"+ timeStamp +".html";	
		} catch (Exception e) {
			 LOG.error("ERORR getScreenShotLocation = {}",e.getCause());
		}
		return retPath;
	}
	
	private String getScreenShotLocation() {
		LOG.info("getScreenShotLocation");
		Properties properties = new Properties();
		String path="";
		try {
			FileInputStream inputStream = new FileInputStream("D:\\AfsConfig\\Testing\\data.properties");
			properties.load(inputStream);
			path = properties.getProperty("screenshots.path");
		} catch (IOException e) {
			 LOG.error("ERORR getScreenShotLocation = {}",e.getCause());
		}
		return path;
	}
	
	private String getReportsLocation() {
		LOG.info("getReportsLocation");
		Properties properties = new Properties();
		String path="";
		try {
			FileInputStream inputStream = new FileInputStream("D:\\AfsConfig\\Testing\\data.properties");
			properties.load(inputStream);
			path = properties.getProperty("reports.path");
		} catch (IOException e) {
			 LOG.error("ERORR getScreenShotLocation = {}",e.getCause());
		}
		return path;
	}
	
	public void pageNavigation(WebDriver driver, ExtentTest test) throws Exception {
		LOG.info("User Login-----");  
		String usr="";
		try {
			String userNameArr[]= {"admin4"};
			String passArr[]= {"abcd4567"};
			
			for(int i=0; i<=0; i++) {
				usr=userNameArr[i];
				LoginControllerPage lp = new LoginControllerPage(driver, test);
				lp.username().sendKeys(userNameArr[i]);
				lp.uiPwd().sendKeys(passArr[i]);
				LOG.debug("[DEBUG] - Login User is "+userNameArr[i]);
				LOG.info("[INFORMATION] Login User is "+userNameArr[i]);
				lp.loginBtn().click();
				Thread.sleep(2000);
				LOG.info("Login userName: "+userNameArr[i]);
				usr="";
			}
			//driver.close();	
		}catch(Exception e) {
			LOG.error("Error"+e.getCause());  
		}
		
	}
	
}
	


