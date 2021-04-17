package com.mmb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mmb.qa.base.TestBase;
import com.mmb.qa.pages.ContactsPage;
import com.mmb.qa.pages.HomePage;
import com.mmb.qa.pages.LoginPage;
import com.mmb.qa.pages.SignUpPage;
import com.mmb.qa.util.TestUtil;

public class SignUpPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homePage;
	SignUpPage signUpPage;
	
	String sheetName ="signup";
	
	public SignUpPageTest() {		
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		signUpPage= new SignUpPage();
		 loginpage =new LoginPage();
		 homePage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		 signUpPage = loginpage.logout();
		
	}
	
	@Test(priority=1)
	public void verifyTheLogOutLableTest() {
		Assert.assertTrue(signUpPage.verifyTheLogOutLable(), "Testing Lable text is not found");
	}
	
	//Clicking on the SignUp link on the login page if not register
	@Test(priority=2)
	public void clickOnTheSignUpLinkTest() {
		signUpPage.clickOnTheSignUpLink();
	}
	
	@DataProvider
	public Object[][] getMbTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1 , dataProvider ="getMbTestData")
	public void validateCreateNewUser(String name,String email,String pwd,String mobile) {
		signUpPage.clickOnTheSignUpLink();
		//signUpPage.createNewUser("Ashokone", "ashokkushone@mailinator.com", "Times@123", "8475837237");
		signUpPage.createNewUser(name, email, pwd, mobile);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


	
	

}
