package com.mmb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mmb.qa.base.TestBase;
import com.mmb.qa.pages.ContactsPage;
import com.mmb.qa.pages.HomePage;
import com.mmb.qa.pages.LoginPage;
import com.mmb.qa.pages.PropertyAlert;

public class PropertyAlertTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homePage;
	ContactsPage contactsPage;
	PropertyAlert propertyAlert;
	
	
	
	public PropertyAlertTest() {		
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		 contactsPage= new ContactsPage();
		 loginpage =new LoginPage();
		 homePage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		 propertyAlert = homePage.clickOnPropertyAlertLink();
		 System.out.println("testing property link page eeeeeeeee");
	}
	
	@Test(priority=1)
	public void verifyPropertyAlertLable() {
		Assert.assertTrue(propertyAlert.verifyPropertyAlertLable(),"Property Alert lable is not found");
				
	}
	
	@Test(priority=2)
	public void verifyClickOnPropertyLink() {
		propertyAlert= homePage.clickOnPropertyAlertLink();
	}
	
	@Test(priority=3)
	public void verifySetNewAlertLink() {
		propertyAlert.verifySetNewAlertLink();
	}
	
	@Test(priority=4)
	public void verifyEditLink() {
		propertyAlert.verifyEditPropertyLink();
	}
	
	@Test(priority=5)
	public void verifyUnSubLink() {
		propertyAlert.verifyUnsubscribeLink();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
