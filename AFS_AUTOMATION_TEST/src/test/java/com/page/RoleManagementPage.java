package com.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RoleManagementPage {

	private static final Logger LOG = LogManager.getLogger(RoleManagementPage.class);
	public WebDriver driver;
	
	public RoleManagementPage(WebDriver driver, ExtentTest test) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		LOG.info("RoleManagementPage Contructor called RoleManagementPage(WebDriver driver)----"); 
		test.log(LogStatus.PASS, "Contructor  of RoleManagementPage.java - called RoleManagementPage(WebDriver driver)");
	}
	
	//================================Locate Repository Elements Start=====================//
	
	@FindBy(xpath= "//*[@class='hi-btn-menu']")
	WebElement Mainmenu;
	
	public WebElement Mainmenu() {
		return Mainmenu;
	}
	
	
	
	
	
	
	//================================Locate Repository Elements End=====================//
}
