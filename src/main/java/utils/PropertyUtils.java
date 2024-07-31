package utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {

	private static PropertyUtils propertyUtils;
	String path = "config\\config.properties";

	InputStream input;
	String value;

	public String getProperty(String key) {
		Properties property = new Properties();
		try {
			input = getClass().getClassLoader().getResourceAsStream(path);
			if (input != null) {
				property.load(input);
			} else {
				throw new FileNotFoundException("Property file not found..!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		value = property.getProperty(key);
		if (value == null) {
			throw new NullPointerException(key.concat(" : Property not found as configured"));
		}
		return value;

	}

	public static PropertyUtils getInstance() {
		if (propertyUtils == null) {
			synchronized (PropertyUtils.class) {
				if (propertyUtils == null) {
					propertyUtils = new PropertyUtils();
				}
			}
		}
		return propertyUtils;
	}
}
