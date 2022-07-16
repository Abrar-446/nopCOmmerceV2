package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	public WebDriver ldriver;
	
	public loginPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//input[@id='Email']")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//button[contains(text(),'Log in')]")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement lnkLogout;
	
	//write action methods
	
	public void setUserName(String uname) {
		txtEmail.clear();
		txtEmail.sendKeys(uname);
		
	}
	
	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
	
}
