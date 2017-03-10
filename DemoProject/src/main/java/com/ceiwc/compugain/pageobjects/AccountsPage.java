package com.ceiwc.compugain.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ceiwc.compugain.Exception.CustomReport;
import com.ceiwc.compugain.funUtil.WebElements;
import com.ceiwc.compugain.setup.BasePage;

public class AccountsPage extends WebElements {

	
	private WebDriver driver;
	private CustomReport customReport;
	private BasePage basePage;
	
	
	
	public AccountsPage(WebDriver driver,CustomReport customReport, BasePage basePage) {
		super(driver);
		this.driver = driver;
		this.customReport= customReport;
		this.basePage=basePage;
		// TODO Auto-generated constructor stub
	}
}
