package com.mmb.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.mmb.qa.base.TestBase;

public class SignUpPage extends TestBase{
	
	@FindBy(xpath="//input[@id='ubiusertype1']")
	WebElement userTypeLink1;
	
	@FindBy(xpath="//input[@id='ubiusertype2']")
	WebElement userTypeLink2;
	
	@FindBy(xpath="//input[@id='ubiusertype3']")
	WebElement userTypeLink3;
	
	@FindBy(xpath="//input[@id='ubifname']")
	WebElement setNewUserName;
	
	@FindBy(xpath="//input[@id='ubiemail']")
	WebElement setNewEmailUser;
	
	@FindBy(xpath="//input[@id='ubipass']")
	WebElement setNewPwdforUser;
	
	@FindBy(xpath="//input[@id='isdCodeText']")
	WebElement showcountrycode;
	
	@FindBy(xpath="//li[@class='hovered']")
	WebElement clickCountryDropdown;
	
	
	@FindBy(xpath="//input[@id='ubimobile1']")
	WebElement userMobileno;
	
	@FindBy(xpath="//li[@class='hovered']")
	WebElement countrycodeUsa;
	
	@FindBy(xpath="//div[@class='signup__text']")
	WebElement newToMagicbricks;
	
	@FindBy(xpath="//h3[@class='web-page__left__heading']")
	WebElement newMagicbricksAccount;
	
	@FindBy(xpath="//a[@id='normalSignupLink']")
	WebElement signUpLinkClick;
	
	@FindBy(xpath="//button[@class='mui-btn mui-btn--primary']")
	WebElement submitSignUpButton;
	
	
	
	
	
	public SignUpPage clickOnTheSignUpLink() {
		driver.findElement(By.xpath("//a[@id='normalSignupLink']")).click();
		return new SignUpPage();
	}
		
	

	public boolean verifyTheLogOutLable() {
		WebElement LableText = driver.findElement(By.xpath("//h3[@class='web-page__left__heading']"));
		System.out.println(LableText.getText());
		return true;
	}
	
	public SignUpPage createNewUser(String ftName, String userEmail, String userPwd, String mobileno) {
		 int a = driver.findElements(By.xpath("//input[@type='radio']")).size();  
	        System.out.println(a);  
	        for(int i=1;i<=a;i++)  
	        {  
	            driver.findElements(By.xpath("//input[@type='radio']")).get(0).click();
	            	            
	        }  
	        try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        driver.findElement(By.xpath("//input[@id='ubifname']")).sendKeys(ftName);
	        driver.findElement(By.xpath("//input[@id='ubiemail']")).sendKeys(userEmail);
	        driver.findElement(By.xpath("//input[@id='ubipass']")).sendKeys(userPwd);
	        driver.findElement(By.xpath("//a[@class='showPassword']")).click();
	        try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        driver.findElement(By.xpath("//input[@id='isdCodeText']")).click();	
	        try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        driver.findElement(By.xpath("//li[contains(text(),'USA +1')]")).click();	        
	        driver.findElement(By.xpath("//input[@id='ubimobile1']")).sendKeys(mobileno);
	        driver.findElement(By.xpath("//button[@class='mui-btn mui-btn--primary']")).click();
            
	        
		return new SignUpPage();
	}




}
