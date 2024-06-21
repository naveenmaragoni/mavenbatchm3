package Listener;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Listener.ListenerImplimentation.class)
public class SampleTest extends BaseClass{
	@Test
	public void test1() {
		Reporter.log("Hello World!",true);
		
	}

}
