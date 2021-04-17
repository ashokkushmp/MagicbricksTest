package com.mmb.qa.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmb.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	//page Factory - OR:
	
	@FindBy(xpath="//div[@id='navUserName']")
	WebElement MyActivity;
	
	@FindBy(xpath="//span[@class='loginBtn']")
	WebElement LoginBtn;	
	
	
	@FindBy(xpath="//input[@id='emailOrMobile']")
	WebElement Username;
	
	@FindBy(xpath="//button[@id='btnStep1']")
	WebElement NextBtn;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@id='btnLogin']")
	WebElement Login;
	
	@FindBy(xpath="//div[@class='logo']//a")
	WebElement MBlogo;
	
	
	@FindBy(xpath="//div[@class='fo_12px font-type-2 c_white']")
	WebElement mbLogoutOption;
	
	@FindBy(xpath="//span[@class='buyerLink signout']")
	WebElement mbSignOutOption;
	
	
	
	//Initializing the page object
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
		
	}
	
	public boolean validateMMBImage() {
		return MBlogo.isDisplayed();
	}
	
	/*public HomePage login(String un,String pwd,WebElement Myactivty) {
		Actions action = new Actions(driver);		
		action.moveToElement(Myactivty).click().build().perform();
		LoginBtn.click();
		Username.sendKeys(un);
		NextBtn.click();
		password.sendKeys(pwd);
		Login.click();
		
		return new HomePage();
		
	}*/

	public HomePage login(String un, String pwd) {
		Actions action = new Actions(driver);		
		action.moveToElement(MyActivity).click().build().perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Actions action1 = new Actions(driver);		
		action1.moveToElement(LoginBtn).click().build().perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(tabs.get(0));
		driver.close();
		driver.switchTo().window(tabs.get(1));
		Username.sendKeys(un);
		NextBtn.click();
		password.sendKeys(pwd);
		Login.click();
		
		return new HomePage();
	}
	
	public SignUpPage logout() {
		Actions action = new Actions(driver);		
		action.moveToElement(mbLogoutOption).click().build().perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Actions action1 = new Actions(driver);		
		action1.moveToElement(mbSignOutOption).click().build().perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new SignUpPage();
	}
	

}
