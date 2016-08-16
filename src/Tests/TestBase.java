package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import DatataTable.XL_Reader;
import Util.TestUtil;

public class TestBase {

	// intializing the property file reading
	public static Properties CONFIG = null;
	public static Properties OR = null;
	public  static WebDriver driver = null;

	public static XL_Reader datatable = null;
	public static boolean isLoggedIn = false;

	public void Intialize() throws IOException {

		// if (driver == null) {

		// intializing config property file
		CONFIG = new Properties();

		FileInputStream fn = new FileInputStream(System.getProperty("user.dir")
				+ "//src//Config//Config.properties");
		CONFIG.load(fn);

		// intializing OR property file
		OR = new Properties();
		fn = new FileInputStream(System.getProperty("user.dir")
				+ "//src//Config//OR.properties");
		OR.load(fn);

		// intializing webdriver

		if (CONFIG.getProperty("browser").equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "//src//Config//chromedriver.exe");

			driver = new ChromeDriver();

		} else if (CONFIG.getProperty("browser").equals("FireFox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// }
	}

	public void GoTOURL() {
		driver.get(CONFIG.getProperty("testSiteName"));

	}

	public static WebElement Getobjectbyxpath(String xpathkey)
			throws IOException {
		try {
			return driver.findElement(By.xpath(OR.getProperty(xpathkey)));
		} catch (Exception ex) {

			throw ex;

		}
	}

	public static WebElement Getobjectbyid(String IDkey) throws IOException {
		try {
			return driver.findElement(By.id(OR.getProperty(IDkey)));
		} catch (Exception ex) {

			throw ex;

		}
	}

	public WebElement GetobjectbyName(String IDkey) throws IOException {

		try {
			return driver.findElement(By.name(OR.getProperty(IDkey)));

		} catch (Exception ex) {

			throw ex;

		}
	}

	public void SetValue(WebElement element, String IDkey2) {

		element.sendKeys(IDkey2);

	}

	public String GetValue(WebElement element) {

		return element.getText();
	}

	public WebElement Click(WebElement element) throws IOException {

		try {
			element.click();
			return element;
		} catch (Exception ex) {

			throw ex;

		}
	}

	public static void TakeScreenShot() throws IOException {

		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")
				+ "//screenshots//screenshot.png"));

	}

	public static void Close() {
		driver.quit();
	}

}
