package CrossBrowserParallel;

import org.testng.annotations.Test;

public class TestClass2 extends BaseClass{
	@Test
	public void swiggyTest() {
		driver.get("https://www.swiggy.com/");
	}
}
