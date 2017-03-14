package com.ceiwc.compugain.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ceiwc.compugain.Exception.CustomReport;
import com.ceiwc.compugain.dao.OTRSAddCustomerBean;
import com.ceiwc.compugain.funUtil.WebElements;
import com.ceiwc.compugain.setup.BasePage;

public class OTRSAddCustomersPage extends WebElements{

	
	private WebDriver driver;
	private CustomReport customReport;
	private BasePage basePage;
	
	public OTRSAddCustomersPage(WebDriver driver,CustomReport customReport, BasePage basePage) {
		super(driver);
		this.driver = driver;
		this.customReport= customReport;
		this.basePage=basePage;
		// TODO Auto-generated constructor stub
	}
	
	By firstNameLocator=By.id("UserFirstname");
	By lastNameLocator=By.id("UserLastname");
	By userNameLocator=By.id("UserLogin");
	By emailLocator=By.id("UserEmail");
	By customerIdLocator=By.id("UserCustomerID");
	By submitButton=By.xpath("//*[contains(@value,'Submit')]");
	By warningMessageLocator=By.xpath("//*[contains(@class,'MessageBox Error')]/p");
	By mandatoryWarningMessageLcoator=By.xpath("(//*[contains(@class,'Mandatory LabelError')])[1]");
	
	
	public void enterFirstName(OTRSAddCustomerBean otrsAddCustomerBean){
		enterText(firstNameLocator, otrsAddCustomerBean.getFirstName());
		customReport.reporter("First Name Entered", otrsAddCustomerBean.getFirstName());
	}
	
	public void enterLastName(OTRSAddCustomerBean otrsAddCustomerBean){
		enterText(lastNameLocator, otrsAddCustomerBean.getLastName());
		customReport.reporter("Last Name Entered", otrsAddCustomerBean.getLastName());
	}
	
	public void enterUserName(OTRSAddCustomerBean otrsAddCustomerBean){
	enterText(userNameLocator, otrsAddCustomerBean.getUserName());	
	customReport.reporter("UserName Entered", otrsAddCustomerBean.getUserName());
	}
	
	public void enterEmail(OTRSAddCustomerBean otrsAddCustomerBean){
		enterText(emailLocator, otrsAddCustomerBean.getEmail());
		customReport.reporter("Email Entered", otrsAddCustomerBean.getEmail());
	}
	
	public void enterCustomerId(OTRSAddCustomerBean otrsAddCustomerBean) {
		enterText(customerIdLocator, otrsAddCustomerBean.getCustomerID());
		customReport.reporter("CustomerID Entered", otrsAddCustomerBean.getCustomerID());
	}
	
	public void clickSubmit(){
		click(submitButton);
		customReport.reporter("Submit Option Clicked","");
	}
	
	public String otrsAddNewCustomer(OTRSAddCustomerBean otrsAddCustomerBean) {
		
		enterFirstName(otrsAddCustomerBean);
		enterLastName(otrsAddCustomerBean);
		enterUserName(otrsAddCustomerBean);
		enterEmail(otrsAddCustomerBean);
		enterCustomerId(otrsAddCustomerBean);
		clickSubmit();
		return getText(warningMessageLocator);
	}
	
	public boolean verifyMandatoryWarningMessage(){
		return isDisplayed(mandatoryWarningMessageLcoator);
	}
	
}
