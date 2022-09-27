package com.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.page.RoleManagementPage;
import com.kiyaai.base.BaseListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(com.listners.RoleManagementControllerListener.class)
public class RoleManagementController extends  BaseListener {
	
	public WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;

	private static final Logger LOG = LogManager.getLogger(RoleManagementController.class);

	@BeforeClass
	public void generateReportPath() {
		String path = getRportsPath("RoleManagementController");
		report = new ExtentReports(path);
		test = report.startTest("RoleManagementController");
	}

	@BeforeTest
	private void setup() {
		driver = initializeDriver();
	}
	//=============== TEST CASES ACTION START============================================//
	
	@Test
	public void roleNavigation() throws Exception {
		LOG.info("roleNavigation Called----------------");
		String usr = "";
		try {
			pageNavigation(driver, test);
			RoleManagementPage rm = new RoleManagementPage(driver, test);
			Thread.sleep(2000);
			rm.Mainmenu().click();
			Thread.sleep(2000);
			LOG.info("roleNavigation rm.Mainmenu().click()----------------");
			//driver.close();
		} catch (Exception e) {
			LOG.error("Error" + e.getCause());
			test.log(LogStatus.FAIL, "roleNavigation Test Failed for " + usr + " " + e.getCause());
		}
	}

	// =============== TEST CASES ACTION
	// END============================================//

	@AfterClass
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}

	/*
	 * @AfterTest public void tearDown() throws Exception { driver.quit(); }
	 * 
	 */

}
