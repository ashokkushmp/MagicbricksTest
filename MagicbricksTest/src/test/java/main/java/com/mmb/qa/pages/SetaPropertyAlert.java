package com.mmb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mmb.qa.base.TestBase;

public class SetaPropertyAlert extends TestBase{
	
	@FindBy(xpath="//p[contains(text(),'Name: Vijay')]")
	WebElement userNameLable;

}
