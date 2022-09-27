package com.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginControllerPage {

	private static final Logger LOG = LogManager.getLogger(LoginControllerPage.class);
	public WebDriver driver;
	
	public LoginControllerPage(WebDriver driver, ExtentTest test) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		LOG.info("LoginPageTest Contructor called LoginPageTest(WebDriver driver)----"); 
		test.log(LogStatus.PASS, "Contructor  of LoginPageTest.java - called LoginPageTest(WebDriver driver)");
	}
	
	//================================Locate Repository Elements Start=====================//
	
	@FindBy(xpath = "//*[@id='loginId']")
	WebElement username;
	
	@FindBy(xpath = "//*[@id='uiPwd']")
	WebElement uiPwd;
	
	@FindBy(xpath = "//*[@id='loginBtn']")
	WebElement loginBtn;

	public WebElement username() {
		return username;
	}
	
	public WebElement uiPwd() {
		return uiPwd;
	}
	
	public WebElement loginBtn() {
		return loginBtn;
	}
	
	//================================Locate Repository Elements End=====================//
 
}
