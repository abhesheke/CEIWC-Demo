package com.ceiwc.compugain.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ceiwc.compugain.Exception.CustomReport;
import com.ceiwc.compugain.funUtil.WebElements;
import com.ceiwc.compugain.setup.BasePage;

public class OTRSEditYourPreferencesPage extends WebElements{

	private WebDriver driver;
	private CustomReport customReport;
	private BasePage basePage;
	
	public OTRSEditYourPreferencesPage(WebDriver driver,CustomReport customReport, BasePage basePage) {
		super(driver);
		this.driver = driver;
		this.customReport= customReport;
		this.basePage=basePage;
		// TODO Auto-generated constructor stub
	}
	By lanLocator=By.id("UserLanguage");
	By lanUpdatelocator=By.id("UserLanguageUpdate");
	
	public void selectLanguage(String drpoption){
		
		selectValuefromDropDown(lanLocator, drpoption);
		customReport.reporter("Language Value Selected", drpoption);
	}
	
	
	public void clicklanUpdateOption(){
		click(lanUpdatelocator);
		customReport.reporter("Clicked Language Update option"," ");
	}
	
	public String verifyLanUpdate(){
		return getAttribute(lanUpdatelocator, "value");
	}
	
}
