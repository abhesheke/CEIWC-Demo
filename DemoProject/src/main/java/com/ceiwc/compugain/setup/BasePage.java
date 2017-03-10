package com.ceiwc.compugain.setup;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.ceiwc.compugain.Exception.CustomReport;
import com.ceiwc.compugain.pageobjects.AccountsPage;
import com.ceiwc.compugain.pageobjects.CustomerPage;
import com.ceiwc.compugain.pageobjects.DashBoardPage;

public class BasePage {

	private static Logger logger = Logger.getLogger(BasePage.class);
	private WebDriver driver;
	private CustomReport customReport;
	private BasePage basePage;
	private DashBoardPage dashboardpage;
	private CustomerPage customerpage;
	private AccountsPage accountsPage;
	
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

	}
