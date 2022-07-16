package com.nopCommerce.testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopCommerce.pageObjects.loginPage;


public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException, IOException {
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("Ecommerce URL is Opened....");
		loginPage lp = new loginPage(driver);
		lp.setUserName(username);
		logger.info("Username Entered");
		lp.setPassword(password);
		logger.info("Password Entered");
		lp.clickLogin();
		logger.info("Login Button is clicked....");
		Thread.sleep(4000);

		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("User Logged out....");
		}
		else {
			captureScreen(driver,"loginTest");
			logger.info("Login Failed");//logger msg
			Assert.assertTrue(false);
		}
	}

	

}
