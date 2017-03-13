package com.ceiwc.compugain.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ceiwc.compugain.Exception.CustomReport;
import com.ceiwc.compugain.funUtil.WebElements;
import com.ceiwc.compugain.setup.BasePage;

public class OTRSLoginPage extends WebElements{

	
	private WebDriver driver;
	private CustomReport customReport;
	private BasePage basePage;
	
	public OTRSLoginPage(WebDriver driver,CustomReport customReport, BasePage basePage) {
		super(driver);
		this.driver = driver;
		this.customReport= customReport;
		this.basePage=basePage;
		// TODO Auto-generated constructor stub
	}
	
	By userNameLocator=By.id("User");
	By passwordLocator=By.id("Password");
	By loginButtonLocator=By.id("LoginButton");
	By customerLoginLocator=By.xpath("//*[contains(@value,'Log In')]");
	
	public OTRSLandingPage login(String userName,String password){
		enterUserName(userName);
		enterPassword(password);
		clickLogin();	
		return basePage.otrsLandingPage(driver, customReport, basePage);
	}
	
	public void enterUserName(String userName){
		enterText(userNameLocator, userName);
	}
	public void enterPassword(String password){
		enterText(passwordLocator, password);
	}
	public void clickLogin(){
		click(loginButtonLocator);
	}
	
	public OTRSLandingPage customerlogin(String userName,String password){
		enterUserName(userName);
		enterPassword(password);
		click(customerLoginLocator);
		return basePage.otrsLandingPage(driver, customReport, basePage);
	}
	
	
}
