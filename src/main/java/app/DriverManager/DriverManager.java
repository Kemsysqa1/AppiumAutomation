package app.DriverManager;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DriverManager {

	private static DriverManager driverManager;
	private AndroidDriver driver;

	public AndroidDriver getDriver(DesiredCapabilities cap) {

		driver = new AndroidDriver(cap);

		return driver;

	}

	public static DriverManager getInstance() {
		if (driverManager == null) {
			synchronized (DriverManager.class) {
				if (driverManager == null) {
					driverManager = new DriverManager();
				}
			}
		}
		return driverManager;
	}

}
