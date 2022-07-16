package com.nopCommerce.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.Addcustomerpage;
import com.nopCommerce.pageObjects.loginPage;

public class TC_Addcustomertest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws IOException {
		driver.get(baseURL);
		driver.manage().window().maximize();
		loginPage lp=new loginPage(driver);
		lp.setUserName(username);
		logger.info("username is provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickLogin();
		
		Addcustomerpage addcust=new Addcustomerpage(driver);
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		
		addcust.clickOnAddnew();
		
		String email = randomestring() + "@gmail.com";
		logger.info("Providing email");
		addcust.setEmail(email);
		logger.info("Providing password");		
		addcust.setPassword("test123");
		
		//Registered - default
		//The customer cannot be in both 'Guests' and 'Registered' customer roles
		//Add the customer to 'Guests' or 'Registered' customer role
		logger.info("Providing Customer roles");
		addcust.setCustomerRoles("Guest");
		logger.info("Selecting vendor");
		addcust.setManagerOfVendor("Vendor 2");
		logger.info("Selecting gender");
		addcust.setGender("Male");
		logger.info("Providing first name and last name");
		addcust.setFirstName("Abrar");
		addcust.setLastName("Ahmed");
		logger.info("Providing dob");
		addcust.setDob("01/01/1991"); // Format: D/MM/YYY
		logger.info("Providing company name and admin content");
		addcust.setCompanyName("busyQA--46");
		addcust.setAdminContent("This is for testing.........");
		logger.info("clicking on save");
		addcust.clickOnSave();
		
		logger.info("validation started....");
				
		//String msg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		
		String msg = driver.findElement(By.tagName("body")).getText();
			
		
		if(msg.contains("The new customer has been added successfully"))
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
		
	}
}
