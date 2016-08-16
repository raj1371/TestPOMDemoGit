package TestNGListners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Tests.TestBase;

public class TestNGListner implements ITestListener {

	private WebDriver driver;
	private StopWatch stopwatch = new StopWatch();;

	@Override
	public void onFinish(ITestContext result) {
		// Invoked after all the tests have run and all their Configuration
		// methods have been called.
	}

	@Override
	public void onStart(ITestContext result) {
		// Invoked after the test class is instantiated and before any
		// configuration method is called.

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailure(ITestResult result) {

		/* Logging, 
		 * Screenshot,
		 * Close browser
		 * Mailsent
		 * Insert dat data 
		 * and log time etc */

		System.out
				.println("Test case Failed Details are:::" + result.getName());

		// Enable this code when showing Gmail login

		 try {
		
		 TestBase.TakeScreenShot();
		 System.out.println("Screenshot captured");
		TestBase.Close();
		
		 } catch (IOException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case Skipped Details are:::"
				+ result.getName());
		// TestBase.Close();

	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test case Started Details are:::"
				+ result.getName());
		stopwatch.start();

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		/*
		 * Logging Insert ExcelData Screenshot log time etc
		 */

		System.out
				.println("Test case sucess Details are:::" + result.getName());

		stopwatch.stop();
		System.out.println(stopwatch.getDuration());

	   TestBase.Close();

	}

}
