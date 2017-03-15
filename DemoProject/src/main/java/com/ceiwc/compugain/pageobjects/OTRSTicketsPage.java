package com.ceiwc.compugain.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ceiwc.compugain.Exception.CustomReport;
import com.ceiwc.compugain.funUtil.WebElements;
import com.ceiwc.compugain.setup.BasePage;

public class OTRSTicketsPage extends WebElements{

	
	private WebDriver driver;
	private CustomReport customReport;
	private BasePage basePage;
	
	public OTRSTicketsPage(WebDriver driver,CustomReport customReport, BasePage basePage) {
		super(driver);
		this.driver = driver;
		this.customReport= customReport;
		this.basePage=basePage;
		
	}
	
	By searchLocator=By.xpath("//*[contains(@id,'nav-Tickets-Search')]/a");
	By searchwindowfulltextlocator=By.name("Fulltext");
	By runserachlocator=By.xpath("//*[contains(text(),'Run search')]");
	By closedStatusLocator=By.xpath("//*[contains(text(),'closed successful')]");
	
	public void clickSearchticketoption() {
		
		clickusingjavascript(searchLocator);
		customReport.reporter("Search Ticket option cliked", "");
	}
	
	
	public void enterTicketTNo(){
		enterText(searchwindowfulltextlocator, "2017031010000103");
		customReport.reporter("Ticket No Entered","2017031010000103");
	}
	
	public void clickrunsearchoption(){
		click(runserachlocator);
	}
	
	public String checkTicketStatus(){
		return getText(closedStatusLocator);
	}
	
}
