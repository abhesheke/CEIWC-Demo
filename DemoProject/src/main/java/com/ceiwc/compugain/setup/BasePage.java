package com.ceiwc.compugain.setup;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.ceiwc.compugain.Exception.CustomReport;
import com.ceiwc.compugain.pageobjects.AccountsPage;
import com.ceiwc.compugain.pageobjects.CustomerPage;
import com.ceiwc.compugain.pageobjects.CustomerSearchPage;
import com.ceiwc.compugain.pageobjects.DashBoardPage;
import com.ceiwc.compugain.pageobjects.OTRSAddCustomersPage;
import com.ceiwc.compugain.pageobjects.OTRSCustomersPage;
import com.ceiwc.compugain.pageobjects.OTRSEditYourPreferencesPage;
import com.ceiwc.compugain.pageobjects.OTRSLandingPage;
import com.ceiwc.compugain.pageobjects.OTRSLoginPage;
import com.ceiwc.compugain.pageobjects.OTRSTicketsPage;

public class BasePage {

	private static Logger logger = Logger.getLogger(BasePage.class);
	private WebDriver driver;
	private CustomReport customReport;
	private BasePage basePage;
	private DashBoardPage dashboardpage;
	private CustomerPage customerpage;
	private AccountsPage accountsPage;
	private OTRSLoginPage otrsLoginPage;
	private OTRSLandingPage otrsLandingPage;
	private OTRSCustomersPage otrsCustomersPage;
	private OTRSAddCustomersPage otrsAddCustomersPage;
	private OTRSEditYourPreferencesPage otrsEditYourPreferencesPage;
	private OTRSTicketsPage otrsticketspage;
	private CustomerSearchPage customersearchpage;
	 
	public BasePage()
	{
		logger.info("Creation of Constructer of basepage");
	}
	
	public BasePage(WebDriver driver, CustomReport customReport,BasePage basePage)
	{
		this.driver=driver;
		this.customReport=customReport;
		this.basePage=basePage;
	}
	
	public DashBoardPage demoDashboardPage(WebDriver driver, CustomReport customReport,BasePage basePage)
	{
		if(dashboardpage==null){
			dashboardpage = new DashBoardPage(driver,  customReport, basePage);
		}
		return dashboardpage;
	}
	
	public CustomerPage customerpage(WebDriver driver, CustomReport customReport,BasePage basePage) {
		
		if(customerpage==null) {
			customerpage=new CustomerPage(driver, customReport, basePage);
		}
		return customerpage;
	}
	
	public AccountsPage accountspage(WebDriver driver, CustomReport customReport,BasePage basePage){
		if(accountsPage==null) {
			accountsPage=new AccountsPage(driver, customReport, basePage);
		}
		return accountsPage;
	}
	
	public OTRSLoginPage otrsLoginPage(WebDriver driver, CustomReport customReport,BasePage basePage) {
		
		if(otrsLoginPage==null) {
			otrsLoginPage = new OTRSLoginPage(driver, customReport, basePage);
		}
		return otrsLoginPage;
	}
	
	public OTRSLandingPage otrsLandingPage(WebDriver driver, CustomReport customReport,BasePage basePage) {
		
		if(otrsLandingPage==null) {
			otrsLandingPage=new OTRSLandingPage(driver, customReport, basePage);
		}
		return otrsLandingPage;
	}

	public OTRSCustomersPage otrsCustomerspage(WebDriver driver, CustomReport customReport,BasePage basePage){
		
		if(otrsCustomersPage==null) {
			otrsCustomersPage=new OTRSCustomersPage(driver, customReport, basePage);
		}
		return otrsCustomersPage;
	}
	
	public OTRSAddCustomersPage otrsAddCustomersPage(WebDriver driver, CustomReport customReport,BasePage basePage) {
		
		if(otrsAddCustomersPage==null) {
			
			otrsAddCustomersPage=new OTRSAddCustomersPage(driver, customReport, basePage);
			
		}	
		return otrsAddCustomersPage;
	}
	
	public OTRSEditYourPreferencesPage otrsEditYourPreferencesPage(WebDriver driver, CustomReport customReport,BasePage basePage){
		
		if(otrsEditYourPreferencesPage==null) {
			otrsEditYourPreferencesPage=new OTRSEditYourPreferencesPage(driver, customReport, basePage);
		}
		return otrsEditYourPreferencesPage;
	}
	public OTRSTicketsPage otrsticketspage(WebDriver driver, CustomReport customReport,BasePage basePage){
		
		if(otrsticketspage==null) {
			otrsticketspage=new OTRSTicketsPage(driver, customReport, basePage);
		}
		
		return otrsticketspage;
	}
	
	
	public CustomerSearchPage customersearchpage(WebDriver driver, CustomReport customReport,BasePage basePage){
		
		if(customersearchpage==null) {
			customersearchpage=new CustomerSearchPage(driver, customReport, basePage);
		}
		return customersearchpage;
	}
	
	}
