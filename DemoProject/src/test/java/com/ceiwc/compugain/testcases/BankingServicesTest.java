package com.ceiwc.compugain.testcases;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ceiwc.compugain.Exception.CustomReport;
import com.ceiwc.compugain.beansfactory.BeanFactory;
import com.ceiwc.compugain.dao.CreateCustomerBean;
import com.ceiwc.compugain.pageobjects.CustomerPage;
import com.ceiwc.compugain.pageobjects.DashBoardPage;
import com.ceiwc.compugain.setup.BasePage;
import com.ceiwc.compugain.setup.TestBase;

public class BankingServicesTest extends TestBase {

	private ResourceBundle bundle;
	private Locale locale;
	private static Logger logger = Logger.getLogger(BankingServicesTest.class);

	@BeforeClass
	public void beforeClass(){
		locale = new Locale("en");
		bundle = ResourceBundle.getBundle("ResourceBundle.BundleFile", locale);
	}
	
	@Test(description = "Adding a customer" , groups="Add user")
	public void AT_Verify_AddCustomerDetails() throws InterruptedException{

		String sTestcaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		CustomReport customReport=new CustomReport();
		WebDriver driver=initializeDriver(SBROWSER);
		launchURL(AutomationURL,driver);
		customReport.reporter("Browser Launched", AutomationURL);
		ArrayList<String> statusValue=new ArrayList<String>();
		BasePage basePage=new BasePage();
		DashBoardPage dashboardpage=basePage.demoDashboardPage(driver, customReport, basePage);
		CustomerPage customerpage=dashboardpage.clickCustomers();
		CreateCustomerBean createCustomerBean=new CreateCustomerBean();
		BeanFactory bean=new BeanFactory();
		bean.createCustomer(createCustomerBean);
		customerpage.createCustomer(createCustomerBean);
		customerpage.clickSubmitButton();
		customReport.customizedReport(false, customerpage.verifyusercreated(bundle.getString("customercreatedmsg")), statusValue, driver, sTestcaseName);
		
		customReport.checkinglist(statusValue);
		browserQuit(driver);
	}
	
	
	@Test(description = "Search for a user" , groups="Search User")
	public void AT_Verify_Searchforcreateduser(){
		
		String sTestcaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		
		WebDriver driver=initializeDriver(SBROWSER);
		CustomReport customReport=new CustomReport();
		
		launchURL(AutomationURL,driver);
		customReport.reporter("Browser Launched", AutomationURL);
		ArrayList<String> statusValue=new ArrayList<String>();
		BasePage basePage=new BasePage();
		DashBoardPage dashboardpage=basePage.demoDashboardPage(driver, customReport, basePage);
		CustomerPage customerpage=dashboardpage.clickCustomers();
		CreateCustomerBean createCustomerBean=new CreateCustomerBean();
		BeanFactory bean=new BeanFactory();
		String customerName="test";
		bean.createCustomer(createCustomerBean);
		createCustomerBean.setCustomername(customerName);
		customerpage.createCustomer(createCustomerBean);
		customerpage.clickSubmitButton();
		customReport.customizedReport(true, customerpage.verifyusercreated(bundle.getString("customercreatedmsg")), statusValue, driver, sTestcaseName);
		dashboardpage.clickAccounts();
		dashboardpage.clickCustomers();
		customerpage.refreshBrowser();
		ArrayList<String> userdata=customerpage.searchforcreateduser(createCustomerBean);
		logger.info("userdata in testcase "+userdata);
		customReport.customizedReport(true, userdata.contains(customerName), statusValue, driver, sTestcaseName);
		customReport.checkinglist(statusValue);
		browserQuit(driver);
	}
	
	
	@Test(description = "Warning Message when Creating user" , groups="Error Messages")
	public void AT_Verify_mandatoryfieldswarningmessage(){
		
		String sTestcaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		WebDriver driver=initializeDriver(SBROWSER);
		CustomReport customReport=new CustomReport();
		
		launchURL(AutomationURL,driver);
		customReport.reporter("Browser Launched", AutomationURL);

		ArrayList<String> statusValue=new ArrayList<String>();
		BasePage basePage=new BasePage();
		DashBoardPage dashboardpage=basePage.demoDashboardPage(driver, customReport, basePage);
		CustomerPage customerpage=dashboardpage.clickCustomers();
		CreateCustomerBean createCustomerBean=new CreateCustomerBean();
		BeanFactory bean=new BeanFactory();
		String customerName="test";
		bean.createCustomer(createCustomerBean);
		createCustomerBean.setCustomername(customerName);
		customerpage.enterCustomerID(createCustomerBean);
		customerpage.enterCustomeraddress(createCustomerBean);
		customerpage.enterCustomerphoneno(createCustomerBean);
		customerpage.enterCustomeremailid(createCustomerBean);
		customerpage.clickSubmitButton();
		
		customReport.customizedReport(bundle.getString("warningmsg.txt"), customerpage.verify_label(bundle.getString("warningmsg.txt")),statusValue, driver, sTestcaseName);
		customReport.checkinglist(statusValue);
		browserQuit(driver);
	}


}
