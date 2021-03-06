package com.ceiwc.compugain.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ceiwc.compugain.Exception.CustomReport;
import com.ceiwc.compugain.funUtil.WebElements;
import com.ceiwc.compugain.setup.BasePage;

public class OTRSLandingPage extends WebElements{


	private WebDriver driver;
	private CustomReport customReport;
	private BasePage basePage;

	public OTRSLandingPage(WebDriver driver,CustomReport customReport, BasePage basePage) {
		super(driver);
		this.driver = driver;
		this.customReport= customReport;
		this.basePage=basePage;
		// TODO Auto-generated constructor stub
	}

	By cutsomersLocator=By.xpath("//*[contains(@title,'Customers (c)')]");
	By editpersonalPreferencesLocator=By.xpath("//*[contains(text(),'jabesh kurapati')]");
	By ticketsLocator=By.xpath("//*[contains(text(),'Tickets')]");
	By customerUISearchLocator=By.xpath("//li[contains(@title,'Search')]");
	
	public OTRSCustomersPage clickCustomers(){
		click(cutsomersLocator);
		customReport.reporter("Customer Option Clicked", "");
		return basePage.otrsCustomerspage(driver, customReport, basePage);
	}

	public OTRSEditYourPreferencesPage clickEditPersonalPreferences(){
		click(editpersonalPreferencesLocator);
		customReport.reporter("Clicked Edit Personal Preferences", "");
		return basePage.otrsEditYourPreferencesPage(driver, customReport, basePage);
	}

	public OTRSTicketsPage clickTickets(){
		click(ticketsLocator);
		customReport.reporter("Clicked Tickets option", "");
		return basePage.otrsticketspage(driver, customReport, basePage);
	}
	
	
	
	public CustomerSearchPage clickCustomerUISearch(){
		click(customerUISearchLocator);
		customReport.reporter("Clicked Ticket search option", "");
		return basePage.customersearchpage(driver, customReport, basePage);
	}

}
