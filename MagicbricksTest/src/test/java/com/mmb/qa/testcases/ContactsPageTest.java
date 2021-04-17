package com.mmb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mmb.qa.base.TestBase;
import com.mmb.qa.pages.ContactsPage;
import com.mmb.qa.pages.HomePage;
import com.mmb.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public ContactsPageTest() {		
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		 contactsPage= new ContactsPage();
		 loginpage =new LoginPage();
		 homePage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		 contactsPage=homePage.clickOnContactLink();
	}
	@Test(priority=1)
	public void verifyContactsPageLable() {
		Assert.assertTrue(contactsPage.verifyContactResponseLable(),"contacts lable is missing on the page");
	}
	@Test(priority=2)
	public void switchContactWiseByName() {
		contactsPage.switchContactWiseByName("Switch to Property-wise display");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
