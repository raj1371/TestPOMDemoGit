package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumWebDriverlistner.EventHandler;
import Util.TestUtil;

public class SeleniumList {
	WebDriver driver;

	@Test
	public void LoopWebTable() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "//src//Config//chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);

		EventHandler handler = new EventHandler();
		eventDriver.register(handler);
		eventDriver.get("https://www.w3.org/community/webed/wiki/HTML_tables");

		List<Row> rowsData = GetDataTable();
		Object[][] data = TestUtil.getData("Expected");

		VerifyTestData(rowsData, data);

		Assert.assertEquals(getCellValue(rowsData, "Row2", "Column1"),"Oregon");

		// driver.quit();

	}

	public void VerifyTestData(List<Row> rowsData, Object[][] data) {

		if ((rowsData.size() - 1) == data.length) {

			for (int i = 1; i < rowsData.size(); i++) {

				for (int j = 0; j < rowsData.size(); j++) {

					String strList = getCellValue(rowsData, "Row" + i, "Column" + j);
					System.out.println("List value was::" + strList);

					String strData = data[i - 1][j].toString();
					System.out.println("2D value was::" + strData);

					if (strList.equals(strData)) {

						System.out.println("Total Data is verified");
						Assert.assertTrue(true);
					}
				}

			}

		} else
			Assert.fail();

	}

	public String getCellValue(List<Row> rowsData, String rowName, String columnName) {

		try {
			String strValue;
			List<Column> columns = new ArrayList<Column>();

			columns = rowsData.stream().filter((p) -> p.RowName.equals((rowName))).findFirst().get().Columns;

			strValue = columns.stream().filter((p) -> p.ColumnName.equals((columnName))).findFirst().get().ColumnValue
					.trim();

			return strValue;

		} catch (NoSuchElementException ex) {
			return ex.getMessage();
		}
	}

	public List<Row> GetDataTable() {

		// Finding HTML table
		List<WebElement> rows = new ArrayList<WebElement>();
		List<WebElement> cols = new ArrayList<WebElement>();

		List<Row> listRows = new ArrayList<Row>();

		rows = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/table[1]/tbody/tr"));
		System.out.println("Rows count \t" + rows.size());

		int rowNum = 0;

		for (WebElement row : rows) {

			Row rowData = new Row();

			cols = row.findElements(By.xpath("td"));
			System.out.println("Column size \t" + cols.size());

			List<Column> listColumns = new ArrayList<Column>();

			int colNumber = 0;

			for (WebElement col : cols) {

				System.out.println("Table cell value is +\t" + col.getText());
				Column coldata = new Column();

				coldata.ColumnName = "Column" + colNumber;
				coldata.ColumnValue = col.getText();
				listColumns.add(colNumber, coldata);
				colNumber++;
			}
			rowData.RowName = "Row" + rowNum;
			rowData.Columns = listColumns;
			listRows.add(rowNum, rowData);
			rowNum++;

		}
		return listRows;

	}

	public class Row {

		public String RowName;
		public List<Column> Columns;

	}

	public class Column {

		public String ColumnName;
		public String ColumnValue;

	}

}
