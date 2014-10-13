package org.iitp.stockmart.utils;

import java.io.IOException;
import java.util.Properties;

public class AppConfig {

	private static AppConfig appConfig;
	private Properties prop;

	private AppConfig() {
		prop = new Properties();
		try {
			prop.load(getClass().getResourceAsStream("appconfig.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static AppConfig getInstance() {
		if (appConfig == null)
			appConfig = new AppConfig();
		return appConfig;
	}

	public String get(String key) {
		return prop.getProperty(key);
	}

	public void set(String key, String value) {
		prop.setProperty(key, value);
	}

}
