package GmailTests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Tests.TestBase;
import Util.TestUtil;

//@Listeners({ TestNGListners.TestNGListner.class })
public class GmailTest extends TestBase {

//	@BeforeMethod
//	public void beforeTest() throws IOException {
//		Intialize();
//
//	}

	@Test(dataProvider = "Logingmail")
	public void GoogleLogin(String Num, String Username, String password,
			String Result, String Sendmail) throws Exception {

		/*
		 * EqualVerify.VerifyEqual(LoginSucess(Num, Username, password, Result),
		 * true); EqualVerify.VerifyEqual(SenmdMailSucess(Num, Sendmail), true);
		 */

		Assert.assertEquals(LoginSucess(Num, Username, password, Result), true);
		Assert.assertEquals(SenmdMailSucess(Num, Sendmail), true);

	}

	/*@AfterMethod
	public void afterTest() {

		Close();
	}*/

//	@Test
//	public void CheckInbox() {
//
//		System.out.println("Inbox verified");
//		Assert.assertTrue(false);
//
//	}
//
//	@Test(dependsOnMethods = "CheckInbox")
//	public void CheckSentItems() {
//
//		System.out.println("Sent Items verified");
//	}

	@DataProvider(name = "Logingmail")
	public Object[][] dataSupplier() {

		System.out.println("Collecting data");

		Object[][] data = TestUtil.getData("Logingmail");

		return data;

	}

	public boolean LoginSucess(String Num, String Username, String password,
			String Result) throws InterruptedException, IOException {
		int num = Integer.parseInt(Num);
		boolean blnSucess = false;

		try {

			System.out.println("Logged in User name" + Username);
			System.out.println("Row Number" + num);

			GoTOURL();

			WebElement element = Getobjectbyid("username_signin_input");

			SetValue(element, Username);
			Thread.sleep(1000);

			Click(Getobjectbyid("btn_Next"));
			Thread.sleep(1000);

			SetValue(Getobjectbyid("password_signin_input"), password);
			Thread.sleep(1000);

			Click(Getobjectbyid("btn_SignIn"));

			Thread.sleep(10000);

			String strCompose = Getobjectbyxpath("btn_Compose").getText();

			if (strCompose.equals("COMPOSE")) {

				TestUtil.setCellValue("Logingmail", "Result", num + 1, "PASS");
				System.out.println("Login sucessful");
				blnSucess = true;

			} else {

				TestUtil.setCellValue("Logingmail", "Result", num + 1, "FAIL");
				System.out.println("Login Failed");

			}
			return blnSucess;

		} catch (org.openqa.selenium.NoSuchElementException ex) {

			TestUtil.setCellValue("Logingmail", "Result", num + 1, "FAIL");

			System.out.println("Login failed" + ex.getMessage());

			return blnSucess;
		}

	}

	public boolean SenmdMailSucess(String Num, String Sendmail)
			throws IOException, InterruptedException {
		int num = Integer.parseInt(Num);
		boolean blnSendmail = false;

		try {
			Click(Getobjectbyxpath("btn_Compose"));
			Thread.sleep(10000);

			String strSend = Getobjectbyxpath("btn_send").getText();

			if (strSend.equals("Send")) {

				TestUtil.setCellValue("Logingmail", "Sendmail", num + 1, "PASS");
				System.out.println("Send mail sucessful");
				blnSendmail = true;

			} else {

				TestUtil.setCellValue("Logingmail", "Sendmail", num + 1, "FAIL");
				System.out.println("Send mail");

			}
			return blnSendmail;

		} catch (org.openqa.selenium.NoSuchElementException ex) {

			TestUtil.setCellValue("Logingmail", "Sendmail", num + 1, "FAIL");
			TakeScreenShot();

			System.out.println("Send mail failed" + ex.getMessage());

			return blnSendmail;
		}

	}

}
