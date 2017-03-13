package com.ceiwc.compugain.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ceiwc.compugain.Exception.CustomReport;
import com.ceiwc.compugain.funUtil.WebElements;
import com.ceiwc.compugain.setup.BasePage;

public class CustomerSearchPage extends WebElements {

	
	private WebDriver driver;
	private CustomReport customReport;
	private BasePage basePage;
	
	public CustomerSearchPage(WebDriver driver,CustomReport customReport, BasePage basePage) {
		super(driver);
		this.driver = driver;
		this.customReport= customReport;
		this.basePage=basePage;
		// TODO Auto-generated constructor stub
	}
	
	
	By ticketNoLocator=By.id("TicketNumber");
	By searchOptionLcoator=By.xpath("//*[contains(@id,'Submit')]");
	By checkticketstatus=By.xpath("//*[contains(@id,'EmptyMessage')]/td");
	By closedTicketlocator=By.xpath("//*[contains(text(),'closed successful')]");
	public void enterTicketNumber(String value){
		enterText(ticketNoLocator,value);
	}
	
	public void clickSearchOption(){
		click(searchOptionLcoator);
	}
	
	public String checkticketStatus(){
		return getText(checkticketstatus);
	}
	
	public String checkClosedticketStatus(){
		return getText(closedTicketlocator);
	}
}
