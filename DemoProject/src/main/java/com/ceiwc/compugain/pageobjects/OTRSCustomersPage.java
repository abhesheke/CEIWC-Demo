package com.ceiwc.compugain.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ceiwc.compugain.Exception.CustomReport;
import com.ceiwc.compugain.funUtil.WebElements;
import com.ceiwc.compugain.setup.BasePage;

public class OTRSCustomersPage extends WebElements{

	
	private WebDriver driver;
	private CustomReport customReport;
	private BasePage basePage;
	
	public OTRSCustomersPage(WebDriver driver,CustomReport customReport, BasePage basePage) {
		super(driver);
		this.driver = driver;
		this.customReport= customReport;
		this.basePage=basePage;
		// TODO Auto-generated constructor stub
	}
	
	
	By addCustomerLocator=By.xpath("//*[contains(text(),'Add customer')]");
	
	public OTRSAddCustomersPage clickAddCustomers(){
		click(addCustomerLocator);
		customReport.reporter("Clicked New Customer option", "");
		return basePage.otrsAddCustomersPage(driver, customReport, basePage);
	}
}
