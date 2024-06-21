package assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	@Test
	public void demo1() {
		String s1= "Nani";
		String s2="Nikhil";
		
	SoftAssert soft =new SoftAssert	() ;
	soft.assertEquals(s1,s2);
	
	System.out.println(s1);
	System.out.println(s2);
	System.out.println("Test Ends Here");
	
	soft.assertAll();
	}

}
