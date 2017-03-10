package com.ceiwc.compugain.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ceiwc.compugain.Exception.CustomReport;
import com.ceiwc.compugain.funUtil.WebElements;
import com.ceiwc.compugain.setup.BasePage;

public class DashBoardPage extends WebElements{


	private WebDriver driver;
	private CustomReport customReport;
	private BasePage basePage;
	
	By customerLocator=By.xpath("//*[contains(@class,'glyphicon btn-glyphicon glyphicon-user img-circle text-success')]");
	By accountslocator=By.xpath("//*[contains(text(),'Accounts  ')]");
	
	public DashBoardPage(WebDriver driver,CustomReport customReport, BasePage basePage) {
		super(driver);
		this.driver = driver;
		this.customReport= customReport;
		this.basePage=basePage;
		// TODO Auto-generated constructor stub
	}
	
	public CustomerPage clickCustomers(){
		click(customerLocator);
		return basePage.customerpage(driver, customReport, basePage);
	}
	
	
	public void clickAccounts(){
		click(accountslocator);
		
	}

		
}
