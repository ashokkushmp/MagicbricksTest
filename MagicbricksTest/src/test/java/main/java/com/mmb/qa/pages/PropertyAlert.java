package com.mmb.qa.pages;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmb.qa.base.TestBase;

public class PropertyAlert extends TestBase{
	
	
	@FindBy(xpath="//div[@class='topHeader']")
	WebElement propertyAlertLable;
	
	@FindBy(xpath="//a[@class='setNewAlert']")
	WebElement setNewPropertyAlert;
	
	@FindBy(xpath="//div[@id='unsubsdiv4']//a[@class='edUn linkUnsc'][contains(text(),'Unsubscribe')]")
	WebElement setUnsubscribe;
	
	@FindBy(xpath="//a[@class='yesLink']")
	WebElement clikOnYes;
	
	
	@FindBy(xpath="//a[@class='searchMatching'][1]")
	WebElement searchMatchingProp;
	
	
	@FindBy(xpath="//div[@id='managePropmainWrap']//div[4]//div[5]//a[2]")
	WebElement editPostAlert;
	
	
	//Initializing the page object
	public PropertyAlert() {				
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyPropertyAlertLable() {
		return propertyAlertLable.isDisplayed();
	}
	
	public SetaPropertyAlert verifySetNewAlertLink() {
		setNewPropertyAlert.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Testing for new set alert page pppppppppppp");
		/*
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(tabs.get(0));
		driver.close();
		driver.switchTo().window(tabs.get(1));
		*/
		return new SetaPropertyAlert();
	}
	
	public void verifyEditPropertyLink() {
		editPostAlert.click();
	}
	
	public void verifyUnsubscribeLink() {
		setUnsubscribe.click();
		clikOnYes.click();
		
	}
	

}
