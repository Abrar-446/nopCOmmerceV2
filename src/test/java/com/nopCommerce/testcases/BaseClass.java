package com.nopCommerce.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopCommerce.utilities.ReadConfig;



public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	//All the common variables, methods
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUseremail();
	public String password = readconfig.getpassword();
	public static WebDriver driver;
	
	public static Logger logger;

	@BeforeClass
	@Parameters("browser")
	public void setup(String br) { //br comes from testng.xml file
		logger =Logger.getLogger("nopEcommerce");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
		driver = new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxpath());
			driver = new FirefoxDriver();
		}
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

}
