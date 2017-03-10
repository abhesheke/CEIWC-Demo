package com.ceiwc.compugain.pageobjects;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ceiwc.compugain.Exception.CustomReport;
import com.ceiwc.compugain.dao.CreateCustomerBean;
import com.ceiwc.compugain.funUtil.WebElements;
import com.ceiwc.compugain.setup.BasePage;

public class CustomerPage extends WebElements {


	private WebDriver driver;
	private CustomReport customReport;
	private BasePage basePage;
	private static Logger logger = Logger.getLogger(CustomerPage.class);

	By customeridlocator=By.id("id");
	By customernamelocator=By.id("name");
	By customeraddresslocator=By.id("address");
	By customerphoneno=By.id("phoneNo");
	By customeremailid=By.id("emailId");
	By submitbuttonlocator=By.xpath("(//*[contains(@class,'btn btn-primary')])[1]");
	By searchboxlocator=By.xpath("//*[contains(@placeholder,'Search')]");


	public CustomerPage(WebDriver driver,CustomReport customReport, BasePage basePage) {
		super(driver);
		this.driver = driver;
		this.customReport= customReport;
		this.basePage=basePage;
	}

	public void enterCustomerID(CreateCustomerBean createCustomerBean) {

		enterText(customeridlocator, createCustomerBean.getCustomerid());
		customReport.reporter("Entered text into Customer ID",createCustomerBean.getCustomerid());
	}

	public void enterCustomerName(CreateCustomerBean createCustomerBean){
		enterText(customernamelocator, createCustomerBean.getCustomername());
		customReport.reporter("Entered text into Customer Name",createCustomerBean.getCustomername());

	}

	public void enterCustomeraddress(CreateCustomerBean createCustomerBean){
		enterText(customeraddresslocator, createCustomerBean.getCustomeraddress());
		customReport.reporter("Entered text into Customer Address",createCustomerBean.getCustomeraddress());

	}

	public void enterCustomerphoneno(CreateCustomerBean createCustomerBean){
		enterText(customerphoneno, createCustomerBean.getPhoneno());
		customReport.reporter("Entered text into Customer PhoneNo",createCustomerBean.getPhoneno());

	}
	public void enterCustomeremailid(CreateCustomerBean createCustomerBean){
		enterText(customeremailid, createCustomerBean.getEmailid());
		customReport.reporter("Entered text into Customer EmailID",createCustomerBean.getEmailid());

	}
	public void createCustomer(CreateCustomerBean createCustomerBean){

		enterCustomerID(createCustomerBean);
		enterCustomerName(createCustomerBean);
		enterCustomeraddress(createCustomerBean);
		enterCustomerphoneno(createCustomerBean);
		enterCustomeremailid(createCustomerBean);

	}


	public void clickSubmitButton(){
		click(submitbuttonlocator);
	}

	
	
	public boolean verifyusercreated(String accountCreatedMsg){
		waitforAlert();
		boolean value=switchTOAlert(accountCreatedMsg);
		acceptAlert();
		return value; 
	}

	public ArrayList<String> searchforcreateduser(CreateCustomerBean createCustomerBean){
		
		enterText(searchboxlocator, createCustomerBean.getCustomername());
		
		By userdata=By.xpath("//*[contains(@class,'table table-bordered table-striped table-hover')]/tbody/tr");
		
		int users=elements(userdata);
		
		String xpath_Start="//*[contains(@class,'table table-bordered table-striped table-hover')]/tbody/tr[";
		String xpath_Middle="]/td[";
		String xpath_End="]";
			
		logger.info("User Entries in table "+users);
		
		ArrayList<String> userlist=new ArrayList<String>();
		for(int i=1;i<users;i++ ) {
			
			for(int j=1;j<=5;j++) {
			
				userlist.add(getText(By.xpath(xpath_Start+i+xpath_Middle+j+xpath_End)));
			}
		}
		logger.info("userlist :::::: "+userlist);
		return userlist;
	}


}
