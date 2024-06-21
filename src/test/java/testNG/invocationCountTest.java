package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class invocationCountTest {
 @Test (invocationCount= 1)
 public void demo1() {
	 Reporter.log("Nani",true);
 }
 @Test( invocationCount= 1)
 public void demo2() {
	 Reporter.log("demo2",true);
 }
 @Test
 public void demo3() {
	 Reporter.log("demo3",true);
 }
 @Test(invocationCount= 1 )
 public void demo4() {
	 Reporter.log("demo4",true);
 }
 
 }


