package SeleniumWebDriverlistner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class EventListnerDemo {

	WebDriver driver;

	@Test
	public void TestEventListner() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")
						+ "//src//Config//chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);

		EventHandler handler = new EventHandler();
		eventDriver.register(handler);
		eventDriver.get("https://gmail.com");

		driver.quit();

	}

}
