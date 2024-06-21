package Listener;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Listener.ListenerImplimentation.class)
public class SkillRarySampleTest2 extends SkillraryBaseClass1{
	@Test
	public void test1() {
		Reporter.log("Hello World!",true);
		
	}

}
