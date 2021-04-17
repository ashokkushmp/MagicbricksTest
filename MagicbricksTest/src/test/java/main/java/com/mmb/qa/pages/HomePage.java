package com.mmb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmb.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//p[contains(text(),'Name: Vijay')]")
	WebElement userNameLable;
	
	@FindBy(xpath="//b[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//b[contains(text(),'Properties')]")
	WebElement propertiesTab;
	
	@FindBy(xpath="//b[contains(text(),'Property Alerts')]")
	WebElement propertyAlertLink;
	
	@FindBy(xpath="//b[contains(text(),'Profile')]")
	WebElement profileTab;
	
	
	//Initializing the page object
		public HomePage() {
			
			PageFactory.initElements(driver, this);
		}
		
		public String verifyHomePageTitle() {
			return driver.getTitle();
			
		}
		
		public boolean verifyCorrectUserName() {
			return userNameLable.isDisplayed();
		}
		
		public ContactsPage clickOnContactLink() {
			contactsLink.click();
			return new ContactsPage();
		}
		
		public Properties clickOnPropertiesTabmmb() {
			propertiesTab.click();
			return new Properties();
		}
		
		
		
		public Profile profileTabmmb() {
			profileTab.click();
			return new Profile();
		}
		
		
		
		public PropertyAlert clickOnPropertyAlertLink() {
			System.out.println("testing for linkkkkkkkkkkkkkkkkkkk");
			try {
				Thread.sleep(5000);
				propertyAlertLink.click();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return new PropertyAlert();
		}
		
		
	
	

}
