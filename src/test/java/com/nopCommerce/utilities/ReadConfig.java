package com.nopCommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	// Class name should have uppercase character first
	Properties prop;

	public ReadConfig() {

		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is...." + e.getMessage());
		}
	}

	public String getApplicationURL() {

		String url = prop.getProperty("baseURL");
		return url;
	}

	public String getUseremail() {

		String username = prop.getProperty("useremail");
		return username;
	}
	
	public String getpassword() {

		String password = prop.getProperty("password");
		return password;
	}

	public String getchromepath() {

		String chromepath = prop.getProperty("chromepath");
		return chromepath;
	}

	public String getfirefoxpath() {

		String firefoxpath = prop.getProperty("firefoxpath");
		return firefoxpath;
	}

}
