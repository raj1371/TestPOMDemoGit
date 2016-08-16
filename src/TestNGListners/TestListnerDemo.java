package TestNGListners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ TestNGListners.TestNGListner.class })
public class TestListnerDemo {

	@Test
	public void Method1() {
		System.out.println("Method1");
	}

	@Test
	public void Method2() {
		System.out.println("Method2");
	}

	@Test
	public void Method3() {
		System.out.println("Method3");
		Assert.fail();
	}

	@Test
	public void Method4() {
		System.out.println("Method4");
		Assert.fail();
	}

}
