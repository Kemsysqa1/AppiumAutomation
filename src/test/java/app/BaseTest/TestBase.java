package app.BaseTest;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import app.DriverManager.DriverManager;
import app.Pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import utils.PropertyUtils;

public class TestBase {
	public static AndroidDriver driver;
	private LoginPage loginPage;
	public static DriverManager driverManager;

	public LoginPage getLoginPageInstance() {
		if (!(loginPage instanceof LoginPage)) {
			loginPage = new LoginPage();
		}
		return loginPage;
	}

	@BeforeTest
	public void setUp() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", PropertyUtils.getInstance().getProperty("platformName"));
		cap.setCapability("appium:platformVersion", PropertyUtils.getInstance().getProperty("platformVersion"));
		cap.setCapability("appium:automationName", PropertyUtils.getInstance().getProperty("automationName"));
		cap.setCapability("appium:appPackage", PropertyUtils.getInstance().getProperty("appPackage"));
		cap.setCapability("appium:appActivity", PropertyUtils.getInstance().getProperty("appActivity"));
		cap.setCapability("platformName", PropertyUtils.getInstance().getProperty("platformName"));
		cap.setCapability("platformName", PropertyUtils.getInstance().getProperty("platformName"));

		driver = new AndroidDriver(cap);

	}

	@AfterTest
	public void tearDown() {

	}

}
