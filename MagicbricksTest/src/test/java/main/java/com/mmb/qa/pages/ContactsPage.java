package com.mmb.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmb.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'Download Responses')]")
	WebElement contactResponseLable;
	

	@FindBy(xpath="//a[contains(text(),'Switch to Month-wise display')]")
	WebElement switchToMonthLable;
	
	@FindBy(xpath="//a[contains(text(),'Switch to Property-wise display')]")
	WebElement switchToPropertyLable;
	
	
	
	//Initializing the page object
			public ContactsPage() {				
				PageFactory.initElements(driver, this);
			}
			
			public boolean verifyContactResponseLable() {
				return contactResponseLable.isDisplayed();
				
			}
			/*
			public void switchContactWise() {
				if(switchToMonthLable.isDisplayed()) {
					switchToMonthLable.click();
				
				}else switchToPropertyLable.isDisplayed();{
					switchToPropertyLable.click(); 
					
				}
				return switchContactWise
				
			}*/
			
			public void switchContactWiseByName(String name) {
				driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]")).click();
			}
	
	

}
