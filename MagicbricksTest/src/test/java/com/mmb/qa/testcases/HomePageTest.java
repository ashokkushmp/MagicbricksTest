package com.mmb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mmb.qa.base.TestBase;
import com.mmb.qa.pages.ContactsPage;
import com.mmb.qa.pages.HomePage;
import com.mmb.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	//test cases should be separated -independent each other.
	//before each  test case - launch the browser and login.
	//@Test - execute the test case
	//after each test case - close the browser 
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		 contactsPage= new ContactsPage();
		 loginpage =new LoginPage();
		 homePage= loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		System.out.println("title kkkkkkkkkkk " +homePageTitle);
		Assert.assertEquals(homePageTitle, "Real Estate | Property in India | Buy/Sale/Rent Properties | MagicBricks","Home page title is not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactLink() {
		contactsPage=homePage.clickOnContactLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
