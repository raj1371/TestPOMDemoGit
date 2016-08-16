package CustomAssert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertverify {

	SoftAssert softAssert = new SoftAssert();

	@Test
	public void SoftAssertTest() {
		System.out.println("SoftAssert1 executed");
		softAssert.assertEquals(true, true);
		
		System.out.println("SoftAssert2 executed");
		softAssert.assertEquals(false, true);
		
		System.out.println("SoftAssert3 executed");
		softAssert.assertEquals(true, true);
		
		System.out.println("SoftAssert4 executed");
		softAssert.assertEquals(false, true);
		
		softAssert.assertAll();

	}

}
