package com.ceiwc.compugain.testcases;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ceiwc.compugain.Exception.CustomReport;
import com.ceiwc.compugain.beansfactory.BeanFactory;
import com.ceiwc.compugain.dao.OTRSAddCustomerBean;
import com.ceiwc.compugain.pageobjects.CustomerSearchPage;
import com.ceiwc.compugain.pageobjects.OTRSAddCustomersPage;
import com.ceiwc.compugain.pageobjects.OTRSCustomersPage;
import com.ceiwc.compugain.pageobjects.OTRSEditYourPreferencesPage;
import com.ceiwc.compugain.pageobjects.OTRSLandingPage;
import com.ceiwc.compugain.pageobjects.OTRSLoginPage;
import com.ceiwc.compugain.pageobjects.OTRSTicketsPage;
import com.ceiwc.compugain.setup.BasePage;
import com.ceiwc.compugain.setup.TestBase;

public class OTRSTestCases_Firefox extends TestBase{


	private ResourceBundle bundle;
	private Locale locale;
	private static Logger logger = Logger.getLogger(OTRSTestCases_Firefox.class);
	
	@BeforeClass
	public void beforeClass(){
		locale = new Locale("en");
		bundle = ResourceBundle.getBundle("ResourceBundle.BundleFile", locale);
		Properties props = System.getProperties();
        props.setProperty("org.uncommons.reportng.title", "CEIWC Automation Report");
	}
	@Parameters("sbrowser")
	@Test(priority=1,description="Create an Account in OTRS and verify Information Message",groups="Customer Creation_Firefox")
	public void AT_Verify_createAccountWarningMessage(@Optional(sbrowser)String sbrowser){

		String sTestcaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		CustomReport customReport=new CustomReport();
		ArrayList<String> statusValue=new ArrayList<String>();
		WebDriver driver=initializeDriver(sbrowser);
		customReport.reporter("Browser Launched ", sbrowser);
/*		String browservalue=sbrowser;
*/		launchURL(OTRSApplicationURL,driver);
		customReport.reporter("URL Entered ", OTRSApplicationURL);
		BasePage basePage=new BasePage();
		OTRSLoginPage otrsLoginPage=basePage.otrsLoginPage(driver, customReport, basePage);
		OTRSLandingPage otrsLandingPage=otrsLoginPage.login(OTRSUserName,OTRSPassword);
		OTRSEditYourPreferencesPage editYourPreferencesPage=otrsLandingPage.clickEditPersonalPreferences();
		editYourPreferencesPage.selectLanguage(bundle.getString("englanoption"));
		editYourPreferencesPage.clicklanUpdateOption();
		OTRSCustomersPage otrsCustomersPage=otrsLandingPage.clickCustomers();
		OTRSAddCustomersPage addCustomersPage=otrsCustomersPage.clickAddCustomers();
		BeanFactory beanFactory=new BeanFactory();
		OTRSAddCustomerBean addCustomerBean=new OTRSAddCustomerBean();
		beanFactory.createOTRSCustomer(addCustomerBean);
		String actualWarningMessageText=addCustomersPage.otrsAddNewCustomer(addCustomerBean);;
		logger.info("Warning Message Text ::::: "+actualWarningMessageText);
		customReport.customizedReport(true,actualWarningMessageText.contains(bundle.getString("createuserwarningmsg")) , statusValue, driver, sTestcaseName);
		customReport.checkinglist(statusValue);
		browserQuit(driver);
	}


	@Parameters("sbrowser")
	@Test(priority=6,description="Search for valid ticket in Customer OTRS Application",groups="Search Ticket_Firefox")
	public void AT_Verify_CustomerClosedTicketSearch(@Optional(sbrowser)String sbrowser){
		String sTestcaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		CustomReport customReport=new CustomReport();
		ArrayList<String> statusValue=new ArrayList<String>();
		WebDriver driver=initializeDriver(sbrowser);
		customReport.reporter("Browser Launched ", sbrowser);
		launchURL(CustomerApplicationURL,driver);
		customReport.reporter("URL Entered ", CustomerApplicationURL);
		BasePage basePage=new BasePage();
		OTRSLoginPage otrsLoginPage=basePage.otrsLoginPage(driver, customReport, basePage);
		OTRSLandingPage otrsLandingPage= otrsLoginPage.customerlogin(customerUserName,customerPassword);
		CustomerSearchPage customerSearchPage=otrsLandingPage.clickCustomerUISearch();
		customerSearchPage.enterTicketNumber("2016101910000022");
		customerSearchPage.clickSearchOption();
		customReport.customizedReport(bundle.getString("closedticketstatus"), customerSearchPage.checkClosedticketStatus(), statusValue, driver, sTestcaseName);
		customReport.checkinglist(statusValue);
		browserQuit(driver);;
		
		
	}


}
