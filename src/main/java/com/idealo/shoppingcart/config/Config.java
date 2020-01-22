package com.idealo.shoppingcart.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Application configuration loader class, to load configuration for pricing
 * rules and items.
 * 
 * @author Vishnu
 *
 */
public class Config {
	static Properties config = new Properties();

	static {
		InputStream is = Config.class.getClassLoader().getResourceAsStream("config.properties");
		try {
			config.load(is);
		} catch (IOException e) {
			e.getMessage();
		}
	}

	/**
	 * This method is responsible for returning the value/values value from the
	 * configuration file corresponding to the provided key.
	 * 
	 * @param key
	 * @return result - value w.r.t key OR null if key is not present.
	 * 
	 */
	public static String get(String key) {
		return (String) config.get(key);
	}
}