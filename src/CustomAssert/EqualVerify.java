package CustomAssert;

import org.testng.Assert;
import org.testng.Reporter;

public class EqualVerify extends Assert {

	public static void VerifyEqual(boolean actual, boolean expected) {

		try {
			Assert.assertEquals(actual, expected);
		} catch (Error er) {
			Reporter.log("Error was::" + er.getLocalizedMessage());

		}
	}

	public static void VerifyEqual(String actual, String expected) {

		try {
			Assert.assertEquals(actual, expected);
		} catch (Error er) {
			Reporter.log("Error was::" + er.getLocalizedMessage());

		}
	}

	public static void VerifyEqual(int actual, int expected) {

		try {
			Assert.assertEquals(actual, expected);
		} catch (Error er) {
			Reporter.log("Error was::" + er.getLocalizedMessage());

		}
	}
}
