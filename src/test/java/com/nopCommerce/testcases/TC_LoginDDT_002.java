package com.nopCommerce.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.loginPage;
import com.nopCommerce.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass 
{
	@Test(dataProvider = "loginData")
	public void loginTest(String user,String pwd) throws InterruptedException, IOException {
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("Ecommerce URL is Opened....");
		loginPage lp = new loginPage(driver);
		lp.setUserName(user);
		logger.info("Username Entered");
		lp.setPassword(pwd);
		logger.info("Password Entered");
		lp.clickLogin();
		logger.info("Login Button is clicked....");
		Thread.sleep(2000);

		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("User Logged out....");
		}
		else {
			//captureScreen(driver,"loginTest");
			logger.info("Login Failed");//logger msg
			Assert.assertTrue(false);
		}
	}
	
	@DataProvider(name="loginData")
	public String[][] getData() throws IOException{
		String path =System.getProperty("user.dir")+ "/src/test/java/com/nopCommerce/testData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j); //1 0 //array value: 0 0 --> Read the data from excel and put that into 2D array
			}
		}
		return logindata;
	}

}
