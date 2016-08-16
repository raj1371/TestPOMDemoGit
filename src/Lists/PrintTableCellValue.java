package Lists;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import SeleniumWebDriverlistner.EventHandler;

public class PrintTableCellValue {
	WebDriver driver;

	@Test
	public void PrintTableCell() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "//src//Config//chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);

		EventHandler handler = new EventHandler();
		eventDriver.register(handler);
		eventDriver.get("https://www.w3.org/community/webed/wiki/HTML_tables");

		// Finding HTML table
		List<WebElement> rows = new ArrayList<WebElement>();
		List<WebElement> cols = new ArrayList<WebElement>();

		rows = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/table[1]/tbody/tr"));
		System.out.println("Rows count \t" + rows.size());

		for (WebElement row : rows) {

			cols = row.findElements(By.xpath("td"));
			System.out.println("Column size \t" + cols.size());

			for (WebElement col : cols) {

				System.out.println("Table cell value is +\t" + col.getText());

			}

		}

	}

}
