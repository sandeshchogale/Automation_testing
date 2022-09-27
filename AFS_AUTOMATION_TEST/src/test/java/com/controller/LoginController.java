package com.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.page.LoginControllerPage;
import com.kiyaai.base.BaseListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(com.listners.LoginControllerListener.class)
public class LoginController extends BaseListener {

	public WebDriver driver;
	
	static ExtentTest test;
	static ExtentReports report;

	private static final Logger LOG = LogManager.getLogger(LoginController.class);
	
	@BeforeClass
	public void generateReportPath() {
		String path = getRportsPath("LoginController");
		report = new ExtentReports(path);
		test = report.startTest("LoginController");
	}
	
	@BeforeTest
	private void setup() {
		driver = initializeDriver();
	}
	
	//=============== TEST CASES START============================================//
	
	@Test
	public void pageNavigation() throws Exception {
		//LOG.debug("Hello this is a debug message");  
		LOG.info("LoginAction pageNavigation()-----");  
		test.log(LogStatus.PASS, "-----LoginAction pageNavigation()-----");
		System.out.println("After pageNavigation()-----");

		  	
		LOG.info("pageNavigation method------------"); 

		String usr="";
		try {
			//String userNameArr[]= {"admin4","admin5","admin6"};
			//String passArr[]= {"abcd1234","abcd4567","abcd7890"};
			String userNameArr[]= {"admin4"};
			String passArr[]= {"abcd4567"};
			
			for(int i=0; i<=0; i++) {
				usr=userNameArr[i];
				//driver = initializeDriver();
				LoginControllerPage lp = new LoginControllerPage(driver, test);
				
				lp.username().sendKeys(userNameArr[i]);
				lp.uiPwd().sendKeys(passArr[i]);
				LOG.debug("[DEBUG] - Login User is "+userNameArr[i]);
				LOG.info("[INFORMATION] Login User is "+userNameArr[i]);
				lp.loginBtn().click();
				
			//	Thread.sleep(2000);
				LOG.info("Login userName: "+userNameArr[i]);
				
				usr="";
				//Thread.sleep(2000);
				//RoleManagementController roleManagementController = new RoleManagementController();
				//roleManagementController.roleNavigation(driver, test, report);
			}
			//driver.close();	
		}catch(Exception e) {
			LOG.error("Error"+e.getCause());  
			test.log(LogStatus.FAIL, "pageNavigation Test Failed for "+usr +" "+e.getCause());
		}
		
	}
	
	//=============== TEST CASES END============================================//
	
	@AfterClass
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}

/*	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}
	*/
}
