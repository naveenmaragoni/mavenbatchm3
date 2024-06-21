package assertions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class SoftAssertPractice {
	@Test
	public void demo3() {
	String s1= "shiva";
	String s2 ="shivam";
	//Here we are creating object to the class , Y because softAssert are non-static methods)
	SoftAssert SA =new SoftAssert();
	SA.assertEquals(s1,s2);
	
    System.out.println(s1);
	System.out.println(s2);
	System.out.println("test end here");
	
	SA.assertAll();
	
}
@Test
public void demo4() {
	int num=10;
	long l =10;
	
	assertNotEquals(num, l);
	System.out.println(num);
	System.out.println(l);
	System.out.println("Here Test Ends");

 }
}
