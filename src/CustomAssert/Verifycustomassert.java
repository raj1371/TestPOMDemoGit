package CustomAssert;

import org.testng.annotations.Test;

public class Verifycustomassert {
	@Test
	public void TestCustomAssert(){
		
		EqualVerify.VerifyEqual(true,true);	
		EqualVerify.VerifyEqual(true,false);	
		EqualVerify.VerifyEqual(true,true);	
		EqualVerify.VerifyEqual(true,false);	
	}
	

}
